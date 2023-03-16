// See https://aka.ms/new-console-template for more information

using System.Net.Mime;
using Antlr4.Runtime;
using OrkLang.Runtime.Content;

namespace OrkLang.Runtime;

class Program
{
    public static void Main(string[] args)
    {
        var fileName = "Content/test.ork";
        var fileContents = File.ReadAllText(fileName);
        var inputStream = new AntlrInputStream(fileContents);

        var simpleLexer = new SimpleLexer(inputStream);
        var commonTokenStream = new CommonTokenStream(simpleLexer);
        var simpleParser = new SimpleParser(commonTokenStream);
        var context = simpleParser.program();
        var visitor = new SimpleVisitor();

        visitor.Visit(context);

        //for now we will just output it to the console
        //Console.WriteLine(result);
    }
}