/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.entidade.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author silvio.junior
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Usuario usuario;
    
    public TelaPrincipal() {
        initComponents();
    }
    
    public TelaPrincipal(Usuario usuario) {
        initComponents();
        this.usuario = usuario;   
        varUsuarioLogado.setText("Seja bem vindo " 
                                    + usuario.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        varUsuarioLogado = new javax.swing.JLabel();
        icone_cad_usuario = new javax.swing.JLabel();
        icone_pesq_usuario = new javax.swing.JLabel();
        icone_cad_fornecedor = new javax.swing.JLabel();
        icone_pesq_fornecedor = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        lblFornecedores = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_cadastro = new javax.swing.JMenu();
        item_cad_usuario = new javax.swing.JMenuItem();
        item_cad_perfil = new javax.swing.JMenuItem();
        item_cad_fornecedor = new javax.swing.JMenuItem();
        menu_pesquisa = new javax.swing.JMenu();
        item_pesq_usuario = new javax.swing.JMenuItem();
        item_pesq_perfil = new javax.swing.JMenuItem();
        item_pesq_fornecedor = new javax.swing.JMenuItem();
        menuTrocaSenha = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Senac");

        icone_cad_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cad_usuario.png"))); // NOI18N
        icone_cad_usuario.setToolTipText("Novo Usuário");
        icone_cad_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_cad_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_cad_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_cad_usuarioMouseClicked(evt);
            }
        });

        icone_pesq_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/pesq_usario.png"))); // NOI18N
        icone_pesq_usuario.setToolTipText("Pesquisa de usuário");
        icone_pesq_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_pesq_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_pesq_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_pesq_usuarioMouseClicked(evt);
            }
        });

        icone_cad_fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cad_fornecedor.png"))); // NOI18N
        icone_cad_fornecedor.setToolTipText("Novo Usuário");
        icone_cad_fornecedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_cad_fornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_cad_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_cad_fornecedorMouseClicked(evt);
            }
        });

        icone_pesq_fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/pes_fornecedor.png"))); // NOI18N
        icone_pesq_fornecedor.setToolTipText("Pesquisa de usuário");
        icone_pesq_fornecedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_pesq_fornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_pesq_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_pesq_fornecedorMouseClicked(evt);
            }
        });

        lblUsuarios.setText("Usuários");

        lblFornecedores.setText("Fornecedores");

        menu_cadastro.setText("Cadastro");

        item_cad_usuario.setText("Usuario");
        menu_cadastro.add(item_cad_usuario);

        item_cad_perfil.setText("Perfil");
        item_cad_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cad_perfilActionPerformed(evt);
            }
        });
        menu_cadastro.add(item_cad_perfil);

        item_cad_fornecedor.setText("Fornecedor");
        item_cad_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cad_fornecedorActionPerformed(evt);
            }
        });
        menu_cadastro.add(item_cad_fornecedor);

        jMenuBar1.add(menu_cadastro);

        menu_pesquisa.setText("Pesquisa");

        item_pesq_usuario.setText("Usuario");
        menu_pesquisa.add(item_pesq_usuario);

        item_pesq_perfil.setText("Perfil");
        item_pesq_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_pesq_perfilActionPerformed(evt);
            }
        });
        menu_pesquisa.add(item_pesq_perfil);

        item_pesq_fornecedor.setText("Fornecedor");
        item_pesq_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_pesq_fornecedorActionPerformed(evt);
            }
        });
        menu_pesquisa.add(item_pesq_fornecedor);

        jMenuBar1.add(menu_pesquisa);

        menuTrocaSenha.setText("Trocar Senha");
        menuTrocaSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTrocaSenhaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuTrocaSenha);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(498, Short.MAX_VALUE)
                .addComponent(varUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFornecedores)
                    .addComponent(lblUsuarios)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icone_cad_fornecedor)
                        .addGap(48, 48, 48)
                        .addComponent(icone_pesq_fornecedor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icone_cad_usuario)
                        .addGap(48, 48, 48)
                        .addComponent(icone_pesq_usuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(varUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icone_cad_usuario)
                    .addComponent(icone_pesq_usuario))
                .addGap(36, 36, 36)
                .addComponent(lblFornecedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icone_cad_fornecedor)
                    .addComponent(icone_pesq_fornecedor))
                .addGap(0, 99, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void icone_cad_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_cad_usuarioMouseClicked
        new CadastroUsuario().setVisible(true);
    }//GEN-LAST:event_icone_cad_usuarioMouseClicked

    private void icone_pesq_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_pesq_usuarioMouseClicked
        new PesquisaUsuario().setVisible(true);
    }//GEN-LAST:event_icone_pesq_usuarioMouseClicked

    private void item_cad_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cad_perfilActionPerformed
        new CadastroPerfil().setVisible(true);
    }//GEN-LAST:event_item_cad_perfilActionPerformed

    private void item_pesq_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_pesq_perfilActionPerformed
        new PesquisaPerfil().setVisible(true);
    }//GEN-LAST:event_item_pesq_perfilActionPerformed

    private void menuTrocaSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTrocaSenhaMouseClicked
       new AlteraSenha(usuario).setVisible(true);
       
       dispose();
    }//GEN-LAST:event_menuTrocaSenhaMouseClicked

    private void icone_cad_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_cad_fornecedorMouseClicked
        new CadastroFornecedor().setVisible(true);
    }//GEN-LAST:event_icone_cad_fornecedorMouseClicked

    private void icone_pesq_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_pesq_fornecedorMouseClicked
        new PesquisaFornecedor().setVisible(true);
    }//GEN-LAST:event_icone_pesq_fornecedorMouseClicked

    private void item_cad_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cad_fornecedorActionPerformed
        new CadastroFornecedor().setVisible(true);
    }//GEN-LAST:event_item_cad_fornecedorActionPerformed

    private void item_pesq_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_pesq_fornecedorActionPerformed
        new PesquisaFornecedor().setVisible(true);
    }//GEN-LAST:event_item_pesq_fornecedorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                TelaPrincipal tela = new TelaPrincipal();
//                tela.setVisible(true);
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icone_cad_fornecedor;
    private javax.swing.JLabel icone_cad_usuario;
    private javax.swing.JLabel icone_pesq_fornecedor;
    private javax.swing.JLabel icone_pesq_usuario;
    private javax.swing.JMenuItem item_cad_fornecedor;
    private javax.swing.JMenuItem item_cad_perfil;
    private javax.swing.JMenuItem item_cad_usuario;
    private javax.swing.JMenuItem item_pesq_fornecedor;
    private javax.swing.JMenuItem item_pesq_perfil;
    private javax.swing.JMenuItem item_pesq_usuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblFornecedores;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JMenu menuTrocaSenha;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenu menu_pesquisa;
    private javax.swing.JLabel varUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}
