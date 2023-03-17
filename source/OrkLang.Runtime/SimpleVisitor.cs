using System.Globalization;
using System.Net.Sockets;
using System.Numerics;
using System.Reflection;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

public class SimpleValue
{
    public bool IsConstant { get; set; }

    public object? Value { get; set; }
    
    public TypeEnum Type { get; set; }
}

public enum TypeEnum
{
    String,
    Int,
    Float
}

public class BoilerClass
{
    private readonly IDictionary<string, ConstructorInfo> _constructors = new Dictionary<string, ConstructorInfo>();

    public BoilerClass()
    {
        // Set default values or do any nessessary setup
    }

    public void AddConstructor(string name, ConstructorInfo constructorInfo)
    {
        _constructors[name] = constructorInfo;
    }
    
    public ConstructorInfo GetConstructor(string name)
    {
        return _constructors.TryGetValue(name, out var constructor) ? constructor : null;
    }
}

public partial class SimpleVisitor : SimpleBaseVisitor<object?> //SimpleValue
{
    private Dictionary<string, object?> Variables { get; } = new();
    private Dictionary<string, object?> Namespaces { get; } = new();
    private Dictionary<string, object?> Classes { get; } = new();

    public SimpleVisitor()
    {
        Variables["print"] = new Func<object?[], object?>(PrintLn);
        Variables["write"] = new Func<object?[], object?>(Write);
        Variables["readLine"] = new Func<object?[], object?>(ReadLine);

        //Operators
        Variables["convert"] = new Func<object?[], object?>(args => ParseConvert(args));
        
        //isConstant = false;
        //value = null;
    }

    private object? Write(object?[] args)
    {
        foreach (var arg in args)
        {
            Console.Write(arg);
        }

        return null;
    }

    private object? PrintLn(object?[] args)
    {
        foreach (var arg in args)
        {
            Console.WriteLine(arg);
        }

        return null;
    }

    private object? ReadLine(object?[] args)
    {
        return Console.ReadLine();
    }

    private object? ParseConvert(object?[] args)
    {
        if (args.Length == 0 || args[0] == null || string.IsNullOrWhiteSpace(args[0]?.ToString()))
        {
            return null;
        }

        ParseTo(args[0], out var result);
        return result;
    }

    private void ParseTo(object? input, out object? result)
    {
        
        if (int.TryParse(input.ToString(), out var intResult))
        {
            result = intResult;
        }

        // Try parsing as a float
        if (float.TryParse(input.ToString(), out var floatResult))
        {
            result = (int)floatResult;
        }

        if (bool.TryParse(input.ToString(), out var boolResult))
        {
            result = (bool)boolResult;
        }

        // Try parsing as another data type
        object convertedResult = Convert.ChangeType(input, typeof(int), CultureInfo.InvariantCulture);
        result = convertedResult;
    }

    void test()
    {
        
        // var memberAccess = SimpleParser
        /*Member access *does* exist, we just need to pair it with something */
        //var memberAccess = SimpleParser.MemberAccessContext.memberAccess();
    }

    public override object? VisitIfBlock(SimpleParser.IfBlockContext context)
    {
        //Get value
        var compCondition = context.expression() as SimpleParser.ComparisonExpressionContext;
        // Evaluate the expression
        var condition = (bool)VisitComparisonExpression(compCondition);

        // If the condition is true, visit the if block
        if (condition)
        {
            return VisitBlock(context.block());
        }
        // Otherwise, visit the elseIfBlock (if it exists)
        else
        {
            SimpleParser.ElseIfBlockContext elseIfBlockContext = context.elseIfBlock();
            if (elseIfBlockContext != null)
            {
                return VisitElseIfBlock(elseIfBlockContext);
            }
            else
            {
                return null;
            }
        }
        //SimpleParser.ExpressionContext condition = context.expression();
        //var s = condition as SimpleParser.ComparisonExpressionContext;
        //var t = VisitComparisonExpression(s);


        //return base.VisitIfBlock(context);
    }

    public override object VisitElseIfBlock([NotNull] SimpleParser.ElseIfBlockContext context)
    {
        // If this is an if block, evaluate the condition and visit the block
        if (context.ifBlock() != null)
        {
            return VisitIfBlock(context.ifBlock());
        }
        // Otherwise, visit the block directly
        else
        {
            return Visit(context.block());
        }
    }

    public override object? VisitAssignment(SimpleParser.AssignmentContext context)
    {
        var varName = context.IDENTIFIER().GetText();

        var value = Visit(context.expression());

        Variables[varName] = value;

        return null; //base.VisitAssignment(context);
    }

    /* Go back to the drawing board with functions */

    public override object? VisitNamespaceBlock(SimpleParser.NamespaceBlockContext context)
    {
        var varName = context.IDENTIFIER().GetText();
        
        var value = Visit(context.block());
        
        Namespaces[varName] = value;
        
        return null;
        //return base.VisitNamespaceBlock(context);
    }

    public override object? VisitClassBlock(SimpleParser.ClassBlockContext context)
    {
        var varName = context.IDENTIFIER().GetText();
        
        var value = Visit(context.block());

        Classes[varName] = value;
        
        return null;
        //return base.VisitClassBlock(context);
    }

    //functionCall: IDENTIFIER '(' (expression (',' expression)*)? ')';
    public override object? VisitFunctionCall(SimpleParser.FunctionCallContext context)
    {
        var name = context.IDENTIFIER().GetText();
        var args = context.expression().Select(Visit).ToArray();

        if (!Variables.ContainsKey(name)) //.TryGetValue(name, out var value))
            throw new Exception($"Function {name} is not defined.");

        if (!(Variables[name] is Func<object?[], object?> func))
            throw new Exception($"Variable {name} is not a function.");

        return func(args);
        //return base.VisitFunctionCall(context);
    }

    /*
    public override object VisitForBlock([NotNull] SimpleParser.ForBlockContext context)
    {
        var initial = (int)Visit(context.assignment());

        //Get value
        var compCondition = context.expression(0) as SimpleParser.ComparisonExpressionContext;

        var condition = (Func<bool>)VisitComparisonExpression(compCondition);

        var increment = (Action)Visit(context.expression(1));

        Console.WriteLine($"Initial = {initial}");
        Console.WriteLine($"Condition = {condition}");
        Console.WriteLine($"Increment = {increment}");
        for (int i = initial; condition(); increment())
        {
            Visit(context.block());
        }

        return null;
        //return base.VisitForBlock(context);
    }
    */
    public override object? VisitIdentifierExpression(SimpleParser.IdentifierExpressionContext context)
    {
        var varName = context.IDENTIFIER().GetText();

        if (!Variables.ContainsKey(varName))
            throw new Exception($"Variable {varName} is not defined.");

        return Variables[varName];
        //return base.VisitIdentifierExpression(context);
    }

    public override object? VisitConstant(SimpleParser.ConstantContext context)
    {
        if (context.INTEGER() is { } i)
            return int.Parse(i.GetText());

        if (context.FLOAT() is { } f)
            return float.Parse(f.GetText());

        if (context.STRING() is { } s)
            return s.GetText()[1..^1];

        if (context.BOOL() is { } b)
            return b.GetText() == "true";

        if (context.NULL() is { })
            return null;

        throw new NotImplementedException();
        //return null; //base.VisitConstant(context);
    }

    //@ SimpleVisitor.Additive.cs
    
    //@ SimpleVisitor.Multiplicative.cs
    
    public override object? VisitWhileBlock(SimpleParser.WhileBlockContext context)
    {
        Func<object?, bool> condition = context.WHILE().GetText() == "while"
                ? IsTrue
                : IsFalse
            ;

        if (condition(Visit(context.expression())))
        {
            while (condition(Visit(context.expression())))
            {
                Visit(context.block());
            }
            //do
           // {
           //     Visit(context.block());
           // } while (condition(Visit(context.expression())));
        }
        else
        {
            Visit(context.elseIfBlock());
        }

        return null;
        //return base.VisitWhileBlock(context);
    }

    /*
    public override object? VisitIfBlock(SimpleParser.IfBlockContext context)
    {
        var condition = context.GetText(); //'if' or 'unless'
        
        if (IsTrue(Visit(context.expression())))
        {
            Visit(context.block());
        }
        else
        {
            Visit(context.elseIfBlock());
        }

        return null;
        //return base.VisitIfBlock(context);
    }
    */

    //@ SimpleVisitor.Comparison.cs
   
    private bool IsTrue(object? value)
    {
        if (value is bool b)
            return b;

        throw new Exception("Value is not a boolean");
    }

    private bool IsFalse(object? value) => !IsTrue(value);
}

