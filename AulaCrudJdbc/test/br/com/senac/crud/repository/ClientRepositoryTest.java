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
        cpf = "321.086.064-50";
        repo = new ClientRepository();
    }

    @Test
    public void testSave() throws Exception {
        // Arrange
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
        repo.delete(idGerado);
    }
    
    @Test
    public void testUpdate() throws Exception {
        // Arrange
        client = new Client(
                null, 
                Gerador.gerarNome(), 
                cpf,
                Gerador.gerarNumero(5), 
                1500.98);
        Long idGerado = repo.save(client);
        client = repo.findByCpf(cpf);
        
        // Act
        client.setName(Gerador.gerarNome());
        repo.update(client);
        Client foundClient = repo.findByCpf(cpf);
        
        // Assert
        assertEquals(foundClient.getName(), client.getName());
        assertEquals(foundClient.getCpf(), client.getCpf());
        assertEquals(foundClient.getRg(), client.getRg());
        assertEquals(foundClient.getSalary(), client.getSalary());
        repo.delete(idGerado);
    }
    
    @Test
    public void testDelete() throws Exception {
        // Arrange
        client = new Client(
                null, 
                Gerador.gerarNome(), 
                cpf,
                Gerador.gerarNumero(5), 
                1500.98);
        Long idGerado = repo.save(client);
        client = repo.findByCpf(cpf);
        
        // Act
        repo.delete(idGerado);
        Client foundClient = repo.findByCpf(cpf);
        
        // Assert
        assertNull(foundClient);
    }
    
}
