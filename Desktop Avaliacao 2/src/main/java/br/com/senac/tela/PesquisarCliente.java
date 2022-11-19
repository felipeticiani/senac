/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.ClienteDao;
import br.com.senac.dao.ClienteDaoImpl;
import br.com.senac.dao.HibernateUtil;
import br.com.senac.entidade.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author silvio.junior
 */
public class PesquisarCliente extends javax.swing.JFrame {

    private Cliente cliente;
    private List<Cliente> clientes;
    private ClienteDao clienteDao = new ClienteDaoImpl();
    private Session sessao;
            
    public PesquisarCliente() {
        initComponents();
        btAlterar.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titulo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Cliente");

        lb_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Pesquisar Cliente");

        lb_nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nome.setText("Nome:");

        btPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "CPF", "Profissão", "Endereço"
            }
        ));
        tbCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbCliente);

        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_nome)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btPesquisar)
                        .addComponent(btAlterar)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        String nome = varNome.getText().trim();
        if(nome.length() > 2){
            try {
                sessao = HibernateUtil.abrirConexao();
                clientes = clienteDao.pesquisarPorNome(nome, sessao);
                if(clientes.isEmpty()){
                    JOptionPane.showMessageDialog(null, 
                            "Nenhum valor encontrado.");
                }else{
                    carregarTabelaCliente();
                    btAlterar.setVisible(true);
                }
            } catch (HibernateException e) {
                System.out.println("Erro ao pesquisar por nome "
                     + e.getMessage());
            }finally{
                sessao.close();
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Digite pelo menos 3 caracteres para pesquisa.");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int linhaSelecionada = tbCliente.getSelectedRow();
        if(linhaSelecionada >= 0){
            cliente = clientes.get(linhaSelecionada);
            new CadastroCliente(cliente).setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma "
                    + "linha para alterar!");
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void carregarTabelaCliente(){
        DefaultTableModel defaultTable = (DefaultTableModel)
                                         tbCliente.getModel();
        defaultTable.setNumRows(0);
        clientes.stream().forEach(cli -> {
            defaultTable.addRow(new Object[]{
               cli.getNome(), 
               cli.getTelefone().getDdd() + cli.getTelefone().getNumero(),
               cli.getCpf(),
               cli.getProfissao().getNome(),
               cli.getEndereco().getLogradouro() 
            });
        });
    }
    
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
            java.util.logging.Logger.getLogger(PesquisarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTextField varNome;
    // End of variables declaration//GEN-END:variables
}
