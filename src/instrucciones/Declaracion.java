/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import expresiones.Return;
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

    public Declaracion(String identificador, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valor =null;
        this.mutabilidad = "var";
    }
    

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        boolean esMutable = false;
        //pasar a minusculas la mutabilidad
        this.mutabilidad = this.mutabilidad.toLowerCase();
        //interpretar la expresion
        Object valorInterpretado;
        if (this.valor == null){
            valorInterpretado =this.valoresDefault(); 
        }else{
            valorInterpretado =this.valor.interpretar(arbol, tabla);
            //actualizar el tipo de la variable
            this.valor.setTipo(this.tipo);            
        }
        


        //validar si hubo un error
        if(valorInterpretado instanceof Errores){
            return valorInterpretado;
        }
        if (this.valor != null) {
            //verificar si el tipo de la variable es igual al tipo de la expresion
            if (this.tipo.getTipo() != this.valor.tipo.getTipo()) {
                return new Errores("Semantico", "El tipo de la variable no coincide con el tipo de la expresion", this.linea, this.col);
            }
            
        }
        //validar si la variable es constante
        switch (this.mutabilidad) {
            case "const" -> esMutable = false;
            case "var" -> esMutable = true;
            default -> {
                return new Errores("Semantico", "El tipo de mutabilidad no es valido", this.linea, this.col);
            }
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
                valorInterpretado = '\u0000';
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

    public Object valoresDefault(){
        return switch (this.tipo.getTipo()) {
            case BOOLEANO ->
                true;
            case CADENA ->
                "";
            case CARACTER ->
                '\u0000';
            case ENTERO ->
                0;
            case DECIMAL ->
                0.0;
            default ->
                null;
        };
    }
    
    



    
}
