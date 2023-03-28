grammar Simple;

// Lexer Part

// tokens
SEMICOLON: ';';

INTEGER: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');

BOOL: 'true' | 'false';
NULL: 'null';
WHILE: 'while' | 'until';

// Keywords
IF: 'if';
ELSE: 'else';
FOR: 'for';
NAMESPACE: 'namespace';
CONSTRUCTOR: 'constructor';
CLASS: 'class';
FUNC: 'func';
TRY: 'try';
CATCH: 'catch';

// Operators
MULT_OP: '*' | '/' | '%';
ADD_OP: '+' | '-';
COMPARE_OP: '==' | '!=' | '>' | '<' | '>=' | '<=';
BOOL_OP: 'and' | 'or' | 'xor' | '&&' | '||' | '^';

// Tokens with actions
STRING_LITERAL: '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"';
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

// Ignored tokens
WS: [ \t\r\n]+ -> skip;
SL_Comment: '//' ~[\r\n]* -> skip;
ML_Comment: '/*' .*? '*/' -> skip;

// Parser Part
program: line* EOF;

line: statement | ifBlock | whileBlock | tryCatchBlock | funcBlock | namespaceBlock | constructorBlock | classBlock | block;

statement: (assignment | functionCall) SEMICOLON; //importBlock |

ifBlock: IF '(' expression ')' block (ELSE elseIfBlock)?;

elseIfBlock: block | ifBlock;

whileBlock: WHILE '(' expression ')' block (ELSE elseIfBlock);
forBlock: FOR '(' assignment ';' expression ';' expression ')' block;

namespaceBlock: NAMESPACE IDENTIFIER block;
constructorBlock: CONSTRUCTOR IDENTIFIER block;
classBlock: CLASS IDENTIFIER block;

funcBlock: FUNC IDENTIFIER '(' (IDENTIFIER (',' IDENTIFIER)*)? ')' block;

tryCatchBlock: TRY block CATCH block; //eventually support exceptions

//importBlock: 'import' filename=STRING_LITERAL;

//what goes into a ternay block exactly
//TernayOperatorBlock: expression '?' STRING ':' STRING ';';



//function Keywords (Cannot be overwritten)
//Print: 'print';
//Write: 'write';
//ReadLine: 'readLine';

assignment: IDENTIFIER '=' expression;

functionCall: IDENTIFIER '(' (expression (',' expression)*)? ')';

expression
    : constant                          #constantExpression
    | IDENTIFIER                        #identifierExpression
    | functionCall                      #functionCallExpression
    | '(' expression ')'                #parenthesizedExpression
    | '!' expression                    #notExpression
    | expression increment              #incrementDecrementExpression //i++ //note expression(i) increment expression(i) doesnt work we need increment expression increment
    | expression MULT_OP expression      #multiplicativeExpression
    | expression ADD_OP expression       #additiveExpression
    | expression COMPARE_OP expression   #comparisonExpression
    | expression BOOL_OP expression      #booleanExpression
    ;

memberAccess
    : IDENTIFIER '.' IDENTIFIER '(' argumentList? ')' #methodCallExpression
    | IDENTIFIER '.' IDENTIFIER                       #fieldCallExpression
    ;

argumentList
    : expression ('.' expression)*
    ;

increment: '++' | '--';


constant: INTEGER | FLOAT | STRING | BOOL | NULL;

BOOL_OPERATOR: BOOL_OP;

block: '{' line* '}';

fragment Escape: '\\\'' | '\\"' | '\\\\' | '\\n' | '\\r';