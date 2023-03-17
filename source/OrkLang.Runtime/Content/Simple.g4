grammar Simple;

program: line* EOF;

line: statement | ifBlock | whileBlock | funcBlock | namespaceBlock | constructorBlock | classBlock | block;

statement: (assignment | functionCall) ';';

ifBlock: 'if' '(' expression ')' block ('else' elseIfBlock)?;

elseIfBlock: block | ifBlock;

whileBlock: WHILE '(' expression ')' block ('else' elseIfBlock);

namespaceBlock: 'namespace' IDENTIFIER block;
constructorBlock: 'constructor' IDENTIFIER block;
classBlock: 'class' IDENTIFIER block;

funcBlock: 'func' IDENTIFIER '(' (IDENTIFIER (',' IDENTIFIER)*)? ')' block;

WHILE: 'while' | 'until';

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

multOp: '*' | '/' | '%';
addOp: '+' | '-';
compareOp: '==' | '!=' | '>' | '<' | '>=' | '<=';
boolOp: BOOL_OPERATOR;

BOOL_OPERATOR: 'and' | 'or' | 'xor';

constant: INTEGER | FLOAT | STRING | BOOL | NULL;

INTEGER: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');
BOOL: 'true' | 'false';
NULL: 'null';

block: '{' line* '}';

WS: [ \t\r\n]+ -> skip;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

//Comments
Comment: '//' CommentLine* -> skip;
fragment CommentLine: ~[\\\r\n] | Escape;

fragment Escape: '\\\'' | '\\"' | '\\\\' | '\\n' | '\\r';
