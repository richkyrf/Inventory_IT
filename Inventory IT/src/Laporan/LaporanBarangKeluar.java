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
import javax.swing.JOptionPane;

/**
 *
 * @author Martono
 */
public class LaporanBarangKeluar extends javax.swing.JFrame {

    /**
     * Creates new form LaporanMasterVendor
     */
    public LaporanBarangKeluar() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Laporan Barang Keluar");
        setVisible(true);
        JCJenisBarang.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLLaporanBarangRusak = new KomponenGUI.JlableF();
        JLTanggalRusak = new KomponenGUI.JlableF();
        JLTanggaRusak2 = new KomponenGUI.JlableF();
        JDTanggalRusakAwal = new KomponenGUI.JdateCF();
        JLTanggalRusak3 = new KomponenGUI.JlableF();
        JDTanggalRusakAkhir = new KomponenGUI.JdateCF();
        JLJenisBarang = new KomponenGUI.JlableF();
        JLJenisBarang2 = new KomponenGUI.JlableF();
        JCJenisBarang = new KomponenGUI.JcomboboxF();
        JLKategoriBarang = new KomponenGUI.JlableF();
        JLKategoriBarang2 = new KomponenGUI.JlableF();
        JCKategoriBarang = new KomponenGUI.JcomboboxF();
        JLNamaBarang = new KomponenGUI.JlableF();
        JLNamaBarang2 = new KomponenGUI.JlableF();
        JCNamaBarang = new KomponenGUI.JcomboboxF();
        JLNamaPemakai = new KomponenGUI.JlableF();
        JLNamaPemakai2 = new KomponenGUI.JlableF();
        JCNamaPemakai = new KomponenGUI.JcomboboxF();
        JBTampilkan = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JLLaporanBarangRusak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLLaporanBarangRusak.setText("LAPORAN BARANG KELUAR");

        JLTanggalRusak.setText("Tanggal Keluar");

        JLTanggaRusak2.setText(":");

        JDTanggalRusakAwal.setDate(new Date());
        JDTanggalRusakAwal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JDTanggalRusakAwalKeyReleased(evt);
            }
        });

        JLTanggalRusak3.setText("s/d");

        JDTanggalRusakAkhir.setDate(new Date());
        JDTanggalRusakAkhir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JDTanggalRusakAkhirKeyReleased(evt);
            }
        });

        JLJenisBarang.setText("Jenis Barang");

        JLJenisBarang2.setText(":");

        JCJenisBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Jenis Barang --" }));
        JCJenisBarang.load("SELECT '-- Semua Jenis Barang --' AS `JenisBarang` UNION SELECT `JenisBarang` FROM `tbmjenisbarang`");
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

        JLKategoriBarang.setText("Kategori Barang");

        JLKategoriBarang2.setText(":");

        JCKategoriBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Kategori Barang --" }));
        JCKategoriBarang.load("SELECT '-- Semua Kategori Barang --' AS `KategoriBarang` UNION SELECT `KategoriBarang` FROM `tbmkategoribarang`");
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

        JLNamaBarang.setText("Nama Barang");

        JLNamaBarang2.setText(":");

        JCNamaBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Nama Barang --" }));
        JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang`");
        JCNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JCNamaBarangKeyReleased(evt);
            }
        });

        JLNamaPemakai.setText("Nama Pemakai");

        JLNamaPemakai2.setText(":");

        JCNamaPemakai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Semua Nama Pemakai --" }));
        JCNamaPemakai.load("SELECT '-- Semua Nama Pemakai --' AS `NamaKaryawan` UNION SELECT `NamaKaryawan` FROM `tbmkaryawan`");
        JCNamaPemakai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JCNamaPemakaiKeyReleased(evt);
            }
        });

        JBTampilkan.setText("Tampilkan");
        JBTampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTampilkanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLLaporanBarangRusak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLJenisBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCJenisBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLKategoriBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCKategoriBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLNamaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLTanggalRusak, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLTanggaRusak2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDTanggalRusakAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLTanggalRusak3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDTanggalRusakAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLNamaPemakai, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLNamaPemakai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBTampilkan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCNamaPemakai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLLaporanBarangRusak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLTanggalRusak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTanggaRusak2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggalRusakAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDTanggalRusakAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLTanggalRusak3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLJenisBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JCJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLKategoriBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNamaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNamaPemakai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNamaPemakai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaPemakai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTampilkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTampilkanActionPerformed
        tampilkan();
    }//GEN-LAST:event_JBTampilkanActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GlobalVar.Var.laporanBarangKeluar = null;
    }//GEN-LAST:event_formWindowClosed

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
        if (JCKategoriBarang.getSelectedIndex() == 0 && JCJenisBarang.getSelectedIndex() == 0) {
            JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang`");
        } else if (JCKategoriBarang.getSelectedIndex() == 0 && JCJenisBarang.getSelectedIndex() != 0) {
            JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `JenisBarang`='" + JCJenisBarang.getSelectedItem() + "'");
        } else if (JCKategoriBarang.getSelectedIndex() != 0 && JCJenisBarang.getSelectedIndex() == 0) {
            JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `KategoriBarang`='" + JCKategoriBarang.getSelectedItem() + "'");
        } else {
            JCNamaBarang.load("SELECT '-- Semua Nama Barang --' AS `NamaBarang` UNION SELECT `NamaBarang` FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `JenisBarang`='" + JCJenisBarang.getSelectedItem() + "' AND `KategoriBarang`='" + JCKategoriBarang.getSelectedItem() + "'");
        }
    }//GEN-LAST:event_JCKategoriBarangItemStateChanged

    private void JCKategoriBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCKategoriBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_JCKategoriBarangKeyReleased

    private void JCNamaBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaPemakai.requestFocus();
        }
    }//GEN-LAST:event_JCNamaBarangKeyReleased

    private void JCNamaPemakaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaPemakaiKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tampilkan();
        }
    }//GEN-LAST:event_JCNamaPemakaiKeyReleased

    private void JDTanggalRusakAwalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalRusakAwalKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JDTanggalRusakAkhir.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalRusakAwalKeyReleased

    private void JDTanggalRusakAkhirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalRusakAkhirKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCJenisBarang.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalRusakAkhirKeyReleased

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
            java.util.logging.Logger.getLogger(LaporanBarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanBarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanBarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanBarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanBarangKeluar();
            }
        });
    }

    boolean checkInput() {
        if (JDTanggalRusakAwal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Keluar Awal Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JDTanggalRusakAwal.requestFocus();
            return false;
        } else if (JDTanggalRusakAkhir.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Keluar Akhir Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JDTanggalRusakAkhir.requestFocus();
            return false;
        } else if (JDTanggalRusakAkhir.getDate().compareTo(JDTanggalRusakAwal.getDate()) < 0) {
            JOptionPane.showMessageDialog(this, "Tanggal Keluar Akhir Tidak Boleh Lebih Kecil Dari Tanggal Keluar Awal", "Information", JOptionPane.INFORMATION_MESSAGE);
            JDTanggalRusakAkhir.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    void tampilkan() {
        if (checkInput()) {
            String jenisBarang, kategoriBarang, namaBarang, namaPemakai;
            HashMap hashs = new HashMap();
            FLaporan fLaporan = new FLaporan();
            hashs.put("Title", "Laporan Barang Keluar");
            hashs.put("TanggalRusakAwal", FDateF.datetostr(JDTanggalRusakAwal.getDate(), "dd/MM/yyyy"));
            hashs.put("TanggalRusakAkhir", FDateF.datetostr(JDTanggalRusakAkhir.getDate(), "dd/MM/yyyy"));
            if (JCJenisBarang.getSelectedIndex() == 0) {
                jenisBarang = "";
                hashs.put("JenisBarang", "Semua Jenis");
            } else {
                jenisBarang = " AND `JenisBarang`='" + JCJenisBarang.getSelectedItem() + "'";
                hashs.put("JenisBarang", JCJenisBarang.getSelectedItem());
            }
            if (JCKategoriBarang.getSelectedIndex() == 0) {
                kategoriBarang = "";
                hashs.put("KategoriBarang", "Semua Kategori");
            } else {
                kategoriBarang = " AND `KategoriBarang`='" + JCKategoriBarang.getSelectedItem() + "'";
                hashs.put("KategoriBarang", JCKategoriBarang.getSelectedItem());
            }
            if (JCNamaBarang.getSelectedIndex() == 0) {
                namaBarang = "";
                hashs.put("NamaBarang", "Semua Barang");
            } else {
                namaBarang = " AND `NamaBarang`='" + JCNamaBarang.getSelectedItem() + "'";
                hashs.put("NamaBarang", JCNamaBarang.getSelectedItem());
            }
            if (JCNamaPemakai.getSelectedIndex() == 0) {
                namaPemakai = "";
                hashs.put("NamaPemakai", "Semua Pemakai");
            } else {
                namaPemakai = " AND `NamaKaryawan`='" + JCNamaPemakai.getSelectedItem() + "'";
                hashs.put("NamaPemakai", JCNamaPemakai.getSelectedItem());
            }
            hashs.put("PrintedBy", "Di Print Oleh " + GlobalVar.VarL.username + " Pada " + FDateF.datetostr(new Date(), "dd/MM/yyyy HH:mm"));
            hashs.put("Where", " AND `TanggalBarangKeluar` BETWEEN '" + FDateF.datetostr(JDTanggalRusakAwal.getDate(), "yyyy-MM-dd") + "' AND '" + FDateF.datetostr(JDTanggalRusakAkhir.getDate(), "yyyy-MM-dd") + "'" + jenisBarang + kategoriBarang + namaBarang + namaPemakai);
            fLaporan.sethashmap(hashs);
            fLaporan.setfilename("LaporanBarangKeluar");
            fLaporan.setErorm("Gagal Menampilkan " + this.getTitle());
            fLaporan.excute();
            History.simpanhistory(GlobalVar.VarL.username, "Melihat Laporan Barang Keluar");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBTampilkan;
    private KomponenGUI.JcomboboxF JCJenisBarang;
    private KomponenGUI.JcomboboxF JCKategoriBarang;
    private KomponenGUI.JcomboboxF JCNamaBarang;
    private KomponenGUI.JcomboboxF JCNamaPemakai;
    private KomponenGUI.JdateCF JDTanggalRusakAkhir;
    private KomponenGUI.JdateCF JDTanggalRusakAwal;
    private KomponenGUI.JlableF JLJenisBarang;
    private KomponenGUI.JlableF JLJenisBarang2;
    private KomponenGUI.JlableF JLKategoriBarang;
    private KomponenGUI.JlableF JLKategoriBarang2;
    private KomponenGUI.JlableF JLLaporanBarangRusak;
    private KomponenGUI.JlableF JLNamaBarang;
    private KomponenGUI.JlableF JLNamaBarang2;
    private KomponenGUI.JlableF JLNamaPemakai;
    private KomponenGUI.JlableF JLNamaPemakai2;
    private KomponenGUI.JlableF JLTanggaRusak2;
    private KomponenGUI.JlableF JLTanggalRusak;
    private KomponenGUI.JlableF JLTanggalRusak3;
    // End of variables declaration//GEN-END:variables
}
