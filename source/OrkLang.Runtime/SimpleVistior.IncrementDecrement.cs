using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime.Misc;
using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

public partial class SimpleVisitor
{
    public override object VisitIncrementDecrementExpression([NotNull] SimpleParser.IncrementDecrementExpressionContext context)
    {
        var left = Visit(context.expression());
        var op = context.increment().GetText();
       // object? right = null;

       // if (context.expression(1) != null)
        //    right = Visit(context.expression(1));
        //var op = Visit(context);

        //TODO: Create diagnosics bag eventually
        //var exception = context.exception;

        return op switch
        {
            "++" => Increment(left/*, right*/),
            "--" => Decrement(left/*, right*/),
            _ => throw new NotImplementedException()
        }; ;
        //return base.VisitIncrementDecrementExpression(context);
    }

    private object? Increment(object? left/*, object? right*/)
    {
        //left
        if (left is int)
        {
            var val = (int)left;
            return (val += 1);
        }

        if (left is float)
        {
            var val = (float)left;
            return (val += 1);
        }

        /*
        if (right != null)
        {
            //right

            if (right is int)
            {
                var val = (int)right;
                return (++val);
            }

            if (right is float)
            {
                var val = (int)right;
                return (++val);
            }
        }
        */

       // if (right == null)
            throw new Exception($"Cannot increment values of types {left?.GetType()}");
        //else
        //    throw new Exception($"Cannot increment values of types {right?.GetType()}");
    }

    private object? Decrement(object? left/*, object? right*/)
    {
        //left
        if (left is int)
        {
            var val = (int)left;
            return (val -= 1);
        }

        if (left is float)
        {
            var val = (float)left;
            return (val -= 1);
        }
        /*

        if (right != null)
        {
            //right

            if (right is int)
            {
                var val = (int)right;
                return (--val);
            }

            if (right is float)
            {
                var val = (float)right;
                return (--val);
            }
        }
        */

        //if (right == null)
            throw new Exception($"Cannot increment values of types {left?.GetType()}");
        //else
          //  throw new Exception($"Cannot increment values of types {right?.GetType()}");
    }
}
