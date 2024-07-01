/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author kevin
 */
public class Return extends Instruccion{
    public Instruccion expresion;
    public Object valor;
    public Tipo tipo;
    private boolean interpreted = false;
    public Instruccion expresionAux;

    public Return(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;

    }

    //obtener el tipo de la expresion
    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }

    public Tipo getTipo(){
        return this.tipo;
    }
    
    public void setInterpreted(boolean interpreted) {
        this.interpreted = interpreted;
    }
    
    public boolean isInterpreted() {
        return this.interpreted;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        
        
        if (this.expresion != null) {
            var valorr = this.expresion.interpretar(arbol, tabla);
            //verficar si valor ya fue interpretado
            if (valorr instanceof Return) {
                if (((Return) valorr).isInterpreted()) {
                    return valorr;
                }
            }

            if (valorr instanceof Errores) {
                return valorr;
            }
            //actualizar el tipo de la variable
            this.tipo = this.expresion.tipo;
            this.valor = valorr;
            setInterpreted(true); // Marcar como ejecutado
            //agrergar el valor de la expresion auxiliar
            this.expresionAux = this.expresion;
            return this;
        }

        //si es metodo void
        setInterpreted(true); // Marcar como ejecutado
        return this;
    }
    
}
