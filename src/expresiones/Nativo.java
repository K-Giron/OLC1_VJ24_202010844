/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Nativo extends Instruccion{
    public Object valor;

    public Nativo(Object valor, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.valor = valor;
    }
    //getters y setters
    public Object getValor() {
        return valor;
    }
    public void setValor(Object valor) {
        this.valor = valor;
    }
    

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {

        //si el valor es de tipo cadena se le quitan las tabulaciones
        if (this.tipo.getTipo() == tipoDato.CADENA) {
            //reemplazar tabulaciones y saltos de linea
            this.valor = this.valor.toString().replace("\\t", "\t").replace("\\n", "\n");
            //reemplazar comillas dobles y simples
            this.valor = this.valor.toString().replace("\\\"", "\"").replace("\\'", "'");
            //reemplazar barra invertida
            this.valor = this.valor.toString().replace("\\\\", "\\");

        }

        return this.valor;
    }    
/*
    @Override
    public String generarast(Arbol arbol, String anterior) {
        String nodoNativo = "n" + arbol.getContador();//n1
        String nodoValor = "n" + arbol.getContador();//n2

        String resultado = anterior + " -> " + nodoNativo;

        resultado += nodoNativo + "[label=\"NATIVO\"];\n";
        resultado += nodoValor + "[label=\""
                + this.valor.toString() + "\"];\n";

        resultado += nodoNativo + " -> " + nodoValor;
        return resultado;
    }*/
}