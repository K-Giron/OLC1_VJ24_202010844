/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class AsignacionVec extends Instruccion {
    private String id;
    private Instruccion expresion;
    private Instruccion index;
    private Instruccion index2;

    public AsignacionVec(String id, Instruccion expresion, Instruccion index, Instruccion index2, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expresion = expresion;
        this.index = index;
        this.index2 = index2;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //arreglo exista
        var arreglo = tabla.getVariable(id);
        if(arreglo == null){
            return new Errores("Semantico", "El arreglo no existe", this.linea, this.col);
        }
        //verificar si el arreglo es mutable
        if (!arreglo.getMutabilidad()) {
            return new Errores("Semantico", "El arreglo es constante", this.linea, this.col);
        }

        if (this.index2 == null) {
            //obtener el indice
            var indice = index.interpretar(arbol, tabla);
            if (indice instanceof Errores) {
                return indice;
            }
            //validar el tipo del indice
            if (this.index.tipo.getTipo() != tipoDato.ENTERO) {
                return new Errores("Semantico", "El indice debe ser de tipo entero", this.linea, this.col);
            }
            //interpretar la expresion
            var newValor = expresion.interpretar(arbol, tabla);
            if (newValor instanceof Errores) {
                return newValor;
            }
            //validar si los tipos coinciden
            if (arreglo.getTipo().getTipo() != expresion.tipo.getTipo()) {
                return new Errores("Semantico", "El tipo de la variable no coincide con el valor asignado", this.linea, this.col);
            }
            //asignar el tipo
            this.tipo.setTipo(arreglo.getTipo().getTipo());
            //asignar el nuevo valor al arreglo
            var lista = (LinkedList) arreglo.getValor();
            if ((int) indice >= lista.size()) {
                return new Errores("Semantico", "Posición de arreglo fuera de rango", this.linea, this.col);
            }
            lista.set((int) indice, newValor);
        } else {
            //obtener el indice
            var indice = index.interpretar(arbol, tabla);
            var indice2 = index2.interpretar(arbol, tabla);
            if (indice instanceof Errores) {
                return indice;
            }
            if (indice2 instanceof Errores) {
                return indice2;
            }
            //validar el tipo del indice
            if (this.index.tipo.getTipo() != tipoDato.ENTERO) {
                return new Errores("Semantico", "El indice debe ser de tipo entero", this.linea, this.col);
            }
            if (this.index2.tipo.getTipo() != tipoDato.ENTERO) {
                return new Errores("Semantico", "El indice debe ser de tipo entero", this.linea, this.col);
            }
            //interpretar la expresion
            var newValor = expresion.interpretar(arbol, tabla);
            if (newValor instanceof Errores) {
                return newValor;
            }
            //validar si los tipos coinciden
            if (arreglo.getTipo().getTipo() != expresion.tipo.getTipo()) {
                return new Errores("Semantico", "El tipo de la variable no coincide con el valor asignado", this.linea, this.col);
            }
            //asignar el tipo
            this.tipo.setTipo(arreglo.getTipo().getTipo());
            //asignar el nuevo valor al arreglo
            var lista = (LinkedList) arreglo.getValor();
            if ((int) indice >= lista.size() || (int) indice2 >= lista.size()) {
                return new Errores("Semantico", "Posición de arreglo fuera de rango", this.linea, this.col);
            }
            var lista2 = (LinkedList) lista.get((int) indice);
            if ((int) indice2 >= lista2.size()) {
                return new Errores("Semantico", "Posición de arreglo fuera de rango", this.linea, this.col);
            }
            lista2.set((int) indice2, newValor);
            
        }
        return null;
    }
    
}
