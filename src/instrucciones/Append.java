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
public class Append extends Instruccion {
    private String id;
    private Instruccion expresion;

    public Append(String id, Instruccion expresion, int linea, int col) {
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
        //interpretar la expresion
        var newValor = expresion.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }
        //validar si los tipos coinciden
        if (lista.getTipo().getTipo() != expresion.tipo.getTipo()) {
            return new Errores("Semantico", "El tipo de la variable no coincide con el valor asignado", this.linea, this.col);
        }
        //asignar el valor
        var listaVal = (LinkedList) lista.getValor();
        listaVal.add(newValor);
        
        return null;
    }
    
}
