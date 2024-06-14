/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;

import abstracto.Instruccion;
import analizadores.parser;
import analizadores.scanner;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.tablaSimbolos;

/**
 *
 * @author kevin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String texto = """
            imprimir(\"Mi cadena\");
                //esto es un comentario
            imprimir(5); 
             imprimir(false || 5<=5);
                  //StrIng texto = \"Mi variable\";
                  var num2 : int = 10;
                  const nota2 : double = 20.6;
                /*esto es un comentario
                multilinea
                fdfs
                */
             imprimir(545); 
            imprimir(13.33$);
             imprimir(45); 
                            /*esto es un comentario
                            multilinea
                            fdfs
                            */
              imprimir(3.54);
            
            """;
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new tablaSimbolos();
            tabla.setNombre("GLOBAL");
            ast.setConsola("");
            //unir las listas de errores
            LinkedList<Errores> errores = new LinkedList<>();
            errores.addAll(s.listaErrores);
            errores.addAll(p.listaErrores);

            for (var a : ast.getInstrucciones()) {
                if (a == null) {
                    continue;
                }
                var res = a.interpretar(ast, tabla);
                if (res instanceof Errores) {
                    errores.add((Errores) res);
                }
            }
            System.out.println(ast.getConsola());
            
            //imprimir errores
            for (var e : errores) {
                System.out.println(e);
            }
            
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            System.out.println(ex);
        }


    }
    
}
