package com.mycompany.juliocesar;

import java.util.Arrays;
import java.util.Scanner;

public class CriptografiaCesariana {
    
    public static void main(String[] args) {
        System.out.println("Digite o texto: ");
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();
        //criptografar(texto);
        //descriptografar(texto);
    }
    
    //@Override
    public static String criptografar(String texto) {
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int chave = 3;
        
        if (texto.isEmpty()) {
            throw new IllegalArgumentException();
	} if (texto == null) {
            throw new NullPointerException();
	}
        
        texto = texto.toLowerCase();
        char[] msgcriptoArray = new char[texto.length()];
 
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isAlphabetic(texto.charAt(i))){
                msgcriptoArray[i] = texto.charAt(i);
            } else {
                for (int j = 0; j < alfabeto.length ; j++) {
                    if (texto.charAt(i) == alfabeto[j]) {
                        msgcriptoArray[i] = alfabeto[(j+chave)%alfabeto.length];
                    }
                }
            }
               
        }
        String msgcripto = new String(msgcriptoArray);
        return msgcripto; 
    }

    //@Override
    public static String descriptografar(String texto) {
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int chave = 3;
        
        if (texto.isEmpty()) {
            throw new IllegalArgumentException();
	} if (texto == null) {
            throw new NullPointerException();
	}
        
        texto = texto.toLowerCase();
        char[] msgcriptoArray = new char[texto.length()];
        
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isAlphabetic(texto.charAt(i))){
                msgcriptoArray[i] = texto.charAt(i);
            } else {
                for (int j = 0; j < alfabeto.length ; j++) {
                    if (texto.charAt(i) == alfabeto[j]) {
                        if (j < chave) {
                            msgcriptoArray[i] = alfabeto[j-chave+alfabeto.length];    
                        } else {
                            msgcriptoArray[i] = alfabeto[j-chave];
                        }
                    } 
                }
            }
               
        }
        String msgcripto = new String(msgcriptoArray);
        return msgcripto;
    }
    
}
