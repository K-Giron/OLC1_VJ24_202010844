/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author kevin
 */
public class Declaracion extends Instruccion{
    public String identificador;
    public Instruccion valor;
    
    
    public Declaracion(String identificador, Instruccion valor, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //interpretar la expresion
        var valorInterpretado = this.valor.interpretar(arbol, tabla);
        //validar si hubo un error
        if(valorInterpretado instanceof Errores){
            return valorInterpretado;
        }
        //validamos los tipos
        if(this.valor.tipo.getTipo() != this.tipo.getTipo()){
            return new Errores("Semantico", "El tipo de la variable no coincide con el valor asignado", this.linea, this.col);
        }
        //crear la variable
        Simbolo s = new Simbolo(this.tipo, this.identificador,valorInterpretado);
        boolean creacion = tabla.setVariable(s);
        if(!creacion){
            return new Errores("Semantico", "La variable ya existe en el ambito actual", this.linea, this.col);
        }

        return null;
    }
    
    



    
}
