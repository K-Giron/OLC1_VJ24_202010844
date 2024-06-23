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
public class Relacionales extends Instruccion {
    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresRelacionales operacion;

    public Relacionales(Instruccion operando1, Instruccion operando2, OperadoresRelacionales operacion, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }
    

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object opIzq = null, opDer = null;
        opIzq = this.operando1.interpretar(arbol, tabla);
        if (opIzq instanceof Errores) {
            return opIzq;
        }
        opDer = this.operando2.interpretar(arbol, tabla);
        if (opDer instanceof Errores) {
            return opDer;
        }

        return switch (operacion) {
            case IGUALACION -> this.igual(opIzq, opDer);
            case DIFERENTE -> this.diferente(opIzq, opDer);
            case MAYOR -> this.mayor(opIzq, opDer);
            case MENOR -> this.menor(opIzq, opDer);
            case MAYORQUE -> this.mayorQue(opIzq, opDer);
            case MENORQUE -> this.menorQue(opIzq, opDer);
            default -> new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);

        };

    }

    public Object igual(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch(tipo1){
            case ENTERO -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq == (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq == (double)opDer;
                    }
                    case CARACTER -> {
                        //pasar el string a char y comparar
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq == (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq == (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq == (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq == (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch(tipo2){
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (boolean)opIzq == (boolean)opDer;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) == (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) == (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return opIzq.equals(opDer);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch(tipo2){
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return opIzq.equals(opDer);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
            }
        }
    }

    public Object diferente(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch(tipo1){
            case ENTERO -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq != (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq != (double)opDer;
                    }
                    case CARACTER -> {
                        //pasar el string a char y comparar
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq != (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq != (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq != (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq != (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch(tipo2){
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (boolean)opIzq != (boolean)opDer;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) != (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) != (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return !opIzq.equals(opDer);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch(tipo2){
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return !opIzq.equals(opDer);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
            }
        }
    }

    public Object mayor(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch(tipo1){
            case ENTERO -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq > (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq > (double)opDer;
                    }
                    case CARACTER -> {
                        //pasar el string a char y comparar
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq > (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq > (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq > (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq > (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch(tipo2){
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //volver los booleanos 1 si es true y 0 si es false
                        int izq = (boolean)opIzq ? 1 : 0;
                        int der = (boolean)opDer ? 1 : 0;
                        return izq > der;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) > (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) > (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return opIzq.toString().charAt(0) > opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch(tipo2){
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //validando si la cadena izquierda es mayor que la derecha
                        return opIzq.toString().length() > opDer.toString().length();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
            }
        }
    }

    public Object menor(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch(tipo1){
            case ENTERO -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq < (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq < (double)opDer;
                    }
                    case CARACTER -> {
                        //pasar el string a char y comparar
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq < (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq < (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq < (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq < (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch(tipo2){
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //volver los booleanos 1 si es true y 0 si es false
                        int izq = (boolean)opIzq ? 1 : 0;
                        int der = (boolean)opDer ? 1 : 0;
                        return izq < der;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatible", this.linea, this.col);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) < (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) < (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return opIzq.toString().charAt(0) < opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch(tipo2){
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //validando si la cadena izquierda es menor que la derecha
                        return opIzq.toString().length() < opDer.toString().length();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
            }
        }
    }

    public Object mayorQue(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch(tipo1){
            case ENTERO -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq >= (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq >= (double)opDer;
                    }
                    case CARACTER -> {
                        //pasar el string a char y comparar
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq >= (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq >= (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq >= (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq >= (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch(tipo2){
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //volver los booleanos 1 si es true y 0 si es false
                        int izq = (boolean)opIzq ? 1 : 0;
                        int der = (boolean)opDer ? 1 : 0;
                        return izq >= der;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) >= (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) >= (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return opIzq.toString().charAt(0) >= opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch(tipo2){
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //validando si la cadena izquierda es mayor o igual que la derecha
                        return opIzq.toString().length() >= opDer.toString().length();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
            }
        }
    }

    public Object menorQue(Object opIzq, Object opDer) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch(tipo1){
            case ENTERO -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq <= (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq <= (double)opDer;
                    }
                    case CARACTER -> {
                        //pasar el string a char y comparar
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int)opIzq <= (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq <= (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq <= (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double)opIzq <= (int) opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch(tipo2){
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //volver los booleanos 1 si es true y 0 si es false
                        int izq = (boolean)opIzq ? 1 : 0;
                        int der = (boolean)opDer ? 1 : 0;
                        return izq <= der;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatible", this.linea, this.col);
                    }
                }
            }
            case CARACTER -> {
                switch(tipo2){
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) <= (int)opDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) opIzq.toString().charAt(0) <= (double)opDer;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return opIzq.toString().charAt(0) <= opDer.toString().charAt(0);
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch(tipo2){
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        //validando si la cadena izquierda es menor o igual que la derecha
                        return opIzq.toString().length() <= opDer.toString().length();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Tipos incompatibles", this.linea, this.col);
            }
        }
    }


    
}



