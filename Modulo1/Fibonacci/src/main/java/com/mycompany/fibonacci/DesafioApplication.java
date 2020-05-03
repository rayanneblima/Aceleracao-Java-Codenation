package com.mycompany.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

    public static void main(String[] args) {
        System.out.println(listaFibonacci());
        System.out.println(isFibonacci(3));
    }

    //@Desafio("Fibonacci")
    public static List<Integer> listaFibonacci() {
	int elemento;
        List<Integer> fibonacci = new ArrayList<>();

        for(int i=0; ;i++) {
            if(i < 2) {
                fibonacci.add(i); //adiciona 0, 1
                continue;
            }

            elemento = fibonacci.get(i-1) + fibonacci.get(i-2);

            if(elemento >= 350) {
                break;
            }

            fibonacci.add(elemento);  
        }
        return fibonacci;
    }

    //@Desafio("isFibonacci")
    public static Boolean isFibonacci(Integer a) {
	return listaFibonacci().contains(a);
    }
    
}
