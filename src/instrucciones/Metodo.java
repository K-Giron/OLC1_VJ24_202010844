/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import expresiones.Return;

import java.util.HashMap;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Metodo extends Instruccion {
    public String id;
    public LinkedList<HashMap> parametros;
    public LinkedList<Instruccion> instrucciones;

    public Metodo(String id, LinkedList<HashMap> parametros, LinkedList<Instruccion> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        for (var i : this.instrucciones) {
            var resultado = i.interpretar(arbol, tabla);
            //resultado instancia de errores
            if (resultado instanceof Errores) {
                return resultado;
            }
            //si llega break o continue
            if (resultado instanceof Break || resultado instanceof Continue) {
                return new Errores("SEMANTICO", "Sentencia fuera de ciclo", linea, col);
            }
            if (resultado instanceof Return) {
                if (((Return) resultado).valor == null) {
                    //hacer un return null
                    return null;
                }
                return resultado;
            }

            // return;
        }
        return null;
    }

    
}
