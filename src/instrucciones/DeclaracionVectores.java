/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import java.util.LinkedList;

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
public class DeclaracionVectores extends Instruccion {
    String mutabilidad;
    String identificador;
    LinkedList<Instruccion> valores;
    //LinkedLis de tipo object para el arreglo de 2 dimensiones
    LinkedList<LinkedList<Instruccion>> valores2;
    int dimension;

    public DeclaracionVectores(String mutabilidad,  String identificador,Tipo tipo, LinkedList<Instruccion> valores, LinkedList<LinkedList<Instruccion>> valores2, int dimension, int linea, int col) {
        super(tipo, linea, col);
        this.mutabilidad = mutabilidad;
        this.identificador = identificador;
        this.valores = valores;
        this.valores2 = valores2;
        this.dimension = dimension;
    }



    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        boolean esMutable = false;
        //pasar a minusculas la mutabilidad
        this.mutabilidad = this.mutabilidad.toLowerCase();
        //validar si la variable es constante
        if(this.mutabilidad.equals("const")){
            esMutable = false;
        }else if(this.mutabilidad.equals("var")){
            esMutable = true;
        }else{
            return new Errores("SEMANTICO", "Tipo de mutabilidad en arreglos no valido", this.linea, this.col);
        }

        //lista de object para el arreglo de cualquier dimension
        LinkedList<Object> arreglo = new LinkedList<>();
        //lista de object para el arreglo de 2 dimensiones
        LinkedList<LinkedList<Object>> arreglo2 = new LinkedList<>();
        //verificar que dimension sera el arreglo
        switch (this.dimension) {
            case 1 -> {
                //recorres la lista de valores
                for (Instruccion instruccion : valores) {
                    //interpretar el valor
                    var valorInterpretado = instruccion.interpretar(arbol, tabla);
                    //validar que el tipo de dato sea correcto
                    if (instruccion.getTipo().getTipo() != this.tipo.getTipo()) {
                        return new Errores("SEMANTICO", "Tipos erroneos", this.linea, this.col);
                    }
                    if(valorInterpretado instanceof Errores){
                        return valorInterpretado;
                    }
                
                    
                    //agregar el valor al arreglo
                    arreglo.add(valorInterpretado);
                }   //veficar que la lista sea de una dimension
                if (arreglo.size() != valores.size()) {
                    return new Errores("SEMANTICO", "Error en la dimension del arreglo", this.linea, this.col);
                }
            }
            case 2 -> {
                //recorres la lista doble de valores para la dimension 2
                for (LinkedList<Instruccion> instrucciones : valores2) {
                    LinkedList<Object> arregloInterno = new LinkedList<>();
                    //recorres la lista de valores
                    for (Instruccion instruccion : instrucciones) {
                        var valorInterpretado = instruccion.interpretar(arbol, tabla);
                        //validar que el tipo de dato sea correcto
                        if (instruccion.getTipo().getTipo() != this.tipo.getTipo()) {
                            return new Errores("SEMANTICO", "Tipos erroneos", this.linea, this.col);
                        }

                        //validar si hubo un error
                        if(valorInterpretado instanceof Errores){
                            return valorInterpretado;
                        }
                        //agregar el valor al arreglo
                        arregloInterno.add(valorInterpretado);
                    }
                    //agregar el arreglo interno al arreglo de 2 dimensiones
                    arreglo2.add(arregloInterno);
                }
                //veficar que la lista sea de dos dimensiones
                if (arreglo2.size() != valores2.size()) {
                    return new Errores("SEMANTICO", "Error en la dimension del arreglo", this.linea, this.col);
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Dimension de arreglo no valida", this.linea, this.col);
            }
        }

        if (this.valores != null) {
            //crear el simbolo con los valores
            Simbolo simbolo = new Simbolo(this.tipo, this.identificador, arreglo, esMutable, this.linea, this.col);
            boolean agregado = tabla.setVariable(simbolo);
            if (!agregado) {
                return new Errores("SEMANTICO", "La variable ya existe en el ambito actual", this.linea, this.col);
            }

        } else if (this.valores2 != null) {
            //crear el simbolo con los valores
            Simbolo simbolo = new Simbolo(this.tipo, this.identificador, arreglo2, esMutable, this.linea, this.col);
            boolean agregado = tabla.setVariable(simbolo);
            if (!agregado) {
                return new Errores("SEMANTICO", "La variable ya existe en el ambito actual", this.linea, this.col);
            }

        } else {
            return new Errores("SEMANTICO", "Error en la declaracion de arreglos", this.linea, this.col);
        }

        return null;
        
        
    }
    
}
