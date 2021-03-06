/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laporan;

import KomponenGUI.FDateF;
import LSubProces.FLaporan;
import LSubProces.History;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRParameter;

/**
 *
 * @author richky
 */
public class LaporanPurchaseRequest extends javax.swing.JFrame {

    /**
     * Creates new form LaporanBarangMasuk
     */
    public LaporanPurchaseRequest() {
        initComponents();
        setTitle("Laporan Purchase Request");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        JCJenisBarang.requestFocus();
    }

    void print() {
        if (checkInput()) {
            HashMap hashs = new HashMap();
            java.util.Locale locale = new Locale("id", "ID");
            hashs.put(JRParameter.REPORT_LOCALE, locale);
            FLaporan fLaporan = new FLaporan();
            String jenisBarang, kategoriBarang, namaBarang, namaVendor;
            if (JCJenisBarang.getSelectedIndex() != 0) {
                jenisBarang = " AND `NamaBarang` = '" + JCJenisBarang.getSelectedItem() + "'";
                hashs.put("JenisBarang", JCJenisBarang.getSelectedItem());
            } else {
                jenisBarang = "";
                hashs.put("JenisBarang", "Semua Jenis");
            }
            if (JCKategoriBarang.getSelectedIndex() != 0) {
                kategoriBarang = " AND `KategoriBarang` = '" + JCKategoriBarang.getSelectedItem() + "'";
                hashs.put("KategoriBarang", JCKategoriBarang.getSelectedItem());
            } else {
                kategoriBarang = "";
                hashs.put("KategoriBarang", "Semua Kategori");
            }
            if (JCNamaBarang.getSelectedIndex() != 0) {
                namaBarang = " AND `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'";
                hashs.put("NamaBarang", JCNamaBarang.getSelectedItem());
            } else {
                namaBarang = "";
                hashs.put("NamaBarang", "Semua Barang");
            }
            if (JCNamaVendor.getSelectedIndex() != 0) {
                namaVendor = " AND `NamaVendor` = '" + JCNamaVendor.getSelectedItem() + "'";
                hashs.put("NamaVendor", JCNamaVendor.getSelectedItem());
            } else {
                namaVendor = "";
                hashs.put("NamaVendor", "Semua Vendor");
            }
            hashs.put("Title", "Laporan Purchase Request");
            hashs.put("PrintedBy", "Di Print Oleh " + GlobalVar.VarL.username + " Pada " + FDateF.datetostr(new Date(), "dd/MM/yyyy HH:mm"));
            hashs.put("FormatTgl1", FDateF.datetostr(JDTanggalPurchaseRequestAwal.getDate(), "dd/MM/yyyy"));
            hashs.put("FormatTgl2", FDateF.datetostr(JDTanggalPurchaseRequestAkhir.getDate(), "dd/MM/yyyy"));
            hashs.put("Where", " AND `TanggalPurchaseRequest` BETWEEN '" + FDateF.datetostr(JDTanggalPurchaseRequestAwal.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggalPurchaseRequestAkhir.getDate(), "yyyy-MM-dd") + "' " + jenisBarang + kategoriBarang + namaBarang + namaVendor);
            fLaporan.sethashmap(hashs);
            fLaporan.setfilename("LaporanPurchaseRequest");
            fLaporan.setErorm("Gagal Menampilkan " + this.getTitle());
            fLaporan.excute();
            History.simpanhistory(GlobalVar.VarL.username, "Melihat Laporan Purchase Request");
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

        jlableF1 = new KomponenGUI.JlableF();
        jlableF2 = new KomponenGUI.JlableF();
        jlableF3 = new KomponenGUI.JlableF();
        JDTanggalPurchaseRequestAwal = new KomponenGUI.JdateCF();
        jlableF4 = new KomponenGUI.JlableF();
        JDTanggalPurchaseRequestAkhir = new KomponenGUI.JdateCF();
        jlableF5 = new KomponenGUI.JlableF();
        jlableF6 = new KomponenGUI.JlableF();
        jlableF7 = new KomponenGUI.JlableF();
        jlableF8 = new KomponenGUI.JlableF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF11 = new KomponenGUI.JlableF();
        jlableF12 = new KomponenGUI.JlableF();
        JCJenisBarang = new KomponenGUI.JcomboboxF();
        JCKategoriBarang = new KomponenGUI.JcomboboxF();
        JCNamaBarang = new KomponenGUI.JcomboboxF();
        JCNamaVendor = new KomponenGUI.JcomboboxF();
        jbuttonF1 = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlableF1.setText("LAPORAN PURCHASE REQUEST");

        jlableF2.setText("Tanggal PR");

        jlableF3.setText(":");

        JDTanggalPurchaseRequestAwal.setDate(new Date());

        jlableF4.setText("s/d");

        JDTanggalPurchaseRequestAkhir.setDate(new Date());

        jlableF5.setText("Jenis Barang");

        jlableF6.setText("Kategori Barang");

        jlableF7.setText("Nama Barang");

        jlableF8.setText(":");

        jlableF9.setText(":");

        jlableF10.setText(":");

        jlableF11.setText("Vendor");

        jlableF12.setText(":");

        JCJenisBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Jenis Barang --" }));
        JCJenisBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCJenisBarangItemStateChanged(evt);
            }
        });
        JCJenisBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JCJenisBarangKeyReleased(evt);
            }
        });

        JCKategoriBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Kategori Barang --" }));
        JCKategoriBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCKategoriBarangItemStateChanged(evt);
            }
        });
        JCKategoriBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JCKategoriBarangKeyReleased(evt);
            }
        });

        JCNamaBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Nama Barang --" }));
        JCNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JCNamaBarangKeyReleased(evt);
            }
        });

        JCNamaVendor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Vendor --" }));
        JCNamaVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCNamaVendorActionPerformed(evt);
            }
        });

        jbuttonF1.setText("Tampilkan");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlableF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlableF11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JDTanggalPurchaseRequestAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JDTanggalPurchaseRequestAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCJenisBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCKategoriBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNamaVendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggalPurchaseRequestAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDTanggalPurchaseRequestAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCNamaVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCNamaVendorActionPerformed

    }//GEN-LAST:event_JCNamaVendorActionPerformed

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        print();
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void JCJenisBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCJenisBarangItemStateChanged
        if (JCJenisBarang.getSelectedIndex() == 0) {
            JCKategoriBarang.load("SELECT '-- Semua Kategori Barang --' AS `KategoriBarang` UNION SELECT `KategoriBarang` FROM `tbmkategoribarang`");
            JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang`");
        } else {
            JCKategoriBarang.load("SELECT '-- Semua Kategori Barang --' AS `KategoriBarang` UNION SELECT `KategoriBarang` FROM `tbmkategoribarang` AS A JOIN `tbmjenisbarang` AS B ON A.`IdJenisBarang`=B.`IdJenisBarang` WHERE `JenisBarang`='" + JCJenisBarang.getSelectedItem() + "'");
            JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `JenisBarang`='" + JCJenisBarang.getSelectedItem() + "'");
        }
    }//GEN-LAST:event_JCJenisBarangItemStateChanged

    private void JCJenisBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCJenisBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCKategoriBarang.requestFocus();
        }
    }//GEN-LAST:event_JCJenisBarangKeyReleased

    private void JCKategoriBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCKategoriBarangItemStateChanged
        if (JCKategoriBarang.getSelectedIndex() == 0) {
            JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang`");
        } else {
            JCNamaBarang.load("SELECT '-- Pilih Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `KategoriBarang`='" + JCKategoriBarang.getSelectedItem() + "'");
        }
    }//GEN-LAST:event_JCKategoriBarangItemStateChanged

    private void JCKategoriBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCKategoriBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_JCKategoriBarangKeyReleased

    private void JCNamaBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaVendor.requestFocus();
        }
    }//GEN-LAST:event_JCNamaBarangKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.laporanPurchaseRequest = null;
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
            java.util.logging.Logger.getLogger(LaporanPurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanPurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanPurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanPurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanPurchaseRequest().setVisible(true);
            }
        });
    }

    boolean checkInput() {
        if (JDTanggalPurchaseRequestAwal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Rusak Awal Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JDTanggalPurchaseRequestAwal.requestFocus();
            return false;
        } else if (JDTanggalPurchaseRequestAkhir.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Rusak Akhir Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JDTanggalPurchaseRequestAkhir.requestFocus();
            return false;
        } else if (JDTanggalPurchaseRequestAkhir.getDate().compareTo(JDTanggalPurchaseRequestAwal.getDate()) < 0) {
            JOptionPane.showMessageDialog(this, "Tanggal Rusak Akhir Tidak Boleh Lebih Kecil Dari Tanggal Rusak Awal", "Information", JOptionPane.INFORMATION_MESSAGE);
            JDTanggalPurchaseRequestAkhir.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JcomboboxF JCJenisBarang;
    private KomponenGUI.JcomboboxF JCKategoriBarang;
    private KomponenGUI.JcomboboxF JCNamaBarang;
    private KomponenGUI.JcomboboxF JCNamaVendor;
    private KomponenGUI.JdateCF JDTanggalPurchaseRequestAkhir;
    private KomponenGUI.JdateCF JDTanggalPurchaseRequestAwal;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF11;
    private KomponenGUI.JlableF jlableF12;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF7;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables
}
