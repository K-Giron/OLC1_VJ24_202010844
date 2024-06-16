/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracto;

import java.util.LinkedList;

import simbolo.*;

/**
 *
 * @author kevin
 */
public class Casos extends Instruccion{
    private Instruccion expresion;
    private LinkedList<Instruccion> instrucciones;
    private boolean defecto;

    public Casos(Instruccion expresion, LinkedList<Instruccion> instrucciones, boolean defecto, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.instrucciones = instrucciones;
        this.defecto = defecto;
    }
    


    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        return null;
    }
    
    
}
