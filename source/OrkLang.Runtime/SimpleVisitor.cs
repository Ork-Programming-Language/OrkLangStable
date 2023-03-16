using System.Net.Sockets;
using System.Numerics;
using System.Reflection;
using Antlr4.Runtime;
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

    public override object? VisitIfBlock(SimpleParser.IfBlockContext context)
    {
        //var condition = Visit(context.expression());
        
        //if (condition is bool b && b)
        //{
        //    return Visit(context.block());
        //}
        //return null;
        return base.VisitIfBlock(context);
    }

    public override object? VisitAssignment(SimpleParser.AssignmentContext context)
    {
        var varName = context.IDENTIFIER().GetText();

        var value = Visit(context.expression());

        Variables[varName] = value;

        return null; //base.VisitAssignment(context);
    }
    
    /*
    //funcBlock: 'func' IDENTIFIER '(' (IDENTIFIER (',' IDENTIFIER)*)? ')' block;
    public override object? VisitFuncBlock(SimpleParser.FuncBlockContext context)
    {
        bool shouldExecute = false;

        Console.WriteLine(context.IDENTIFIER(0).GetText());
        
        var functionName = context.IDENTIFIER(0).GetText();

        var parameterNames = context.IDENTIFIER().Skip(1).Select(x => x.GetText());

        Variables[functionName] = new Func<object?[], object?>(args => parameterNames);
            
        var block = context.block();

        if (context.Parent is SimpleParser.FunctionCallContext)
        {
            var funcCallContext = (SimpleParser.FunctionCallContext)context.Parent;

            if (funcCallContext.IDENTIFIER().GetText() == context.IDENTIFIER(0).GetText())
            {
                shouldExecute = true;
            }
        }
        
        if (shouldExecute)
        {
            // Define a delegate to execute the block with the given parameter names and variables
            Func<object?[], object?> func = args =>
            {
                // Store the parameter values in the variables dictionary
                for (int i = 0; i < parameterNames.Count(); i++)
                {
                    Variables[parameterNames.ElementAt(i)] = args.ElementAt(i);
                }

                // Execute the block of statements in the function
                var result = Visit(block);

                // Clear the parameter values from the variables dictionary
                foreach (var parameterName in parameterNames)
                {
                    Variables.Remove(parameterName);
                }

                return result;
            };

            // Store the function delegate in the variables dictionary
            Variables[functionName] = func;

            return null;
        }

        return null;
        //return base.VisitFuncBlock(context);
    }*/

    /*
    public override object? VisitBlock(SimpleParser.BlockContext context)
    {
        foreach (var statement in context.statement())
        {
            Visit(statement);
        }

        return null; //base.VisitBlock(context);
    } */

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
            do
            {
                Visit(context.block());
            } while (condition(Visit(context.expression())));
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

