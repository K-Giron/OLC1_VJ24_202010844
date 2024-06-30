/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Length extends Instruccion {
    private Instruccion expresion;

    public Length(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //obtenemos el valor de la expresion
        var valor = expresion.interpretar(arbol, tabla);
        if (valor instanceof Errores) {
            return valor;
        }
        
        if (valor instanceof LinkedList) {
            //actualizar el tipo de la expresion
            this.tipo.setTipo(tipoDato.ENTERO);
            //devolver el tamaño de la lista
            return ((LinkedList)valor).size();
        }
        if (valor instanceof String ) {
            //actualizar el tipo de la expresion
            this.tipo.setTipo(tipoDato.ENTERO);
            //devolver el tamaño de la cadena
            return ((String)valor).length();
        }
        return new Errores("Semantico", "La funcion length solo acepta listas,vectores o cadenas", this.linea, this.col);
    }
}
        
