/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Profissao;
import br.com.senac.util.Gerador;
import java.util.List;
import org.hibernate.Session;
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
        
        cliente = new Cliente(Gerador.gerarNome(),
                Gerador.gerarCpf(), Gerador.gerarNumero(5),
                265656.36, profissao);
        cliente.setProfissao(profissao);

        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

}
