/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import java.util.LinkedList;
import abstracto.Instruccion;
import excepciones.Errores;
import expresiones.Return;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class DoWhile extends Instruccion{
    private Instruccion expresion;
    private LinkedList<Instruccion> instrucciones;

    public DoWhile(Instruccion expresion, LinkedList<Instruccion> instrucciones, int linea, int col) {
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

        do {
            //nuevo entorno
            var newTabla2 = new tablaSimbolos(newTabla);

            //ejecutar instrucciones
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    return null;
                }
                if (i instanceof Continue) {
                    break;
                }
                if (i instanceof Return) {
                    return i;
                }
                var res = i.interpretar(arbol, newTabla2);
                if (res instanceof Break) {
                    return null;
                }
                if (res instanceof Continue) {
                    break;
                }
                if (res instanceof Return) {
                    return res;
                }
                if (res instanceof Errores) {
                    return res;
                }

            }
        } while ((boolean) this.expresion.interpretar(arbol, newTabla));

        return null;
    }
    
}
