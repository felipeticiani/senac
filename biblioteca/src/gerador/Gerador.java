/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

/**
 *
 * @author felipe.ticiani
 */
public class Gerador {
    public static String gerarNumero(int qtd) {
        String numero = "";
        for (int i = 0; i < qtd; i++) {
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }
    
    public static String gerarTelefoneFixo() {
        return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
    }
    
    public static String gerarTelefoneCelular() {
        return "(48)99" + gerarNumero(3) + "-" + gerarNumero(4);
    }
    
    public static String gerarCpf() {
        return gerarNumero(3) + "." 
                + gerarNumero(3) + "."
                + gerarNumero(3) + "-"
                + gerarNumero(2);
    }
    
    public static void main(String[] args) {
        System.out.println(gerarNumero(3));
        System.out.println(gerarTelefoneFixo());
        System.out.println(gerarTelefoneCelular());
        System.out.println(gerarCpf());
    }
}
