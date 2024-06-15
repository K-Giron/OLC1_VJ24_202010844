/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

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
public class AsignacionVar extends Instruccion {
    private String id;
    private Instruccion expresion;

    public AsignacionVar(String id, Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        
        
        //variable exista
        var variable= tabla.getVariable(id);
        if(variable == null){
            return new Errores("Semantico", "La variable no existe", this.linea, this.col);
        }

        //verificar si la variable es mutable
        if(!variable.getMutabilidad()){
            return new Errores("Semantico", "La variable es constante", this.linea, this.col);
        }

        //intepretar el nuevo valor a asignar
        var newValor = expresion.interpretar(arbol, tabla);
        if(newValor instanceof Errores){
            return newValor;
        }

        //validar si los tipos coinciden
        if(variable.getTipo().getTipo() != expresion.tipo.getTipo()){
            return new Errores("Semantico", "El tipo de la variable no coincide con el valor asignado", this.linea, this.col);
        }
        //asignar el tipo
        this.tipo.setTipo(variable.getTipo().getTipo());
        //asignar el nuevo valor
        variable.setValor(newValor);
        return null;
    }
}
