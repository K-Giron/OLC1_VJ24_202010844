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
public class AccesoList extends Instruccion {
    private String id;
    private Instruccion index;

    public AccesoList(String id, Instruccion index, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.index = index;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        //buscar la lista
        var lista = tabla.getVariable(this.id);
        if (lista == null) {
            return new Errores("SEMANTICA", "Variable no existente",
                    this.linea, this.col);
        }
        //acceder a la lista de valores en la posicion del index
        var posicion = this.index.interpretar(arbol, tabla);
        if (posicion instanceof Errores) {
            return posicion;
        }
        //verificar que el index sea un entero
        if (this.index.tipo.getTipo() != tipoDato.ENTERO) {
            return new Errores("SEMANTICO", "Posicion de lista no existe",
                    this.linea, this.col);
        }
        //acceder a la linkedlist lista.valor
        var linkedList = (LinkedList) lista.getValor();
        //verificar que el index sea menor al tamaño de la lista
        if ((int) posicion >= linkedList.size()) {
            return new Errores("SEMANTICO", "Posición de lista fuera de rango",
                    this.linea, this.col);
        }
        this.tipo.setTipo(lista.getTipo().getTipo());
        //obtener el valor en la posicion del index
        return linkedList.get((int) posicion);
    }
    
}
