/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Casos;
import abstracto.Instruccion;
import java.util.LinkedList;

import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class Match extends Instruccion {
    private Instruccion expresion;
    private LinkedList<Casos> casos;
    private Casos defecto;

    
    public Match(Instruccion expresion, LinkedList<Casos> casos, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.casos = casos;
    }



    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //creamos un nuevo entorno
        var newTabla = new tablaSimbolos(tabla);

        //validar la condicion -> Booleano
        var cond = this.expresion.interpretar(arbol, newTabla);
        if (cond instanceof Errores) {
            return cond;
        }

        //verificar que sea booleano la expresion
        if(this.expresion.tipo.getTipo() != tipoDato.BOOLEANO){
            return new Errores("SEMANTICO", "La expresion debe ser booleana", this.linea, this.col);
        }

        //recorrer los casos
        for (var c : this.casos) {
            //recorriendo la lista de casos y ejecutando las instrucciones
            if (c instanceof Casos) {
                var res = c.interpretar(arbol, newTabla);
                if (res instanceof Errores) {
                    return res;
                }
            }

            return new Errores ("SEMANTICO", "No se encontro un caso", this.linea, this.col);
            
        }

        //verificar si hay un defecto
        if (this.defecto != null) {
            var res = this.defecto.interpretar(arbol, newTabla);
            if (res instanceof Errores) {
                return res;
            }
            return new Errores ("SEMANTICO", "No se encontro un caso", this.linea, this.col);
        }


        

        return null;
    }
    
    
}
