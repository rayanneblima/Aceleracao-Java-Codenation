package com.mycompany.juliocesar;

import java.util.Arrays;

public class CriptografiaCesariana implements Criptografia {    
    
    @Override
    public String criptografar(String texto) {
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int chave = 3;
        
        char[] letras = texto.toCharArray();
        char[] msgcripto = new char[letras.length];
        
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == ' '){
                msgcripto[i] = letras[i];
            } else {
                for (int j = 0; j < alfabeto.length ; j++) {
                    if (letras[i] == alfabeto[j]) {
                        msgcripto[i] = alfabeto[(j+chave)%alfabeto.length];
                    }
                }
            }
               
        }
        return Arrays.toString(msgcripto); 
    }

    @Override
    public String descriptografar(String texto) {
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int chave = 3;
        
        char[] letras = texto.toCharArray();
        char[] msgcripto = new char[letras.length];
        
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == ' '){
                msgcripto[i] = letras[i];
            } else {
                for (int j = 0; j < alfabeto.length ; j++) {
                    if (letras[i] == alfabeto[j]) {
                        if (j < chave) {
                            msgcripto[i] = alfabeto[j-chave+alfabeto.length];    
                        } else {
                            msgcripto[i] = alfabeto[j-chave];
                        }
                    } 
                }
            }
               
        }
        return Arrays.toString(msgcripto);
    }
    
}
