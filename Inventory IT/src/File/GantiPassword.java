/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import LSubProces.DRunSelctOne;
import LSubProces.Update;
import static File.EncMD5.getMD5;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Martono
 */
public class GantiPassword extends javax.swing.JFrame {

    /**
     * Creates new form GantiPassword
     */
    public GantiPassword() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Ganti Password");
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

        JLUsername = new KomponenGUI.JlableF();
        JLUsername2 = new KomponenGUI.JlableF();
        JLUsername3 = new KomponenGUI.JlableF();
        JLPasswordLama = new KomponenGUI.JlableF();
        JLPasswordLama2 = new KomponenGUI.JlableF();
        JTPasswordLama = new KomponenGUI.JpasswordT();
        JLPasswordBaru = new KomponenGUI.JlableF();
        JLPasswordBaru2 = new KomponenGUI.JlableF();
        JTPasswordBaru = new KomponenGUI.JpasswordT();
        JLKonfirmasiPassword = new KomponenGUI.JlableF();
        JLKonfirmasiPassword2 = new KomponenGUI.JlableF();
        JTKonfirmasiPassword = new KomponenGUI.JpasswordT();
        JBGanti = new KomponenGUI.JbuttonF();
        JBBatal = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JLUsername.setText("Username");

        JLUsername2.setText(":");

        JLUsername3.setText(GlobalVar.VarL.username);

        JLPasswordLama.setText("Password Lama");

        JLPasswordLama2.setText(":");

        JTPasswordLama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTPasswordLamaKeyReleased(evt);
            }
        });

        JLPasswordBaru.setText("Password Baru");

        JLPasswordBaru2.setText(":");

        JTPasswordBaru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTPasswordBaruKeyReleased(evt);
            }
        });

        JLKonfirmasiPassword.setText("Konfirmasi Password");

        JLKonfirmasiPassword2.setText(":");

        JTKonfirmasiPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTKonfirmasiPasswordKeyReleased(evt);
            }
        });

        JBGanti.setText("Ganti");
        JBGanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGantiActionPerformed(evt);
            }
        });

        JBBatal.setText("Batal");
        JBBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLPasswordLama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLPasswordBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLKonfirmasiPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JLUsername2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLPasswordBaru2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLKonfirmasiPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JLPasswordLama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBGanti, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTPasswordLama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTPasswordBaru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTKonfirmasiPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLUsername3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLUsername3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLUsername2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLPasswordLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLPasswordLama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPasswordLama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLPasswordBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLPasswordBaru2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPasswordBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTKonfirmasiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLKonfirmasiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLKonfirmasiPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGanti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBGantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGantiActionPerformed
        ganti();
    }//GEN-LAST:event_JBGantiActionPerformed

    private void JTPasswordLamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPasswordLamaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTPasswordBaru.requestFocus();
        }
    }//GEN-LAST:event_JTPasswordLamaKeyReleased

    private void JTPasswordBaruKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPasswordBaruKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKonfirmasiPassword.requestFocus();
        }
    }//GEN-LAST:event_JTPasswordBaruKeyReleased

    private void JTKonfirmasiPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKonfirmasiPasswordKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ganti();
        }
    }//GEN-LAST:event_JTKonfirmasiPasswordKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        GlobalVar.Var.gantiPassword = null;
    }//GEN-LAST:event_formWindowClosing

    private void JBBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBatalActionPerformed
        GlobalVar.Var.gantiPassword.dispose();
        GlobalVar.Var.gantiPassword = null;
    }//GEN-LAST:event_JBBatalActionPerformed

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
            java.util.logging.Logger.getLogger(GantiPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GantiPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GantiPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GantiPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GantiPassword();
            }
        });
    }

    void ganti() {
        if (new String(JTKonfirmasiPassword.getPassword()).equals(new String(JTPasswordBaru.getPassword()))) {
            DRunSelctOne dRunSelctOne = new LSubProces.DRunSelctOne();
            dRunSelctOne.seterorm("Gagal Ganti Passsword");
            dRunSelctOne.setQuerynolimit("SELECT `Username`, `Password` FROM `tbuser` WHERE `Username`='" + GlobalVar.VarL.username + "' AND `Password`='" + getMD5(new String(JTPasswordLama.getPassword())) + "'");
            ArrayList<String> list = dRunSelctOne.excute();
            try {
                if (list.get(0) != null) {
                    Update update = new LSubProces.Update();
                    boolean ubah = update.Ubah("UPDATE `tbuser` SET `Password`='" + getMD5(new String(JTPasswordBaru.getPassword())) + "' WHERE `Username`='" + GlobalVar.VarL.username + "'", "Ganti Password", this);
                    if (ubah) {
                        GlobalVar.Var.gantiPassword.dispose();
                        GlobalVar.Var.gantiPassword = null;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal Ganti Passsword. Password Lama Salah !!!", "Error", JOptionPane.ERROR_MESSAGE);
                    JTPasswordLama.requestFocus();
                }
            } catch (Exception e) {
                Eror.LogEror.SaveEror(e);
                JOptionPane.showMessageDialog(this, "Gagal Ganti Password !!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Gagal Ganti Password. Konfirmasi Password Tidak Sama Dengan Password Baru !!!", "Error", JOptionPane.ERROR_MESSAGE);
            JTKonfirmasiPassword.requestFocus();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBBatal;
    private KomponenGUI.JbuttonF JBGanti;
    private KomponenGUI.JlableF JLKonfirmasiPassword;
    private KomponenGUI.JlableF JLKonfirmasiPassword2;
    private KomponenGUI.JlableF JLPasswordBaru;
    private KomponenGUI.JlableF JLPasswordBaru2;
    private KomponenGUI.JlableF JLPasswordLama;
    private KomponenGUI.JlableF JLPasswordLama2;
    private KomponenGUI.JlableF JLUsername;
    private KomponenGUI.JlableF JLUsername2;
    private KomponenGUI.JlableF JLUsername3;
    private KomponenGUI.JpasswordT JTKonfirmasiPassword;
    private KomponenGUI.JpasswordT JTPasswordBaru;
    private KomponenGUI.JpasswordT JTPasswordLama;
    // End of variables declaration//GEN-END:variables
}
