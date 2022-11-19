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
 * @author silvio.junior
 */
public interface BaseDao<T, ID> {
    
    void salvarOuAlterar(T entidade, Session sessao) throws HibernateException;
    
    void excluir(T entidade, Session sessao) throws HibernateException;
    
    T pesquisarPorId(Long id, Session sessao)throws HibernateException;
    
}
