/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.entidade.Usuario;

/**
 *
 * @author felipe.ticiani
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private Usuario usuario;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }
    
    public TelaPrincipal(Usuario usuario) {
        initComponents();
        if (usuario != null && usuario.getNome().isEmpty()) {
            lblBemVindo.setVisible(false);
        } else {
            this.usuario = usuario;
            lblBemVindo.setText(lblBemVindo.getText() + usuario.getNome() + "!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBemVindo = new javax.swing.JLabel();
        icone_cad_usuario = new javax.swing.JLabel();
        icone_pes_usuario = new javax.swing.JLabel();
        icone_cad_perfil = new javax.swing.JLabel();
        icone_pes_perfil = new javax.swing.JLabel();
        lbl_cad_usuario = new javax.swing.JLabel();
        lbl_pes_usuario = new javax.swing.JLabel();
        lbl_cad_perfil = new javax.swing.JLabel();
        lbl_pes_perfil = new javax.swing.JLabel();
        lbl_cad_perfil1 = new javax.swing.JLabel();
        icone_cad_perfil1 = new javax.swing.JLabel();
        lbl_pes_perfil1 = new javax.swing.JLabel();
        icone_pes_perfil1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_cadastro = new javax.swing.JMenu();
        item_cad_usuario = new javax.swing.JMenuItem();
        item_cad_perfil = new javax.swing.JMenuItem();
        menu_pesquisa = new javax.swing.JMenu();
        item_pes_usuario = new javax.swing.JMenuItem();
        item_pes_perfil = new javax.swing.JMenuItem();
        menu_trocarSenha = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema SENAC");

        lblBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBemVindo.setText("Seja bem vind@, ");

        icone_cad_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad_usuario.png"))); // NOI18N
        icone_cad_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_cad_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_cad_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_cad_usuarioMouseClicked(evt);
            }
        });

        icone_pes_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pes_usuario.png"))); // NOI18N
        icone_pes_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_pes_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_pes_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_pes_usuarioMouseClicked(evt);
            }
        });

        icone_cad_perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad_perfil.png"))); // NOI18N
        icone_cad_perfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_cad_perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_cad_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_cad_perfilMouseClicked(evt);
            }
        });

        icone_pes_perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad_perfil.png"))); // NOI18N
        icone_pes_perfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_pes_perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_pes_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_pes_perfilMouseClicked(evt);
            }
        });

        lbl_cad_usuario.setText("Cadastrar usu??rio");

        lbl_pes_usuario.setText("Pesquisar usu??rios");

        lbl_cad_perfil.setText("Cadastrar perfil");

        lbl_pes_perfil.setText("Pesquisar perfil");

        lbl_cad_perfil1.setText("Cadastrar profiss??o");

        icone_cad_perfil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad_perfil.png"))); // NOI18N
        icone_cad_perfil1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_cad_perfil1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_cad_perfil1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_cad_perfil1MouseClicked(evt);
            }
        });

        lbl_pes_perfil1.setText("Pesquisar profiss??es");

        icone_pes_perfil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad_perfil.png"))); // NOI18N
        icone_pes_perfil1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_pes_perfil1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_pes_perfil1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_pes_perfil1MouseClicked(evt);
            }
        });

        menu_cadastro.setText("Cadastro");

        item_cad_usuario.setText("Usu??rio");
        item_cad_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_cad_usuarioMouseClicked(evt);
            }
        });
        menu_cadastro.add(item_cad_usuario);

        item_cad_perfil.setText("Perfil");
        item_cad_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_cad_perfilMouseClicked(evt);
            }
        });
        menu_cadastro.add(item_cad_perfil);

        jMenuBar1.add(menu_cadastro);

        menu_pesquisa.setText("Pesquisa");

        item_pes_usuario.setText("Usu??rio");
        item_pes_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_pes_usuarioMouseClicked(evt);
            }
        });
        menu_pesquisa.add(item_pes_usuario);

        item_pes_perfil.setText("Perfil");
        item_pes_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_pes_perfilMouseClicked(evt);
            }
        });
        menu_pesquisa.add(item_pes_perfil);

        jMenuBar1.add(menu_pesquisa);

        menu_trocarSenha.setText("Trocar senha");
        menu_trocarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_trocarSenhaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_trocarSenha);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lbl_cad_perfil1)
                                .addGap(57, 57, 57)
                                .addComponent(lbl_pes_perfil1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(icone_cad_usuario))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(lbl_cad_usuario)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(icone_pes_usuario))
                                    .addComponent(lbl_pes_usuario))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(icone_cad_perfil, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_cad_perfil, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_pes_perfil)
                                    .addComponent(icone_pes_perfil)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(icone_cad_perfil1)
                                .addGap(84, 84, 84)
                                .addComponent(icone_pes_perfil1)))
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icone_pes_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_pes_usuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBemVindo)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icone_cad_usuario)
                            .addComponent(icone_pes_perfil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cad_usuario)
                            .addComponent(lbl_pes_perfil)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icone_cad_perfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cad_perfil)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icone_cad_perfil1)
                    .addComponent(icone_pes_perfil1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cad_perfil1)
                    .addComponent(lbl_pes_perfil1))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void icone_cad_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_cad_usuarioMouseClicked
        new CadastroUsuario().setVisible(true);
    }//GEN-LAST:event_icone_cad_usuarioMouseClicked

    private void icone_pes_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_pes_usuarioMouseClicked
        new PesquisaUsuario().setVisible(true);
    }//GEN-LAST:event_icone_pes_usuarioMouseClicked

    private void icone_cad_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_cad_perfilMouseClicked
        new CadastroPerfil().setVisible(true);
    }//GEN-LAST:event_icone_cad_perfilMouseClicked

    private void icone_pes_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_pes_perfilMouseClicked
        new PesquisaPerfil().setVisible(true);
    }//GEN-LAST:event_icone_pes_perfilMouseClicked

    private void icone_cad_perfil1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_cad_perfil1MouseClicked
        new CadastroProfissao().setVisible(true);
    }//GEN-LAST:event_icone_cad_perfil1MouseClicked

    private void icone_pes_perfil1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_pes_perfil1MouseClicked
        new PesquisaProfissao().setVisible(true);
    }//GEN-LAST:event_icone_pes_perfil1MouseClicked

    private void menu_trocarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_trocarSenhaMouseClicked
        this.dispose();
        new TrocarSenha(usuario).setVisible(true);
    }//GEN-LAST:event_menu_trocarSenhaMouseClicked

    private void item_cad_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_cad_usuarioMouseClicked
        new CadastroPerfil().setVisible(true);
    }//GEN-LAST:event_item_cad_usuarioMouseClicked

    private void item_cad_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_cad_perfilMouseClicked
        new CadastroPerfil().setVisible(true);
    }//GEN-LAST:event_item_cad_perfilMouseClicked

    private void item_pes_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_pes_usuarioMouseClicked
        new PesquisaUsuario().setVisible(true);
    }//GEN-LAST:event_item_pes_usuarioMouseClicked

    private void item_pes_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_pes_perfilMouseClicked
        new PesquisaPerfil().setVisible(true);
    }//GEN-LAST:event_item_pes_perfilMouseClicked

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
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icone_cad_perfil;
    private javax.swing.JLabel icone_cad_perfil1;
    private javax.swing.JLabel icone_cad_usuario;
    private javax.swing.JLabel icone_pes_perfil;
    private javax.swing.JLabel icone_pes_perfil1;
    private javax.swing.JLabel icone_pes_usuario;
    private javax.swing.JMenuItem item_cad_perfil;
    private javax.swing.JMenuItem item_cad_usuario;
    private javax.swing.JMenuItem item_pes_perfil;
    private javax.swing.JMenuItem item_pes_usuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lbl_cad_perfil;
    private javax.swing.JLabel lbl_cad_perfil1;
    private javax.swing.JLabel lbl_cad_usuario;
    private javax.swing.JLabel lbl_pes_perfil;
    private javax.swing.JLabel lbl_pes_perfil1;
    private javax.swing.JLabel lbl_pes_usuario;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenu menu_pesquisa;
    private javax.swing.JMenu menu_trocarSenha;
    // End of variables declaration//GEN-END:variables
}
