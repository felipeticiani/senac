/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Endereco;
import br.com.senac.entidade.Profissao;
import br.com.senac.entidade.Telefone;
import webservice.CepRest;
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
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDao clienteDao;
    private Session sessao;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
//        ProfissaoDaoImplTest pdit = new ProfissaoDaoImplTest();
//        Profissao profissao = pdit.buscarProfissaoBD(); 
        sessao = HibernateUtil.abrirConexao();

        Profissao profissao = new Profissao("Prog", "dfgdf");
        ProfissaoDao profissaoDao = new ProfissaoDaoImpl();
        profissaoDao.salvarOuAlterar(profissao, sessao);
        
        Telefone telefone = new Telefone(
                "(48)", 
                "9" + Gerador.gerarNumero(4) + "-" + Gerador.gerarNumero(4), 
                "TIM", 
                "Celular");
        
        CepRest cepRest = new CepRest();
        Endereco endereco = cepRest.pesquisaCep("88110612");
        endereco.setNumero("1234");
        endereco.setComplemento("Apto 9999");
        endereco.setObservacao("Residencial Tal");
        
        cliente = new Cliente(
                Gerador.gerarNome(),
                Gerador.gerarCpf(), 
                Gerador.gerarNumero(5),
                265656.36);
        cliente.setProfissao(profissao);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);

        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }
    
    @Test
    public void testPesquisarCep() {
        CepRest cepRest = new CepRest();
        Endereco endereco = cepRest.pesquisaCep("88110612");
        
        assertNotNull(endereco.getLogradouro());
    }
    
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarClienteBD();
        
        cliente.getTelefone().setNumero("9" + Gerador.gerarNumero(4) + "-" + Gerador.gerarNumero(4));
        cliente.getEndereco().setLogradouro("Rua Nova");
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Cliente cli = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        
        assertEquals(cliente.getTelefone().getNumero(), cli.getTelefone().getNumero());
        assertEquals(cliente.getEndereco().getLogradouro(), cli.getEndereco().getLogradouro());
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

    public Cliente buscarClienteBD() {
        try {
            sessao = HibernateUtil.abrirConexao();
            Query consulta = sessao.createQuery("from Cliente c");
            consulta.setMaxResults(1);
            List<Cliente> clientes = consulta.getResultList();
            if(clientes.isEmpty()) {
                testSalvar();
            } else {
                cliente = clientes.get(0);
            }
            consulta.getFirstResult();
        } catch (Exception e) {
            System.out.println("Erro no buscarClienteBD");
        } finally {
            sessao.close();
        }
        
        return cliente;
    }
}
