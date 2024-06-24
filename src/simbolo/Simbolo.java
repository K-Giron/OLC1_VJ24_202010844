/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

/**
 *
 * @author kevin
 */
public class Simbolo {
    private Tipo tipo;
    private String id;
    private Object valor;
    private boolean mutabilidad;
    private int linea;
    private int columna;

    public Simbolo(Tipo tipo, String id) {
        this.tipo = tipo;
        this.id = id;
    }

    public Simbolo(Tipo tipo, String id, Object valor) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
    }
    //nuevo constructor para la mutabilidad
    public Simbolo(Tipo tipo, String id, Object valor, boolean mutabilidad, int linea, int columna) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
        this.mutabilidad = mutabilidad;
        this.linea = linea;
        this.columna = columna;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    //metodo para obtener la mutabilidad
    public boolean getMutabilidad(){
        return this.mutabilidad;
    }
    public void setMutabilidad(boolean mutabilidad){
        this.mutabilidad = mutabilidad;
    }
    public int getLinea() {
        return linea;
    }
    public void setLinea(int linea) {
        this.linea = linea;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}