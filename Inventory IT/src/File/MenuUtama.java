/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

//import Laporan.*;
import List.*;
import Proses.*;

/**
 *
 * @author Martono
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Menu Utama");
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

        JMenuBar = new javax.swing.JMenuBar();
        JMFile = new javax.swing.JMenu();
        JMITambahUser = new javax.swing.JMenuItem();
        JMIResetPasswordUser = new javax.swing.JMenuItem();
        SFile = new javax.swing.JPopupMenu.Separator();
        JMIGantiPassword = new javax.swing.JMenuItem();
        JMIExit = new javax.swing.JMenuItem();
        JMMaster = new javax.swing.JMenu();
        JMIMasterJenisBarang = new javax.swing.JMenuItem();
        JMIMasterKategoriBarang = new javax.swing.JMenuItem();
        JMIMasterBarang = new javax.swing.JMenuItem();
        SMaster1 = new javax.swing.JPopupMenu.Separator();
        JMIMasterJenisService = new javax.swing.JMenuItem();
        JMIMasterJenisBarangService = new javax.swing.JMenuItem();
        JMIMasterBarangService = new javax.swing.JMenuItem();
        SMaster2 = new javax.swing.JPopupMenu.Separator();
        JMIMasterKaryawan = new javax.swing.JMenuItem();
        SMaster3 = new javax.swing.JPopupMenu.Separator();
        JMIMasterVendor = new javax.swing.JMenuItem();
        JMProses = new javax.swing.JMenu();
        JMIProsesPurchaseRequest = new javax.swing.JMenuItem();
        JMIProsesBarangMasuk = new javax.swing.JMenuItem();
        JMIProsesBarangKeluar = new javax.swing.JMenuItem();
        JMIProsesPenyesuaianStok = new javax.swing.JMenuItem();
        SProses1 = new javax.swing.JPopupMenu.Separator();
        JMIProsesService = new javax.swing.JMenuItem();
        SProses2 = new javax.swing.JPopupMenu.Separator();
        JMIProsesBarangRusak = new javax.swing.JMenuItem();
        JMList = new javax.swing.JMenu();
        JMIListPurchaseRequest = new javax.swing.JMenuItem();
        JMIListBarangMasuk = new javax.swing.JMenuItem();
        JMIListBarangKeluar = new javax.swing.JMenuItem();
        JMIListPenyesuaianStok = new javax.swing.JMenuItem();
        SList1 = new javax.swing.JPopupMenu.Separator();
        JMIListService = new javax.swing.JMenuItem();
        SList2 = new javax.swing.JPopupMenu.Separator();
        JMIListBarangRusak = new javax.swing.JMenuItem();
        JMLaporan = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JMFile.setText("File");

        if (!GlobalVar.VarL.level.equals("Administrator")) {
            JMITambahUser.setVisible(false);
        }
        JMITambahUser.setText("Tambah User");
        JMITambahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMITambahUserActionPerformed(evt);
            }
        });
        JMFile.add(JMITambahUser);

        if (!GlobalVar.VarL.level.equals("Administrator")) {
            JMIResetPasswordUser.setVisible(false);
            SFile.setVisible(false);
        }
        JMIResetPasswordUser.setText("Reset Password User");
        JMIResetPasswordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIResetPasswordUserActionPerformed(evt);
            }
        });
        JMFile.add(JMIResetPasswordUser);
        JMFile.add(SFile);

        JMIGantiPassword.setText("Ganti Password");
        JMIGantiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIGantiPasswordActionPerformed(evt);
            }
        });
        JMFile.add(JMIGantiPassword);

        JMIExit.setText("Exit");
        JMIExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIExitActionPerformed(evt);
            }
        });
        JMFile.add(JMIExit);

        JMenuBar.add(JMFile);

        JMMaster.setText("Master");

        JMIMasterJenisBarang.setText("Jenis Barang");
        JMIMasterJenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterJenisBarangActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterJenisBarang);

        JMIMasterKategoriBarang.setText("Kategori Barang");
        JMIMasterKategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterKategoriBarangActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterKategoriBarang);

        JMIMasterBarang.setText("Barang");
        JMIMasterBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterBarangActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterBarang);
        JMMaster.add(SMaster1);

        JMIMasterJenisService.setText("Jenis Service");
        JMIMasterJenisService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterJenisServiceActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterJenisService);

        JMIMasterJenisBarangService.setText("Jenis Barang Service");
        JMIMasterJenisBarangService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterJenisBarangServiceActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterJenisBarangService);

        JMIMasterBarangService.setText("Barang Service");
        JMIMasterBarangService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterBarangServiceActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterBarangService);
        JMMaster.add(SMaster2);

        JMIMasterKaryawan.setText("Karyawan (Pemakai)");
        JMIMasterKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterKaryawanActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterKaryawan);
        JMMaster.add(SMaster3);

        JMIMasterVendor.setText("Vendor");
        JMIMasterVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIMasterVendorActionPerformed(evt);
            }
        });
        JMMaster.add(JMIMasterVendor);

        JMenuBar.add(JMMaster);

        JMProses.setText("Proses");

        JMIProsesPurchaseRequest.setText("Purchase Request ");
        JMIProsesPurchaseRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPurchaseRequestActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPurchaseRequest);

        JMIProsesBarangMasuk.setText("Barang Masuk");
        JMProses.add(JMIProsesBarangMasuk);

        JMIProsesBarangKeluar.setText("Barang Keluar");
        JMProses.add(JMIProsesBarangKeluar);

        JMIProsesPenyesuaianStok.setText("Penyesuaian Stok");
        JMIProsesPenyesuaianStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesPenyesuaianStokActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesPenyesuaianStok);
        JMProses.add(SProses1);

        JMIProsesService.setText("Service");
        JMIProsesService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesServiceActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesService);
        JMProses.add(SProses2);

        JMIProsesBarangRusak.setText("Barang Rusak");
        JMIProsesBarangRusak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProsesBarangRusakActionPerformed(evt);
            }
        });
        JMProses.add(JMIProsesBarangRusak);

        JMenuBar.add(JMProses);

        JMList.setText("List");

        JMIListPurchaseRequest.setText("Purchase Request");
        JMIListPurchaseRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPurchaseRequestActionPerformed(evt);
            }
        });
        JMList.add(JMIListPurchaseRequest);

        JMIListBarangMasuk.setText("Barang Masuk");
        JMList.add(JMIListBarangMasuk);

        JMIListBarangKeluar.setText("Barang Keluar");
        JMList.add(JMIListBarangKeluar);

        JMIListPenyesuaianStok.setText("Penyesuaian Stok");
        JMIListPenyesuaianStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPenyesuaianStokActionPerformed(evt);
            }
        });
        JMList.add(JMIListPenyesuaianStok);
        JMList.add(SList1);

        JMIListService.setText("Service");
        JMIListService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListServiceActionPerformed(evt);
            }
        });
        JMList.add(JMIListService);
        JMList.add(SList2);

        JMIListBarangRusak.setText("Barang Rusak");
        JMIListBarangRusak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListBarangRusakActionPerformed(evt);
            }
        });
        JMList.add(JMIListBarangRusak);

        JMenuBar.add(JMList);

        JMLaporan.setText("Laporan");
        JMenuBar.add(JMLaporan);

        setJMenuBar(JMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMITambahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMITambahUserActionPerformed
        if (GlobalVar.Var.tambahUser == null) {
            GlobalVar.Var.tambahUser = new TambahUser();
        } else {
            GlobalVar.Var.tambahUser.setState(NORMAL);
            GlobalVar.Var.tambahUser.toFront();
        }
    }//GEN-LAST:event_JMITambahUserActionPerformed

    private void JMIGantiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIGantiPasswordActionPerformed
        if (GlobalVar.Var.gantiPassword == null) {
            GlobalVar.Var.gantiPassword = new GantiPassword();
        } else {
            GlobalVar.Var.gantiPassword.setState(NORMAL);
            GlobalVar.Var.gantiPassword.toFront();
        }
    }//GEN-LAST:event_JMIGantiPasswordActionPerformed

    private void JMIExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JMIExitActionPerformed

    private void JMIResetPasswordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIResetPasswordUserActionPerformed
        if (GlobalVar.Var.resetPasswordUser == null) {
            GlobalVar.Var.resetPasswordUser = new ResetPasswordUser();
        } else {
            GlobalVar.Var.resetPasswordUser.setState(NORMAL);
            GlobalVar.Var.resetPasswordUser.toFront();
        }
    }//GEN-LAST:event_JMIResetPasswordUserActionPerformed

    private void JMIMasterVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterVendorActionPerformed
        if (GlobalVar.Var.listMasterVendor == null) {
            GlobalVar.Var.listMasterVendor = new ListMasterVendor();
        } else {
            GlobalVar.Var.listMasterVendor.setState(NORMAL);
            GlobalVar.Var.listMasterVendor.toFront();
        }
    }//GEN-LAST:event_JMIMasterVendorActionPerformed

    private void JMIMasterKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterKaryawanActionPerformed
        if (GlobalVar.Var.listMasterKaryawan == null) {
            GlobalVar.Var.listMasterKaryawan = new ListMasterKaryawan();
        } else {
            GlobalVar.Var.listMasterKaryawan.setState(NORMAL);
            GlobalVar.Var.listMasterKaryawan.toFront();
        }
    }//GEN-LAST:event_JMIMasterKaryawanActionPerformed

    private void JMIMasterJenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterJenisBarangActionPerformed
        if (GlobalVar.Var.listMasterJenisBarang == null) {
            GlobalVar.Var.listMasterJenisBarang = new ListMasterJenisBarang();
        } else {
            GlobalVar.Var.listMasterJenisBarang.setState(NORMAL);
            GlobalVar.Var.listMasterJenisBarang.toFront();
        }
    }//GEN-LAST:event_JMIMasterJenisBarangActionPerformed

    private void JMIMasterKategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterKategoriBarangActionPerformed
        if (GlobalVar.Var.listMasterKategoriBarang == null) {
            GlobalVar.Var.listMasterKategoriBarang = new ListMasterKategoriBarang();
        } else {
            GlobalVar.Var.listMasterKategoriBarang.setState(NORMAL);
            GlobalVar.Var.listMasterKategoriBarang.toFront();
        }
    }//GEN-LAST:event_JMIMasterKategoriBarangActionPerformed

    private void JMIMasterBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterBarangActionPerformed
        if (GlobalVar.Var.listMasterBarang == null) {
            GlobalVar.Var.listMasterBarang = new ListMasterBarang();
        } else {
            GlobalVar.Var.listMasterBarang.setState(NORMAL);
            GlobalVar.Var.listMasterBarang.toFront();
        }
    }//GEN-LAST:event_JMIMasterBarangActionPerformed

    private void JMIMasterJenisServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterJenisServiceActionPerformed
        if (GlobalVar.Var.listMasterJenisService == null) {
            GlobalVar.Var.listMasterJenisService = new ListMasterJenisService();
        } else {
            GlobalVar.Var.listMasterJenisService.setState(NORMAL);
            GlobalVar.Var.listMasterJenisService.toFront();
        }
    }//GEN-LAST:event_JMIMasterJenisServiceActionPerformed

    private void JMIMasterJenisBarangServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterJenisBarangServiceActionPerformed
        if (GlobalVar.Var.listMasterJenisBarangService == null) {
            GlobalVar.Var.listMasterJenisBarangService = new ListMasterJenisBarangService();
        } else {
            GlobalVar.Var.listMasterJenisBarangService.setState(NORMAL);
            GlobalVar.Var.listMasterJenisBarangService.toFront();
        }
    }//GEN-LAST:event_JMIMasterJenisBarangServiceActionPerformed

    private void JMIMasterBarangServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIMasterBarangServiceActionPerformed
        if (GlobalVar.Var.listMasterBarangService == null) {
            GlobalVar.Var.listMasterBarangService = new ListMasterBarangService();
        } else {
            GlobalVar.Var.listMasterBarangService.setState(NORMAL);
            GlobalVar.Var.listMasterBarangService.toFront();
        }
    }//GEN-LAST:event_JMIMasterBarangServiceActionPerformed

    private void JMIListBarangRusakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListBarangRusakActionPerformed
        if (GlobalVar.Var.listBarangRusak == null) {
            GlobalVar.Var.listBarangRusak = new ListBarangRusak();
        } else {
            GlobalVar.Var.listBarangRusak.setState(NORMAL);
            GlobalVar.Var.listBarangRusak.toFront();
        }
    }//GEN-LAST:event_JMIListBarangRusakActionPerformed

    private void JMIProsesBarangRusakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesBarangRusakActionPerformed
        if (GlobalVar.Var.tambahBarangRusak == null) {
            GlobalVar.Var.tambahBarangRusak = new BarangRusak("0");
        } else {
            GlobalVar.Var.tambahBarangRusak.setState(NORMAL);
            GlobalVar.Var.tambahBarangRusak.toFront();
        }
    }//GEN-LAST:event_JMIProsesBarangRusakActionPerformed

    private void JMIListServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListServiceActionPerformed
        if (GlobalVar.Var.listService == null) {
            GlobalVar.Var.listService = new ListService();
        } else {
            GlobalVar.Var.listService.setState(NORMAL);
            GlobalVar.Var.listService.toFront();
        }
    }//GEN-LAST:event_JMIListServiceActionPerformed

    private void JMIProsesServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesServiceActionPerformed
        if (GlobalVar.Var.tambahService == null) {
            GlobalVar.Var.tambahService = new Service("0");
        } else {
            GlobalVar.Var.tambahService.setState(NORMAL);
            GlobalVar.Var.tambahService.toFront();
        }
    }//GEN-LAST:event_JMIProsesServiceActionPerformed

    private void JMIListPenyesuaianStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPenyesuaianStokActionPerformed
        if (GlobalVar.Var.listPenyesuaianStok == null) {
            GlobalVar.Var.listPenyesuaianStok = new ListPenyesuaianStok();
        } else {
            GlobalVar.Var.listPenyesuaianStok.setState(NORMAL);
            GlobalVar.Var.listPenyesuaianStok.toFront();
        }
    }//GEN-LAST:event_JMIListPenyesuaianStokActionPerformed

    private void JMIProsesPenyesuaianStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPenyesuaianStokActionPerformed
        if (GlobalVar.Var.tambahPenyesuaianStok == null) {
            GlobalVar.Var.tambahPenyesuaianStok = new PenyesuaianStok();
        } else {
            GlobalVar.Var.tambahPenyesuaianStok.setState(NORMAL);
            GlobalVar.Var.tambahPenyesuaianStok.toFront();
        }
    }//GEN-LAST:event_JMIProsesPenyesuaianStokActionPerformed

    private void JMIProsesPurchaseRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProsesPurchaseRequestActionPerformed
        if (GlobalVar.Var.tambahPurchaseRequest == null) {
            GlobalVar.Var.tambahPurchaseRequest = new PurchaseRequest("0");
        } else {
            GlobalVar.Var.tambahPurchaseRequest.setState(NORMAL);
            GlobalVar.Var.tambahPurchaseRequest.toFront();
        }
    }//GEN-LAST:event_JMIProsesPurchaseRequestActionPerformed

    private void JMIListPurchaseRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPurchaseRequestActionPerformed
        if (GlobalVar.Var.listPurchaseRequest == null) {
            GlobalVar.Var.listPurchaseRequest = new ListPurchaseRequest();
        } else {
            GlobalVar.Var.listPurchaseRequest.setState(NORMAL);
            GlobalVar.Var.listPurchaseRequest.toFront();
        }
    }//GEN-LAST:event_JMIListPurchaseRequestActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMFile;
    private javax.swing.JMenuItem JMIExit;
    private javax.swing.JMenuItem JMIGantiPassword;
    private javax.swing.JMenuItem JMIListBarangKeluar;
    private javax.swing.JMenuItem JMIListBarangMasuk;
    private javax.swing.JMenuItem JMIListBarangRusak;
    private javax.swing.JMenuItem JMIListPenyesuaianStok;
    private javax.swing.JMenuItem JMIListPurchaseRequest;
    private javax.swing.JMenuItem JMIListService;
    private javax.swing.JMenuItem JMIMasterBarang;
    private javax.swing.JMenuItem JMIMasterBarangService;
    private javax.swing.JMenuItem JMIMasterJenisBarang;
    private javax.swing.JMenuItem JMIMasterJenisBarangService;
    private javax.swing.JMenuItem JMIMasterJenisService;
    private javax.swing.JMenuItem JMIMasterKaryawan;
    private javax.swing.JMenuItem JMIMasterKategoriBarang;
    private javax.swing.JMenuItem JMIMasterVendor;
    private javax.swing.JMenuItem JMIProsesBarangKeluar;
    private javax.swing.JMenuItem JMIProsesBarangMasuk;
    private javax.swing.JMenuItem JMIProsesBarangRusak;
    private javax.swing.JMenuItem JMIProsesPenyesuaianStok;
    private javax.swing.JMenuItem JMIProsesPurchaseRequest;
    private javax.swing.JMenuItem JMIProsesService;
    private javax.swing.JMenuItem JMIResetPasswordUser;
    private javax.swing.JMenuItem JMITambahUser;
    private javax.swing.JMenu JMLaporan;
    private javax.swing.JMenu JMList;
    private javax.swing.JMenu JMMaster;
    private javax.swing.JMenu JMProses;
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JPopupMenu.Separator SFile;
    private javax.swing.JPopupMenu.Separator SList1;
    private javax.swing.JPopupMenu.Separator SList2;
    private javax.swing.JPopupMenu.Separator SMaster1;
    private javax.swing.JPopupMenu.Separator SMaster2;
    private javax.swing.JPopupMenu.Separator SMaster3;
    private javax.swing.JPopupMenu.Separator SProses1;
    private javax.swing.JPopupMenu.Separator SProses2;
    // End of variables declaration//GEN-END:variables
}
