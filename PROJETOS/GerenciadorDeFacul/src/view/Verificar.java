/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelDao.VerificarDAO;
import modelBean.VerificarBeans;

/**
 *
 * @author 100296el
 */
public class Verificar extends javax.swing.JFrame {

    private VerificarDAO DAO;

    public Verificar() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        DefaultTableModel modelo = (DefaultTableModel) tbl_cam.getModel();
        tbl_cam.setRowSorter(new TableRowSorter(modelo));

        DefaultTableModel modelo1 = (DefaultTableModel) tbl_pro.getModel();
        tbl_pro.setRowSorter(new TableRowSorter(modelo1));

        DefaultTableModel modelo2 = (DefaultTableModel) tbl_cur.getModel();
        tbl_cur.setRowSorter(new TableRowSorter(modelo2));

        DefaultTableModel modelo3 = (DefaultTableModel) tbl_dis.getModel();
        tbl_dis.setRowSorter(new TableRowSorter(modelo3));

        DAO = new VerificarDAO();
        //con.getConnection();
        readTableCampus();
        readTableProfissao();
        readTableCurso();
        readTableDis();

    }

    public void readTableCampus() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cam.getModel();
        modelo.setNumRows(0);
        VerificarDAO adao = new VerificarDAO();

        for (VerificarBeans a : adao.read()) {
            modelo.addRow(new Object[]{
                a.getIdC(),
                a.getCampus()

            });
        }
    }

    public void readTableProfissao() {
        DefaultTableModel modelo1 = (DefaultTableModel) tbl_pro.getModel();
        modelo1.setNumRows(0);
        VerificarDAO adao = new VerificarDAO();

        for (VerificarBeans a : adao.read2()) {
            modelo1.addRow(new Object[]{
                a.getIdP(),
                a.getNome()

            });
        }
    }

    public void readTableCurso() {
        DefaultTableModel modelo2 = (DefaultTableModel) tbl_cur.getModel();
        modelo2.setNumRows(0);
        VerificarDAO adao = new VerificarDAO();

        for (VerificarBeans a : adao.read3()) {
            modelo2.addRow(new Object[]{
                a.getIdCu(),
                a.getNome1()

            });
        }
    }

    public void readTableDis() {
        DefaultTableModel modelo3 = (DefaultTableModel) tbl_dis.getModel();
        modelo3.setNumRows(0);
        VerificarDAO adao = new VerificarDAO();

        for (VerificarBeans a : adao.read4()) {
            modelo3.addRow(new Object[]{
                a.getIdDis(),
                a.getNome2()

            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_dis = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_cur = new javax.swing.JTable();
        tbl_al = new javax.swing.JScrollPane();
        tbl_cam = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pro = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tbl_dis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_dis);
        if (tbl_dis.getColumnModel().getColumnCount() > 0) {
            tbl_dis.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl_dis.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(620, 160, 220, 330);

        tbl_cur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_cur);
        if (tbl_cur.getColumnModel().getColumnCount() > 0) {
            tbl_cur.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl_cur.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(320, 160, 210, 330);

        tbl_cam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Local"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_al.setViewportView(tbl_cam);
        if (tbl_cam.getColumnModel().getColumnCount() > 0) {
            tbl_cam.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl_cam.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        getContentPane().add(tbl_al);
        tbl_al.setBounds(30, 160, 210, 150);

        tbl_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_pro);
        if (tbl_pro.getColumnModel().getColumnCount() > 0) {
            tbl_pro.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl_pro.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(930, 160, 210, 330);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Curso:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(320, 110, 80, 80);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Disciplina:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(620, 110, 100, 80);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Identificadores:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 10, 410, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Profissão:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(930, 110, 100, 80);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Campus:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 70, 80);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 5, 1150, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Verificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane tbl_al;
    private javax.swing.JTable tbl_cam;
    private javax.swing.JTable tbl_cur;
    private javax.swing.JTable tbl_dis;
    private javax.swing.JTable tbl_pro;
    // End of variables declaration//GEN-END:variables
}
