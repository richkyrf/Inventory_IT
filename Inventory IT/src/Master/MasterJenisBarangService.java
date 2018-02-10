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
public class MasterJenisBarangService extends javax.swing.JFrame {

    String idEdit;

    /**
     * Creates new form MasterPemasok
     */
    public MasterJenisBarangService(Object id) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        idEdit = id.toString();
        if (idEdit.equals("0")) {
            setTitle("Tambah Master Jenis Barang Service");
            JBUbah.setVisible(false);
        } else {
            setTitle("Ubah Master Jenis Barang Service");
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
        JTJenisBarangService = new KomponenGUI.JtextF();
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

        JLJenisBarangService.setText("Jenis Barang Service");

        JLJenisBarangService2.setText(":");

        JTJenisBarangService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTJenisBarangServiceKeyReleased(evt);
            }
        });
        JTJenisBarangService.setMaxText(50);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLJenisBarangService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLJenisBarangService2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSPKeterangan)
                            .addComponent(JTJenisBarangService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLJenisBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLJenisBarangService2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJenisBarangService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (idEdit.equals("0")) {
            GlobalVar.Var.tambahMasterJenisBarangService.dispose();
        } else {
            GlobalVar.Var.editMasterJenisBarangService.dispose();
        }
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        ubah();
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JTJenisBarangServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJenisBarangServiceKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTJenisBarangServiceKeyReleased

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            if (JBTambah.isVisible()) {
                tambah(false);
            } else {
                ubah();
            }
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (idEdit.equals("0")) {
            GlobalVar.Var.tambahMasterJenisBarangService = null;
        } else {
            GlobalVar.Var.editMasterJenisBarangService = null;
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
            java.util.logging.Logger.getLogger(MasterJenisBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterJenisBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterJenisBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterJenisBarangService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterJenisBarangService("0");
            }
        });
    }

    boolean checkInput() {
        if (JTJenisBarangService.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jenis Barang Service Tidak Boleh Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
            JTJenisBarangService.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    void tambah(boolean tutup) {
        if (checkInput()) {
            Insert insert = new LSubProces.Insert();
            boolean simpan = insert.Simpan("INSERT INTO `tbmjenisbarangservice`(`JenisBarangService`, `Keterangan`) VALUES ('" + JTJenisBarangService.getText() + "', '" + JTKeterangan.getText() + "')", "Tambah Data Master Jenis Barang Service", this);
            if (simpan) {
                if (GlobalVar.Var.listMasterJenisBarangService != null) {
                    GlobalVar.Var.listMasterJenisBarangService.load();
                }
                if (GlobalVar.Var.tambahMasterBarangService != null) {
                    GlobalVar.Var.tambahMasterBarangService.JCJenisBarangService.load("SELECT '-- Pilih Jenis Barang Service --' AS `JenisBarangService` UNION SELECT `JenisBarangService` FROM `tbmjenisbarangservice`");
                    GlobalVar.Var.tambahMasterBarangService.JCJenisBarangService.setSelectedItem(JTJenisBarangService.getText());
                    GlobalVar.Var.tambahMasterBarangService.JCJenisBarangService.requestFocus();
                }
                if (GlobalVar.Var.editMasterBarangService != null) {
                    GlobalVar.Var.editMasterBarangService.JCJenisBarangService.load("SELECT '-- Pilih Jenis Barang Service --' AS `JenisBarangService` UNION SELECT `JenisBarangService` FROM `tbmjenisbarangservice`");
                    GlobalVar.Var.editMasterBarangService.JCJenisBarangService.setSelectedItem(JTJenisBarangService.getText());
                    GlobalVar.Var.editMasterBarangService.JCJenisBarangService.requestFocus();
                }
                if (GlobalVar.Var.tambahService != null) {
                    GlobalVar.Var.tambahService.JCJenisBarangService.load("SELECT '-- Pilih Jenis Barang Service --' AS `JenisBarangService` UNION SELECT `JenisBarangService` FROM `tbmjenisbarangservice`");
                    GlobalVar.Var.tambahService.JCJenisBarangService.setSelectedItem(JTJenisBarangService.getText());
                    GlobalVar.Var.tambahService.JCJenisBarangService.requestFocus();
                }
                if (GlobalVar.Var.editService != null) {
                    GlobalVar.Var.editService.JCJenisBarangService.load("SELECT '-- Pilih Jenis Barang Service --' AS `JenisBarangService` UNION SELECT `JenisBarangService` FROM `tbmjenisbarangservice`");
                    GlobalVar.Var.editService.JCJenisBarangService.setSelectedItem(JTJenisBarangService.getText());
                    GlobalVar.Var.editService.JCJenisBarangService.requestFocus();
                }
                if (tutup) {
                    GlobalVar.Var.tambahMasterJenisBarangService.dispose();
                } else {
                    clearText();
                    JTJenisBarangService.requestFocus();
                }
            }
        }
    }

    void clearText() {
        JTJenisBarangService.setText("");
        JTKeterangan.setText("");
    }

    void loadData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Menampilkan Data Master Jenis Barang Service");
        dRunSelctOne.setQuery("SELECT `IdJenisBarangService`, `JenisBarangService`, `Keterangan` FROM `tbmjenisbarangservice` WHERE `IdJenisBarangService`='" + idEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JTJenisBarangService.setText(list.get(1));
        JTKeterangan.setText(list.get(2));
    }

    void ubah() {
        if (checkInput()) {
            Update update = new LSubProces.Update();
            boolean ubah = update.Ubah("UPDATE `tbmjenisbarangservice` SET `JenisBarangService`='" + JTJenisBarangService.getText() + "', `Keterangan`='" + JTKeterangan.getText() + "' WHERE `IdJenisBarangService`=" + idEdit, "Ubah Data Master Jenis Barang Service", this);
            if (ubah) {
                GlobalVar.Var.editMasterJenisBarangService.dispose();
                GlobalVar.Var.listMasterJenisBarangService.load();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JlableF JLJenisBarangService;
    private KomponenGUI.JlableF JLJenisBarangService2;
    private KomponenGUI.JlableF JLKeterangan;
    private KomponenGUI.JlableF JLKeterangan2;
    private javax.swing.JScrollPane JSPKeterangan;
    private KomponenGUI.JtextF JTJenisBarangService;
    private KomponenGUI.JTextAreaF JTKeterangan;
    // End of variables declaration//GEN-END:variables
}
