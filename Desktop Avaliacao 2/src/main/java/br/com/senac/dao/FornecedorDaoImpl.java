/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author silvio.junior
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long>
                       implements FornecedorDao, Serializable{

    @Override
    public Fornecedor pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Fornecedor.class, id);
    }

    @Override
    public List<Fornecedor> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao
        .createQuery("from Fornecedor c where c.nome like :nome order by c.nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Fornecedor> pesquisarPorNomeEStatus(String nome, boolean status, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao
        .createQuery("from Fornecedor c where c.nome like :nome and c.ativo = :status order by c.nome");
        consulta.setParameter("nome", "%" + nome + "%");
        consulta.setParameter("status", status);
        return consulta.getResultList();
    }
    
}
