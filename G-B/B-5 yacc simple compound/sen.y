%{
#include<stdio.h>
#include<stdlib.h>
%}
%token AND OR BUT CAND COR CBUT ID 

%%
S : ST {printf("Compound statement\n"); } 
ST 
	:ID AND ID'.'
	|ID OR ID'.'
        |ID BUT ID'.'
	|ID CAND ID'.'
	|ID COR ID'.'
	|ID CBUT ID'.'
    	;	

%%

#include "lex.yy.c"

main()
{

yyin=fopen("input.txt","r");  
 yyparse();   
fclose(yyin);
exit(0);
} 
int yywrap()  
{  
return 0;  
}  
yyerror(){
printf("simple statement\n");
}
