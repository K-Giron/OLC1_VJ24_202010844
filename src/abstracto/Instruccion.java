/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracto;

import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author kevin
 */
public abstract class Instruccion {

    public Tipo tipo;
    public int linea;
    public int col;

    public Instruccion(Tipo tipo, int linea, int col) {
        this.tipo = tipo;
        this.linea = linea;
        this.col = col;
    }

    //GETTERS AND SETTERS
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public abstract Object interpretar(Arbol arbol, tablaSimbolos tabla);

    //public abstract String generarast(Arbol arbol, String anterior);

}