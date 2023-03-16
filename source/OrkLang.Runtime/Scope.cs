using LLVMSharp;
using LLVMSharp.Interop;

namespace OrkLang.Runtime;

public class Scope
{
    private Dictionary<string, LLVMSharp.Value> Variables { get; } = new();

    private LLVMSharp.Function currentFunction;
    
    public Scope(LLVMSharp.Function currentFunction)
    {
        this.currentFunction = currentFunction;
    }
    
    public LLVMSharp.Value? GetVariable(string name)
    {
        if (Variables.TryGetValue(name, out var value))
        {
            return value;
        }

        return null;
    }
    
    public void SetVariable(string name, LLVMSharp.Value value)
    {
        Variables[name] = value;
    }
}