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
GT        : '>' ;
LT        : '<' ;
GTE       : '>=';
LTE       : '<=';
EQ        : '==';

SEPARATOR : ';' ;

// Variable stuff
ASGN       : '=' ;
IDENTIFIER : ([a-zA-Z] | '_') ([a-zA-Z0-9] | '_')* ; 

// Whitespace and comments
NEWLINE       : '\r'? '\n' -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;

// ***Parsing rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                   # bareExpr
   | IF '(' expr ')' block ELSE block                  # ifThenElse
   | IF '(' expr ')' block                             # ifThen
   | WHILE '(' expr ')' block                          # while
   | PRINT '(' expr ')' SEPARATOR                      # print
   ;

expr: expr op=( '*' | '/' | '%' ) expr                 # MultiplyDivisionModulus
   | expr op=( '+' | '-' ) expr                        # AdditionSubtraction
   | expr op=( '>' | '<' | '>=' | '<=' | '==' ) expr   # comparison
   | '(' expr ')'                                      # parens
   | INT                                               # integer
   | BOOL                                              # boolean
   | NULL                                              # null
   | VAR IDENTIFIER ASGN expr                          # VarDecl
   | IDENTIFIER ASGN expr                              # VarAsgn
   | IDENTIFIER                                        # VarApp
   | FUNCTION '(' (expr)? (',' expr)* ')' block        # FuncDecl
   | IDENTIFIER '(' (expr)? (',' expr)* ')'            # FuncApp
   ;

block: '{' stat* '}'                                   # fullBlock
   | stat                                              # simpBlock
   ;
