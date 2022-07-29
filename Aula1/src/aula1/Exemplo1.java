/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1;

import aula1.service.Calculadora;
import javax.swing.JOptionPane;


/**
 *
 * @author felipe.ticiani
 */
public class Exemplo1 {

    public static void main(String[] args) {
        System.out.println("Oi Felipe Ticiani :)");
        
        // Exercício 1
        int valor1 = 10;
        int valor2 = 7;
        int valor3 = 12;
        Calculadora calculadora = new Calculadora();
        // showMessageDialog: parâmetro 1: posição na tela (null fica no meio); parâmetro 2: mensagem exibida
        JOptionPane.showMessageDialog(null, "Soma: " + calculadora.somar(valor1, valor2, valor3));
        
        // Exercício 2
        String texto = "Simples como amar";
        JOptionPane.showMessageDialog(null, "Total de caracteres: " + calculadora.contarCaracteres(texto));
        
        // Exercício 3
        JOptionPane.showMessageDialog(null, "Número aleatório: " + calculadora.sortearNumero());
    }
    
}
