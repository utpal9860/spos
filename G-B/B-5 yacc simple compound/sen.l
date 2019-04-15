%{
%}
alpha [A-Za-z]
digit [0-9]
%%
[ \t\n]
and return AND;
or return OR;
but return BUT;
BUT return CBUT;
OR return COR;
AND return CAND;

{alpha}({alpha}|{digit})* return ID;

.  return yytext[0];
%%

