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
    
    public Instruccion getExpresion() {
        return expresion;
    }
    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }
    public boolean isDefecto() {
        return defecto;
    }
    public void setExpresion(Instruccion expresion) {
        this.expresion = expresion;
    }
    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    public void setDefecto(boolean defecto) {
        this.defecto = defecto;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        return true;
    }
    
    
}
