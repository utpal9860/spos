

%{
%}
alpha [A-Za-z]
digit [0-9]
%%
[ \t\n]
int return INT;
short return SHORT;
float return FLOAT;
long return LONG;
double return DOUBLE;
char return CHAR;
String return STRING;
{digit}+ return NUM;
[0-9]+.[0-9]* return FNUM;
"public" return PUBLIC;
"private" return PRIVATE;
"protected" return PROTECTED;
alpha return AL;
{alpha}({alpha}|{digit})* return ID;

"=" return EQ;

.  return yytext[0];
%%



