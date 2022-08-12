/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import br.com.senac.crud.model.Client;
import gerador.Gerador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe.ticiani
 */
public class ClientRepositoryTest {
    private Client client;
    private IClientRepository repo;
    String cpf;
    
    public ClientRepositoryTest() {
        cpf = Gerador.gerarCpf();
        repo = new ClientRepository();
    }

    @Test
    public void testSave() throws Exception {
        // Arrange
        repo.delete(repo.findByCpf(cpf).getId());
        client = new Client(
                null, 
                Gerador.gerarNome(), 
                cpf,
                Gerador.gerarNumero(5), 
                1500.98);
        
        // Act
        Long idGerado =  repo.save(client);
        Client foundUser = repo.findById(idGerado);
        
        // Assert
        assertEquals(foundUser.getName(), client.getName());
        assertEquals(foundUser.getCpf(), client.getCpf());
        assertEquals(foundUser.getRg(), client.getRg());
        assertEquals(foundUser.getSalary(), client.getSalary());
    }
    
}
