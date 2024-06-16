/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Casteos extends Instruccion {
    private Instruccion expresion;

    public Casteos(Instruccion expresion,Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        Object valor = expresion.interpretar(arbol, tabla);
        if (valor instanceof Errores) {
            return valor;
        }
        //hacer casteos
        if (this.expresion.tipo.getTipo() == tipoDato.ENTERO) {
            if (this.tipo.getTipo() == tipoDato.DECIMAL) {
                return (double) (int) valor;
            }
            if (this.tipo.getTipo() == tipoDato.CARACTER) {
                return (char) (int) valor;
            }
            return new Errores("SEMANTICO", "No se puede convertir " + valor + " a " + this.expresion.tipo.getTipo(), this.linea, this.col);
        }
        if (this.expresion.tipo.getTipo() == tipoDato.DECIMAL) {
            if (this.tipo.getTipo() == tipoDato.ENTERO) {
                return (int) (double) valor;
            }
            return new Errores("SEMANTICO", "No se puede convertir " + valor + " a " + this.expresion.tipo.getTipo(), this.linea, this.col);
        }
        if (this.expresion.tipo.getTipo() == tipoDato.CARACTER) {
            if (this.tipo.getTipo() == tipoDato.ENTERO) {
                return (int) (char) valor;
            }
            if (this.tipo.getTipo() == tipoDato.DECIMAL) {
                return (double) (char) valor;
            }
            return new Errores("SEMANTICO", "No se puede convertir " + valor + " a " + this.expresion.tipo.getTipo(), this.linea, this.col);
        }

        return new Errores("SEMANTICO", "No se puede convertir " + valor + " a " + this.expresion.tipo.getTipo(), this.linea, this.col);
    }
    
}
