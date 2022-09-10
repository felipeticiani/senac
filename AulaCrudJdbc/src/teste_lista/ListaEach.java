/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_lista;

import java.util.Arrays;
import java.util.List;
import static gerador.Gerador.*;
import java.util.ArrayList;

/**
 *
 * @author felipe.ticiani
 */
public class ListaEach {
    public static void main(String[] args) {
        // forEach a partir do Java 1.8
        List<String> nomes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nomes.add(gerarNome());
        }
        nomes.forEach(nome -> {
            System.out.print(nome);
            System.out.println(" (" + nome.length() + " caracteres)");
        });
        
        // forEach até o Java 1.7 (ou quando precisamos acessar a possição do laço)
        List<Integer> numeros = Arrays.asList(8, 7, 41, 78, 61, 3, 98, 21, 27, 39);
        int contador = 1;
        for (Integer numero : numeros) {
            System.out.print(contador + "º número: ");
            System.out.print(numero);
            System.out.println(" * 2 = " + numero * 2);
            contador++;
        }
    }
}
