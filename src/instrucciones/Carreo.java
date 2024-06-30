/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Carreo   {
    public Instruccion expresion;
    public Object valor;
    public Tipo tipo;
    public int linea;
    public int col;

    public Carreo(Instruccion expresion, Object valor, int linea, int col) {
        this.tipo = new Tipo(tipoDato.VOID);
        this.expresion = expresion;
        this.linea = linea;
        this.col = col;
    }

    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }

    public Tipo getTipo(){
        return this.tipo;
    }





    
}
