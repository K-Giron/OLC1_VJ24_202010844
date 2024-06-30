/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import java.util.LinkedList;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author kevin
 */
public class Find extends Instruccion {
    private String id;
    private Instruccion expresion;

    public Find(String id, Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.id = id;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // Buscar el id en la tabla de simbolos
        Object valor = tabla.getVariable(id);
        if (valor == null) {
            return new Errores("SEMANTICO", "No se ha encontrado la lista o arreglo para el find" + id, linea, col);
        }

        // interpretar la expresion
        Object valorExpresion = expresion.interpretar(arbol, tabla);
        if (valorExpresion == null) {
            return new Errores("SEMANTICO", "No se puede buscar un valor nulo", linea, col);
        }

        //acceder a la lista o arreglo
        var lista = (LinkedList) (((Simbolo)valor).getValor());
        //verificar en un posible arreglo de doss dimensiones
        if (lista.get(0) instanceof LinkedList) {
            for (Object object : lista) {
                if (((LinkedList)object).contains(valorExpresion)) {
                    return true;
                }
            }
            return false;
        }
        //verificar si la expresion existe en la lista o arreglo
        if (lista.contains(valorExpresion)) {
            return true;
        }else{
            return false;
        }
    }
    
}
