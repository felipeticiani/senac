/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author felipe.ticiani
 */
public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID> {
    
    private Transaction transaction;

    @Override
    public void salvarOuAlterar(T entidade, Session session) throws HibernateException {
        transaction = session.beginTransaction();
        session.saveOrUpdate(entidade);
        transaction.commit(); 
    }

    @Override
    public void excluir(T entidade, Session session) throws HibernateException {
        transaction = session.beginTransaction();
        session.delete(entidade);
        transaction.commit();
    }

}
