/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import java.util.LinkedList;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Else extends Instruccion {
    private LinkedList<Instruccion> instrucciones;

    public Else(LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.instrucciones = instrucciones;
    }


    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var newTabla = new tablaSimbolos(tabla);
        for (var i : this.instrucciones) {
            if (i instanceof Break) {
                return i;
            }
            if (i instanceof Continue) {
                return i;
            }
            var resultado = i.interpretar(arbol, newTabla);
            if (resultado instanceof Break) {
                return resultado;
            }
            if (resultado instanceof Continue) {
                return resultado;
            }
            if (resultado instanceof Errores) {
                return resultado;
            }
        }
        return null;
    }
    
}
