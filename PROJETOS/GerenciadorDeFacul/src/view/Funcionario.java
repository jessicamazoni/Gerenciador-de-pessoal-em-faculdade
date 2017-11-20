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
import modelDao.FuncionarioDAO;
import modelBean.FuncionarioBeans;

/**
 *
 * @author 100296el
 */
public class Funcionario extends javax.swing.JFrame {

    private FuncionarioDAO DAO;
    private FuncionarioBeans objFun;
    private int acao;
    //ConnectionFactory con = new ConnectionFactory();

    public Funcionario() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        DefaultTableModel modelo = (DefaultTableModel) tbl_cad_fun.getModel();
        tbl_cad_fun.setRowSorter(new TableRowSorter(modelo));
        DAO = new FuncionarioDAO();
        //con.getConnection();
        readTable();

    }

    public void readTable() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cad_fun.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO adao = new FuncionarioDAO();

        for (FuncionarioBeans a : adao.read()) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getData(),
                a.getSexo(),
                a.getRg(),
                a.getId_prof(),
                a.getEndereco()
            });
        }
    }

    public void readTablePesquisar(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cad_fun.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO adao = new FuncionarioDAO();

        for (FuncionarioBeans a : adao.readBuscar(nome)) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getData(),
                a.getSexo(),
                a.getRg(),
                a.getId_prof(),
                a.getEndereco()
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
        tbl_cad_fun = new javax.swing.JTable();
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
        jLabel10 = new javax.swing.JLabel();
        cb_pro = new javax.swing.JComboBox<>();
        btn_ver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setEnabled(false);

        jLabel2.setText("Nome:");

        jLabel3.setText("Sexo:");

        jLabel4.setText("Data de Nascimento:");

        jLabel6.setText("RG:");

        txt_nom.setEnabled(false);
        txt_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomActionPerformed(evt);
            }
        });

        txt_dat.setEnabled(false);

        txt_rg.setEnabled(false);

        cb_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "M", "F" }));
        cb_sex.setToolTipText("");
        cb_sex.setEnabled(false);

        btn_nov.setBackground(java.awt.Color.blue);
        btn_nov.setText("Novo");
        btn_nov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novActionPerformed(evt);
            }
        });

        btn_sal.setBackground(java.awt.Color.green);
        btn_sal.setText("Salvar");
        btn_sal.setEnabled(false);
        btn_sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salActionPerformed(evt);
            }
        });

        btn_edi.setBackground(java.awt.Color.orange);
        btn_edi.setText("Editar");
        btn_edi.setEnabled(false);
        btn_edi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ediActionPerformed(evt);
            }
        });

        btn_exc.setBackground(java.awt.Color.red);
        btn_exc.setText("Excluir");
        btn_exc.setEnabled(false);
        btn_exc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excActionPerformed(evt);
            }
        });

        tbl_cad_fun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Sexo", "Data de Nascimento", "RG", "Endereço", "Profissão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_cad_fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cad_funMouseClicked(evt);
            }
        });
        tbl_cad_fun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_cad_funKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cad_fun);
        if (tbl_cad_fun.getColumnModel().getColumnCount() > 0) {
            tbl_cad_fun.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_cad_fun.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbl_cad_fun.getColumnModel().getColumn(2).setPreferredWidth(15);
            tbl_cad_fun.getColumnModel().getColumn(3).setPreferredWidth(20);
            tbl_cad_fun.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbl_cad_fun.getColumnModel().getColumn(5).setPreferredWidth(200);
            tbl_cad_fun.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        btn_can.setBackground(java.awt.Color.red);
        btn_can.setText("Cancelar");
        btn_can.setEnabled(false);
        btn_can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_canActionPerformed(evt);
            }
        });

        jLabel7.setText("Id:");

        txt_id.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Procurar"));
        jPanel2.setLayout(null);
        jPanel2.add(txt_bus);
        txt_bus.setBounds(60, 20, 210, 40);

        btn_pes.setText("Buscar");
        btn_pes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pes);
        btn_pes.setBounds(280, 20, 90, 40);

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
        btn_vol.setBounds(380, 20, 90, 40);

        txt_end.setEnabled(false);

        jLabel8.setText("Endereço:");

        jLabel10.setText("Profissão:");

        cb_pro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "1", "2", "3", "4", "5", "6" }));
        cb_pro.setToolTipText("");
        cb_pro.setEnabled(false);

        btn_ver.setText("Verificar");
        btn_ver.setEnabled(false);
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_nov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_exc, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_end))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_dat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_rg)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_can))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_nov, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_dat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cb_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_can, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setText("Cadastro de Funcionários:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(469, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1308, 767));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomActionPerformed

    private void btn_novActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novActionPerformed
        limparCampos();
        btn_ver.setEnabled(true);
        txt_end.setEnabled(true);
        cb_pro.setEnabled(true);
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
                        if (DAO.create(objFun)) {
                            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
                            btn_canActionPerformed(evt);

                            txt_end.setText("");
                            cb_pro.setSelectedItem("");
                            txt_bus.setText("");
                            txt_nom.setText("");
                            cb_sex.setSelectedItem("");
                            txt_dat.setText("");
                            txt_rg.setText("");
                            txt_bus.setText("");
                            txt_end.setEnabled(false);
                            cb_pro.setEnabled(false);
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
                            btn_ver.setEnabled(false);

                        }

                    } else {

                        JOptionPane.showMessageDialog(this, "Não foi possível inserir o registro!");
                    }
                }
                if (acao == 2) {
                    if (preencherObj2()) {
                        if (DAO.Editar(objFun)) {
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
        cb_pro.setSelectedItem("");
        readTable();


    }//GEN-LAST:event_btn_salActionPerformed

    private void btn_ediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ediActionPerformed
        if (tbl_cad_fun.getSelectedRow() != -1) {

            btn_ver.setEnabled(true);
            txt_end.setEnabled(true);
            cb_pro.setEnabled(true);
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
            tbl_cad_fun.setEnabled(true);
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
        cb_pro.setEnabled(false);
        txt_bus.setEnabled(true);
        txt_nom.setEnabled(false);
        cb_sex.setEnabled(false);
        txt_dat.setEnabled(false);
        txt_rg.setEnabled(false);
        txt_id.setEnabled(false);
        btn_pes.setEnabled(true);
        btn_nov.setEnabled(true);
        btn_sal.setEnabled(false);
        btn_edi.setEnabled(false);
        btn_vol.setEnabled(true);
        btn_pes.setEnabled(true);
        btn_exc.setEnabled(false);
        btn_can.setEnabled(false);
        btn_ver.setEnabled(false);

        txt_id.setText("");
        txt_end.setText("");
        cb_pro.setSelectedItem("");

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
            /*} if(objFun == null){
                    

                    
                    btn_nov.setEnabled(false);
                    btn_edi.setEnabled(true);
                    btn_can.setEnabled(true);
                    btn_exc.setEnabled(true);
                    btn_pes.setEnabled(true);
                    acao = 2;
                }*/

        }
    }//GEN-LAST:event_btn_pesActionPerformed

    private void tbl_cad_funMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cad_funMouseClicked

        if (tbl_cad_fun.getSelectedRow() != -1) {
            txt_id.setText(tbl_cad_fun.getValueAt(tbl_cad_fun.getSelectedRow(), 0).toString());
            txt_nom.setText(tbl_cad_fun.getValueAt(tbl_cad_fun.getSelectedRow(), 1).toString());
            txt_dat.setText(tbl_cad_fun.getValueAt(tbl_cad_fun.getSelectedRow(), 2).toString());
            cb_sex.setSelectedItem(tbl_cad_fun.getValueAt(tbl_cad_fun.getSelectedRow(), 3).toString());           
            txt_rg.setText(tbl_cad_fun.getValueAt(tbl_cad_fun.getSelectedRow(), 4).toString());
            cb_pro.setSelectedItem(tbl_cad_fun.getValueAt(tbl_cad_fun.getSelectedRow(), 5).toString());
            txt_end.setText(tbl_cad_fun.getValueAt(tbl_cad_fun.getSelectedRow(), 6).toString());


            cb_pro.setEnabled(false);
            txt_end.setEnabled(false);
            txt_bus.setEnabled(false);
            txt_nom.setEnabled(false);
            cb_sex.setEnabled(false);
            txt_dat.setEnabled(false);
            txt_rg.setEnabled(false);
            btn_pes.setEnabled(true);
            btn_nov.setEnabled(false);
            btn_sal.setEnabled(false);
            btn_edi.setEnabled(true);
            btn_exc.setEnabled(true);
            btn_can.setEnabled(true);
            btn_pes.setEnabled(false);
            btn_vol.setEnabled(false);
        }

    }//GEN-LAST:event_tbl_cad_funMouseClicked

    private void tbl_cad_funKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_cad_funKeyReleased

    }//GEN-LAST:event_tbl_cad_funKeyReleased

    private void btn_volActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volActionPerformed
        txt_bus.setText("");
        txt_bus.setEnabled(true);
        readTable();
    }//GEN-LAST:event_btn_volActionPerformed

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        Verificar ver = new Verificar();
        ver.setVisible(true);
    }//GEN-LAST:event_btn_verActionPerformed

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
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_can;
    private javax.swing.JButton btn_edi;
    private javax.swing.JButton btn_exc;
    private javax.swing.JButton btn_nov;
    private javax.swing.JButton btn_pes;
    private javax.swing.JButton btn_sal;
    private javax.swing.JButton btn_ver;
    private javax.swing.JButton btn_vol;
    private javax.swing.JComboBox<String> cb_pro;
    private javax.swing.JComboBox<String> cb_sex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cad_fun;
    private javax.swing.JTextField txt_bus;
    private javax.swing.JTextField txt_dat;
    private javax.swing.JTextField txt_end;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_rg;
    // End of variables declaration//GEN-END:variables
public void limparCampos() {
        txt_id.setText("");
        txt_bus.setText("");
        txt_nom.setText("");
        txt_dat.setText("");
        txt_rg.setText("");

        cb_pro.setSelectedItem("Selecione");
        cb_sex.setSelectedItem("Selecione");
    }

    public boolean validarCampos() {
        if (txt_nom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo nome!");
            txt_nom.requestFocus();
            return false;
        }
        if (cb_sex.getSelectedItem().equals("") || cb_sex.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "A pessoa é assexuada? Selecione algum sexo!");
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
        if (cb_pro.getSelectedItem().equals("") || cb_pro.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Escolha algum profissional!");
            cb_pro.requestFocus();
            return false;
        }
        return true;
    }

    public boolean preencherObj() {
        objFun = new FuncionarioBeans();
        objFun.setNome(txt_nom.getText());
        objFun.setData(txt_dat.getText());
        objFun.setSexo((String) cb_sex.getSelectedItem());
        objFun.setRg(Integer.parseInt(txt_rg.getText()));
        objFun.setId_prof((int) cb_pro.getSelectedIndex());
        objFun.setEndereco(txt_end.getText());
        return true;
    }

    public boolean preencherObj2() {
        objFun = new FuncionarioBeans();
        objFun.setId(Integer.parseInt(txt_id.getText()));
        objFun.setNome(txt_nom.getText());
        objFun.setData(txt_dat.getText());
        objFun.setSexo((String) cb_sex.getSelectedItem());
        objFun.setRg(Integer.parseInt(txt_rg.getText()));
        objFun.setId_prof((int) cb_pro.getSelectedIndex());
        objFun.setEndereco(txt_end.getText());
        return true;
    }
}
