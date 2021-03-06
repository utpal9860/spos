%{
#include<stdio.h>
%}

%%

public |
static |
class  |
double |
int    |
break  |
void       {printf("%s is keyword",yytext);}

[0-9]+   {printf("%s is literal",yytext);}

[a-zA-Z]([a-zA-Z]|[0-9]|'_')*  {printf("%s is identifier",yytext);}

%%


void main()
{
yyin=fopen("b2.java","r");
yylex();
}

yywrap()
{

}

/* output
student@student-Veriton-Series:~/Desktop/sanchaya/G-B/lex token generation$ lex j.l
student@student-Veriton-Series:~/Desktop/sanchaya/G-B/lex token generation$ gcc lex.yy.c
j.l:28:1: warning: return type defaults to ‘int’ [-Wimplicit-int]
 yywrap()
 ^
student@student-Veriton-Series:~/Desktop/sanchaya/G-B/lex token generation$ ./a.out b2.java
class is keyword 
b2 is identifier	
public is keyword 
static is keyword 
void is keyword
main is identifier  
23 is literal


*/
