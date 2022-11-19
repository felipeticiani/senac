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
import br.com.senac.util.Gerador;
import br.com.senac.webservice.CepRest;
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

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ProfissaoDaoImplTest pdit = new ProfissaoDaoImplTest();
        Profissao profissao = pdit.buscarProfissaoBD(); 
        sessao = HibernateUtil.abrirConexao();
        
        cliente = new Cliente(Gerador.gerarNome(),
                Gerador.gerarCpf(), Gerador.gerarNumero(5),
                265656.36);
        cliente.setProfissao(profissao);
        
        Telefone telefone = new Telefone("98888-9988", "(48)", 
                "Oi", "Celular");
        cliente.setTelefone(telefone);
        
        CepRest cepRest = new CepRest();
        Endereco endereco = cepRest.pesquisarCep(Gerador.gerarCep());
        endereco.setNumero(Gerador.gerarNumero(3));
        endereco.setComplemento("Casa");
        endereco.setObservacao("Px a vaca malhada");
        
        cliente.setEndereco(endereco);
        
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarClienteBD();        
        cliente.getTelefone().setNumero("98877-7070");
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Cliente cli = clienteDao.pesquisarPorId(cliente.getId(),
                  sessao);
        sessao.close();
        assertEquals(cliente.getTelefone().getNumero(),
                     cli.getTelefone().getNumero());
    }
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }
    
    public Cliente buscarClienteBD(){
        String sql = "from Cliente c ";
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery(sql);
        consulta.setMaxResults(1);
        List<Cliente> clientes = consulta.getResultList();
        sessao.close();
        if(clientes.isEmpty()){
            testSalvar();
        }else{
            cliente = clientes.get(0);
        }
        return cliente;
    }

}
