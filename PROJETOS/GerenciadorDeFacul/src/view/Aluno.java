/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConnectionFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelDao.AlunoDAO;
import modelBean.AlunoBeans;

/**
 *
 * @author 100296el
 */
public class Aluno extends javax.swing.JFrame {

    private AlunoDAO DAO;
    private AlunoBeans objAlu;
    private int acao;
    //ConnectionFactory con = new ConnectionFactory();

    public Aluno() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        DefaultTableModel modelo = (DefaultTableModel) tbl_cad_alu.getModel();
        tbl_cad_alu.setRowSorter(new TableRowSorter(modelo));
        DAO = new AlunoDAO();
        //con.getConnection();
        readTable();

    }

    public void readTable() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cad_alu.getModel();
        modelo.setNumRows(0);
        AlunoDAO adao = new AlunoDAO();

        for (AlunoBeans a : adao.read()) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getSexo(),
                a.getData(),
                a.getRg(),
                a.getCurso(),
                a.getEndereco(),
                a.getId_campus()
            });
        }
    }

    public void readTablePesquisar(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cad_alu.getModel();
        modelo.setNumRows(0);
        AlunoDAO adao = new AlunoDAO();

        for (AlunoBeans a : adao.readBuscar(nome)) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getSexo(),
                a.getData(),
                a.getRg(),
                a.getCurso(),
                a.getEndereco(),
                a.getId_campus()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_dat = new javax.swing.JTextField();
        txt_rg = new javax.swing.JTextField();
        cb_sex = new javax.swing.JComboBox<>();
        btn_nov = new javax.swing.JButton();
        btn_sal = new javax.swing.JButton();
        btn_edi = new javax.swing.JButton();
        btn_exc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cad_alu = new javax.swing.JTable();
        btn_can = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txt_bus = new javax.swing.JTextField();
        btn_pes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_vol = new javax.swing.JButton();
        txt_end = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_alt_alu = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_cam = new javax.swing.JComboBox<>();
        cb_cur = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setEnabled(false);
        jPanel1.setLayout(null);

        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 63, 46, 40);

        jLabel3.setText("Sexo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 108, 50, 30);

        jLabel4.setText("Data de Nascimento:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(330, 110, 160, 30);

        jLabel6.setText("RG:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(620, 120, 30, 17);

        txt_nom.setEnabled(false);
        txt_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nom);
        txt_nom.setBounds(200, 70, 560, 30);

        txt_dat.setEnabled(false);
        jPanel1.add(txt_dat);
        txt_dat.setBounds(480, 110, 130, 31);

        txt_rg.setEnabled(false);
        jPanel1.add(txt_rg);
        txt_rg.setBounds(650, 110, 110, 31);

        cb_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino" }));
        cb_sex.setToolTipText("");
        cb_sex.setEnabled(false);
        jPanel1.add(cb_sex);
        cb_sex.setBounds(200, 110, 120, 30);

        btn_nov.setBackground(java.awt.Color.blue);
        btn_nov.setText("Novo");
        btn_nov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nov);
        btn_nov.setBounds(10, 20, 80, 32);

        btn_sal.setBackground(java.awt.Color.green);
        btn_sal.setText("Salvar");
        btn_sal.setEnabled(false);
        btn_sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sal);
        btn_sal.setBounds(1170, 220, 80, 30);

        btn_edi.setBackground(java.awt.Color.orange);
        btn_edi.setText("Editar");
        btn_edi.setEnabled(false);
        btn_edi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ediActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edi);
        btn_edi.setBounds(10, 80, 80, 30);

        btn_exc.setBackground(java.awt.Color.red);
        btn_exc.setText("Excluir");
        btn_exc.setEnabled(false);
        btn_exc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excActionPerformed(evt);
            }
        });
        jPanel1.add(btn_exc);
        btn_exc.setBounds(10, 130, 80, 31);

        tbl_cad_alu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPD", "Nome", "Sexo", "Data de Nascimento", "RG", "Campus", "Endereço", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_cad_alu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cad_aluMouseClicked(evt);
            }
        });
        tbl_cad_alu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_cad_aluKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cad_alu);
        if (tbl_cad_alu.getColumnModel().getColumnCount() > 0) {
            tbl_cad_alu.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_cad_alu.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbl_cad_alu.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_cad_alu.getColumnModel().getColumn(3).setPreferredWidth(20);
            tbl_cad_alu.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbl_cad_alu.getColumnModel().getColumn(5).setPreferredWidth(5);
            tbl_cad_alu.getColumnModel().getColumn(6).setPreferredWidth(200);
            tbl_cad_alu.getColumnModel().getColumn(7).setPreferredWidth(5);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 270, 1330, 350);

        btn_can.setBackground(java.awt.Color.red);
        btn_can.setText("Cancelar");
        btn_can.setEnabled(false);
        btn_can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_canActionPerformed(evt);
            }
        });
        jPanel1.add(btn_can);
        btn_can.setBounds(1260, 220, 80, 31);

        jLabel7.setText("CPD:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(150, 20, 40, 30);

        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel1.add(txt_id);
        txt_id.setBounds(190, 20, 96, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Procurar"));
        jPanel2.setLayout(null);
        jPanel2.add(txt_bus);
        txt_bus.setBounds(70, 20, 220, 40);

        btn_pes.setText("Buscar");
        btn_pes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pes);
        btn_pes.setBounds(300, 20, 90, 40);

        jLabel5.setText("Nome:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 0, 90, 70);

        btn_vol.setText("Voltar");
        btn_vol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volActionPerformed(evt);
            }
        });
        jPanel2.add(btn_vol);
        btn_vol.setBounds(400, 20, 90, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(850, 20, 500, 70);

        txt_end.setEnabled(false);
        jPanel1.add(txt_end);
        txt_end.setBounds(230, 160, 530, 30);

        jLabel8.setText("Endereço:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 160, 80, 30);

        jLabel9.setText("Campus:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(160, 210, 60, 30);

        btn_alt_alu.setText("Verificar");
        btn_alt_alu.setEnabled(false);
        btn_alt_alu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alt_aluActionPerformed(evt);
            }
        });
        jPanel1.add(btn_alt_alu);
        btn_alt_alu.setBounds(590, 210, 100, 30);

        jLabel10.setText("Curso:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(380, 210, 50, 30);

        cb_cam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "1", "2", "3" }));
        cb_cam.setEnabled(false);
        jPanel1.add(cb_cam);
        cb_cam.setBounds(230, 210, 130, 30);

        cb_cur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "1", "2", "3", "4", "5" }));
        cb_cur.setToolTipText("");
        cb_cur.setEnabled(false);
        cb_cur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_curActionPerformed(evt);
            }
        });
        jPanel1.add(cb_cur);
        cb_cur.setBounds(430, 210, 130, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 50, 1360, 640);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Cadastrar Alunos:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(540, 0, 310, 50);

        setSize(new java.awt.Dimension(1388, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomActionPerformed

    private void btn_novActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novActionPerformed
        limparCampos();
        btn_alt_alu.setEnabled(true);
        txt_end.setEnabled(true);
        cb_cur.setEnabled(true);
        cb_cam.setEnabled(true);
        txt_bus.setEnabled(false);
        txt_nom.setEnabled(true);
        txt_id.setEnabled(false);
        cb_sex.setEnabled(true);
        txt_dat.setEnabled(true);
        txt_rg.setEnabled(true);
        btn_pes.setEnabled(false);
        btn_vol.setEnabled(false);
        btn_nov.setEnabled(false);
        btn_sal.setEnabled(true);
        btn_edi.setEnabled(false);
        btn_exc.setEnabled(false);
        btn_can.setEnabled(true);
        txt_id.setText("");
        acao = 1;
    }//GEN-LAST:event_btn_novActionPerformed

    private void btn_salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salActionPerformed
        ConnectionFactory con = new ConnectionFactory();
        try {
            if (validarCampos()) {
                if (acao == 1) {
                    if (preencherObj()) {
                        if (DAO.create(objAlu)) {
                            JOptionPane.showMessageDialog(this,"Salvo com sucesso!");
                            btn_canActionPerformed(evt);

                            txt_end.setText("");
                            cb_cur.setSelectedItem("");
                            cb_cam.setSelectedItem("");
                            txt_bus.setText("");
                            txt_nom.setText("");
                            cb_sex.setSelectedItem("");
                            txt_dat.setText("");
                            txt_rg.setText("");
                            txt_bus.setText("");
                            txt_end.setEnabled(false);
                            cb_cur.setEnabled(false);
                            cb_cam.setEnabled(false);
                            txt_bus.setEnabled(false);
                            txt_nom.setEnabled(false);
                            cb_sex.setEnabled(false);
                            txt_dat.setEnabled(false);
                            txt_rg.setEnabled(false);
                            btn_pes.setEnabled(true);
                            btn_nov.setEnabled(true);
                            btn_sal.setEnabled(false);
                            btn_edi.setEnabled(false);
                            btn_exc.setEnabled(false);
                            btn_can.setEnabled(false);
                            btn_alt_alu.setEnabled(false);

                        }

                    } else {

                        JOptionPane.showMessageDialog(this, "Não foi possível inserir o registro!");
                    }
                }
                if (acao == 2) {
                    if (preencherObj2()) {
                        if (DAO.Editar(objAlu)) {
                            JOptionPane.showMessageDialog(this, "Editado com sucesso!");
                            btn_canActionPerformed(evt);
                            btn_sal.setEnabled(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Não foi possível editar o registro!");
                    }
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro: " + erro.getMessage());
        }
        txt_bus.setText("");
        txt_nom.setText("");
        cb_sex.setSelectedItem("");
        txt_dat.setText("");
        txt_rg.setText("");
        txt_end.setText("");
        cb_cur.setSelectedItem("");
        cb_cam.setSelectedItem("");
        readTable();


    }//GEN-LAST:event_btn_salActionPerformed

    private void btn_ediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ediActionPerformed
        if (tbl_cad_alu.getSelectedRow() != -1) {

            btn_alt_alu.setEnabled(true);
            txt_end.setEnabled(true);
            cb_cur.setEnabled(true);
            cb_cam.setEnabled(true);
            txt_bus.setEnabled(false);
            txt_nom.setEnabled(true);
            cb_sex.setEnabled(true);
            txt_dat.setEnabled(true);
            txt_rg.setEnabled(true);
            btn_pes.setEnabled(false);
            btn_nov.setEnabled(false);
            btn_sal.setEnabled(true);
            btn_edi.setEnabled(false);
            btn_exc.setEnabled(false);
            btn_can.setEnabled(true);
            txt_id.setEnabled(false);
            tbl_cad_alu.setEnabled(true);
            acao = 2;
        }
    }//GEN-LAST:event_btn_ediActionPerformed

    private void btn_excActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excActionPerformed

        try {
            if (DAO.Excluir(Integer.parseInt(txt_id.getText()))) {
                JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
                btn_canActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível excluir o registro!");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro " + erro.getMessage());
        }
        readTable();
        txt_id.setEnabled(false);
    }//GEN-LAST:event_btn_excActionPerformed

    private void btn_canActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_canActionPerformed
        limparCampos();
        txt_end.setEnabled(false);
        cb_cur.setEnabled(false);
        cb_cam.setEnabled(false);
        txt_bus.setEnabled(true);
        txt_nom.setEnabled(false);
        cb_sex.setEnabled(false);
        txt_dat.setEnabled(false);
        txt_id.setEnabled(false);
        txt_rg.setEnabled(false);
        txt_id.setEnabled(false);
        btn_pes.setEnabled(true);
        btn_vol.setEnabled(true);
        btn_nov.setEnabled(true);
        btn_sal.setEnabled(false);
        btn_edi.setEnabled(false);
        btn_exc.setEnabled(false);
        btn_can.setEnabled(false);
        btn_alt_alu.setEnabled(false);

        txt_id.setText("");
        txt_end.setText("");
        cb_cur.setSelectedItem("");
        cb_cam.setSelectedItem("");
    }//GEN-LAST:event_btn_canActionPerformed

    private void btn_pesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesActionPerformed

        if (txt_bus.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo com o nome desejado!");
            txt_bus.requestFocus();
        } else {

            readTablePesquisar(txt_bus.getText());
            btn_vol.setEnabled(true);
            btn_edi.setEnabled(false);
            btn_exc.setEnabled(false);
            /*} if(objAlu == null){
                    

                    
                    btn_nov.setEnabled(false);
                    btn_edi.setEnabled(true);
                    btn_can.setEnabled(true);
                    btn_exc.setEnabled(true);
                    btn_pes.setEnabled(true);
                    acao = 2;
                }*/

        }
    }//GEN-LAST:event_btn_pesActionPerformed

    private void tbl_cad_aluMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cad_aluMouseClicked

        if (tbl_cad_alu.getSelectedRow() != -1) {
            txt_id.setText(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 0).toString());
            txt_nom.setText(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 1).toString());
            cb_sex.setSelectedItem(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 2).toString());
            txt_dat.setText(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 3).toString());
            txt_rg.setText(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 4).toString());
            cb_cur.setSelectedItem(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 5).toString());
            txt_end.setText(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 6).toString());
            cb_cam.setSelectedItem(tbl_cad_alu.getValueAt(tbl_cad_alu.getSelectedRow(), 7).toString());

            cb_cam.setEnabled(false);
            cb_cur.setEnabled(false);
            txt_end.setEnabled(false);
            txt_bus.setEnabled(false);
            txt_nom.setEnabled(false);
            cb_sex.setEnabled(false);
            txt_dat.setEnabled(false);
            txt_rg.setEnabled(false);
            btn_pes.setEnabled(false);
            btn_nov.setEnabled(false);
            btn_sal.setEnabled(false);
            btn_edi.setEnabled(true);
            btn_exc.setEnabled(true);
            btn_can.setEnabled(true);
            btn_vol.setEnabled(false);
            btn_alt_alu.setEnabled(false);

        }

    }//GEN-LAST:event_tbl_cad_aluMouseClicked

    private void tbl_cad_aluKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_cad_aluKeyReleased

    }//GEN-LAST:event_tbl_cad_aluKeyReleased

    private void btn_volActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volActionPerformed
        txt_bus.setText("");
        txt_bus.setEnabled(true);
        readTable();
    }//GEN-LAST:event_btn_volActionPerformed

    private void cb_curActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_curActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_curActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_alt_aluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alt_aluActionPerformed
        Verificar ver = new Verificar();
        ver.setVisible(true);
    }//GEN-LAST:event_btn_alt_aluActionPerformed

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
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alt_alu;
    private javax.swing.JButton btn_can;
    private javax.swing.JButton btn_edi;
    private javax.swing.JButton btn_exc;
    private javax.swing.JButton btn_nov;
    private javax.swing.JButton btn_pes;
    private javax.swing.JButton btn_sal;
    private javax.swing.JButton btn_vol;
    private javax.swing.JComboBox<String> cb_cam;
    private javax.swing.JComboBox<String> cb_cur;
    private javax.swing.JComboBox<String> cb_sex;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cad_alu;
    private javax.swing.JTextField txt_bus;
    private javax.swing.JTextField txt_dat;
    private javax.swing.JTextField txt_end;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_rg;
    // End of variables declaration//GEN-END:variables
public void limparCampos() {
        txt_bus.setText("");
        txt_nom.setText("");
        cb_sex.setSelectedItem("Selecione");
        cb_cam.setSelectedItem("Selecione");
        cb_cur.setSelectedItem("Selecione");
        txt_dat.setText("");
        txt_rg.setText("");
    }

    public boolean validarCampos() {
        if (txt_nom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo nome!");
            txt_nom.requestFocus();
            return false;
        }
        if (cb_sex.getSelectedItem().equals("") || cb_sex.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Tu é assexuado animal? Escolha um Sexo!");
            cb_sex.requestFocus();
            return false;
        }
        if (txt_dat.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha a data!");
            txt_dat.requestFocus();
            return false;
        }
        if (txt_rg.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o RG!");
            txt_rg.requestFocus();
            return false;
        }
        if (txt_end.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o Endereço!");
            txt_end.requestFocus();
            return false;
        }
        if (cb_cur.getSelectedItem().equals("") || cb_cur.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Preencha o Curso!");
            cb_cur.requestFocus();
            return false;
        }
        if (cb_cam.getSelectedItem().equals("") || cb_cam.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Preencha o campus!");
            cb_cam.requestFocus();
            return false;
        }
        return true;
    }

    public boolean preencherObj() {
        objAlu = new AlunoBeans();
        objAlu.setNome(txt_nom.getText());
        objAlu.setSexo((String) cb_sex.getSelectedItem());
        objAlu.setData(txt_dat.getText());
        objAlu.setRg(Long.parseLong(txt_rg.getText()));
        objAlu.setCurso((int) cb_cur.getSelectedIndex());
        objAlu.setEndereco(txt_end.getText());
        objAlu.setId_campus((int) cb_cam.getSelectedIndex());
        return true;
    }

    public boolean preencherObj2() {
        objAlu = new AlunoBeans();
        objAlu.setId(Long.parseLong(txt_id.getText()));
        objAlu.setNome(txt_nom.getText());
        objAlu.setSexo((String) cb_sex.getSelectedItem());
        objAlu.setData(txt_dat.getText());
        objAlu.setRg(Long.parseLong(txt_rg.getText()));
        objAlu.setCurso((int) cb_cur.getSelectedIndex());
        objAlu.setEndereco(txt_end.getText());
        objAlu.setId_campus((int) cb_cam.getSelectedIndex());
        return true;
    }
}
