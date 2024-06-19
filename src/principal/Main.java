/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;

import abstracto.Instruccion;
import analizadores.parser;
import analizadores.scanner;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.tablaSimbolos;

/**
 *
 * @author kevin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        Ventana ven= new Ventana();
        ven.setVisible(true);
    }
    
}
