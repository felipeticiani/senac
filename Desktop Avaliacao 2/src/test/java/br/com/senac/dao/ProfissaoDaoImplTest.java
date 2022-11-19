/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import br.com.senac.util.Gerador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author silvio.junior
 */
public class ProfissaoDaoImplTest {
    
    private Profissao profissao;
    private ProfissaoDao profissaoDao;
    private Session sessao;    
    
    public ProfissaoDaoImplTest() {
        profissaoDao = new ProfissaoDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        profissao = new Profissao(Gerador.gerarNome(), 
                                            "bla, bla...", true);
        sessao = HibernateUtil.abrirConexao();
        profissaoDao.salvarOuAlterar(profissao, sessao);
        sessao.close();
        assertNotNull(profissao.getId());
    }
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

//    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
    }
    
    public Profissao buscarProfissaoBD(){
        sessao = HibernateUtil.abrirConexao();
        Query<Profissao> consulta = sessao
                   .createQuery("from Profissao p");
        consulta.setFirstResult(1);
        List<Profissao> profissaos = consulta.getResultList();
        sessao.close();
        if(profissaos.isEmpty()){
            testSalvar();
        }else{
            profissao = profissaos.get(0);
        }
        return profissao;
    }
    
}
