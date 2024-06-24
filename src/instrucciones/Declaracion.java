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
import simbolo.tipoDato;

/**
 *
 * @author kevin
 */
public class Declaracion extends Instruccion{
    public String identificador;
    public Instruccion valor;
    public String mutabilidad;
    
    
    public Declaracion(String identificador, Instruccion valor, Tipo tipo,String mutabilidad, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valor = valor;
        this.mutabilidad = mutabilidad;
    }
    

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        boolean esMutable = false;
        //pasar a minusculas la mutabilidad
        this.mutabilidad = this.mutabilidad.toLowerCase();
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
        //validar si la variable es constante
        if(this.mutabilidad.equals("const")){
            esMutable = false;
        }else if(this.mutabilidad.equals("var")){
            esMutable = true;
        }else {
            return new Errores("Semantico", "El tipo de mutabilidad no es valido", this.linea, this.col);
        }
        //validar para cada tipo de dato cuando la variable solo se declara
        if (valorInterpretado== tipoDato.NULL ){
            if (this.tipo.getTipo() == tipoDato.ENTERO){
                valorInterpretado = 0;
            }else if (this.tipo.getTipo() == tipoDato.DECIMAL){
                valorInterpretado = 0.0;
            }else if (this.tipo.getTipo() == tipoDato.BOOLEANO){
                valorInterpretado = true;
            }else if (this.tipo.getTipo() == tipoDato.CADENA){
                valorInterpretado = "";
            }else if (this.tipo.getTipo() == tipoDato.CARACTER){
                valorInterpretado = '0';
            }else{
                return new Errores("Semantico", "El tipo de dato no es valido", this.linea, this.col);}
        }
        //ver el valor de la variable
        //System.out.println(valorInterpretado);

        //crear la variable
        Simbolo s = new Simbolo(this.tipo, this.identificador,valorInterpretado, esMutable, this.linea, this.col);
        //imprimir todo el simbolo
        //System.out.println(s.getId() + " " + s.getTipo().getTipo() + " el valor " + s.getValor() + " " + s.getMutabilidad());

        boolean creacion = tabla.setVariable(s);
        if(!creacion){
            return new Errores("Semantico", "La variable ya existe en el ambito actual", this.linea, this.col);
        }

        return null;
    }
    
    



    
}
