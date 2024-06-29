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
    public Tipo tipo;

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

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        
        if (this.expresion != null) {
            var valor = this.expresion.interpretar(arbol, tabla);
            if (valor instanceof Errores) {
                return valor;
            }
            //actualizar el tipo de la variable
            this.tipo = this.expresion.tipo;
            return valor;
            
        }



        return null;
    }
    
}
