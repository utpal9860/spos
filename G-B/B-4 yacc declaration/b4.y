
%{

#include<stdio.h>
#include<stdlib.h>
%}
%token ID PUBLIC PRIVATE PROTECTED INT SHORT  FLOAT LONG DOUBLE CHAR STRING FNUM NUM EQ AL
%right '='
%%

S 	: ST {printf("input accepted\n"); exit(0);}

ST 	:E2 ';'
	|E ';'
    ;
E 	:
         INT ID EQ NUM
	|FLOAT ID EQ FNUM
	|CHAR ID EQ AL
	|LONG ID EQ NUM
	|DOUBLE ID EQ FNUM
	|SHORT ID EQ NUM
        |INT ID
	|FLOAT ID
	|CHAR ID
	|LONG ID
	|DOUBLE ID
	|SHORT ID
	;
E2 	:PUBLIC E
	|PRIVATE E
	|PROTECTED E
	;
%%

#include "lex.yy.c"
void main()
{
printf("enter the exp: ");
yyparse();
}

int yywrap()
{
return 0;
}
yyerror()
{
printf("parse error\n");
}
/*else
{
printf("Input accepted");
}*/

/* ************output****************
[student@localhost ~]$ lex if.l
[student@localhost ~]$ yacc -d datatype.y
[student@localhost ~]$ gcc y.tab.c
[student@localhost ~]$ ./a.out
enter the exp: 
int a=5;
input accepted
[student@localhost ~]$ ./a.out
enter the exp: int a=5.5;         
parse error
[student@localhost ~]$ ./a.out
enter the exp: 
public int a=5;
input accepted
********************** */


