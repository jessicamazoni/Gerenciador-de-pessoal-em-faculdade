package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelDao.UsuarioDAO;

/**
 *
 * @author 100296el
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_sai = new javax.swing.JButton();
        btn_ace = new javax.swing.JButton();
        lbl_usu = new javax.swing.JLabel();
        lbl_sen = new javax.swing.JLabel();
        txt_log = new javax.swing.JTextField();
        txt_sen = new javax.swing.JPasswordField();
        cb_usu = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        btn_sai.setBackground(java.awt.Color.red);
        btn_sai.setText("Sair");
        jPanel1.add(btn_sai);
        btn_sai.setBounds(190, 150, 60, 29);

        btn_ace.setBackground(java.awt.Color.green);
        btn_ace.setText("Acessar");
        btn_ace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ace);
        btn_ace.setBounds(70, 150, 90, 29);

        lbl_usu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_usu.setForeground(java.awt.Color.black);
        lbl_usu.setText("Login:");
        jPanel1.add(lbl_usu);
        lbl_usu.setBounds(50, 70, 60, 15);

        lbl_sen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_sen.setForeground(java.awt.Color.black);
        lbl_sen.setText("Senha:");
        jPanel1.add(lbl_sen);
        lbl_sen.setBounds(50, 120, 60, 15);
        jPanel1.add(txt_log);
        txt_log.setBounds(110, 60, 140, 30);
        jPanel1.add(txt_sen);
        txt_sen.setBounds(110, 110, 140, 30);

        cb_usu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Professor", "Reitor", "Atendente", "Coordenador", "Porteiro", "Recursos Humanos", " " }));
        jPanel1.add(cb_usu);
        cb_usu.setBounds(110, 10, 140, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Usuário:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 20, 60, 15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceActionPerformed
        UsuarioDAO dao = new UsuarioDAO();
        if (cb_usu.getSelectedItem().equals("") || (txt_log.getText().equals("")) || txt_sen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        if (dao.checkLogin((String) cb_usu.getSelectedItem(), Integer.parseInt(txt_log.getText()), txt_sen.getText())) {
            new Principal().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário inválido!");
        }
    }//GEN-LAST:event_btn_aceActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ace;
    private javax.swing.JButton btn_sai;
    private javax.swing.JComboBox<String> cb_usu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_sen;
    private javax.swing.JLabel lbl_usu;
    private javax.swing.JTextField txt_log;
    private javax.swing.JPasswordField txt_sen;
    // End of variables declaration//GEN-END:variables
}
