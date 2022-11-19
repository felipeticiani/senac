/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.ClienteDao;
import br.com.senac.dao.ClienteDaoImpl;
import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.ProfissaoDao;
import br.com.senac.dao.ProfissaoDaoImpl;
import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Endereco;
import br.com.senac.entidade.Profissao;
import br.com.senac.entidade.Telefone;
import br.com.senac.webservice.CepRest;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author silvio.junior
 */
public class CadastroCliente extends javax.swing.JFrame {

    private Cliente cliente;
    private Telefone telefone;
    private Endereco endereco;
    private ClienteDao clienteDao = new ClienteDaoImpl();
    private List<Profissao> profissaos;
    private Session sessao;

    public CadastroCliente() {
        initComponents();
        carregaComboProfissao();
        //varLogradouro.setEditable(false);
    }

    public CadastroCliente(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        telefone = cliente.getTelefone();
        endereco = cliente.getEndereco();
        carregaComboProfissao();
        carregarAlteracaoCliente();
    }
    
    private void carregarAlteracaoCliente(){
        //objeto cliente
        varNome.setText(cliente.getNome());
        varCpf.setText(cliente.getCpf());
        varSalario.setText(Double.toString(cliente.getSalario()));
        varRg.setText(cliente.getRg());
        //objeto telefone
        String tipo = telefone.getTipo();
        varTipoTelefone.getModel().setSelectedItem(tipo);
        String operadora = telefone.getOperadora();
        varOperadora.getModel().setSelectedItem(operadora);        
        String ddd = cliente.getTelefone().getDdd();
        varTelefone.setText(ddd + telefone.getNumero());
        //objeto profissão
        varProfissao.getModel()
            .setSelectedItem(cliente.getProfissao().getNome());
        //objeto endereço
        varCep.setText(endereco.getCep());
        varLogradouro.setText(endereco.getLogradouro());
        varBairro.setText(endereco.getBairro());
        varCidade.setText(endereco.getLocalidade());
        varEstado.setText(endereco.getUf());
        varNumero.setText(endereco.getNumero());
        varComplemento.setText(endereco.getComplemento());
        varObservacao.setText(endereco.getObservacao());        
    }
    
    private void carregaComboProfissao(){
        ProfissaoDao profissaoDao = new ProfissaoDaoImpl();
        try {
            sessao = HibernateUtil.abrirConexao();
            profissaos = profissaoDao.pesquisarTodos(sessao);
            profissaos.stream().forEach(profissao -> {
                varProfissao.addItem(profissao.getNome());
            });      
        } catch (HibernateException e) {
            System.out.println("Erro ao pesquisar todas "
                    + "profissões " + e.getMessage());
        }finally{
            sessao.close();
        }
    }
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titulo = new javax.swing.JLabel();
        lb_telefone = new javax.swing.JPanel();
        lb_nome = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        lb_salario = new javax.swing.JLabel();
        varSalario = new javax.swing.JFormattedTextField();
        lb_tipo = new javax.swing.JLabel();
        varTipoTelefone = new javax.swing.JComboBox<>();
        lb_tipo1 = new javax.swing.JLabel();
        varCep = new javax.swing.JFormattedTextField();
        btBuscar = new javax.swing.JButton();
        lb_tipo2 = new javax.swing.JLabel();
        varProfissao = new javax.swing.JComboBox<>();
        lb_tipo3 = new javax.swing.JLabel();
        lb_tipo4 = new javax.swing.JLabel();
        lb_tipo5 = new javax.swing.JLabel();
        varBairro = new javax.swing.JTextField();
        varEstado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        varComplemento = new javax.swing.JTextArea();
        painel_02 = new javax.swing.JPanel();
        lb_cpf = new javax.swing.JLabel();
        varCpf = new javax.swing.JFormattedTextField();
        lb_cpf1 = new javax.swing.JLabel();
        varTelefone = new javax.swing.JFormattedTextField();
        lb_cpf2 = new javax.swing.JLabel();
        varLogradouro = new javax.swing.JTextField();
        lb_rg = new javax.swing.JLabel();
        varRg = new javax.swing.JTextField();
        lb_cpf3 = new javax.swing.JLabel();
        varOperadora = new javax.swing.JComboBox<>();
        lb_cpf4 = new javax.swing.JLabel();
        lb_cpf5 = new javax.swing.JLabel();
        lb_cpf6 = new javax.swing.JLabel();
        varCidade = new javax.swing.JTextField();
        varNumero = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        varObservacao = new javax.swing.JTextArea();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente");

        lb_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Cadastro de Cliente");

        lb_nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nome.setText("Nome:");

        lb_salario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_salario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_salario.setText("Salário:");

        varSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        lb_tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_tipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tipo.setText("Tipo Telefone:");

        varTipoTelefone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um tipo...", "Fixo", "Celular" }));

        lb_tipo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_tipo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tipo1.setText("CEP:");

        try {
            varCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        lb_tipo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_tipo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tipo2.setText("Profissão:");

        varProfissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha uma profissão..." }));

        lb_tipo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_tipo3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tipo3.setText("Bairro:");

        lb_tipo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_tipo4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tipo4.setText("Estado:");

        lb_tipo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_tipo5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tipo5.setText("Complemento:");

        varComplemento.setColumns(20);
        varComplemento.setRows(5);
        jScrollPane1.setViewportView(varComplemento);

        javax.swing.GroupLayout lb_telefoneLayout = new javax.swing.GroupLayout(lb_telefone);
        lb_telefone.setLayout(lb_telefoneLayout);
        lb_telefoneLayout.setHorizontalGroup(
            lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lb_telefoneLayout.createSequentialGroup()
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lb_telefoneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lb_telefoneLayout.createSequentialGroup()
                                .addComponent(lb_tipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(varCep, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(lb_telefoneLayout.createSequentialGroup()
                                .addComponent(lb_tipo3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(varBairro))
                            .addGroup(lb_telefoneLayout.createSequentialGroup()
                                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lb_telefoneLayout.createSequentialGroup()
                                        .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(lb_telefoneLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(lb_telefoneLayout.createSequentialGroup()
                                                .addComponent(lb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(varTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(lb_telefoneLayout.createSequentialGroup()
                                                .addComponent(lb_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(varSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(lb_telefoneLayout.createSequentialGroup()
                                                .addComponent(lb_tipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(varProfissao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(lb_telefoneLayout.createSequentialGroup()
                        .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_tipo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_tipo5, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varEstado)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        lb_telefoneLayout.setVerticalGroup(
            lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lb_telefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_salario)
                    .addComponent(varSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipo)
                    .addComponent(varTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipo2)
                    .addComponent(varProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipo1)
                    .addComponent(varCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipo3)
                    .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipo4)
                    .addComponent(varEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lb_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_tipo5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lb_cpf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_cpf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cpf.setText("CPF:");

        try {
            varCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lb_cpf1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_cpf1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cpf1.setText("Telefone:");

        try {
            varTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lb_cpf2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_cpf2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cpf2.setText("Logradouro:");

        lb_rg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_rg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_rg.setText("RG:");

        lb_cpf3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_cpf3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cpf3.setText("Operadora:");

        varOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha a operadora...", "Claro", "Tim", "Vivo", "Unifique", "Surf", "Correios" }));

        lb_cpf4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_cpf4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cpf4.setText("Cidade:");

        lb_cpf5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_cpf5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cpf5.setText("Número:");

        lb_cpf6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_cpf6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cpf6.setText("Observação:");

        varObservacao.setColumns(20);
        varObservacao.setRows(5);
        jScrollPane2.setViewportView(varObservacao);

        javax.swing.GroupLayout painel_02Layout = new javax.swing.GroupLayout(painel_02);
        painel_02.setLayout(painel_02Layout);
        painel_02Layout.setHorizontalGroup(
            painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_cpf2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_cpf3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varOperadora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varRg))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_cpf1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_cpf4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varCidade))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_cpf5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(lb_cpf6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        painel_02Layout.setVerticalGroup(
            painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf)
                    .addComponent(varCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_rg)
                    .addComponent(varRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf1)
                    .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf3)
                    .addComponent(varOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf2)
                    .addComponent(varLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf4)
                    .addComponent(varCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf5)
                    .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_cpf6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painel_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_telefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addGap(42, 42, 42))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (validarFormulario()) {
            if(cliente == null){
                cliente = new Cliente();
                telefone = new Telefone();
            }
            
            carregarFormulario();
            try {
                sessao = HibernateUtil.abrirConexao();
                clienteDao.salvarOuAlterar(cliente, sessao);
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                dispose();
                new TelaPrincipal().setVisible(true);
            } catch ( HibernateException e) {
                System.out.println("Erro ao salvar usuário!");
            } finally {
                sessao.close();
            }

        }


    }//GEN-LAST:event_btSalvarActionPerformed

    private void carregarFormulario() {        
        cliente.setNome(varNome.getText().trim());
        cliente.setCpf(varCpf.getText());
        cliente.setRg(varRg.getText().trim());
        //inicio formatando salário
        String salarioTela = varSalario.getText();
        salarioTela = salarioTela.replace(".", "");
        salarioTela = salarioTela.replace(",", ".");
        double salario = Double.parseDouble(salarioTela);
        cliente.setSalario(salario);
        // setando profissão
        int indice = varProfissao.getSelectedIndex();
        indice--;
        Profissao profissao = profissaos.get(indice);
        cliente.setProfissao(profissao);
        
        //setando telefone
        
        telefone.setTipo(varTipoTelefone.getSelectedItem().toString());
        telefone.setOperadora(varOperadora.getSelectedItem().toString());
        telefone.setDdd(varTelefone.getText().substring(0, 4));
        telefone.setNumero(varTelefone.getText().substring(4));
        cliente.setTelefone(telefone);

        //setando endereco
        if (endereco.getLogradouro() != null) {
            endereco.setNumero(varNumero.getText().trim());
            endereco.setComplemento(varComplemento.getText().trim());
            endereco.setObservacao(varObservacao.getText().trim());
        } else {
            endereco.setLogradouro(varLogradouro.getText().trim());
            endereco.setLocalidade(varCidade.getText().trim());
            endereco.setUf(varEstado.getText().trim());
            endereco.setBairro(varBairro.getText().trim());
            endereco.setCep(varCep.getText());
        }
        cliente.setEndereco(endereco);
    }

    private boolean validarFormulario() {
        String nome = varNome.getText().trim();
        if (validarMenorQue3(nome)) {
            JOptionPane.showMessageDialog(null, "Digite o nome corretamente!");
            return false;
        }

        String cpf = varCpf.getText().trim();
        if (cpf.length() < 14) {
            JOptionPane.showMessageDialog(null, "Digite um cpf corretamente!");
            return false;
        }

        String salarioTela = varSalario.getText().trim();
        if (salarioTela.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo salário não pode estar em branco!");
            return false;
        }//1256
        salarioTela = salarioTela.replace(".", "");
        salarioTela = salarioTela.replace(",", ".");//1256
        double salario = Double.parseDouble(salarioTela);

        if (salario <= 0) {
            JOptionPane.showMessageDialog(null, "O salário não pode ser negativo!");
            return false;
        }

        String rg = varRg.getText().trim();
        if (validarMenorQue3(rg)) {
            JOptionPane.showMessageDialog(null, "Digite o RG corretamente!");
            return false;
        }

        if (varTipoTelefone.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha um tipo de telefone!");
            return false;
        }

        String telefone = varTelefone.getText().trim();
        if (telefone.length() < 14) {
            JOptionPane.showMessageDialog(null, "Digite um telefone corretamente!");
            return false;
        }

//        if(varProfissao.getSelectedIndex() == 0){
//            JOptionPane.showMessageDialog(null, "Escolha uma profissão!");
//            return false;
//        }
        if (varOperadora.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha uma operadora!");
            return false;
        }

        String cep = varCep.getText().trim(); //99999-999
        if (cep.length() < 9) {
            JOptionPane.showMessageDialog(null, "Preencha o CEP corretamente!");
            return false;
        }

        String logradouro = varLogradouro.getText().trim();
        if (validarMenorQue3(logradouro)) {
            JOptionPane.showMessageDialog(null, "Digite o logradouro corretamente!");
            return false;
        }

        String bairro = varBairro.getText().trim();
        if (validarMenorQue3(bairro)) {
            JOptionPane.showMessageDialog(null, "Digite o bairro corretamente!");
            return false;
        }

        String cidade = varCidade.getText().trim();
        if (validarMenorQue3(cidade)) {
            JOptionPane.showMessageDialog(null, "Digite a cidade corretamente!");
            return false;
        }

        String estado = varEstado.getText().trim();
        if (estado.length() != 2) {
            JOptionPane.showMessageDialog(null, "Digite a sigla do estado!");
            return false;
        }

        String numero = varNumero.getText().trim();
        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um número!");
            return false;
        }

        String complemento = varComplemento.getText().trim();
        if (validarMenorQue3(complemento)) {
            JOptionPane.showMessageDialog(null, "Digite um complemento corretamente!");
            return false;
        }

        return true;
    }

    private boolean validarMenorQue3(String valor) {
        return valor.length() < 3;
    }

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        String cep = varCep.getText().trim();
        if (cep.length() == 9) {
            CepRest cepRest = new CepRest();
            endereco = cepRest.pesquisarCep(cep);
            if (endereco.getLogradouro() == null) {
                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum com esse número.\n"
                        + "Preencha os dados do endereço manualmente");

            } else {
                varLogradouro.setText(endereco.getLogradouro());
                varBairro.setText(endereco.getBairro());
                varCidade.setText(endereco.getLocalidade());
                varEstado.setText(endereco.getUf());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha o CEP corretamente!");
        }

    }//GEN-LAST:event_btBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_cpf;
    private javax.swing.JLabel lb_cpf1;
    private javax.swing.JLabel lb_cpf2;
    private javax.swing.JLabel lb_cpf3;
    private javax.swing.JLabel lb_cpf4;
    private javax.swing.JLabel lb_cpf5;
    private javax.swing.JLabel lb_cpf6;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_rg;
    private javax.swing.JLabel lb_salario;
    private javax.swing.JPanel lb_telefone;
    private javax.swing.JLabel lb_tipo;
    private javax.swing.JLabel lb_tipo1;
    private javax.swing.JLabel lb_tipo2;
    private javax.swing.JLabel lb_tipo3;
    private javax.swing.JLabel lb_tipo4;
    private javax.swing.JLabel lb_tipo5;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JPanel painel_02;
    private javax.swing.JTextField varBairro;
    private javax.swing.JFormattedTextField varCep;
    private javax.swing.JTextField varCidade;
    private javax.swing.JTextArea varComplemento;
    private javax.swing.JFormattedTextField varCpf;
    private javax.swing.JTextField varEstado;
    private javax.swing.JTextField varLogradouro;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNumero;
    private javax.swing.JTextArea varObservacao;
    private javax.swing.JComboBox<String> varOperadora;
    private javax.swing.JComboBox<String> varProfissao;
    private javax.swing.JTextField varRg;
    private javax.swing.JFormattedTextField varSalario;
    private javax.swing.JFormattedTextField varTelefone;
    private javax.swing.JComboBox<String> varTipoTelefone;
    // End of variables declaration//GEN-END:variables

}
