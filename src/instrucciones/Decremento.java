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
public class Decremento extends Instruccion{
    private String id;

    public Decremento(String id, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var simbolo = tabla.getVariable(id);
        if (simbolo == null) {
            return new Errores("SEMANTICO", "No se encontro la variable " + id, this.linea, this.col);
        }
        if (simbolo.getTipo().getTipo() != tipoDato.ENTERO) {
            return new Errores("SEMANTICO", "La variable " + id + " no es de tipo entero", this.linea, this.col);
        }
        // si la variable es no mutable no se puede modificar
        if (!simbolo.getMutabilidad()) {
            return new Errores("SEMANTICO", "La variable " + id + " es constante", this.linea, this.col);
        }
        simbolo.setValor((int) simbolo.getValor() - 1);
        return null;
        
    }
    
}
