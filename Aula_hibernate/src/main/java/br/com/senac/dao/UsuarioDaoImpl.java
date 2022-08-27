/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author felipe.ticiani
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario,Long> implements UsuarioDao {

    @Override
    public Usuario pesquisarPorID(Long id, Session session) throws HibernateException {
        return session.find(Usuario.class, id);
    }

    
}
