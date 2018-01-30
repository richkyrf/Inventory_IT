/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses;

import java.awt.event.KeyEvent;

/**
 *
 * @author Martono
 */
public class JCari extends javax.swing.JFrame {

    /**
     * Creates new form JCari
     */
    Boolean Success = false;
    String Query1, Query2, Query3;
    int SelectedRow = -1;
    KomponenGUI.JtextF[] ArrayBarang = new KomponenGUI.JtextF[3];
    KomponenGUI.JtextF FocusIfCancel;
    KomponenGUI.JRibuanTextField FocusIfSuccess;

    public JCari(String query1, String query2, String query3, String title, KomponenGUI.JtextF[] arrayBarang, String keywordForSearch, KomponenGUI.JRibuanTextField focusIfSuccess, KomponenGUI.JtextF focusIfCancel) {
        Query1 = query1;
        Query2 = query2;
        Query3 = query3;
        ArrayBarang = arrayBarang;
        FocusIfSuccess = focusIfSuccess;
        FocusIfCancel = focusIfCancel;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(title);
        setVisible(true);
        JTNamaBarang.setText(keywordForSearch);
        searchByNamaBarang();
        JTNamaBarang.requestFocus();
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
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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

        JSPData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                executePilih();
                break;
            case KeyEvent.VK_DOWN:
                JTableData.requestFocus();
                if (JTableData.getSelectedRow() == 0) {
                    JTableData.setRowSelectionInterval(1, 1);
                }   break;
            default:
                searchByJenisBarang();
                break;
        }
    }//GEN-LAST:event_JTJenisBarangKeyReleased

    private void JBPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPilihActionPerformed
        executePilih();
    }//GEN-LAST:event_JBPilihActionPerformed

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        GlobalVar.Var.jCari.dispose();
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JTableDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableDataMouseReleased
        if (JTableData.getSelectedRow() == SelectedRow) {
            executePilih();
        } else {
            SelectedRow = JTableData.getSelectedRow();
        }
    }//GEN-LAST:event_JTableDataMouseReleased

    private void JTNamaBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                executePilih();
                break;
            case KeyEvent.VK_DOWN:
                JTableData.requestFocus();
                if (JTableData.getSelectedRow() == 0) {
                    JTableData.setRowSelectionInterval(1, 1);
                }   break;
            default:
                searchByNamaBarang();
                break;
        }
    }//GEN-LAST:event_JTNamaBarangKeyReleased

    private void JTableDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTableDataKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            executePilih();
        }
    }//GEN-LAST:event_JTableDataKeyPressed

    private void JTJenisBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTJenisBarangFocusGained
        searchByJenisBarang();
    }//GEN-LAST:event_JTJenisBarangFocusGained

    private void JTNamaBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTNamaBarangFocusGained
        searchByNamaBarang();
    }//GEN-LAST:event_JTNamaBarangFocusGained

    private void JTKategoriBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTKategoriBarangFocusGained
        searchByKategoriBarang();
    }//GEN-LAST:event_JTKategoriBarangFocusGained

    private void JTKategoriBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKategoriBarangKeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                executePilih();
                break;
            case KeyEvent.VK_DOWN:
                JTableData.requestFocus();
                if (JTableData.getSelectedRow() == 0) {
                    JTableData.setRowSelectionInterval(1, 1);
                }   break;
            default:
                searchByKategoriBarang();
                break;
        }
    }//GEN-LAST:event_JTKategoriBarangKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.jCari = null;
        if (Success) {
            FocusIfSuccess.requestFocus();
        } else {
            FocusIfCancel.requestFocus();
        }
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBPilih;
    private javax.swing.JScrollPane JSPData;
    public static KomponenGUI.JtextF JTJenisBarang;
    public static KomponenGUI.JtextF JTKategoriBarang;
    private KomponenGUI.JtextFnoSelect JTNamaBarang;
    private KomponenGUI.JtableF JTableData;
    // End of variables declaration//GEN-END:variables

    void tampilkan(){
        JTableData.tampilkan();
        JTableData.getColumnModel().getColumn(0).setPreferredWidth(366);
        JTableData.getColumnModel().getColumn(1).setPreferredWidth(371);
        JTableData.getColumnModel().getColumn(2).setPreferredWidth(648);
        if (JTableData.getRowCount() != 0) {
            JTableData.setRowSelectionInterval(0, 0);
        }
    }
    
    void executePilih() {
        ArrayBarang[0].setText(JTableData.getValueAt(JTableData.getSelectedRow(), 0).toString());
        ArrayBarang[1].setText(JTableData.getValueAt(JTableData.getSelectedRow(), 1).toString());
        ArrayBarang[2].setText(JTableData.getValueAt(JTableData.getSelectedRow(), 2).toString());
        Success = true;
        GlobalVar.Var.jCari.dispose();
    }

    void searchByJenisBarang() {
        if (JTJenisBarang.getText().equals("")) {
            JTableData.setQuery(Query1 + "LIKE '%" + JTJenisBarang.getText() + "%' ORDER BY `JenisBarang`, `KategoriBarang`, `NamaBarang`");
        } else {
            JTableData.setQuery(Query1 + "REGEXP '" + JTJenisBarang.getText().replace(" ", ".+") + "' ORDER BY `JenisBarang`, `KategoriBarang`, `NamaBarang`");
        }
        tampilkan();
    }

    void searchByKategoriBarang() {
        if (JTKategoriBarang.getText().equals("")) {
            JTableData.setQuery(Query2 + "LIKE '%" + JTKategoriBarang.getText() + "%' ORDER BY `JenisBarang`, `KategoriBarang`, `NamaBarang`");
        } else {
            JTableData.setQuery(Query2 + "REGEXP '" + JTKategoriBarang.getText().replace(" ", ".+") + "' ORDER BY `JenisBarang`, `KategoriBarang`, `NamaBarang`");
        }
        tampilkan();
    }

    void searchByNamaBarang() {
        if (JTNamaBarang.getText().equals("")) {
            JTableData.setQuery(Query3 + "LIKE '%" + JTNamaBarang.getText() + "%' ORDER BY `JenisBarang`, `KategoriBarang`, `NamaBarang`");
        } else {
            JTableData.setQuery(Query3 + "REGEXP '" + JTNamaBarang.getText().replace(" ", ".+") + "' ORDER BY `JenisBarang`, `KategoriBarang`, `NamaBarang`");
        }
        tampilkan();
    }
}
