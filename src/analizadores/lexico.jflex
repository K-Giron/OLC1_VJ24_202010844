
package analizadores;

//importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import excepciones.Errores;


%%

//codigo de usuario
%{

    public LinkedList<Errores> listaErrores = new LinkedList<Errores>();

    

%}

%init{
    yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<Errores>();
%init}

//caracteristicas de jflex
%cup
%class scanner
%public
%line
%char
%column
%full
//%debug
%ignorecase

//simbolos del sistema
PAR1="("
PAR2=")"
CORCHE1="["
CORCHE2="]"
LLAVE1="{"
LLAVE2="}"
MAS="+"
MENOS="-"
POTENCIA="**"
MULTIPLICACION="*"
DIVISION="/"
MODULO="%"
IGUAL = "="
IGUALACION="=="
DIFERENTE="!="
MAYORQUE=">="
MENORQUE="<="
MAYOR=">"
MENOR="<"
OR="||"
AND="&&"
NOT="!"
XOR="^"
FINCADENA=";"
DOSPUNTOS=":"
FLECHA="=>"
BARRABAJA="_"
COMA=","
PUNTO="."





//expresiones regulares
BLANCOS=[\ \r\t\f\n]+
ENTERO=[0-9]+
DECIMAL=[0-9]+"."[0-9]+
ID = [a-zA-Z][a-zA-Z0-9_]*
CADENA = \"(\\.|[^\"\\])*\"
BOOLEANO="true"|"false"
MUTABILIDAD = "var"|"const"
CARACTER = [']([^\'])*[']
COMENTARIOSIMPLE= "//".*
COMENTARIOMULTIPLE= "/*"[^*]*"*"+([^/*][^*]*"*"+)*"/"


//palabras reservadas
IMPRIMIR="println"
IF="if"
ELSE="else"
FOR="for"
BREAK="break"
CONTINUE="continue"
WHILE="while"
DO = "do"
MATCH = "match"
VOID = "void"
STARTWITH = "start_with"
RETURN = "return"
LIST = "list"
NEW = "new"
APPEND = "append"
REMOVE = "remove"
ROUND = "round"
LENGTH = "length"
TOSTRING = "tostring"
FIND = "find"




INT = "int"
DOUBLE = "double"
STRING = "string"
CHAR = "char"
BOOL = "bool"


%%

<YYINITIAL> {IMPRIMIR} {return new Symbol(sym.IMPRIMIR, yyline, yycolumn,yytext());}
<YYINITIAL> {IF} {return new Symbol(sym.IF, yyline, yycolumn,yytext());}
<YYINITIAL> {ELSE} {return new Symbol(sym.ELSE, yyline, yycolumn,yytext());}
<YYINITIAL> {FOR} {return new Symbol(sym.FOR, yyline, yycolumn,yytext());}
<YYINITIAL> {BREAK} {return new Symbol(sym.BREAK, yyline, yycolumn,yytext());}
<YYINITIAL> {CONTINUE} {return new Symbol(sym.CONTINUE, yyline, yycolumn,yytext());}
<YYINITIAL> {WHILE} {return new Symbol(sym.WHILE, yyline, yycolumn,yytext());}
<YYINITIAL> {DO} {return new Symbol(sym.DO, yyline, yycolumn,yytext());}
<YYINITIAL> {MATCH} {return new Symbol(sym.MATCH, yyline, yycolumn,yytext());}
<YYINITIAL> {VOID} {return new Symbol(sym.VOID, yyline, yycolumn,yytext());}
<YYINITIAL> {STARTWITH} {return new Symbol(sym.STARTWITH, yyline, yycolumn,yytext());}
<YYINITIAL> {RETURN} {return new Symbol(sym.RETURN, yyline, yycolumn,yytext());}
<YYINITIAL> {LIST} {return new Symbol(sym.LIST, yyline, yycolumn,yytext());}
<YYINITIAL> {NEW} {return new Symbol(sym.NEW, yyline, yycolumn,yytext());}
<YYINITIAL> {APPEND} {return new Symbol(sym.APPEND, yyline, yycolumn,yytext());}
<YYINITIAL> {REMOVE} {return new Symbol(sym.REMOVE, yyline, yycolumn,yytext());}
<YYINITIAL> {ROUND} {return new Symbol(sym.ROUND, yyline, yycolumn,yytext());}
<YYINITIAL> {LENGTH} {return new Symbol(sym.LENGTH, yyline, yycolumn,yytext());}
<YYINITIAL> {TOSTRING} {return new Symbol(sym.TOSTRING, yyline, yycolumn,yytext());}
<YYINITIAL> {FIND} {return new Symbol(sym.FIND, yyline, yycolumn,yytext());}
<YYINITIAL> {INT} {return new Symbol(sym.INT, yyline, yycolumn,yytext());}
<YYINITIAL> {DOUBLE} {return new Symbol(sym.DOUBLE, yyline, yycolumn,yytext());}
<YYINITIAL> {STRING} {return new Symbol(sym.STRING, yyline, yycolumn,yytext());}
<YYINITIAL> {CHAR} {return new Symbol(sym.CHAR, yyline, yycolumn,yytext());}
<YYINITIAL> {BOOL} {return new Symbol(sym.BOOL, yyline, yycolumn,yytext());}



<YYINITIAL> {DECIMAL} {return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());}
<YYINITIAL> {ENTERO} {return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}
<YYINITIAL> {BOOLEANO} {return new Symbol(sym.BOOLEANO, yyline, yycolumn,yytext());}
<YYINITIAL> {MUTABILIDAD} {return new Symbol(sym.MUTABILIDAD, yyline, yycolumn,yytext());}
<YYINITIAL> {ID} {return new Symbol(sym.ID, yyline, yycolumn,yytext());}

<YYINITIAL> {CADENA} {
    String cadena = yytext();
    cadena = cadena.substring(1, cadena.length()-1);
    return new Symbol(sym.CADENA, yyline, yycolumn,cadena);
    }

<YYINITIAL> {CARACTER} {
    String caracter = yytext();
    caracter = caracter.substring(1, caracter.length()-1);
    return new Symbol(sym.CARACTER, yyline, yycolumn,caracter);
    }

<YYINITIAL> {FINCADENA} {return new Symbol(sym.FINCADENA, yyline, yycolumn,yytext());}
<YYINITIAL> {DOSPUNTOS} {return new Symbol(sym.DOSPUNTOS, yyline, yycolumn,yytext());}
<YYINITIAL> {PAR1} {return new Symbol(sym.PAR1, yyline, yycolumn,yytext());}
<YYINITIAL> {PAR2} {return new Symbol(sym.PAR2, yyline, yycolumn,yytext());}
<YYINITIAL> {CORCHE1} {return new Symbol(sym.CORCHE1, yyline, yycolumn,yytext());}
<YYINITIAL> {CORCHE2} {return new Symbol(sym.CORCHE2, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAVE1} {return new Symbol(sym.LLAVE1, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAVE2} {return new Symbol(sym.LLAVE2, yyline, yycolumn,yytext());}

<YYINITIAL> {MAS} {return new Symbol(sym.MAS, yyline, yycolumn,yytext());}
<YYINITIAL> {MENOS} {return new Symbol(sym.MENOS, yyline, yycolumn,yytext());}
<YYINITIAL> {POTENCIA} {return new Symbol(sym.POTENCIA, yyline, yycolumn,yytext());}
<YYINITIAL> {MULTIPLICACION} {return new Symbol(sym.MULTIPLICACION, yyline, yycolumn,yytext());}
<YYINITIAL> {DIVISION} {return new Symbol(sym.DIVISION, yyline, yycolumn,yytext());}
<YYINITIAL> {MODULO} {return new Symbol(sym.MODULO, yyline, yycolumn,yytext());}
<YYINITIAL> {IGUAL} {return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());}
<YYINITIAL> {IGUALACION} {return new Symbol(sym.IGUALACION, yyline, yycolumn,yytext());}
<YYINITIAL> {DIFERENTE} {return new Symbol(sym.DIFERENTE, yyline, yycolumn,yytext());}
<YYINITIAL> {MAYORQUE} {return new Symbol(sym.MAYORQUE, yyline, yycolumn,yytext());}
<YYINITIAL> {MENORQUE} {return new Symbol(sym.MENORQUE, yyline, yycolumn,yytext());}
<YYINITIAL> {MAYOR} {return new Symbol(sym.MAYOR, yyline, yycolumn,yytext());}
<YYINITIAL> {MENOR} {return new Symbol(sym.MENOR, yyline, yycolumn,yytext());}
<YYINITIAL> {OR} {return new Symbol(sym.OR, yyline, yycolumn,yytext());}
<YYINITIAL> {AND} {return new Symbol(sym.AND, yyline, yycolumn,yytext());}
<YYINITIAL> {NOT} {return new Symbol(sym.NOT, yyline, yycolumn,yytext());}
<YYINITIAL> {XOR} {return new Symbol(sym.XOR, yyline, yycolumn,yytext());}
<YYINITIAL> {FLECHA} {return new Symbol(sym.FLECHA, yyline, yycolumn,yytext());}
<YYINITIAL> {BARRABAJA} {return new Symbol(sym.BARRABAJA, yyline, yycolumn,yytext());}
<YYINITIAL> {COMA} {return new Symbol(sym.COMA, yyline, yycolumn,yytext());}
<YYINITIAL> {PUNTO} {return new Symbol(sym.PUNTO, yyline, yycolumn,yytext());}



<YYINITIAL> {BLANCOS} {}
<YYINITIAL> {COMENTARIOSIMPLE} {}
<YYINITIAL> {COMENTARIOMULTIPLE} {}



<YYINITIAL> . { listaErrores.add(new Errores("LEXICO", "El caracter "+yytext()+" no pertence al lenguaje", yyline, yycolumn));}