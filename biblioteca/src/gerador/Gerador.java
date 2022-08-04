/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

import java.util.UUID;

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
    
    public static String gerarCep() {
        return "8" + gerarNumero(4) + "-"
                + gerarNumero(3);
    }
    
    public static String gerarCnpj() {
        return gerarNumero(2) + "." 
                + gerarNumero(3) + "."
                + gerarNumero(3) + "/"
                + "0001" + "-"
                + gerarNumero(2);
    }
    
    public static String gerarSenha(int qtde) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, qtde);
    }
    
    public static String gerarNome() {
        String[] nomes = {"Miguel", "Gabriel", "Rafael", "Lucas", "Felipe", 
            "Alice", "Sarah", "Beatriz", "Mariana", "Isabela"};
        return nomes[Integer.parseInt(gerarNumero(1))];
    }
    
    public static String gerarSobrenome() {
        String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Souza", "Rodrigues", 
            "Ferreira", "Alves", "Pereira", "Lima", "Gomes"};
        return sobrenomes[Integer.parseInt(gerarNumero(1))];
    }
    
    public static String gerarNomeCompleto() {
        return gerarNome() + " " + gerarSobrenome();
    }
    
    public static String gerarLogin() {
        return gerarNome().toLowerCase() + "." + gerarSobrenome().toLowerCase();
    }
    
    public static String gerarUf() {
        String[] ufs = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
            "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", 
            "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
        int i = 0;
        do {
            i = Integer.parseInt(gerarNumero(2));
        } while (i > ufs.length);
        return ufs[i];
    }
    
    public static String gerarBairro() {
        String[] bairros = {"Centro", "Capoeiras", "Trindade", "Agronômica", 
            "Saco dos Limões", "Coqueiros", "Monte Cristo", "Balneário", 
            "Itacorubi", "Estreito"};
        return bairros[Integer.parseInt(gerarNumero(1))];
    }
    
    public static String gerarCidade() {
        String[] cidades = {"São José", "Florianópolis", "Palhoça", "Biguaçu", 
            "Ipumirim", "Concórdia", "Chapecó", "Lages", 
            "São Paulo", "Rio de Janeiro"};
        return cidades[Integer.parseInt(gerarNumero(1))];
    }
    
    public static void main(String[] args) {
        System.out.println(gerarNumero(3));
        System.out.println(gerarTelefoneFixo());
        System.out.println(gerarTelefoneCelular());
        System.out.println(gerarCpf());
        System.out.println(gerarCnpj());
        System.out.println(gerarCep());
        System.out.println(gerarSenha(9));
        System.out.println(gerarNome());
        System.out.println(gerarSobrenome());
        System.out.println(gerarNomeCompleto());
        System.out.println(gerarLogin());
        System.out.println(gerarUf());
        System.out.println(gerarBairro());
        System.out.println(gerarCidade());
    }
}
