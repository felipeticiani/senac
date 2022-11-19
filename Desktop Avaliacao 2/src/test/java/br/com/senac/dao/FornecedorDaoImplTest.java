/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Endereco;
import br.com.senac.entidade.Fornecedor;
import br.com.senac.util.Gerador;
import br.com.senac.webservice.CepRest;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author silvio.junior
 */
public class FornecedorDaoImplTest {

    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;

    public FornecedorDaoImplTest() {
        fornecedorDao = new FornecedorDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        
        sessao = HibernateUtil.abrirConexao();
        fornecedor = new Fornecedor(Gerador.gerarNome(),
                Gerador.gerarLogin() + Gerador.gerarNumero(4) + "@email.com",
                new Date(),
                true);
        
        CepRest cepRest = new CepRest();
        Endereco endereco = cepRest.pesquisarCep(Gerador.gerarCep());
        endereco.setNumero(Gerador.gerarNumero(3));
        endereco.setComplemento("Casa");
        endereco.setObservacao("Px a vaca malhada");
        
        fornecedor.setEndereco(endereco);
        
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        assertNotNull(fornecedor.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarClienteBD();        
        fornecedor.setNome(Gerador.gerarNome() + " alt");
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Fornecedor forne = fornecedorDao.pesquisarPorId(fornecedor.getId(),
                  sessao);
        sessao.close();
        assertEquals(fornecedor.getNome(), forne.getNome());
    }
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }
    
    public Fornecedor buscarClienteBD(){
        String sql = "from Fornecedor c ";
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery(sql);
        consulta.setMaxResults(1);
        List<Fornecedor> fornecedores = consulta.getResultList();
        sessao.close();
        if(fornecedores.isEmpty()){
            testSalvar();
        }else{
            fornecedor = fornecedores.get(0);
        }
        return fornecedor;
    }

}
