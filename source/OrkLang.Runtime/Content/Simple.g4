grammar Simple;

program: line* EOF;

line: statement | ifBlock | whileBlock | tryCatchBlock | funcBlock | namespaceBlock | constructorBlock | classBlock | block;

statement: (assignment | functionCall) ';'; //importBlock |

ifBlock: 'if' '(' expression ')' block ('else' elseIfBlock)?;

elseIfBlock: block | ifBlock;

whileBlock: WHILE '(' expression ')' block ('else' elseIfBlock);
forBlock: 'for' '(' assignment ';' expression ';' expression ')' block;

namespaceBlock: 'namespace' IDENTIFIER block;
constructorBlock: 'constructor' IDENTIFIER block;
classBlock: 'class' IDENTIFIER block;

funcBlock: 'func' IDENTIFIER '(' (IDENTIFIER (',' IDENTIFIER)*)? ')' block;

tryCatchBlock: 'try' block 'catch' block; //eventually support exceptions

//importBlock: 'import' filename=STRING_LITERAL;

//what goes into a ternay block exactly
//TernayOperatorBlock: expression '?' STRING ':' STRING ';';

WHILE: 'while' | 'until';

//function Keywords (Cannot be overwritten)
//Print: 'print';
//Write: 'write';
//ReadLine: 'readLine';

assignment: IDENTIFIER '=' expression;

functionCall: IDENTIFIER '(' (expression (',' expression)*)? ')';

//inlineBlock: 'inline' '{{' csharpCode '}}';

//csharpCode: .*?;

expression
    : constant                          #constantExpression
    | IDENTIFIER                        #identifierExpression
    | functionCall                      #functionCallExpression
    | '(' expression ')'                #parenthesizedExpression
    | '!' expression                    #notExpression
    | expression increment              #incrementDecrementExpression //i++ //note expression(i) increment expression(i) doesnt work we need increment expression increment
    | expression multOp expression      #multiplicativeExpression
    | expression addOp expression       #additiveExpression
    | expression compareOp expression   #comparisonExpression
    | expression boolOp expression      #booleanExpression
    ;

memberAccess
    : IDENTIFIER '.' IDENTIFIER '(' argumentList? ')' #methodCallExpression
    | IDENTIFIER '.' IDENTIFIER                       #fieldCallExpression
    ;

argumentList
    : expression ('.' expression)*
    ;

increment: '++' | '--';
multOp: '*' | '/' | '%';
addOp: '+' | '-';
compareOp: '==' | '!=' | '>' | '<' | '>=' | '<=';
boolOp: BOOL_OPERATOR;
//&&, ||, ^, ~
BOOL_OPERATOR: 'and' | 'or' | 'xor' | '&&' | '||' | '^';

constant: INTEGER | FLOAT | STRING | BOOL | NULL;

INTEGER: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');
BOOL: 'true' | 'false';
NULL: 'null';

SEMICOLON: ';';

STRING_LITERAL 
 : '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"'
 ;

block: '{' line* '}';

WS: [ \t\r\n]+ -> skip;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

//Comments
SL_Comment: '//' CommentLine* -> skip;
fragment CommentLine: ~[\\\r\n] | Escape;

ML_Comment: '/*' .*? '*/' -> skip;

fragment Escape: '\\\'' | '\\"' | '\\\\' | '\\n' | '\\r';