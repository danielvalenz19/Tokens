/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareatokens;

import java.util.Scanner;

/**
 *
 * @author hetzo
 */
public class TareaTokens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa una oración o párrafo: ");
        String entrada = scanner.nextLine();

        int contadorTokens = contarTokens(entrada);
        System.out.println("La entrada tiene " + contadorTokens + " tokens.");

        clasificarTokens(entrada);
    }

    public static int contarTokens(String entrada) {
        String[] tokens = entrada.split(" ");
        return tokens.length;
    }

    public static void clasificarTokens(String entrada) {
        String[] tokens = entrada.split(" ");
        System.out.println("Clasificación de tokens:");

        for (String token : tokens) {
            if (esSignoAritmetico(token)) {
                System.out.println(token + ": Signo Aritmético");
            } else if (esPalabraReservada(token)) {
                System.out.println(token + ": Palabra Reservada");
            } else if (esCadenaCaracteres(token)) {
                System.out.println(token + ": Cadena de Caracteres");
            } else if (esNumero(token)) {
                System.out.println(token + ": Número");
            } else {
                System.out.println(token + ": Otro");
            }
        }
    }

    public static boolean esSignoAritmetico(String token) {
        return token.matches("[+\\-*/]");
    }

    public static boolean esPalabraReservada(String token) {
        String[] palabrasReservadas = {
            "if", "else", "while", "for", "switch", "case", "break", "return"
        // Agrega más palabras reservadas según sea necesario
        };
        for (String palabra : palabrasReservadas) {
            if (palabra.equals(token)) {
                return true;
            }
        }
        return false;
    }

    public static boolean esCadenaCaracteres(String token) {
        return !token.matches("[+\\-*/]") && !esPalabraReservada(token) && !esNumero(token);
    }

    public static boolean esNumero(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }
}
