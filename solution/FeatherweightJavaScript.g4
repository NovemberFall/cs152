grammar FeatherweightJavaScript;


@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE	  : 'while';
FUNCTION  : 'function';
VAR		  : 'var';
PRINT	  : 'print';

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL	  : 'true' | 'false';
NULL	  : 'null';
ID		  : [a-zA-Z_][a-zA-Z_0-9]*;

// Symbols
ADD   	      :  '+'  ;
SUB          :   '-'   ;
MUL          :  '*'  ;
DIV            :  '/'  ;
MOD 	      : '%' ;

// Comparison
GT		  : '>' ;
LT 		  : '<' ;
GE		  : '>=';
LE 		  : '<=';
EQ		  : '==';
ASSIGN 	  : '=' ;
SEPARATOR : ';' ;


// Whitespace and comments
NEWLINE   : '\r'? '\n' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace


// ***Paring rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                          # bareExpr
    | IF '(' expr ')' block ELSE block                         # ifThenElse
    | IF '(' expr ')' block                                              # ifThen
    | WHILE '(' expr ')' block 			        # while
    | PRINT '(' expr ')' SEPARATOR? 			# print
    | SEPARATOR											# empty
    ;

expr: expr op=( MUL | DIV | MOD ) expr                           # MulDivMod
	| expr op=( ADD | SUB ) expr 		        # AddSub
	| expr op=( LT | LE | GT | GE | EQ ) expr 	        # Comparison
	| FUNCTION argslist block 			       # FuncDecl
	| expr argscalllist 					      # FuncApp
	| VAR ID ASSIGN expr 			     # VarDecl
	| ID 						     # VarReference
	| ID ASSIGN expr 				    # VarAssign
            | INT                                               # int
            | BOOL 					# boolean
            | NULL 					# null
            | '(' expr ')'                                      # parens
            ;

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;

argslist: '(' (ID (',' ID)* )? ')' ;

argscalllist: '(' (expr (',' expr)* )? ')' ;
