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
                var a:int=10;
                           println(\"prueba else\");
                         println(a);
                 var b:bool=false;
                 var c:bool=false;
                 if(b){
                  var a:int=20;
                  println(a);
                  }else if(c){
                      var a:int=30;
                      println(a);
                           println(\"prueba else 2\");
                    }else{
                           println(\"prueba else 3\");
                    }
                  
                
                  println(a);
                  println(c);

                /*esto es un comentario
                multilinea
                fdfs
                            var TEXTO:StrIng  = \"Mi variable\";
                                             var nUm2 : dOuBLE = 10.20;  
                                             const NUM3: int=20;
                                             var numeroPRueba:int;
                                              println(numeroPRueba);
                                             var numeroDOUble:double;
                                             numeroPRueba=numeroPRueba+10;
                                             println(numeroprueba+25);
                */

            
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
            
            //println errores
            for (var e : errores) {
                System.out.println(e);
            }
            
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            System.out.println(ex);
        }


    }
    
}
