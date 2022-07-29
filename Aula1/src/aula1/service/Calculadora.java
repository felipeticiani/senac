/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1.service;

import java.util.Random;

/**
 *
 * @author felipe.ticiani
 */
public class Calculadora {
    // Exercício 1
    public int somar(int valor1, int valor2, int valor3) {
        return valor1 + valor2 + valor3;
    }
    
    // Exercício 2
    public int contarCaracteres(String texto) {
        return texto.length();
    }
    
    // Exercício 3
    public int sortearNumero() {
        // professor usou: return (int) (Math.random() * 10)
        return new Random().nextInt(9);
    }
}
