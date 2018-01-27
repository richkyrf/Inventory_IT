/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import java.awt.event.KeyEvent;
import javax.swing.table.TableColumn;

/**
 *
 * @author Martono
 */
public class JCari extends javax.swing.JFrame {

    /**
     * Creates new form JCari
     */
    String query1, query2, query3, judul1, judul2, judul3;
    Object selectedRow = null;
    int colNum;
    KomponenGUI.JtextF jF;
    KomponenGUI.JtextF jR;

    /**
     *
     * @param Query_Pencarian_1
     * @param Query_Pencarian_2
     * @param Query_Pencarian_3
     * @param Judul1_Pencarian_1
     * @param Judul2_Pencarian_2
     * @param Judul3_Pencarian_3
     * @param Title
     * @param Jf__parameter_untuk_isi_jtext_di_form_sbelumnya
     * @param FocusLeftOrRight__pilih_request_fokus_jtext_di_jcari
     */
    public JCari(String Query1, String Query2, String Query3, String Judul1, String Judul2, String Judul3, String Title, int Colnum, KomponenGUI.JtextF Jf, String FocusLeftOrRight, KomponenGUI.JtextF Jr) {
        jR = Jr;
        jF = Jf;
        colNum = Colnum;
        query1 = Query1;
        query2 = Query2;
        query3 = Query3;
        judul1 = Judul1;
        judul2 = Judul2;
        judul3 = Judul3;
        initComponents();
        JTNamaBarang.setText(FocusLeftOrRight);
        searchByNamaBarang();
        JTNamaBarang.requestFocus();
        setTitle(Title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        JTNamaBarang.setCaretPosition(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTJenisBarang = new KomponenGUI.JtextF();
        JTKategoriBarang = new KomponenGUI.JtextF();
        JTNamaBarang = new KomponenGUI.JtextFnoSelect();
        JSPData = new javax.swing.JScrollPane();
        JTableData = new KomponenGUI.JtableF();
        JBKembali = new KomponenGUI.JbuttonF();
        JBPilih = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JTJenisBarang.setForeground(new java.awt.Color(153, 153, 153));
        JTJenisBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTJenisBarangFocusGained(evt);
            }
        });
        JTJenisBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTJenisBarangKeyReleased(evt);
            }
        });

        JTKategoriBarang.setForeground(new java.awt.Color(153, 153, 153));
        JTKategoriBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTKategoriBarangFocusGained(evt);
            }
        });
        JTKategoriBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTKategoriBarangKeyReleased(evt);
            }
        });

        JTNamaBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTNamaBarangFocusGained(evt);
            }
        });
        JTNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTNamaBarangKeyReleased(evt);
            }
        });

        JTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                judul1, judul2
            }
        ));
        JTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTableDataMouseReleased(evt);
            }
        });
        JTableData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTableDataKeyPressed(evt);
            }
        });
        JSPData.setViewportView(JTableData);

        JBKembali.setText("Kembali");
        JBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKembaliActionPerformed(evt);
            }
        });

        JBPilih.setText("Pilih");
        JBPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPilihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSPData, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPData, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBPilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTJenisBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJenisBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jF.setText(JTableData.getValueAt(JTableData.getSelectedRow(), colNum).toString());
            GlobalVar.Var.jCari.dispose();
            GlobalVar.Var.jCari = null;
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JTableData.requestFocus();
            if (JTableData.getSelectedRow() == 0) {
                JTableData.setRowSelectionInterval(1, 1);
            }
        } else {
            searchByJenisBarang();
        }
    }//GEN-LAST:event_JTJenisBarangKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        GlobalVar.Var.jCari = null;
    }//GEN-LAST:event_formWindowClosing

    private void JBPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPilihActionPerformed
        jF.setText(JTableData.getValueAt(JTableData.getSelectedRow(), colNum).toString());
        GlobalVar.Var.jCari.dispose();
        GlobalVar.Var.jCari = null;
    }//GEN-LAST:event_JBPilihActionPerformed

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        GlobalVar.Var.jCari.dispose();
        GlobalVar.Var.jCari = null;
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JTableDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableDataMouseReleased
        if (JTableData.getValueAt(JTableData.getSelectedRow(), colNum) == selectedRow) {
            jF.setText(JTableData.getValueAt(JTableData.getSelectedRow(), colNum).toString());
            GlobalVar.Var.jCari.dispose();
            GlobalVar.Var.jCari = null;
        } else {
            selectedRow = JTableData.getValueAt(JTableData.getSelectedRow(), colNum);
        }
    }//GEN-LAST:event_JTableDataMouseReleased

    private void JTNamaBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jF.setText(JTableData.getValueAt(JTableData.getSelectedRow(), colNum).toString());
            GlobalVar.Var.jCari.dispose();
            GlobalVar.Var.jCari = null;
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JTableData.requestFocus();
            if (JTableData.getSelectedRow() == 0) {
                JTableData.setRowSelectionInterval(1, 1);
            }
        } else {
            searchByNamaBarang();
        }

    }//GEN-LAST:event_JTNamaBarangKeyReleased

    private void JTableDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTableDataKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jF.setText(JTableData.getValueAt(JTableData.getSelectedRow(), colNum).toString());
            GlobalVar.Var.jCari.dispose();
            GlobalVar.Var.jCari = null;
        }
    }//GEN-LAST:event_JTableDataKeyPressed

    private void JTJenisBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTJenisBarangFocusGained
        searchByJenisBarang();
    }//GEN-LAST:event_JTJenisBarangFocusGained

    private void JTNamaBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTNamaBarangFocusGained
        searchByNamaBarang();
    }//GEN-LAST:event_JTNamaBarangFocusGained

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        jR.requestFocus();
    }//GEN-LAST:event_formWindowClosed

    private void JTKategoriBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTKategoriBarangFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKategoriBarangFocusGained

    private void JTKategoriBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKategoriBarangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKategoriBarangKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBPilih;
    private javax.swing.JScrollPane JSPData;
    public static KomponenGUI.JtextF JTJenisBarang;
    public static KomponenGUI.JtextF JTKategoriBarang;
    private KomponenGUI.JtextFnoSelect JTNamaBarang;
    private KomponenGUI.JtableF JTableData;
    // End of variables declaration//GEN-END:variables

    void searchByJenisBarang() {
        if (JTJenisBarang.getText().equals("")) {
            JTableData.setQuery(query1);
        } else {
            JTableData.setQuery(query1 + "REGEXP '" + JTJenisBarang.getText().replace(" ", ".+") + "'");
        }
        JTableData.tampilkan();
        TableColumn tableColumn = JTableData.getColumnModel().getColumn(0);
        tableColumn.setPreferredWidth(90);
        if (JTableData.getRowCount() != 0) {
            JTableData.setRowSelectionInterval(0, 0);
        }
    }
    
    void searchByKategoriBarang() {
        if (JTKategoriBarang.getText().equals("")) {
            JTableData.setQuery(query2);
        } else {
            JTableData.setQuery(query2 + "REGEXP '" + JTKategoriBarang.getText().replace(" ", ".+") + "'");
        }
        JTableData.tampilkan();
        TableColumn tableColumn = JTableData.getColumnModel().getColumn(0);
        tableColumn.setPreferredWidth(90);
        if (JTableData.getRowCount() != 0) {
            JTableData.setRowSelectionInterval(0, 0);
        }
    }

    void searchByNamaBarang() {
        if (JTNamaBarang.getText().equals("")) {
            JTableData.setQuery(query3);
        } else {
            JTableData.setQuery(query3 + "REGEXP '" + JTNamaBarang.getText().replace(" ", ".+") + "'");
        }
        JTableData.tampilkan();
        TableColumn tableColumn = JTableData.getColumnModel().getColumn(0);
        tableColumn.setPreferredWidth(90);
        if (JTableData.getRowCount() != 0) {
            JTableData.setRowSelectionInterval(0, 0);
        }
    }
}