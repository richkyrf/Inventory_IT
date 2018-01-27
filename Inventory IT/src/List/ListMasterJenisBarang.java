/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import javax.swing.JOptionPane;
import LSubProces.Delete;
import Master.MasterJenisBarang;

/**
 *
 * @author Martono
 */
public class ListMasterJenisBarang extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ListMasterJenisBarang() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Master Jenis Barang");
        setVisible(true);
        load();
        if (!GlobalVar.VarL.level.equals("Administrator")) {
            JBHapus.setVisible(false);
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

        JComCari = new KomponenGUI.JcomCari();
        JBKembali = new KomponenGUI.JbuttonF();
        JBRefresh = new KomponenGUI.JbuttonF();
        JBTambah = new KomponenGUI.JbuttonF();
        JBUbah = new KomponenGUI.JbuttonF();
        JBHapus = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JBKembali.setText("Kembali");
        JBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKembaliActionPerformed(evt);
            }
        });

        JBRefresh.setText("Refresh");
        JBRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRefreshActionPerformed(evt);
            }
        });

        JBTambah.setText("Tambah");
        JBTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahActionPerformed(evt);
            }
        });

        JBUbah.setText("Ubah");
        JBUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahActionPerformed(evt);
            }
        });

        JBHapus.setText("Hapus");
        JBHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JComCari, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JComCari, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        ubah();
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JBRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRefreshActionPerformed
        load();
    }//GEN-LAST:event_JBRefreshActionPerformed

    private void JBHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHapusActionPerformed
        hapus();
    }//GEN-LAST:event_JBHapusActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        GlobalVar.Var.listMasterJenisBarang = null;
    }//GEN-LAST:event_formWindowClosing

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        GlobalVar.Var.listMasterJenisBarang.dispose();
        GlobalVar.Var.listMasterJenisBarang = null;
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        tambah();
    }//GEN-LAST:event_JBTambahActionPerformed

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
            java.util.logging.Logger.getLogger(ListMasterJenisBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMasterJenisBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMasterJenisBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMasterJenisBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMasterJenisBarang();
            }
        });
    }

    public void load() {
        JComCari.setQuery("SELECT `IdJenisBarang` AS 'ID', `JenisBarang` AS 'Jenis Barang', `Keterangan` FROM `tbmjenisbarang`");
        JComCari.tampilkan();
    }

    void tambah() {
        if (GlobalVar.Var.tambahMasterJenisBarang == null) {
            GlobalVar.Var.tambahMasterJenisBarang = new MasterJenisBarang("0");
        }
    }

    void ubah() {
        if (JComCari.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (GlobalVar.Var.editMasterJenisBarang == null) {
                GlobalVar.Var.editMasterJenisBarang = new MasterJenisBarang(JComCari.GetIDTable());
            }
        }
    }

    void hapus() {
        if (JComCari.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Delete delete = new LSubProces.Delete();
            if (delete.Hapus(JComCari.GetIDTable(), "DELETE FROM `tbmjenisbarang` WHERE `IdJenisBarang`=" + JComCari.GetIDTable(), "Hapus Data Master Jenis Barang", this)) {
                load();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBHapus;
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBRefresh;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JcomCari JComCari;
    // End of variables declaration//GEN-END:variables
}
