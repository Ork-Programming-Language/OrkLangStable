using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

public partial class SimpleVisitor
{
    public override object? VisitAdditiveExpression(SimpleParser.AdditiveExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        var op = context.addOp().GetText();

        return op switch
        {
            "+" => Add(left, right),
            "-" => Subtract(left, right),
            _ => throw new NotImplementedException()
        };
        //return base.VisitAdditiveExpression(context);
    }

    //add and subtract functions
    private object? Add(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l + r;

        if (left is float lf && right is float rf)
            return lf + rf;

        if (left is int lInt && right is float rFloat)
            return lInt + rFloat;

        if (left is float lFloat && right is int rInt)
            return lFloat + rInt;

        if (left is string || right is string)
            return $"{left}{right}";

        throw new Exception($"Cannot add values of types {left?.GetType()} and {right?.GetType()}");
    }

    private object? Subtract(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l - r;

        if (left is float lf && right is float rf)
            return lf - rf;
        
        if (left is int lInt && right is float rFloat)
            return lInt - rFloat;
        
        if (left is float lFloat && right is int rInt)
            return lFloat - rInt;

        throw new Exception($"Cannot subtract values of types {left?.GetType()} and {right?.GetType()}");
    }
}