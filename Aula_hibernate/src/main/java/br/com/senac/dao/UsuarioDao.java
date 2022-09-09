/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author felipe.ticiani
 */
public interface UsuarioDao extends BaseDao<Usuario, Long> {
    List<Usuario> pesquisarPorNome(String nome, Session session) throws HibernateException;
    List<Usuario> pesquisarTodos(Session session) throws HibernateException;
    Usuario logar(Session session, String login, String senha) throws HibernateException;
}
