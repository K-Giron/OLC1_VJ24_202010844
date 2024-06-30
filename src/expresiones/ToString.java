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
public class ToString extends Instruccion {

    public ToString(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.CADENA), linea, col);
        this.expresion = expresion;
    }
    private Instruccion expresion;

    

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        
        Object valor = expresion.interpretar(arbol, tabla);
        
        if (valor == null) {
            return new Errores("SEMANTICO", "No se puede convertir a cadena un valor nulo", linea, col);
        }

        // swith para saber que tipo de dato es
        switch (expresion.getTipo().getTipo()) {
            case ENTERO:
                return valor.toString();
            case DECIMAL:
                return valor.toString();
            case BOOLEANO:
                return valor.toString();
            case CARACTER:
                return valor.toString();
            default:
                return new Errores("SEMANTICO", "No se puede convertir a cadena un valor de tipo " + expresion.getTipo().getTipo(), linea, col);
        }
    }
    
}
