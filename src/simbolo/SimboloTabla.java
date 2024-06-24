/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

/**
 *
 * @author kevin
 */
public class SimboloTabla {
    private String id;
    private tipoDato tipo;
    private Object valor;
    private String entorno;
    private int linea;
    private int columna;
    private String mutabilidad;

    public SimboloTabla(String id, String mutabilidad, tipoDato tipo, Object valor, String entorno, int linea, int columna) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.entorno = entorno;
        this.linea = linea;
        this.columna = columna;
        this.mutabilidad = mutabilidad;
    }

    public String getId() {
        return id;
    }

    public tipoDato getTipo() {
        return tipo;
    }

    public Object getValor() {
        return valor;
    }

    public String getEntorno() {
        return entorno;
    }  

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTipo(tipoDato tipo) {
        this.tipo = tipo;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getMutabilidad() {
        return mutabilidad;
    }

    public void setMutabilidad(String mutabilidad) {
        this.mutabilidad = mutabilidad;
    }



    
}
