package Master;

import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.Update;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;

/**
 *
 * @author Martono
 */
public class MasterVendor extends javax.swing.JFrame {

    String idEdit;

    /**
     * Creates new form MasterPemasok
     */
    public MasterVendor(Object id) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        idEdit = id.toString();
        if (idEdit.equals("0")) {
            setTitle("Tambah Master Vendor");
            JBUbah.setVisible(false);
        } else {
            setTitle("Ubah Master Vendor");
            loadData();
            JBTambah.setVisible(false);
            JBTambahTutup.setVisible(false);
        }
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLNamaVendor = new KomponenGUI.JlableF();
        JLNamaVendor2 = new KomponenGUI.JlableF();
        JTNamaVendor = new KomponenGUI.JtextF();
        JLNomorTelepon = new KomponenGUI.JlableF();
        JLNomorTelepon2 = new KomponenGUI.JlableF();
        JTNomorTelepon = new KomponenGUI.JtextF();
        JLAlamat = new KomponenGUI.JlableF();
        JLAlamat2 = new KomponenGUI.JlableF();
        JTAlamat = new KomponenGUI.JtextF();
        JLKeterangan = new KomponenGUI.JlableF();
        JLKeterangan2 = new KomponenGUI.JlableF();
        JSPKeterangan = new javax.swing.JScrollPane();
        JTKeterangan = new KomponenGUI.JTextAreaF();
        JBKembali = new KomponenGUI.JbuttonF();
        JBTambah = new KomponenGUI.JbuttonF();
        JBTambahTutup = new KomponenGUI.JbuttonF();
        JBUbah = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JLNamaVendor.setText("Nama Vendor");

        JLNamaVendor2.setText(":");

        JTNamaVendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTNamaVendorKeyReleased(evt);
            }
        });
        JTNamaVendor.setMaxText(50);

        JLNomorTelepon.setText("Nomor Telepon");

        JLNomorTelepon2.setText(":");

        JTNomorTelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTNomorTeleponKeyReleased(evt);
            }
        });
        JTNomorTelepon.setMaxText(20);

        JLAlamat.setText("Alamat");

        JLAlamat2.setText(":");

        JTAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTAlamatKeyReleased(evt);
            }
        });

        JLKeterangan.setText("Keterangan");

        JLKeterangan2.setText(":");

        JTKeterangan.setColumns(20);
        JTKeterangan.setLineWrap(true);
        JTKeterangan.setRows(5);
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyPressed(evt);
            }
        });
        JSPKeterangan.setViewportView(JTKeterangan);

        JBKembali.setText("Kembali");
        JBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKembaliActionPerformed(evt);
            }
        });

        JBTambah.setText("Tambah");
        JBTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahActionPerformed(evt);
            }
        });

        JBTambahTutup.setText("Tambah dan Tutup");
        JBTambahTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahTutupActionPerformed(evt);
            }
        });

        JBUbah.setText("Ubah");
        JBUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JSPKeterangan)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLNomorTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLAlamat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLNomorTelepon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNomorTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLNamaVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLNamaVendor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTNamaVendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNamaVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNamaVendor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNamaVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNomorTelepon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLAlamat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JSPKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTambahTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahTutupActionPerformed
        tambah(true);
    }//GEN-LAST:event_JBTambahTutupActionPerformed

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        tambah(false);
    }//GEN-LAST:event_JBTambahActionPerformed

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        if (idEdit.equals("0")) {
            GlobalVar.Var.tambahMasterVendor.dispose();
        } else {
            GlobalVar.Var.editMasterVendor.dispose();
        }
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        ubah();
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JTNamaVendorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaVendorKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNomorTelepon.requestFocus();
        }
    }//GEN-LAST:event_JTNamaVendorKeyReleased

    private void JTNomorTeleponKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNomorTeleponKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAlamat.requestFocus();
        }
    }//GEN-LAST:event_JTNomorTeleponKeyReleased

    private void JTAlamatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAlamatKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTAlamatKeyReleased

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JBTambah.isVisible()) {
                tambah(false);
            } else {
                ubah();
            }
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (idEdit.equals("0")) {
            GlobalVar.Var.tambahMasterVendor = null;
        } else {
            GlobalVar.Var.editMasterVendor = null;
        }
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
            java.util.logging.Logger.getLogger(MasterVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterVendor("0");
            }
        });
    }

    boolean checkInput() {
        if (JTNamaVendor.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Vendor Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JTNamaVendor.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    void tambah(boolean tutup) {
        if (checkInput()) {
            Insert insert = new LSubProces.Insert();
            boolean simpan = insert.Simpan("INSERT INTO `tbmvendor`(`NamaVendor`, `NomorTelepon`, `Alamat`, `Keterangan`) VALUES ('" + JTNamaVendor.getText() + "', '" + JTNomorTelepon.getText() + "', '" + JTAlamat.getText() + "', '" + JTKeterangan.getText() + "')", "Tambah Data Master Vendor", this);
            if (simpan) {
                if (GlobalVar.Var.listMasterVendor != null) {
                    GlobalVar.Var.listMasterVendor.load();
                }
                if (GlobalVar.Var.tambahPurchaseRequest != null) {
                    GlobalVar.Var.tambahPurchaseRequest.JCNamaVendor.load("SELECT `NamaVendor` FROM `tbmvendor` ");
                    GlobalVar.Var.tambahPurchaseRequest.JCNamaVendor.setSelectedItem(JTNamaVendor.getText());
                    GlobalVar.Var.tambahPurchaseRequest.JCNamaVendor.requestFocus();
                }
                if (GlobalVar.Var.editPurchaseRequest != null) {
                    GlobalVar.Var.editPurchaseRequest.JCNamaVendor.load("SELECT `NamaVendor` FROM `tbmvendor` ");
                    GlobalVar.Var.editPurchaseRequest.JCNamaVendor.setSelectedItem(JTNamaVendor.getText());
                    GlobalVar.Var.editPurchaseRequest.JCNamaVendor.requestFocus();
                }
                if (GlobalVar.Var.tambahBarangMasuk != null) {
                    GlobalVar.Var.tambahBarangMasuk.JCNamaVendor.load("SELECT `NamaVendor` FROM `tbmvendor` ");
                    GlobalVar.Var.tambahBarangMasuk.JCNamaVendor.setSelectedItem(JTNamaVendor.getText());
                    GlobalVar.Var.tambahBarangMasuk.JCNamaVendor.requestFocus();
                }
                if (GlobalVar.Var.editBarangMasuk != null) {
                    GlobalVar.Var.editBarangMasuk.JCNamaVendor.load("SELECT `NamaVendor` FROM `tbmvendor` ");
                    GlobalVar.Var.editBarangMasuk.JCNamaVendor.setSelectedItem(JTNamaVendor.getText());
                    GlobalVar.Var.editBarangMasuk.JCNamaVendor.requestFocus();
                }
                if (tutup) {
                    GlobalVar.Var.tambahMasterVendor.dispose();
                } else {
                    clearText();
                    JTNamaVendor.requestFocus();
                }
            }
        }
    }

    void clearText() {
        JTNamaVendor.setText("");
        JTNomorTelepon.setText("");
        JTAlamat.setText("");
        JTKeterangan.setText("");
    }

    void loadData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Menampilkan Data Master Vendor");
        dRunSelctOne.setQuery("SELECT `IdVendor`, `NamaVendor`, `NomorTelepon`, `Alamat`, `Keterangan` FROM `tbmvendor` WHERE `IdVendor`='" + idEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JTNamaVendor.setText(list.get(1));
        JTNomorTelepon.setText(list.get(2));
        JTAlamat.setText(list.get(3));
        JTKeterangan.setText(list.get(4));
    }

    void ubah() {
        if (checkInput()) {
            Update update = new LSubProces.Update();
            boolean ubah = update.Ubah("UPDATE `tbmvendor` SET `NamaVendor`='" + JTNamaVendor.getText() + "', `NomorTelepon`='" + JTNomorTelepon.getText() + "', `Alamat`='" + JTAlamat.getText() + "', `Keterangan`='" + JTKeterangan.getText() + "' WHERE `IdVendor`=" + idEdit, "Ubah Data Master Vendor", this);
            if (ubah) {
                GlobalVar.Var.editMasterVendor.dispose();
                GlobalVar.Var.listMasterVendor.load();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JlableF JLAlamat;
    private KomponenGUI.JlableF JLAlamat2;
    private KomponenGUI.JlableF JLKeterangan;
    private KomponenGUI.JlableF JLKeterangan2;
    private KomponenGUI.JlableF JLNamaVendor;
    private KomponenGUI.JlableF JLNamaVendor2;
    private KomponenGUI.JlableF JLNomorTelepon;
    private KomponenGUI.JlableF JLNomorTelepon2;
    private javax.swing.JScrollPane JSPKeterangan;
    private KomponenGUI.JtextF JTAlamat;
    private KomponenGUI.JTextAreaF JTKeterangan;
    private KomponenGUI.JtextF JTNamaVendor;
    private KomponenGUI.JtextF JTNomorTelepon;
    // End of variables declaration//GEN-END:variables
}
