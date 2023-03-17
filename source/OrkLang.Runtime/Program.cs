// See https://aka.ms/new-console-template for more information

using System.Net.Mime;
using System.Runtime.CompilerServices;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

class Program
{
    public static void Main(string[] args)
    {
        string version = "v0.0.6-alpha";
        bool isDebug = true;

        string filename;
        if (args.Length < 1)
        {
#if !DEBUG
            Console.Error.WriteLine("Usage: [OrkLang.Runtime.exe] <inputfile>");
            Environment.Exit(1);
#endif
        }

#if DEBUG
        filename = "Content/test.ork";
#else
        filename = args[0];
#endif

        var fileContents = File.ReadAllText(filename);
        var inputStream = new AntlrInputStream(fileContents);

        var errorListener = new OrkParserException();

        var simpleLexer = new SimpleLexer(inputStream);
        var commonTokenStream = new CommonTokenStream(simpleLexer);
        var simpleParser = new SimpleParser(commonTokenStream);



        var context = simpleParser.program();
        var visitor = new SimpleVisitor();

        visitor.Visit(context);


        //simpleParser.RemoveErrorListeners();
        //simpleParser.AddErrorListener(errorListener);
        //simpleParser.ErrorHandler = new BailErrorStrategy();

        //for now we will just output it to the console
        //Console.WriteLine(result);
    }
}

public class OrkParserException : BaseErrorListener
{
    public override void SyntaxError([NotNull] IRecognizer recognizer, [Nullable] IToken offendingSymbol, int line, int charPositionInLine, [NotNull] string msg, [Nullable] RecognitionException e)
    {
        base.SyntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
    }
}