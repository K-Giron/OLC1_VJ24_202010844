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
public class While extends Instruccion{
    private Instruccion expresion;
    private LinkedList<Instruccion> instrucciones;

    public While(Instruccion expresion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //creamos un nuevo entorno
        var newTabla = new tablaSimbolos(tabla);

        //validar la condicion -> Booleano
        var cond = this.expresion.interpretar(arbol, newTabla);
        if (cond instanceof Errores) {
            return cond;
        }

        if (this.expresion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion debe ser bool",
                    this.linea, this.col);
        }

        while ((boolean) this.expresion.interpretar(arbol, newTabla)) {
            //nuevo entorno
            var newTabla2 = new tablaSimbolos(newTabla);

            //ejecutar instrucciones
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    return i;
                }
                if (i instanceof Continue) {
                    return i;
                }
                var res = i.interpretar(arbol, newTabla2);
                if (res instanceof Errores) {
                    return res;
                }
                
            }
        }
        return null;
    }
    
}
