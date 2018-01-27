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
public class MasterBarangService extends javax.swing.JFrame {

    String idEdit;
    String[] data;

    /**
     * Creates new form MasterPemasok
     */
    public MasterBarangService(Object id) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        idEdit = id.toString();
        data = idEdit.split("\\+");
        if (idEdit.equals("0") || data.length > 1) {
            setTitle("Tambah Master Barang Service");
            if (data.length > 1) {
                JCJenisBarangService.setSelectedItem(data[1]);
                JTNamaBarangService.requestFocus();
            }
            JBUbah.setVisible(false);
        } else {
            setTitle("Ubah Master Barang Service");
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

        JLJenisBarangService = new KomponenGUI.JlableF();
        JLJenisBarangService2 = new KomponenGUI.JlableF();
        JCJenisBarangService = new KomponenGUI.JcomboboxF();
        JBJenisBarangService = new KomponenGUI.JbuttonF();
        JLNamaBarangService = new KomponenGUI.JlableF();
        JLNamaBarangService2 = new KomponenGUI.JlableF();
        JTNamaBarangService = new KomponenGUI.JtextF();
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
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JLJenisBarangService.setText("Jenis Barang Service");

        JLJenisBarangService2.setText(":");

        JCJenisBarangService.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Jenis Barang Service --" }));
        JCJenisBarangService.load("SELECT '-- Pilih Jenis Barang Service --' AS `JenisBarangService` UNION SELECT `JenisBarangService` FROM `tbmjenisbarangservice`");
        JCJenisBarangService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JCJenisBarangServiceKeyReleased(evt);
            }
        });

        JBJenisBarangService.setText("+");
        JBJenisBarangService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBJenisBarangServiceActionPerformed(evt);
            }
        });

        JLNamaBarangService.setText("Nama Barang Service");

        JLNamaBarangService2.setText(":");

        JTNamaBarangService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTNamaBarangServiceKeyReleased(evt);
            }
        });
        JTNamaBarangService.setMaxText(50);

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
                        .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JLNamaBarangService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLJenisBarangService, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLKeterangan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLNamaBarangService2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLJenisBarangService2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSPKeterangan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JCJenisBarangService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBJenisBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTNamaBarangService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLJenisBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLJenisBarangService2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCJenisBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBJenisBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNamaBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNamaBarangService2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNamaBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JSPKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        if (idEdit.equals("0") || data.length > 1) {
            GlobalVar.Var.tambahMasterBarangService.dispose();
            GlobalVar.Var.tambahMasterBarangService = null;
        } else {
            GlobalVar.Var.editMasterBarangService.dispose();
            GlobalVar.Var.editMasterBarangService = null;
        }
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (idEdit.equals("0") || data.length > 1) {
            GlobalVar.Var.tambahMasterBarangService = null;
        } else {
            GlobalVar.Var.editMasterBarangService = null;
        }
    }//GEN-LAST:event_formWindowClosing

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        ubah();
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JTNamaBarangServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangServiceKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTNamaBarangServiceKeyReleased

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JBTambah.isVisible()) {
                tambah(false);
            } else {
                ubah();
            }
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void JBJenisBarangServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBJenisBarangServiceActionPerformed
        if (GlobalVar.Var.tambahMasterJenisBarangService == null) {
            GlobalVar.Var.tambahMasterJenisBarangService = new MasterJenisBarangService("0");
        }
    }//GEN-LAST:event_JBJenisBarangServiceActionPerformed

    private void JCJenisBarangServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCJenisBarangServiceKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JCJenisBarangService.getSelectedIndex() == 0) {
                JCJenisBarangService.showPopup();
            } else {
                JTNamaBarangService.requestFocus();
            }
        }
    }//GEN-LAST:event_JCJenisBarangServiceKeyReleased

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
            java.util.logging.Logger.getLogger(MasterBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterBarangService("0");
            }
        });
    }

    boolean checkInput() {
        if (JCJenisBarangService.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Jenis Barang Service Harus Dipilih", "Information", JOptionPane.INFORMATION_MESSAGE);
            JCJenisBarangService.requestFocus();
            return false;
        } else if (JTNamaBarangService.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Barang Service Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JTNamaBarangService.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    void tambah(boolean tutup) {
        if (checkInput()) {
            Insert insert = new LSubProces.Insert();
            boolean simpan = insert.Simpan("INSERT INTO `tbmbarangservice`(`IdJenisBarangService`, `NamaBarangService`, `Keterangan`) VALUES ((SELECT `IdJenisBarangService` FROM `tbmjenisbarangservice` WHERE `JenisBarangService`='" + JCJenisBarangService.getSelectedItem() + "'), '" + JTNamaBarangService.getText() + "', '" + JTKeterangan.getText() + "')", "Tambah Data Master Barang Service", this);
            if (simpan) {
                if (GlobalVar.Var.listMasterBarangService != null) {
                    GlobalVar.Var.listMasterBarangService.load();
                }
                if (GlobalVar.Var.tambahService != null) {
                    GlobalVar.Var.tambahService.JCNamaBarangService.load("SELECT '-- Pilih Nama Barang Service --' AS `NamaBarangService` UNION SELECT `NamaBarangService` FROM `tbmbarangservice` AS A JOIN `tbmjenisbarangservice` AS B ON A.`IdJenisBarangService`=B.`IdJenisBarangService` WHERE `JenisBarangService`='" + JCJenisBarangService.getSelectedItem() + "'");
                    GlobalVar.Var.tambahService.JCNamaBarangService.setSelectedItem(JTNamaBarangService.getText());
                    GlobalVar.Var.tambahService.JCNamaBarangService.requestFocus();
                }
                if (GlobalVar.Var.editService != null) {
                    GlobalVar.Var.editService.JCNamaBarangService.load("SELECT '-- Pilih Nama Barang Service --' AS `NamaBarangService` UNION SELECT `NamaBarangService` FROM `tbmbarangservice` AS A JOIN `tbmjenisbarangservice` AS B ON A.`IdJenisBarangService`=B.`IdJenisBarangService` WHERE `JenisBarangService`='" + JCJenisBarangService.getSelectedItem() + "'");
                    GlobalVar.Var.editService.JCNamaBarangService.setSelectedItem(JTNamaBarangService.getText());
                    GlobalVar.Var.editService.JCNamaBarangService.requestFocus();
                }
                if (tutup) {
                    GlobalVar.Var.tambahMasterBarangService.dispose();
                    GlobalVar.Var.tambahMasterBarangService = null;
                } else {
                    clearText();
                    JCJenisBarangService.requestFocus();
                }
            }
        }
    }

    void clearText() {
        JTNamaBarangService.setText("");
        JTKeterangan.setText("");
    }

    void loadData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Menampilkan Data Master Barang Service");
        dRunSelctOne.setQuery("SELECT `IdBarangService`, `JenisBarangService`, `NamaBarangService`, A.`Keterangan` FROM `tbmbarangservice` AS A JOIN `tbmjenisbarangservice` AS B ON A.`IdJenisBarangService`=B.`IdJenisBarangService` WHERE `IdBarangService`='" + idEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JCJenisBarangService.setSelectedItem(list.get(1));
        JTNamaBarangService.setText(list.get(2));
        JTKeterangan.setText(list.get(3));
    }

    void ubah() {
        if (checkInput()) {
            Update update = new LSubProces.Update();
            boolean ubah = update.Ubah("UPDATE `tbmbarangservice` SET `IdJenisBarangService`=(SELECT `IdJenisBarangService` FROM `tbmjenisbarangservice` WHERE `JenisBarangService`='" + JCJenisBarangService.getSelectedItem() + "'), `NamaBarangService`='" + JTNamaBarangService.getText() + "', `Keterangan`='" + JTKeterangan.getText() + "' WHERE `IdBarangService`=" + idEdit, "Ubah Data Master Barang Service", this);
            if (ubah) {
                GlobalVar.Var.editMasterBarangService.dispose();
                GlobalVar.Var.editMasterBarangService = null;
                GlobalVar.Var.listMasterBarangService.load();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBJenisBarangService;
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBUbah;
    public KomponenGUI.JcomboboxF JCJenisBarangService;
    private KomponenGUI.JlableF JLJenisBarangService;
    private KomponenGUI.JlableF JLJenisBarangService2;
    private KomponenGUI.JlableF JLKeterangan;
    private KomponenGUI.JlableF JLKeterangan2;
    private KomponenGUI.JlableF JLNamaBarangService;
    private KomponenGUI.JlableF JLNamaBarangService2;
    private javax.swing.JScrollPane JSPKeterangan;
    private KomponenGUI.JTextAreaF JTKeterangan;
    private KomponenGUI.JtextF JTNamaBarangService;
    // End of variables declaration//GEN-END:variables
}
