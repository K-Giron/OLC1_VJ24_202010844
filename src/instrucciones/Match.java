/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Casos;
import abstracto.Instruccion;
import java.util.LinkedList;

import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Match extends Instruccion {
    private Instruccion expresion;
    private LinkedList<Casos> casos;
    private Casos defecto;

    
    public Match(Instruccion expresion, LinkedList<Casos> casos,Casos defecto, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.casos = casos;
        this.defecto = defecto;
    }



    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var newTabla = new tablaSimbolos(tabla);
        boolean bandera = false;

        //recorrer los casos y ver si alguno coincide con la expresion
        for (var c : this.casos) {
            var exp = this.expresion.interpretar(arbol, tabla);
            var caso = c.getExpresion().interpretar(arbol, tabla);
            if (exp instanceof Errores) {
                return exp;
            }
            if (caso instanceof Errores) {
                return caso;
            }
            if (exp.equals(caso)) {
                for (var i : c.getInstrucciones()) {
                    if (i instanceof Break) {
                        return i;
                    }
                    if (i instanceof Continue) {
                        return i;
                    }
                    var resultado = i.interpretar(arbol, newTabla);
                    if (resultado instanceof Errores) {
                        return resultado;
                    }
                    if ( resultado instanceof Break || resultado instanceof Continue) {
                        return resultado;
                    }
                }
                bandera = true;
            }
        }

        //si no se encontro ningun caso que coincida con la expresion
        if (!bandera) {
            for (var i : this.defecto.getInstrucciones()) {
                if (i instanceof Break) {
                    return i;
                }
                if (i instanceof Continue) {
                    return i;
                }
                var resultado = i.interpretar(arbol, newTabla);
                if (resultado instanceof Errores) {
                    return resultado;
                }
                if ( resultado instanceof Break || resultado instanceof Continue) {
                    return resultado;
                }
            }
        }


        return null;
    }
    
    
}
