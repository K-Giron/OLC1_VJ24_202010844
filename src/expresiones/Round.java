/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Round extends Instruccion {
    private Instruccion expresion;

    public Round(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.DECIMAL), linea, col);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var valor = expresion.interpretar(arbol, tabla);
        if (valor instanceof Errores) {
            return valor;
        }
        if (expresion.tipo.getTipo() != tipoDato.DECIMAL) {
            return new Errores("Semantico", "La funcion round solo acepta valores decimales", this.linea, this.col);
        }
        return Math.round((double) valor);
    }
    
}
