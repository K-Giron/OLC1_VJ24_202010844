/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author kevin
 */
public class AccesoVec extends Instruccion {
    private String id;
    private Instruccion index1;
    private Instruccion index2;

    public AccesoVec(String id, Instruccion index1, Instruccion index2, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //buscar el vector
        var vector = tabla.getVariable(this.id);
        if (vector == null) {
            return new Errores("SEMANTICA", "Vector no existente",
                    this.linea, this.col);
        }
        if (index2 == null) {
            //acceder a la lista de valores en la posicion del index
            var posicion1 = this.index1.interpretar(arbol, tabla);
            if (posicion1 instanceof Errores) {
                return posicion1;
            }
            //verificar que el index sea un entero
            if (this.index1.tipo.getTipo() != tipoDato.ENTERO) {
                return new Errores("SEMANTICO", "Posicion de arreglo no existe",
                        this.linea, this.col);
            }
            //acceder a la linkedlist vector.valor
            var lista = (LinkedList) vector.getValor();
            //verificar que el index sea menor al tamaño de la lista
            if ((int) posicion1 >= lista.size()) {
                return new Errores("SEMANTICO", "Posición de arreglo fuera de rango",
                        this.linea, this.col);
            }
            this.tipo.setTipo(vector.getTipo().getTipo());
            //obtener el valor en la posicion del index
            return lista.get((int) posicion1);
            
        }else{
            
            //acceder a la lista de valores en la posicion del index
            var posicion1 = this.index1.interpretar(arbol, tabla);
            var posicion2 = this.index2.interpretar(arbol, tabla);
            if (posicion1 instanceof Errores) {
                return posicion1;
            }
            if (posicion2 instanceof Errores) {
                return posicion2;
            }
            //verificar que el index sea un entero
            if (this.index1.tipo.getTipo() != tipoDato.ENTERO) {
                return new Errores("SEMANTICO", "Posicion de arreglo no existe",
                        this.linea, this.col);
            }
            if (this.index2.tipo.getTipo() != tipoDato.ENTERO) {
                return new Errores("SEMANTICO", "Posicion de arreglo no existe",
                        this.linea, this.col);
            }
            //acceder a la linkedlist de linkedlists en vector.valor
            var lista = (LinkedList) vector.getValor();
            //verificar que el index no sea mayor al tamaño de la lista
            if ((int) posicion1 >= lista.size()) {
                return new Errores("SEMANTICO", "Posición de arreglo fuera de rango",
                        this.linea, this.col);
            }
            //acceder a la linkedlist en la posicion del index
            var lista2 = (LinkedList) lista.get((int) posicion1);
            //verificar que el index sea menor al tamaño de la lista
            if ((int) posicion2 >= lista2.size()) {
                return new Errores("SEMANTICO", "Posición de arreglo fuera de rango",
                        this.linea, this.col);
            }
            this.tipo.setTipo(vector.getTipo().getTipo());
            //obtener el valor en la posicion del index
            return lista2.get((int) posicion2);
        }
        
    }
    
}
