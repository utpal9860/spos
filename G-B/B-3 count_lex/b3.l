%{
#include<stdio.h>
int lines=0;
int words=0;
int chars=0;

%}
%%
\n {lines++;}
[^\n\t' ']+ {words++;chars=chars+yyleng;}

%%
void main()
{
	yyin=fopen("a.txt","r");
   yylex();
	printf("\nno of lines=%d",lines);
       printf("\nno of words=%d",words);

	printf("\nno of chars=%d",chars);
}
	int yywrap()
	{
		return(1);
	}
/*student@student-HCL-Desktop:~$ lex dipali.l
student@student-HCL-Desktop:~$ gcc lex.yy.c
student@student-HCL-Desktop:~$ ./a.out
hiwelcomepatternforrecognizingwordsinlexspecification
no of lines=3
no of words=6student@student-HCL-Desktop:~$ lex dipali.l*/


