using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

public partial class SimpleVisitor
{
    public override object? VisitComparisonExpression(SimpleParser.ComparisonExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        var op = context.COMPARE_OP().GetText();

        return op switch
        {
            "==" => Equals(left, right),
            "!=" => !Equals(left, right),
            ">" => GreaterThan(left, right),
            ">=" => GreaterThanOrEqual(left, right),
            "<" => LessThan(left, right),
            "<=" => LessThanOrEqual(left, right),

            //replace default with diagnostics bag
            _ => throw new NotImplementedException()
        };
        //return base.VisitComparisonExpression(context);
    }

    /*
     * Equals and not equals are done by c# default
     * Might want to do our own later for more control
     */

    private new bool Equals(object? left, object? right)
    {
        return left?.Equals(right) ?? right == null;
    }

    //comparison functions
    private bool GreaterThan(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l > r;

        if (left is float lf && right is float rf)
            return lf > rf;
        
        if (left is int lInt && right is float rFloat)
            return lInt > rFloat;
        
        if (left is float lFloat && right is int rInt)
            return lFloat > rInt;

        throw new Exception($"Cannot apply `>` values of types {left?.GetType()} and {right?.GetType()}");
    }

    private bool GreaterThanOrEqual(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l >= r;

        if (left is float lf && right is float rf)
            return lf >= rf;
        
        if (left is int lInt && right is float rFloat)
            return lInt >= rFloat;
        
        if (left is float lFloat && right is int rInt)
            return lFloat >= rInt;

        throw new Exception($"Cannot apply `>=` values of types {left?.GetType()} and {right?.GetType()}");
    }

    private bool LessThan(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l < r;

        if (left is float lf && right is float rf)
            return lf < rf;

        if (left is int lInt && right is float rFloat)
            return lInt < rFloat;

        if (left is float lFloat && right is int rInt)
            return lFloat < rInt;

        throw new Exception($"Cannot apply `<` values of types {left?.GetType()} and {right?.GetType()}");
    }

    private bool LessThanOrEqual(object? left, object? right)
    {
        if (left is int l && right is int r)
            return l <= r;

        if (left is float lf && right is float rf)
            return lf <= rf;
        
        if (left is int lInt && right is float rFloat)
            return lInt <= rFloat;
        
        if (left is float lFloat && right is int rInt)
            return lFloat <= rInt;

        throw new Exception($"Cannot apply `<=` values of types {left?.GetType()} and {right?.GetType()}");
    }
}