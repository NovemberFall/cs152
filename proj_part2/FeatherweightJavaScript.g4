grammar FeatherweightJavaScript;

@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE     : 'while' ;
FUNCTION  : 'function' ;
VAR       : 'var' ;
PRINT     : 'print' ;

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL      : ('true' | 'false');
NULL      : 'null';

// Symbols
MUL       : '*' ;
DIV       : '/' ;
ADD       : '+' ;
SUB       : '-' ;
MOD       : '%' ;

// Comparison
GREATER_THAN : '>' ;
LESS_THAN : '<' ;
GREATER_THAN_EQUAL_TO : '>=' ;
LESS_THAN_EQUAL_TO : '<=' ;
EQUAL_TO : '==';

SEPARATOR : ';' ;

//Identifiers
IDENTIFIER : ([a-zA-Z] | '_') ([a-zA-Z0-9] | '_')* ;

// Whitespace and comments
NEWLINE       : '\r'? '\n' -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;

// ***Parsing rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                    # bareExpr
    | IF '(' expr ')' block ELSE block                  # ifThenElse
    | IF '(' expr ')' block                             # ifThen
    | WHILE '(' expr ')' block                          # while
    | PRINT '(' expr ')' SEPARATOR                      # print
    ;

expr: expr op=( '*' | '/' | '%' ) expr                  # MulDivMod
    | expr op=( '+' | '-' ) expr                        # AddSub
    | expr op=( '>' | '<' | '>=' | '<=' | '==' ) expr   # comparison
    | '(' expr ')'                                      # parens
    | INT                                               # int
    | BOOL                                              # bool
    | NULL                                              # null
    | VAR IDENTIFIER ASGN expr                          # VarDecl
    | IDENTIFIER ASGN expr                              # VarAsgn
    | IDENTIFIER                                        # VarApp
    | FUNCTION '(' (expr)? (',' expr)* ')' block        # FuncDecl
    | IDENTIFIER '(' (expr)? (',' expr)* ')'            # FucApp
    ;

block: '{' stat* '}'                                    # fullBlock
    | stat                                              # simpBlock
    ;


