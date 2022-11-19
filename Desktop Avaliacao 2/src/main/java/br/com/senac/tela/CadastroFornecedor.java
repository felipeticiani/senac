/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.FornecedorDaoImpl;
import br.com.senac.dao.HibernateUtil;
import br.com.senac.entidade.Endereco;
import br.com.senac.entidade.Fornecedor;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import br.com.senac.webservice.CepRest;
import java.time.Instant;
import java.util.Date;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author felipe.ticiani
 */
public class CadastroFornecedor extends javax.swing.JFrame {
    
    private Session sessao;
    private Fornecedor fornecedor;
    private Endereco endereco;

    /**
     * Creates new form CadastroCliente
     */
    public CadastroFornecedor() {
        initComponents();
        btnAlterar.setVisible(false);
        varAtivo.setVisible(false);
        lblDataCadastro.setVisible(false);
        varDataCadastro.setVisible(false);
        fornecedor = new Fornecedor();
        endereco = new Endereco();
    }
    
    public CadastroFornecedor(Fornecedor fornecedor) {
        initComponents();
        this.fornecedor = fornecedor;
        this.endereco = fornecedor.getEndereco();
        btnSalvar.setVisible(false);
        lblTitulo.setText("Editar Fornecedor");
        popularCamposFornecedor();
        popularCamposEndereco();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        painel_01 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        painel_02 = new javax.swing.JPanel();
        lblCEP = new javax.swing.JLabel();
        varCEP = new javax.swing.JFormattedTextField();
        lblLogradouro = new javax.swing.JLabel();
        varLogradouro = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        varNumero = new javax.swing.JTextField();
        varComplemento = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        varBairro = new javax.swing.JTextField();
        lblLocalidade = new javax.swing.JLabel();
        varLocalidade = new javax.swing.JTextField();
        lblUF = new javax.swing.JLabel();
        varUF = new javax.swing.JTextField();
        lblObservacao = new javax.swing.JLabel();
        varObservacao = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        varAtivo = new javax.swing.JCheckBox();
        lblDataCadastro = new javax.swing.JLabel();
        varDataCadastro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de cliente");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar Fornecedor");

        painel_01.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email:");

        javax.swing.GroupLayout painel_01Layout = new javax.swing.GroupLayout(painel_01);
        painel_01.setLayout(painel_01Layout);
        painel_01Layout.setHorizontalGroup(
            painel_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_01Layout.createSequentialGroup()
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                    .addGroup(painel_01Layout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varNome)))
                .addContainerGap())
        );
        painel_01Layout.setVerticalGroup(
            painel_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEmail)
                    .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        painel_02.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        lblCEP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCEP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCEP.setText("CEP:");

        try {
            varCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varCEPFocusLost(evt);
            }
        });

        lblLogradouro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogradouro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogradouro.setText("Logradouro:");

        lblNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumero.setText("Número:");

        lblComplemento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblComplemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComplemento.setText("Complemento:");

        lblBairro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBairro.setText("Bairro:");

        lblLocalidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLocalidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLocalidade.setText("Localidade:");

        lblUF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUF.setText("UF:");

        lblObservacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblObservacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblObservacao.setText("Observação:");

        javax.swing.GroupLayout painel_02Layout = new javax.swing.GroupLayout(painel_02);
        painel_02.setLayout(painel_02Layout);
        painel_02Layout.setHorizontalGroup(
            painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogradouro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addComponent(lblCEP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblObservacao))
                .addGap(18, 18, 18)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblComplemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varComplemento))
                    .addComponent(varLogradouro)
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addComponent(varLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varUF))
                    .addGroup(painel_02Layout.createSequentialGroup()
                        .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addComponent(varObservacao))
                .addContainerGap())
        );
        painel_02Layout.setVerticalGroup(
            painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_02Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCEP)
                    .addComponent(varCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogradouro)
                    .addComponent(varLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNumero)
                    .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblComplemento)
                        .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocalidade)
                    .addComponent(varLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUF))
                .addGap(18, 18, 18)
                .addGroup(painel_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObservacao)
                    .addComponent(varObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        varAtivo.setText("Ativo");

        lblDataCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDataCadastro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDataCadastro.setText("Data de cadastro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painel_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painel_01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDataCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(varAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel_01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(varAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataCadastro)
                            .addComponent(varDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(8, 8, 8)
                        .addComponent(btnAlterar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private boolean validarFormularioDados() {
        if(varNome.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Digite o nome!");
            return false;
        }
        if(!varEmail.getText().contains("@") || !varEmail.getText().contains(".com")) {
            JOptionPane.showMessageDialog(null, "Digite o email corretamente!");
            return false;
        }
        return true;
    }
    
    private boolean validarFormularioEndereco() {
        if(varCEP.getText().trim().length() != 9) {
            JOptionPane.showMessageDialog(null, "Digite o CEP corretamente!");
            return false;
        }
        if(varLogradouro.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o logradouro!");
            return false;
        }
        if(varNumero.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o número!");
            return false;
        }
        if(varBairro.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o bairro!");
            return false;
        }
        if(varLocalidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a localidade!");
            return false;
        }
        if(varUF.getText().trim().length() != 2) {
            JOptionPane.showMessageDialog(null, "Informe a UF corretamente!");
            return false;
        }
        return true;
    }
    
    private Fornecedor popularObjetoFornecedor() {
        fornecedor.setNome(varNome.getText());
        fornecedor.setEmail(varEmail.getText());
        fornecedor.setData_cadastro(Date.from(Instant.now()));
        fornecedor.setAtivo(true);
        return fornecedor;
    }
    
    private void popularCamposFornecedor() {
        varNome.setText(fornecedor.getNome());
        varEmail.setText(fornecedor.getEmail());
        varAtivo.setSelected(fornecedor.isAtivo());
        varDataCadastro.setText(fornecedor.getData_cadastro().toString());
        varDataCadastro.setEditable(false);
    }
  
    private Endereco popularObjetoEndereco() {
        endereco.setLogradouro(varLogradouro.getText());
        endereco.setNumero(varNumero.getText());
        endereco.setComplemento(varComplemento.getText());
        endereco.setBairro(varBairro.getText());
        endereco.setObservacao(varObservacao.getText());
        return endereco;
    }
    
    private void popularCamposEndereco() {
        varCEP.setText(fornecedor.getEndereco().getCep());
        varLogradouro.setText(fornecedor.getEndereco().getLogradouro());
        varNumero.setText(fornecedor.getEndereco().getNumero());
        varComplemento.setText(fornecedor.getEndereco().getComplemento());
        varBairro.setText(fornecedor.getEndereco().getBairro());
        varLocalidade.setText(fornecedor.getEndereco().getLocalidade());
        varUF.setText(fornecedor.getEndereco().getUf());
        varObservacao.setText(fornecedor.getEndereco().getObservacao());
    }
    
    private boolean validarCampoCEP() {
        if (varCEP.getText().trim().length() != 9) {
            JOptionPane.showMessageDialog(null, "Digite o CEP corretamente!");
            return false;
        }
        return true;
    }
    
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (validarFormularioDados() && validarFormularioEndereco()) {
            try {
                sessao = HibernateUtil.abrirConexao();
                fornecedor = popularObjetoFornecedor();
                fornecedor.setEndereco(popularObjetoEndereco());
                fornecedor.setAtivo(varAtivo.isSelected());
                new FornecedorDaoImpl().salvarOuAlterar(fornecedor, sessao);
                JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!");
                this.dispose();
            } catch (ConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Fornecedor já cadastrado!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar fornecedor!");
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validarFormularioDados() && validarFormularioEndereco()) {
            try {
                sessao = HibernateUtil.abrirConexao();
                fornecedor = popularObjetoFornecedor();
                fornecedor.setEndereco(popularObjetoEndereco());
                new FornecedorDaoImpl().salvarOuAlterar(fornecedor, sessao);
                JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!");
                this.dispose();
            } catch (ConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Fornecedor já cadastrado!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar fornecedor!");
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void varCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varCEPFocusLost
        if (validarCampoCEP()) {
            CepRest cepRest = new CepRest();
            endereco = cepRest.pesquisarCep(varCEP.getText().replace("-", ""));
            if (endereco.getLogradouro() == null) {
                JOptionPane.showMessageDialog(null, "CEP não encontrado!");
            } else {
                varLogradouro.setText(endereco.getLogradouro());
                varBairro.setText(endereco.getBairro());
                varLocalidade.setText(endereco.getLocalidade());
                varUF.setText(endereco.getUf());
            }
        }
    }//GEN-LAST:event_varCEPFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDataCadastro;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLocalidade;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUF;
    private javax.swing.JPanel painel_01;
    private javax.swing.JPanel painel_02;
    private javax.swing.JCheckBox varAtivo;
    private javax.swing.JTextField varBairro;
    private javax.swing.JFormattedTextField varCEP;
    private javax.swing.JTextField varComplemento;
    private javax.swing.JTextField varDataCadastro;
    private javax.swing.JTextField varEmail;
    private javax.swing.JTextField varLocalidade;
    private javax.swing.JTextField varLogradouro;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNumero;
    private javax.swing.JTextField varObservacao;
    private javax.swing.JTextField varUF;
    // End of variables declaration//GEN-END:variables
}
