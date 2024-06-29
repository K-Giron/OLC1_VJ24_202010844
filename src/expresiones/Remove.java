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
public class Remove extends Instruccion {
    private String id;
    private Instruccion expresion;
    
    public Remove(String id, Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expresion = expresion;
    }
    
    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        
        //lista exista
        var lista = tabla.getVariable(id);
        if(lista == null){
            return new Errores("Semantico", "La lista no existe", this.linea, this.col);
        }
        //interpretar la expresion como indice
        var indice = expresion.interpretar(arbol, tabla);
        if (indice instanceof Errores) {
            return indice;
        }
        //validar si los tipos coinciden
        if (lista.getTipo().getTipo() != expresion.tipo.getTipo()) {
            return new Errores("Semantico", "El tipo de la variable no coincide con el valor asignado", this.linea, this.col);
        }
        //obtener el valor de la lista en la posicion del indice
        var listaVal = (LinkedList) lista.getValor();
        if ((int)indice < 0 || (int)indice >= listaVal.size()) {
            return new Errores("Semantico", "El indice esta fuera de rango", this.linea, this.col);
        }
        //actualizar el tipo de la expresion
        this.tipo.setTipo(lista.getTipo().getTipo());
        var valor = listaVal.remove((int)indice);

        return valor;

    }
    
}
