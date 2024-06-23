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
import instrucciones.If;

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
        //PruebaBreak();
        //ruebaFor();
        //PruebaLetra();
        //crear una instancia de if

        
        
    }
    
    public static void Prueba(){

        int var1 = 50;

        // Verificación de paridad
        System.out.println("----------- Opción 1 -----------");
        int numero = var1;
        do {
            numero--;
            numero--;
            if (numero == 0) {
                System.out.println("El número " + var1 + " es par");
                break;
            }
            if (numero == 1 || numero < 0) {
                System.out.println("El número " + var1 + " es impar");
                break;
            }
        } while (true);
    }
    
    public static void PruebaBreak(){
        // Declaración de variables
int k = 0;


// Bucle while externo (ciclo1)
while (k < 10) {
    int l = 0;
    System.out.println("Entramos al ciclo1 con k = " + k);

    // Bucle while interno (ciclo2)
    while (l < 3) {
        System.out.println("Entramos al ciclo2 con l = " + l);

        // Condición para break en ciclo2
        if (k == 1 && l == 1) {
            System.out.println("Hacemos break al ciclo2");
            break;
        }

        // Condición para continue en ciclo2
        if (k == 2 && l == 1) {
            System.out.println("Hacemos continue al ciclo2");
            l++;
            continue;
        }

        // Incremento de l
        l++;
    }

    // Condición para break en ciclo1
    if (k == 5) {
        System.out.println("Hacemos break al ciclo1");
        break;
    }

    // Incremento de k
    k++;
}
    
    }
    public static void pruebaFor(){
        System.out.println("----------- Ejemplo de for con if y continue -----------");

        // Bucle for
        for (int i = 0; i < 10; i++) {
            // Estructura if que contiene una sentencia continue
            if (i == 5) {
                System.out.println("Se cumple la condición (i == 5), hacemos continue");
                continue;  // Salta a la siguiente iteración del bucle for
            }
            System.out.println("Valor de i = " + i);
        }

        System.out.println("Se ha salido del bucle for");


    }
    
    public static void PruebaLetra(){
        final int n = 7; // Use final for constant values
        String letraA = "";
        int i;

        // Outer loop for rows
        for (i = 0; i < n; i++) {
            String linea = "";
            int j;

            // Inner loop for spaces before asterisk
            for (j = 0; j < n - i; j++) {
                linea += " "; // Use += for string concatenation
            }
            linea += "*";

            // Inner loop for middle section (optional for non-center row)
            if (i != 0) {
                for (j = 0; j < 2 * i; j++) {
                    if (i == n / 2-0.5) { // Use double for floating-point comparison
                        linea =linea+ "*";
                    } else {
                        linea =linea+ " ";
                    }
                }
                linea =linea+ "*";
            }

            // Add line to letraA with newline character
            letraA =letraA+ linea + "\n";
        }

        System.out.println(letraA);
    }






    
}
