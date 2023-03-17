# OrkLangStable
Orklang (written in c#) with paired with antlr4 generators

**OrkLang Support**

**Comments**
```csharp
//comment goes here
```

**Notes:**
Most of the statements built-ins or variables must end with `;`
Member access is built-in but no functionality is currently supporting it; <br/> *example: `test.Do()`*

**Variable declaration**
```csharp
//Variable declaration is nothing that fancy
a = 5;
b = 10.5;
c = "hello";

//and then boolean
d = false;

print(convert(d)); //"false"
```

**Built-In functions**
```csharp
//print (with newLine)
print("hello " + "world!");

//write (with no newLine)
write("hello");

//readLine
x = readLine();

//convert has yet to be fully tested i'll list it anyway
x = convert("30"); /*OR*/ x = convert("3.4"); /*OR*/ x = convert("true");
```

**If statements**
```csharp
if (condition)
{
    print("true");
}
else if (condition)
{
    //do something else
}
else
{
    print("false");
}
```

**While & Until statements**
```csharp
/* The code technically supports `else if` also */
//while is a true based condition
while (condition)
{
    //do
}
//called if `condition` is never executed
else
{
    //do
}

//until is a false based condition
until(condition)
{
    do
}
//called if `condition` is never executed
else
{
    //do
}
```

**Known Issues**
* Multi-Line comments don't exist yet
* You can accidently override built-in functions if not careful
* scope is missing
* classes & namespaces are incomplete
* *The Language lacks basic identity*
  
**Planned functionality**
* Support for for() statements
* Multi-Line comments
* Sometype of functions