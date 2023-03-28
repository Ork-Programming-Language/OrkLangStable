using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

public partial class SimpleVisitor
{
    public override object? VisitMultiplicativeExpression(SimpleParser.MultiplicativeExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        var op = context.MULT_OP().GetText();

        return op switch
        {
            "*" => Multiply(left, right),
            "/" => Divide(left, right),
            "%" => Modulo(left, right),
            _ => throw new NotImplementedException()
        };
        // return base.VisitMultiplicativeExpression(context);
    }

    //multiply divde and modulo functions
    private object? Multiply(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l * r;

        if (left is float lf && right is float rf)
            return lf * rf;

        if (left is int lInt && right is float rFloat)
            return lInt * rFloat;

        if (left is float lFloat && right is int rInt)
            return lFloat * rInt;

        // var rightInt = right as int?;

        //  if (left is string || right is int)
        //    return String.Concat(Enumerable.Repeat($"{left}", int.Parse(rightInt)));

        throw new Exception($"Cannot multiply values of types {left?.GetType()} and {right?.GetType()}");
    }

    private object? Divide(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l / r;

        if (left is float lf && right is float rf)
            return lf / rf;
        
        if (left is int lInt && right is float rFloat)
            return lInt / rFloat;
        
        if (left is float lFloat && right is int rInt)
            return lFloat / rInt;

        throw new Exception($"Cannot divide values of types {left?.GetType()} and {right?.GetType()}");
    }

    private object? Modulo(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l % r;

        if (left is float lf && right is float rf)
            return lf % rf;

        if (left is int lInt && right is float rFloat)
            return lInt % rFloat;
        
        if (left is float lFloat && right is int rInt)
            return lFloat % rInt;
        
        throw new Exception($"Cannot modulo values of types {left?.GetType()} and {right?.GetType()}");
    }
}