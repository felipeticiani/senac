/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.repository;

import br.com.senac.crud.model.Client;
import java.sql.SQLException;

/**
 *
 * @author felipe.ticiani
 */
public interface IClientRepository {
    Long save(Client client) throws SQLException;
    Client findById(Long id) throws SQLException;
    Client findByCpf(String cpf) throws SQLException;
    void delete(Long id) throws SQLException;
}
