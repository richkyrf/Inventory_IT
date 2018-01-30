/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import javax.swing.JOptionPane;
import LSubProces.Delete;
import Proses.Service;
import Proses.ServiceAll;

/**
 *
 * @author Martono
 */
public class ListService extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ListService() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Service");
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
        JBService = new KomponenGUI.JbuttonF();
        JBUbah = new KomponenGUI.JbuttonF();
        JBHapus = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
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

        JBService.setText("Service");
        JBService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBServiceActionPerformed(evt);
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
                        .addComponent(JBService, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(JBRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        GlobalVar.Var.listService.dispose();
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        tambah();
    }//GEN-LAST:event_JBTambahActionPerformed

    private void JBServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBServiceActionPerformed
        if (JComCari.getSelectedRows() < 1) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (GlobalVar.Var.serviceAll == null) {
            GlobalVar.Var.serviceAll = new ServiceAll(JComCari.getSelectedIDs());
        } else {
            GlobalVar.Var.serviceAll.setState(NORMAL);
            GlobalVar.Var.serviceAll.toFront();
        }
    }//GEN-LAST:event_JBServiceActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.listService = null;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ListService.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListService.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListService.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListService.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListService();
            }
        });
    }

    public void load() {
        JComCari.setQuery("SELECT A.`IdService` AS 'ID', `JenisService` AS 'Jenis Service', `JenisBarangService` AS 'Jenis Barang Service', `NamaBarangService` AS 'Nama Barang Service', DATE_FORMAT(`TanggalService`, '%d/%m/%Y') AS 'Tanggal Service', DATE_FORMAT(`TanggalServiceSelanjutnya`, '%d/%m/%Y') AS 'Tanggal Service Selanjutnya', A.`Keterangan`, 0 AS 'Pilih' FROM `tbservice` AS A JOIN `tbmjenisservice` AS B ON A.`IdJenisService`=B.`IdJenisService` JOIN `tbmbarangservice` AS C ON A.`IdBarangService`=C.`IdBarangService` JOIN `tbmjenisbarangservice` AS D ON C.`IdJenisBarangService`=D.`IdJenisBarangService` JOIN (SELECT MAX(`IdService`) AS 'IdService' FROM `tbservice` GROUP BY `IdBarangService`) AS E ON A.`IdService`=E.`IdService`");
        JComCari.setOrder("ORDER BY `JenisService`, `JenisBarangService`, `NamaBarangService`");
        JComCari.jtablef.useboolean(true);
        JComCari.jtablef.setbooleanfield(7);
        JComCari.setSelectedIndex(3);
        JComCari.tampilkan();
    }

    void tambah() {
        if (GlobalVar.Var.tambahService == null) {
            GlobalVar.Var.tambahService = new Service("0");
        } else {
            GlobalVar.Var.tambahService.setState(NORMAL);
            GlobalVar.Var.tambahService.toFront();
        }
    }

    void ubah() {
        if (JComCari.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (GlobalVar.Var.editService == null) {
                GlobalVar.Var.editService = new Service(JComCari.GetIDTable());
            } else {
                GlobalVar.Var.editService.setState(NORMAL);
                GlobalVar.Var.editService.toFront();
            }
        }
    }

    void hapus() {
        if (JComCari.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Delete delete = new LSubProces.Delete();
            if (delete.Hapus(JComCari.GetIDTable(), "DELETE FROM `tbservice` WHERE `IdService`=" + JComCari.GetIDTable(), "Hapus Data Service", this)) {
                load();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBHapus;
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBRefresh;
    private KomponenGUI.JbuttonF JBService;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JcomCari JComCari;
    // End of variables declaration//GEN-END:variables
}
