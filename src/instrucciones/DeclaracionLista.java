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
public class DeclaracionLista extends Instruccion{
    private String id;

    public DeclaracionLista(String id, Tipo tipo,int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
    }
    

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //verificar si la variable ya existe
        if(tabla.getVariable(id) != null){
            return new Errores("SEMANTICO", "Variable ya existente", this.linea, this.col);
        }
        //crear una lista vacia
        LinkedList<Object> lista = new LinkedList<>();
        //crear el simbolo
        Simbolo simbolo = new Simbolo(tipo, this.id, lista, true, linea, col);
        //agregar a la tabla de simbolos
        tabla.setVariable(simbolo);
        return null;
    }
    
}
