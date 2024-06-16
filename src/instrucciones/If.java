/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import java.util.LinkedList;

import abstracto.Instruccion;
import simbolo.*;
import excepciones.Errores;

/**
 *
 * @author kevin
 */
public class If extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;
    private static boolean condicionEvaluada = false;

    public If(Instruccion condicion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }


    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores) {
            return cond;
        }

        // ver que cond sea booleano
        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "Expresion invalida",
                    this.linea, this.col);
        }

        var newTabla = new tablaSimbolos(tabla);
        boolean bandera = false;
        if (cond == tipoDato.NULL && If.condicionEvaluada==false) {
            bandera = true;
        }
        
        //bandera para ejecutar el else
        if (bandera ) {
            for (var i : this.instrucciones) {
                var resultado = i.interpretar(arbol, newTabla);
                //manejando el error de que no se haya retornado nada
                if (resultado instanceof Errores) {
                    return resultado;
                }
            }
        }
        try {
            //ejecutar el if
            if ((boolean) cond) {
                for (var i : this.instrucciones) {
                    If.condicionEvaluada = true;
                    var resultado = i.interpretar(arbol, newTabla);
                    //manejando el error de que no se haya retornado nada
                    if (resultado instanceof Errores) {
                        return resultado;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return null;

    }

}