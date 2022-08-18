/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
        List<String> nomes = Arrays.asList("Miguel", "Gabriel", "Rafael", "Lucas", "Felipe", 
            "Alice", "Sarah", "Beatriz", "Mariana", "Isabela");
        Collections.shuffle(nomes);
        return nomes.get(0);
    }
    
    public static String gerarSobrenome() {
        List<String> sobrenomes = Arrays.asList("Silva", "Santos", "Oliveira", "Souza", "Rodrigues", 
            "Ferreira", "Alves", "Pereira", "Lima", "Gomes");
        Collections.shuffle(sobrenomes);
        return sobrenomes.get(0);
    }
    
    public static String gerarNomeCompleto() {
        return gerarNome() + " " + gerarSobrenome();
    }
    
    public static String gerarLogin() {
        return gerarNome().toLowerCase() + "." + gerarSobrenome().toLowerCase();
    }
    
    public static String gerarUf() {
        List<String> ufs = Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
            "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", 
            "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        Collections.shuffle(ufs);
        return ufs.get(0);
    }
    
    public static String gerarBairro() {
        List<String> bairros = Arrays.asList("Centro", "Capoeiras", "Trindade", "Agronômica", 
            "Saco dos Limões", "Coqueiros", "Monte Cristo", "Balneário", 
            "Itacorubi", "Estreito");
        Collections.shuffle(bairros);
        return bairros.get(0);
    }
    
    public static String gerarCidade() {
        List<String> cidades = Arrays.asList("São José", "Florianópolis", "Palhoça", "Biguaçu", 
            "Ipumirim", "Concórdia", "Chapecó", "Lages", 
            "São Paulo", "Rio de Janeiro");
        Collections.shuffle(cidades);
        return cidades.get(0);
    }
    
    public static String gerarIdade() {
        int number = new Random().nextInt(65);
        while (number <= 18 && number >= 65) {
            number = new Random().nextInt(65);
        }
        return String.valueOf(number);
    }
}
