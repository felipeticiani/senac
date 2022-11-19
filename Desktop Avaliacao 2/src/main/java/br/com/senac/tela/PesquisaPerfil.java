/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.PerfilDao;
import br.com.senac.dao.PerfilDaoImpl;
import br.com.senac.entidade.Perfil;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author silvio.junior
 */
public class PesquisaPerfil extends javax.swing.JFrame {

    private Session sessao;
    private Perfil perfil;
    private PerfilDao perfilDao = new PerfilDaoImpl();
    private List<Perfil> perfis;

    public PesquisaPerfil() {
        initComponents();
        pesquisarTodosPerfil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPerfil = new javax.swing.JTable();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Perfil");

        lb_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Pesquisa de Perfil");

        tbPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Situação"
            }
        ));
        tbPerfil.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbPerfil);

        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarTodosPerfil(){
        try {
            sessao = HibernateUtil.abrirConexao();
            perfis = perfilDao.pesquisarTodos(sessao);
            carregarTabelaPerfil();
        } catch (HibernateException e) {
            System.out.println("Erro ao pesquisar "
                    + e.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linhaSelecionada = tbPerfil.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(null,
                    "Selecione um perfil para excluir!");
        } else {
            try {
                sessao = HibernateUtil.abrirConexao();
                perfil = perfis.get(linhaSelecionada);
                perfilDao.excluir(perfil, sessao);
                JOptionPane.showMessageDialog(null,
                        "Perfil deletado com sucesso!");
                dispose();
            } catch (HibernateException e) {
                System.out.println("Erro ao excluir "
                        + e.getMessage());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int linhaSelecionada = tbPerfil.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(null,
                    "Selecione um perfil para alterar!");
        } else {
            perfil = perfis.get(linhaSelecionada);
            new CadastroPerfil(perfil).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void carregarTabelaPerfil() {
        DefaultTableModel defaultTable = (DefaultTableModel) tbPerfil.getModel();
        defaultTable.setNumRows(0);
        perfis.stream()
                .forEach(perf -> {
                    defaultTable.addRow(new Object[]{
                        perf.getNome(),
                        perf.getDescricao(),
                        perf.isAtivo() ? "Ativo" : "Inativo"
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
            java.util.logging.Logger.getLogger(PesquisaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTable tbPerfil;
    // End of variables declaration//GEN-END:variables
}
