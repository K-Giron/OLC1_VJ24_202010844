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
public class Logicos extends Instruccion {
    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresLogicos operacion;
    private Instruccion operandoUnico;

    //negacion 
    public Logicos(Instruccion operandoUnico, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }
    //cualquier operacion menos negacion
    public Logicos(Instruccion operando1, Instruccion operando2, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object opIzq = null, opDer = null, Unico = null;
        if (this.operandoUnico != null) {
            Unico = this.operandoUnico.interpretar(arbol, tabla);
            if (Unico instanceof Errores) {
                return Unico;
            }
        } else {
            opIzq = this.operando1.interpretar(arbol, tabla);
            if (opIzq instanceof Errores) {
                return opIzq;
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Errores) {
                return opDer;
            }
        }

        return switch (operacion) {
            case OR -> this.or(opIzq, opDer);
            case AND -> this.and(opIzq, opDer);
            case NOT -> this.not(Unico);
            case XOR -> this.xor(opIzq, opDer);
            default -> new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);

        };
    }

    public Object or(Object opIzq, Object opDer) {
        if (opIzq instanceof Boolean && opDer instanceof Boolean) {
            return (Boolean) opIzq || (Boolean) opDer;
        }
        return new Errores("SEMANTICO", "Operandos invalidos", this.linea, this.col);
    }

    public Object and(Object opIzq, Object opDer) {
        if (opIzq instanceof Boolean && opDer instanceof Boolean) {
            return (Boolean) opIzq && (Boolean) opDer;
        }
        return new Errores("SEMANTICO", "Operandos invalidos", this.linea, this.col);
    }

    public Object not(Object Unico) {
        if (Unico instanceof Boolean) {
            return !(Boolean) Unico;
        }
        return new Errores("SEMANTICO", "Operandos invalidos", this.linea, this.col);
    }

    public Object xor(Object opIzq, Object opDer) {
        if (opIzq instanceof Boolean && opDer instanceof Boolean) {
            return (Boolean) opIzq ^ (Boolean) opDer;
        }
        return new Errores("SEMANTICO", "Operandos invalidos", this.linea, this.col);
    }

    
}
