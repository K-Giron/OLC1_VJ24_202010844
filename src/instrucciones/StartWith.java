/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import java.util.LinkedList;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author kevin
 */
public class StartWith extends Instruccion {
    private String id;
    private LinkedList<Instruccion> parametros;

    public StartWith(String id, LinkedList<Instruccion> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.parametros = parametros;
    }



    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        //buscar la funcion
        var busqueda= arbol.getFuncion(id);
        if(busqueda==null){
            return new Errores("SEMANTICO", "La funcion "+id+" no existe", linea, col);
        }

        if (busqueda instanceof Metodo metodo) {
            var newTabla = new tablaSimbolos(arbol.getTablaGlobal());
            newTabla.setNombre("Star_With");

            if (metodo.parametros.size() != this.parametros.size()) {
                return new Errores("SEMANTICO", "Parametros incorrectos en la funcion",
                        this.linea, this.col);
            }

            for (int i = 0; i < this.parametros.size(); i++) {
                var identificador = (String) metodo.parametros.get(i).get("id");
                var valor = this.parametros.get(i);
                var tipo2 = (Tipo) metodo.parametros.get(i).get("tipo");

                var declaracionParametro = new Declaracion(identificador, valor, tipo2, "const", this.linea, this.col);

                var resultadoDeclaracion = declaracionParametro.interpretar(arbol, newTabla);

                if (resultadoDeclaracion instanceof Errores) {
                    return resultadoDeclaracion;
                }
            }

            var resultadoFuncion = metodo.interpretar(arbol, newTabla);
            if (resultadoFuncion instanceof Errores) {
                return resultadoFuncion;
            }
        }
        return null;
    }
    
    
}
