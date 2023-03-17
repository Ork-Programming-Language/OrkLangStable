using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime.Misc;
using LLVMSharp.Interop;
using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

public partial class SimpleVisitor
{
    public override object VisitBooleanExpression([NotNull] SimpleParser.BooleanExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        var op = context.boolOp().GetText();


        return op switch
        {
            //Word
            "and" => WAndOp(left, right),
            "or" => WOrOp(left, right),
            "xor" => WXorOp(left, right), //^
            //Logic
            "&&" => LAndOp(left, right),
            "||" => LOrOp(left, right),
            "^" => LXorOp(left, right),
            /*Add support for [||, &&]*/
            /*In a bitwise class add support for [&, |, ~, !, <<, >>, >>>]*/
            _ => throw new NotImplementedException(),
        };
    }

    /* I know this is really messy but I will work on the solution */
    //Word
    private object? WAndOp(object? left, object? right)
    {
        //turn (bool) into tryparse
        var bLeft = (bool)left;
        var bRight = (bool)right;
        if (left is bool && right is bool)
            return (bLeft && bRight);
        
        return false;
    }

    //Logic
    private object? LAndOp(object? left, object? right)
    {
        //turn (bool) into tryparse
        var bLeft = (bool)left;
        var bRight = (bool)right;
        if (left is bool && right is bool)
            return (bLeft && bRight);

        return false;
    }

    //Word
    private object? WOrOp(object? left, object? right)
    {
        //turn (bool) into tryparse
        var bLeft = (bool)left;
        var bRight = (bool)right;
        if (left is bool && right is bool)
            return (bLeft || bRight);
        return false;
    }

    //Logic
    private object? LOrOp(object? left, object? right)
    {
        //turn (bool) into tryparse
        var bLeft = (bool)left;
        var bRight = (bool)right;
        if (left is bool && right is bool)
            return (bLeft || bRight);
        return false;
    }

    void ttest()
    {
        int l = 0;
        int r = 0;

        //float lf = 0.0f;
        //float rf = 0.0f;

        var s = l | r; //int
        s = l & r; //int
        s = l ^ r; //int
        //~
        //s = l || r;
        //s = l && r;
        s = l << r; //int
        s = l >>> r; //int
        s = l >> r; //int

        //var fs = lf | rf; //float
        //fs = lf & rf;
        //fs = lf ^ rf;
        //fs = lf >>> rf;
        //fs = lf >> rf;
        //fs = lf << rf;
    }

    //Word
    private object? WXorOp(object? left, object? right)
    {
        //turn (bool) into tryparse
        var bLeft = (bool)left;
        var bRight = (bool)right;
        if (left is bool && right is bool)
            return (bLeft ^ bRight);

        if (left is int l && right is int r)
            return l ^ r;
        return false;
    }

    //Logic
    private object? LXorOp(object? left, object? right)
    {
        //turn (bool) into tryparse
        var bLeft = (bool)left;
        var bRight = (bool)right;
        if (left is bool && right is bool)
            return (bLeft ^ bRight);

        if (left is int l && right is int r)
            return l ^ r;
        return false;
    }
}
