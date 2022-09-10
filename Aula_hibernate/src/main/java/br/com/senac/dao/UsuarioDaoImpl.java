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
import org.hibernate.query.Query;

/**
 *
 * @author felipe.ticiani
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario,Long> implements UsuarioDao {

    @Override
    public Usuario pesquisarPorID(Long id, Session session) throws HibernateException {
        return session.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome, Session session) throws HibernateException {
        Query<Usuario> consulta = session.createQuery("FROM Usuario WHERE nome LIKE :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Usuario> pesquisarTodos(Session session) throws HibernateException {
        return session.createQuery("FROM Usuario ORDER BY nome").getResultList();
    }

    @Override
    public Usuario logar(Session session, String login, String senha) throws HibernateException {
        Query<Usuario> consulta = session.createQuery("FROM Usuario WHERE login = :login AND senha = :senha");
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return consulta.uniqueResult();
    }

}
