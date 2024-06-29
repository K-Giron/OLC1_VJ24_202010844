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
public class AsignacionList extends Instruccion {
    private String id;
    private Instruccion index;
    private Instruccion valor;

    public AsignacionList(String id, Instruccion index, Instruccion valor, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.index = index;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //lista exista
        var lista = tabla.getVariable(id);
        if(lista == null){
            return new Errores("Semantico", "La lista no existe", this.linea, this.col);
        }
        //verificar si la lista es mutable
        if (!lista.getMutabilidad()) {
            return new Errores("Semantico", "La lista es constante", this.linea, this.col);
        }

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
        var newValor = valor.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }
        //validar si los tipos coinciden
        if (lista.getTipo().getTipo() != valor.tipo.getTipo()) {
            return new Errores("Semantico", "El tipo de la variable no coincide con el valor asignado", this.linea, this.col);
        }
        //asignar el valor
        var listaVal = (LinkedList) lista.getValor();
        listaVal.set((int) indice, newValor);
        return null;
    }
    
}
