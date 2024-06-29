/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import java.util.LinkedList;

import abstracto.Instruccion;
import simbolo.*;
import excepciones.Errores;
import analizadores.*;
import expresiones.Return;

/**
 *
 * @author kevin
 */
public class If extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;
    private LinkedList<Instruccion> instruccionesElse;
    private Instruccion elseIfInstruccion;



    public If(Instruccion condicion, LinkedList<Instruccion> instrucciones, LinkedList<Instruccion> instruccionesElse, Instruccion elseIfInstruccion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.instruccionesElse = instruccionesElse;
        this.elseIfInstruccion = elseIfInstruccion;
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
        if ((boolean) cond) {
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    return i;
                }
                if (i instanceof Continue) {
                    return i;
                }
                if (i instanceof Return) {
                    return i;
                }
                var resultado = i.interpretar(arbol, newTabla);
                if (resultado instanceof Break) {
                    return resultado;
                }
                if (resultado instanceof Continue) {
                    return resultado;
                }
                
                if (resultado instanceof Return) {
                    return resultado;
                }

                if (resultado instanceof Errores) {
                    return resultado;
                }
                
            }
        }else{
            if(this.instruccionesElse != null){
                for (var i : this.instruccionesElse) {
                    if (i instanceof Break) {
                        return i;
                    }
                    if (i instanceof Continue) {
                        return i;
                    }
                    if (i instanceof Return) {
                        return i;
                    }
                    var resultado = i.interpretar(arbol, newTabla);
                    if (resultado instanceof Break) {
                        return resultado;
                    }
                    if (resultado instanceof Continue) {
                        return resultado;
                    }
                    if (resultado instanceof Return) {
                        return resultado;
                    }
                    if (resultado instanceof Errores) {
                        return resultado;
                    }
                }
            }

            if (this.elseIfInstruccion != null) {
                var res = this.elseIfInstruccion.interpretar(arbol, tabla);
                if (res instanceof Errores) {
                    return res;
                }
            }
        } 
        return null;

    }

}