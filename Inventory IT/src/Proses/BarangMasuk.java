package Proses;

import static KomponenGUI.FDateF.datetostr;
import KomponenGUI.FDateF;
import LSubProces.MultiInsert;
import LSubProces.DRunSelctOne;
import LSubProces.RunSelct;
import Master.MasterBarang;
import Master.MasterVendor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author riki
 */
public class BarangMasuk extends javax.swing.JFrame {

    KomponenGUI.JtextF[] arrayBarang;
    String idEdit;

    /**
     * Creates new form BarangMasuk
     */
    public BarangMasuk(Object id) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        idEdit = id.toString();
        arrayBarang = new KomponenGUI.JtextF[]{JTJenisBarang, JTKategoriBarang, JTNamaBarang};
        if (idEdit.equals("0")) {
            setTitle("Tambah Barang Masuk");
            setNomorBarangMasuk();
            JBUbah.setVisible(false);
        } else {
            setTitle("Ubah Barang Masuk");
            loadData();
            JBTambah.setVisible(false);
            JBTambahTutup.setVisible(false);
        }
        setVisible(true);
    }

    boolean checkInput() {
        if (JTNomorBarangMasuk.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor Barang Masuk Tidak Boleh Kosong");
            return false;
        } else if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Purchase Request Tidak Boleh Kosong");
            return false;
        } else if (JTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Detail Permintaan Tidak Boleh Kosong");
            return false;
        } else {
            return checkSerialNumber();
        }
    }

    boolean checkUbah() {
        if (JTNomorBarangMasuk.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor Barang Masuk Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    boolean checkTable() {
        if (JTNamaBarang.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Barang Tidak Boleh Kosong");
            JTNamaBarang.requestFocus();
            return false;
        } else if (JTHargaBarang.getInt() == 0) {
            JOptionPane.showMessageDialog(this, "Harga Tidak Boleh Kosong");
            JTHargaBarang.requestFocus();
            return false;
        } else if (JTJumlahBarang.getInt() == 0) {
            JOptionPane.showMessageDialog(this, "Jumlah Tidak Boleh Kosong");
            JTJumlahBarang.requestFocus();
            return false;
        } else if (JTable.getRowCount() >= 12) {
            JOptionPane.showMessageDialog(this, "Jenis Barang Yang Diinput Tidak Bisa Lebih Dari 12");
            return false;
        } else if (cekdoubleitem(JTNamaBarang.getText(), 3, JTKategoriBarang.getText(), 2, JTJenisBarang.getText(), 1)) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Input Barang Yang Sama");
            JTNamaBarang.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean checkTableUbah() {
        if (JTNamaBarang.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Barang Tidak Boleh Kosong");
            return false;
        } else if (JTHargaBarang.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harga Barang Tidak Boleh Kosong");
            return false;
        } else if (JTJumlahBarang.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Barang Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    void loadData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Panggil Data Edit");
        dRunSelctOne.setQuery("SELECT `IdBarangMasuk`, `NomorBarangMasuk`, `TanggalBarangMasuk`, `NomorPurchaseRequest`, `NamaVendor`, `UrlPurchaseRequest`, `UrlNotaBarangMasuk`, a.`Keterangan` FROM `tbbarangmasuk`a JOIN `tbmvendor`b ON a.`IdVendor`=b.`IdVendor` WHERE `IdBarangMasuk` = '" + idEdit + "' ");
        ArrayList<String> list = dRunSelctOne.excute();
        JTNomorBarangMasuk.setText(list.get(1));
        JDTanggal.setDate(FDateF.strtodate(list.get(2), "yyyy-MM-dd"));
        JCNomorPurchaseRequest.setSelectedItem(list.get(3));
        JCVendor.setSelectedItem(list.get(4));
        JTUrlBuktiPurchaseRequest.setText(list.get(5));
        JTUrlBuktiNota.setText(list.get(6));
        JTAKeterangan.setText(list.get(7));
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NomorKolom`, `JenisBarang`, `KategoriBarang`, `NamaBarang`, FORMAT(`HargaBarang`,0), FORMAT(`JumlahBarang`,0), `Garansi`, `SerialNumber`, a.`Keterangan` FROM `tbbarangmasukdetail`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` JOIN `tbmkategoribarang`c ON b.`IdKategoriBarang`=c.`IdKategoriBarang` JOIN `tbmjenisbarang`d ON c.`IdJenisBarang`=d.`IdJenisBarang` WHERE `NomorBarangMasuk` = '" + list.get(1) + "'");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", "", "", ""});
                JTable.setValueAt(rs.getString(1), row, 0);
                JTable.setValueAt(rs.getString(2), row, 1);
                JTable.setValueAt(rs.getString(3), row, 2);
                JTable.setValueAt(rs.getString(4), row, 3);
                JTable.setValueAt(rs.getString(5).replace(",", "."), row, 4);
                JTable.setValueAt(rs.getString(6).replace(",", "."), row, 5);
                JTable.setValueAt(rs.getString(7), row, 6);
                JTable.setValueAt(rs.getString(8), row, 7);
                JTable.setValueAt(rs.getString(9), row, 8);
                row++;
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Edit Detail");
        } finally {
            runSelct.closecon();
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        JTNomorBarangMasuk = new KomponenGUI.JtextF();
        jlableF1 = new KomponenGUI.JlableF();
        jlableF2 = new KomponenGUI.JlableF();
        JCVendor = new KomponenGUI.JcomboboxF();
        JTNamaBarang = new KomponenGUI.JtextF();
        jtextF7 = new KomponenGUI.JtextF();
        jtextF8 = new KomponenGUI.JtextF();
        jtextF9 = new KomponenGUI.JtextF();
        jtextF10 = new KomponenGUI.JtextF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        jlableF4 = new KomponenGUI.JlableF();
        jlableF5 = new KomponenGUI.JlableF();
        JBTambah = new KomponenGUI.JbuttonF();
        JBTambahTutup = new KomponenGUI.JbuttonF();
        JBUbahDetail = new KomponenGUI.JbuttonF();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        jtextF12 = new KomponenGUI.JtextF();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF6 = new KomponenGUI.JlableF();
        JBUbah = new KomponenGUI.JbuttonF();
        JBKembali = new KomponenGUI.JbuttonF();
        JBSearchNamaBarang = new KomponenGUI.JbuttonF();
        JBRefreshDetail = new KomponenGUI.JbuttonF();
        jlableF8 = new KomponenGUI.JlableF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF11 = new KomponenGUI.JlableF();
        jlableF12 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF13 = new KomponenGUI.JlableF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jbuttonF6 = new KomponenGUI.JbuttonF();
        JTKategoriBarang = new KomponenGUI.JtextF();
        jtextF13 = new KomponenGUI.JtextF();
        JTJenisBarang = new KomponenGUI.JtextF();
        jtextF11 = new KomponenGUI.JtextF();
        JTKeterangan = new KomponenGUI.JtextF();
        JTSerialNumber = new KomponenGUI.JtextF();
        JTJumlahBarang = new KomponenGUI.JRibuanTextField();
        JCNomorPurchaseRequest = new KomponenGUI.JcomboboxF();
        jbuttonF5 = new KomponenGUI.JbuttonF();
        jtextF14 = new KomponenGUI.JtextF();
        JTHargaBarang = new KomponenGUI.JRibuanTextField();
        HapusTable = new KomponenGUI.JbuttonF();
        jlableF3 = new KomponenGUI.JlableF();
        JTUrlBuktiPurchaseRequest = new KomponenGUI.JtextF();
        JBPilihUrlBuktiPurchaseRequest = new KomponenGUI.JbuttonF();
        JBPilihUrlBuktiPurchaseRequest1 = new KomponenGUI.JbuttonF();
        JBPilihUrlBuktiNota1 = new KomponenGUI.JbuttonF();
        JBPilihUrlBuktiNota = new KomponenGUI.JbuttonF();
        JTUrlBuktiNota = new KomponenGUI.JtextF();
        jlableF7 = new KomponenGUI.JlableF();
        jlableF15 = new KomponenGUI.JlableF();
        jlableF14 = new KomponenGUI.JlableF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JTNomorBarangMasuk.setEnabled(false);

        jlableF1.setText("No. Barang Masuk");

        jlableF2.setText("No. PR");

        JCVendor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Nama Vendor --" }));
        JCVendor.load("SELECT '-- Pilih Nama Vendor --' AS 'NamaVendor' UNION SELECT `NamaVendor` FROM `tbmvendor` ");
        JCVendor.setNextFocusableComponent(JTNamaBarang);
        JCVendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCVendorKeyPressed(evt);
            }
        });

        JTNamaBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTNamaBarang.setNextFocusableComponent(JTSerialNumber);
        JTNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTNamaBarangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTNamaBarangKeyReleased(evt);
            }
        });

        jtextF7.setText("Nama Barang");
        jtextF7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF7.setEnabled(false);

        jtextF8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtextF8.setText("Jumlah");
        jtextF8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF8.setEnabled(false);

        jtextF9.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtextF9.setText("Serial Number");
        jtextF9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF9.setEnabled(false);

        jtextF10.setText("Keterangan");
        jtextF10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF10.setEnabled(false);

        new JScrollPane(JTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTable.getTableHeader().setReorderingAllowed(false);
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Jenis Barang", "Kategori Barang", "Nama Barang", "Harga", "Jumlah", "Garansi", "Serial Number", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.getTableHeader().setReorderingAllowed(false);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setMinWidth(60);
            JTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            JTable.getColumnModel().getColumn(0).setMaxWidth(60);
            JTable.getColumnModel().getColumn(1).setMinWidth(120);
            JTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            JTable.getColumnModel().getColumn(1).setMaxWidth(120);
            JTable.getColumnModel().getColumn(2).setMinWidth(140);
            JTable.getColumnModel().getColumn(2).setPreferredWidth(140);
            JTable.getColumnModel().getColumn(2).setMaxWidth(140);
            JTable.getColumnModel().getColumn(3).setMinWidth(400);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(400);
            JTable.getColumnModel().getColumn(3).setMaxWidth(400);
            JTable.getColumnModel().getColumn(4).setMinWidth(100);
            JTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(4).setMaxWidth(100);
            JTable.getColumnModel().getColumn(5).setMinWidth(70);
            JTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            JTable.getColumnModel().getColumn(5).setMaxWidth(70);
            JTable.getColumnModel().getColumn(6).setMinWidth(50);
            JTable.getColumnModel().getColumn(6).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(6).setMaxWidth(50);
            JTable.getColumnModel().getColumn(7).setMinWidth(140);
            JTable.getColumnModel().getColumn(7).setPreferredWidth(140);
            JTable.getColumnModel().getColumn(7).setMaxWidth(140);
            JTable.getColumnModel().getColumn(8).setMinWidth(200);
            JTable.getColumnModel().getColumn(8).setPreferredWidth(200);
            JTable.getColumnModel().getColumn(8).setMaxWidth(200);
        }
        JTable.setrender(4, "Number");
        JTable.setrender(5, "Number");

        jlableF4.setText("USER :");

        jlableF5.setText(GlobalVar.VarL.username);

        JBTambah.setText("Simpan");
        JBTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahActionPerformed(evt);
            }
        });

        JBTambahTutup.setText("Simpan & Tutup");
        JBTambahTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahTutupActionPerformed(evt);
            }
        });

        JBUbahDetail.setText("Ubah");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), JBUbahDetail, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        JBUbahDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahDetailActionPerformed(evt);
            }
        });

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        jScrollPane2.setViewportView(JTAKeterangan);

        jtextF12.setText("Kategori Barang");
        jtextF12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF12.setEnabled(false);

        JDTanggal.setDate(new Date());

        jlableF6.setText("Tanggal Masuk");

        JBUbah.setText("Ubah");
        JBUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahActionPerformed(evt);
            }
        });

        JBKembali.setText("Kembali");
        JBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKembaliActionPerformed(evt);
            }
        });

        JBSearchNamaBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Search.png"))); // NOI18N
        JBSearchNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchNamaBarangActionPerformed(evt);
            }
        });

        JBRefreshDetail.setText("Refresh");
        JBRefreshDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRefreshDetailActionPerformed(evt);
            }
        });

        jlableF8.setText("BARANG MASUK");
        jlableF8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jlableF9.setText(":");

        jlableF11.setText("Vendor");

        jlableF12.setText(":");

        jlableF10.setText(":");

        jlableF13.setText(":");

        jbuttonF4.setText("+");
        jbuttonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF4ActionPerformed(evt);
            }
        });

        jbuttonF6.setText("+");
        jbuttonF6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF6ActionPerformed(evt);
            }
        });

        JTKategoriBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTKategoriBarang.setEnabled(false);
        JTKategoriBarang.setNextFocusableComponent(JTSerialNumber);

        jtextF13.setText("Jenis Barang");
        jtextF13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF13.setEnabled(false);

        JTJenisBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTJenisBarang.setEnabled(false);
        JTJenisBarang.setNextFocusableComponent(JTSerialNumber);

        jtextF11.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtextF11.setText("Keterangan");
        jtextF11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF11.setEnabled(false);

        JTKeterangan.setMaxText(250);
        JTKeterangan.setForeground(new java.awt.Color(102, 102, 102));
        JTKeterangan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTKeterangan.setNextFocusableComponent(JTSerialNumber);
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyPressed(evt);
            }
        });

        JTSerialNumber.setMaxText(50);
        JTSerialNumber.setForeground(new java.awt.Color(102, 102, 102));
        JTSerialNumber.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTSerialNumber.setNextFocusableComponent(JTSerialNumber);
        JTSerialNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTSerialNumberActionPerformed(evt);
            }
        });
        JTSerialNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTSerialNumberKeyPressed(evt);
            }
        });

        JCNomorPurchaseRequest.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih No Purchase Request --" }));
        JCNomorPurchaseRequest.load("SELECT '-- Pilih No Purchase Request --' AS 'NomorPurchaseRequest' UNION SELECT `NomorPurchaseRequest` FROM (SELECT X.`NomorPurchaseRequest`, SUM(`JumlahBarang`) as 'JumlahX', IFNULL(Y.`Jumlah`,0) as 'JumlahY' FROM `tbpurchaserequestdetail` as X LEFT JOIN (SELECT b.`NomorPurchaseRequest`, SUM(`JumlahBarang`) as 'Jumlah' FROM `tbbarangmasukdetail`a JOIN `tbbarangmasuk`b ON a.`NomorBarangMasuk`=b.`NomorBarangMasuk` WHERE 1 GROUP BY b.`NomorPurchaseRequest`) as Y ON X.`NomorPurchaserequest`=Y.`NomorPurchaseRequest` WHERE 1 GROUP BY `NomorPurchaseRequest` ) t1 WHERE `JumlahX`!=`JumlahY` ");
        JCNomorPurchaseRequest.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCNomorPurchaseRequestItemStateChanged(evt);
            }
        });

        jbuttonF5.setText("+");
        jbuttonF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF5ActionPerformed(evt);
            }
        });

        jtextF14.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtextF14.setText("Harga");
        jtextF14.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF14.setEnabled(false);

        HapusTable.setText("Hapus");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), HapusTable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        HapusTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusTableActionPerformed(evt);
            }
        });

        jlableF3.setText("Upload Bukti PR");

        JTUrlBuktiPurchaseRequest.setEnabled(false);

        JBPilihUrlBuktiPurchaseRequest.setText("Pilih");
        JBPilihUrlBuktiPurchaseRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPilihUrlBuktiPurchaseRequestActionPerformed(evt);
            }
        });

        JBPilihUrlBuktiPurchaseRequest1.setText("Tampilkan");
        JBPilihUrlBuktiPurchaseRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPilihUrlBuktiPurchaseRequest1ActionPerformed(evt);
            }
        });

        JBPilihUrlBuktiNota1.setText("Tampilkan");
        JBPilihUrlBuktiNota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPilihUrlBuktiNota1ActionPerformed(evt);
            }
        });

        JBPilihUrlBuktiNota.setText("Pilih");
        JBPilihUrlBuktiNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPilihUrlBuktiNotaActionPerformed(evt);
            }
        });

        JTUrlBuktiNota.setEnabled(false);

        jlableF7.setText("Upload Bukti Nota");

        jlableF15.setText(":");

        jlableF14.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jtextF10, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF13, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(JTJenisBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF12, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(JTKategoriBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF7, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                    .addComponent(JTNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JBSearchNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbuttonF6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF14, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(JTHargaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF8, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                    .addComponent(JTJumlahBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTSerialNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtextF11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBUbahDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBRefreshDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HapusTable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlableF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTUrlBuktiNota, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JBPilihUrlBuktiNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JBPilihUrlBuktiNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCNomorPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTUrlBuktiPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JBPilihUrlBuktiPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JBPilihUrlBuktiPurchaseRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JDTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(JTNomorBarangMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNomorBarangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNomorPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTUrlBuktiPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBPilihUrlBuktiPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBPilihUrlBuktiPurchaseRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTUrlBuktiNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBPilihUrlBuktiNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBPilihUrlBuktiNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtextF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtextF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextF14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBSearchNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBUbahDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HapusTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBRefreshDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtextF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlableF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTNamaBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            cariBarang(null);
        } else if (isAlphanumeric(String.valueOf(evt.getKeyChar()))) {
            cariBarang(JTNamaBarang.getText());
        }
    }//GEN-LAST:event_JTNamaBarangKeyReleased

    private void JBUbahDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahDetailActionPerformed
        ubahtable();
    }//GEN-LAST:event_JBUbahDetailActionPerformed

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        TambahData(false);
    }//GEN-LAST:event_JBTambahActionPerformed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        UbahData(false);
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JBTambahTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahTutupActionPerformed
        TambahData(true);
    }//GEN-LAST:event_JBTambahTutupActionPerformed

    private void JBSearchNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchNamaBarangActionPerformed
        cariBarang(null);
    }//GEN-LAST:event_JBSearchNamaBarangActionPerformed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        if (JTable.getSelectedRow() != -1) {
            JTJenisBarang.setText(JTable.getValueAt(JTable.getSelectedRow(), 1).toString());
            JTKategoriBarang.setText(JTable.getValueAt(JTable.getSelectedRow(), 2).toString());
            JTNamaBarang.setText(JTable.getValueAt(JTable.getSelectedRow(), 3).toString());
            JTHargaBarang.setText(JTable.getValueAt(JTable.getSelectedRow(), 4).toString().replace(".", ""));
            JTJumlahBarang.setText(JTable.getValueAt(JTable.getSelectedRow(), 5).toString().replace(".", ""));
            JTSerialNumber.setText(JTable.getValueAt(JTable.getSelectedRow(), 7).toString());
            JTKeterangan.setText(JTable.getValueAt(JTable.getSelectedRow(), 8).toString());
            if (isGaransi()) {
                JTJumlahBarang.setEnabled(false);
            } else {
                JTJumlahBarang.setEnabled(true);
            }
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        dispose();
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JBRefreshDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRefreshDetailActionPerformed
        RefreshTbl();
    }//GEN-LAST:event_JBRefreshDetailActionPerformed

    private void JCVendorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCVendorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_JCVendorKeyPressed

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        if (GlobalVar.Var.tambahMasterVendor == null) {
            GlobalVar.Var.tambahMasterVendor = new MasterVendor("0");
        } else {
            GlobalVar.Var.tambahMasterVendor.setState(NORMAL);
            GlobalVar.Var.tambahMasterVendor.toFront();
        }
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void jbuttonF6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF6ActionPerformed
        if (GlobalVar.Var.tambahMasterBarang == null) {
            GlobalVar.Var.tambahMasterBarang = new MasterBarang("0");
        } else {
            GlobalVar.Var.tambahMasterBarang.setState(NORMAL);
            GlobalVar.Var.tambahMasterBarang.toFront();
        }
    }//GEN-LAST:event_jbuttonF6ActionPerformed

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ubahtable();
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (idEdit.equals("0")) {
            GlobalVar.Var.tambahBarangMasuk = null;
        } else {
            GlobalVar.Var.editBarangMasuk = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void JTSerialNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTSerialNumberKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTSerialNumberKeyPressed

    private void JTSerialNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTSerialNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTSerialNumberActionPerformed

    private void JTNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JTNamaBarang.getText().replace(" ", "").isEmpty()) {
                cariBarang(null);
            } else {
                JTJumlahBarang.requestFocus();
            }
        }
    }//GEN-LAST:event_JTNamaBarangKeyPressed

    private void JCNomorPurchaseRequestItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCNomorPurchaseRequestItemStateChanged
        loadDataPurchaseRequest();
    }//GEN-LAST:event_JCNomorPurchaseRequestItemStateChanged

    private void jbuttonF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF5ActionPerformed
        if (GlobalVar.Var.tambahPurchaseRequest == null) {
            GlobalVar.Var.tambahPurchaseRequest = new PurchaseRequest("0");
        } else {
            GlobalVar.Var.tambahPurchaseRequest.setState(NORMAL);
            GlobalVar.Var.tambahPurchaseRequest.toFront();
        }
    }//GEN-LAST:event_jbuttonF5ActionPerformed

    private void HapusTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusTableActionPerformed
        hapusTable();
    }//GEN-LAST:event_HapusTableActionPerformed

    private void JBPilihUrlBuktiPurchaseRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPilihUrlBuktiPurchaseRequestActionPerformed
        JFileChooser fc = new JFileChooser();
        String FileType = "Doccument File (PDF)";
        String[] ExstensionFile = new String[]{"pdf"};
        FileNameExtensionFilter filter = new FileNameExtensionFilter(FileType, ExstensionFile);
        File file = null;
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);
        String FileL = "";
        if (returnVal == 0) {
            file = fc.getSelectedFile();
            FileL = file.getAbsolutePath();
            JTUrlBuktiPurchaseRequest.setText(FileL);
        }
    }//GEN-LAST:event_JBPilihUrlBuktiPurchaseRequestActionPerformed

    private void JBPilihUrlBuktiNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPilihUrlBuktiNotaActionPerformed
        JFileChooser fc = new JFileChooser();
        String FileType = "Doccument File (PDF)";
        String[] ExstensionFile = new String[]{"pdf"};
        FileNameExtensionFilter filter = new FileNameExtensionFilter(FileType, ExstensionFile);
        File file = null;
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);
        String FileL = "";
        if (returnVal == 0) {
            file = fc.getSelectedFile();
            FileL = file.getAbsolutePath();
            JTUrlBuktiNota.setText(FileL);
        }
    }//GEN-LAST:event_JBPilihUrlBuktiNotaActionPerformed

    private void JBPilihUrlBuktiPurchaseRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPilihUrlBuktiPurchaseRequest1ActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(JTUrlBuktiPurchaseRequest.getText());
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Eror: File tidak di temukan !!");
            }
        }
    }//GEN-LAST:event_JBPilihUrlBuktiPurchaseRequest1ActionPerformed

    private void JBPilihUrlBuktiNota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPilihUrlBuktiNota1ActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(JTUrlBuktiNota.getText());
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Eror: File tidak di temukan !!");
            }
        }
    }//GEN-LAST:event_JBPilihUrlBuktiNota1ActionPerformed

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
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangMasuk("0").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF HapusTable;
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBPilihUrlBuktiNota;
    private KomponenGUI.JbuttonF JBPilihUrlBuktiNota1;
    private KomponenGUI.JbuttonF JBPilihUrlBuktiPurchaseRequest;
    private KomponenGUI.JbuttonF JBPilihUrlBuktiPurchaseRequest1;
    private KomponenGUI.JbuttonF JBRefreshDetail;
    private KomponenGUI.JbuttonF JBSearchNamaBarang;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JbuttonF JBUbahDetail;
    private KomponenGUI.JcomboboxF JCNomorPurchaseRequest;
    public static KomponenGUI.JcomboboxF JCVendor;
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTHargaBarang;
    public static KomponenGUI.JtextF JTJenisBarang;
    private KomponenGUI.JRibuanTextField JTJumlahBarang;
    public static KomponenGUI.JtextF JTKategoriBarang;
    public static KomponenGUI.JtextF JTKeterangan;
    public static KomponenGUI.JtextF JTNamaBarang;
    private KomponenGUI.JtextF JTNomorBarangMasuk;
    public static KomponenGUI.JtextF JTSerialNumber;
    private KomponenGUI.JtextF JTUrlBuktiNota;
    private KomponenGUI.JtextF JTUrlBuktiPurchaseRequest;
    private KomponenGUI.JtableF JTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JbuttonF jbuttonF5;
    private KomponenGUI.JbuttonF jbuttonF6;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF11;
    private KomponenGUI.JlableF jlableF12;
    private KomponenGUI.JlableF jlableF13;
    private KomponenGUI.JlableF jlableF14;
    private KomponenGUI.JlableF jlableF15;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF7;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    private KomponenGUI.JtextF jtextF10;
    private KomponenGUI.JtextF jtextF11;
    private KomponenGUI.JtextF jtextF12;
    private KomponenGUI.JtextF jtextF13;
    private KomponenGUI.JtextF jtextF14;
    private KomponenGUI.JtextF jtextF7;
    private KomponenGUI.JtextF jtextF8;
    private KomponenGUI.JtextF jtextF9;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    void hapusTable() {
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Berhasil Hapus List");
            RefreshTbl();
            JTNamaBarang.requestFocus();
        }
    }

    boolean isGaransi() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal checkGaransi");
        dRunSelctOne.setQuery("SELECT `Garansi` FROM `tbmbarang`a JOIN `tbmkategoribarang`b ON a.`IdKategoriBarang`=b.`IdKategoriBarang` JOIN `tbmjenisbarang`c ON b.`IdJenisBarang`=c.`IdJenisBarang` WHERE `JenisBarang` = '" + JTable.getValueAt(JTable.getSelectedRow(), 1) + "' AND `KategoriBarang` = '" + JTable.getValueAt(JTable.getSelectedRow(), 2) + "' AND `NamaBarang` = '" + JTable.getValueAt(JTable.getSelectedRow(), 3) + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        return list.get(0).equals("Ya");
    }

    void loadDataPurchaseRequest() {
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.setRowCount(0);
        if (!JCNomorPurchaseRequest.getSelectedItem().equals("-- Pilih No Purchase Request --")) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal Panggil Data Edit");
            dRunSelctOne.setQuery("SELECT `IdPurchaseRequest` as 'ID', `NomorPurchaseRequest` as 'No. PR', `TanggalPurchaseRequest` as 'Tanggal', `NamaVendor`, a.`Keterangan` FROM `tbpurchaserequest`a JOIN `tbmvendor`b ON a.`IdVendor`=b.`IdVendor` WHERE `NomorPurchaseRequest` = '" + JCNomorPurchaseRequest.getSelectedItem() + "' ");
            ArrayList<String> list = dRunSelctOne.excute();
            //JDTanggal.setDate(FDateF.strtodate(list.get(2), "yyyy-MM-dd"));
            JCVendor.setSelectedItem(list.get(3));
            JTAKeterangan.setText(list.get(4));
            RunSelct runSelct = new RunSelct();
            runSelct.setQuery("SELECT x.`NomorKolom`, `JenisBarang`, `KategoriBarang`, `NamaBarang`, FORMAT(x.`HargaBarang`,0) 'Harga Barang', x.`JumlahBarang`-IFNULL(y.`Jumlah`,0) as 'Jumlah', `Garansi`, '' as 'SerialNumber', x.`Keterangan` FROM `tbpurchaserequestdetail` as x JOIN `tbmbarang`a ON x.`IdBarang`=a.`IdBarang` JOIN `tbmkategoribarang`b ON a.`IdKategoriBarang`=b.`IdKategoriBarang` JOIN `tbmjenisbarang`c ON b.`IdJenisBarang`=c.`IdJenisBarang` LEFT JOIN (SELECT `IdDetailBarangMasuk`, b.`NomorPurchaseRequest`, a.`NomorBarangMasuk`, `NomorKolom`, `IdBarang`, `HargaBarang`, IFNULL(SUM(`JumlahBarang`),0) as 'Jumlah', `SerialNumber`, a.`Keterangan` FROM `tbbarangmasukdetail`a JOIN `tbbarangmasuk`b ON a.`NomorBarangMasuk`=b.`NomorBarangmasuk` WHERE b.`NomorPurchaseRequest` = '" + list.get(1) + "' GROUP BY `IdBarang`) as y ON x.`IdBarang`=y.`IdBarang` WHERE x.`NomorPurchaseRequest` = '" + list.get(1) + "' AND x.`JumlahBarang` != IFNULL(y.`Jumlah`,0)");
            try {
                ResultSet rs = runSelct.excute();
                int row = 0;
                while (rs.next()) {
                    if (rs.getString(7).equals("Ya")) {
                        for (int i = 0; i < rs.getInt(6); i++) {
                            model.addRow(new Object[]{"", "", "", "", "", "", ""});
                            JTable.setValueAt(JTable.getRowCount(), row, 0);
                            JTable.setValueAt(rs.getString(2), row, 1);
                            JTable.setValueAt(rs.getString(3), row, 2);
                            JTable.setValueAt(rs.getString(4), row, 3);
                            JTable.setValueAt(rs.getString(5).replace(",", "."), row, 4);
                            JTable.setValueAt(1, row, 5);
                            JTable.setValueAt(rs.getString(7), row, 6);
                            JTable.setValueAt(rs.getString(8), row, 7);
                            JTable.setValueAt(rs.getString(9), row, 8);
                            row++;
                        }
                    } else {
                        model.addRow(new Object[]{"", "", "", "", "", "", ""});
                        JTable.setValueAt(JTable.getRowCount(), row, 0);
                        JTable.setValueAt(rs.getString(2), row, 1);
                        JTable.setValueAt(rs.getString(3), row, 2);
                        JTable.setValueAt(rs.getString(4), row, 3);
                        JTable.setValueAt(rs.getString(5).replace(",", "."), row, 4);
                        JTable.setValueAt(rs.getString(6), row, 5);
                        JTable.setValueAt(rs.getString(7), row, 6);
                        JTable.setValueAt(rs.getString(8), row, 7);
                        JTable.setValueAt(rs.getString(9), row, 8);
                        row++;
                    }
                }
            } catch (SQLException e) {
                out.println("E6" + e);
                showMessageDialog(null, "Gagal Panggil Data Edit Detail");
            } finally {
                runSelct.closecon();
            }
        }
    }

    void setNomorBarangMasuk() {
        NumberFormat nf = new DecimalFormat("0000");
        String nomorTransaksi = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NomorBarangMasuk` FROM `tbbarangmasuk` ORDER BY `NomorBarangMasuk` DESC LIMIT 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                nomorTransaksi = "0001/" + datetostr(new Date(), "YY") + "/BM";
            }
            while (rs.next()) {
                String lastNomorTransaksi = rs.getString("NomorBarangMasuk");
                String subNomorTransaksi = lastNomorTransaksi.substring(0, 4);
                int generatedNumber = parseInt(subNomorTransaksi) + 1;
                if (generatedNumber == 9999 || Integer.valueOf(lastNomorTransaksi.substring(5, 7)) < Integer.valueOf(datetostr(new Date(), "YY"))) {
                    generatedNumber = 1;
                }
                nomorTransaksi = nf.format(generatedNumber) + "/" + datetostr(new Date(), "YY") + "/BM";
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            JOptionPane.showMessageDialog(this, "Gagal Generate Nomor Barang Masuk", "Information", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            runSelct.closecon();
        }
        JTNomorBarangMasuk.setText(nomorTransaksi);
    }

    void cariBarang(String keywordCari) {
        if (GlobalVar.Var.jCari == null) {
            GlobalVar.Var.jCari = new JCari("SELECT `JenisBarang` AS 'Jenis Barang', `KategoriBarang` AS 'Kategori Barang', `NamaBarang` AS 'Nama Barang' FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `JenisBarang` ", "SELECT `JenisBarang` AS 'Jenis Barang', `KategoriBarang` AS 'Kategori Barang', `NamaBarang` AS 'Nama Barang' FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `KategoriBarang` ", "SELECT `JenisBarang` AS 'Jenis Barang', `KategoriBarang` AS 'Kategori Barang', `NamaBarang` AS 'Nama Barang' FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `NamaBarang` ", "Cari Barang", arrayBarang, keywordCari, JTHargaBarang, JTNamaBarang);
        } else {
            GlobalVar.Var.jCari.setState(NORMAL);
            GlobalVar.Var.jCari.toFront();
        }
    }

    void RefreshAll() {
        setNomorBarangMasuk();
        JTAKeterangan.setText("");
        JTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "No", "Jenis Barang", "Kategori Barang", "Nama Barang", "Harga", "Jumlah", "Garansi", "Serial Number", "Keterangan"
                }
        ));
        JTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        JTable.getColumnModel().getColumn(0).setMinWidth(60);
        JTable.getColumnModel().getColumn(0).setMaxWidth(60);
        JTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        JTable.getColumnModel().getColumn(1).setMinWidth(120);
        JTable.getColumnModel().getColumn(1).setMaxWidth(120);
        JTable.getColumnModel().getColumn(2).setPreferredWidth(140);
        JTable.getColumnModel().getColumn(2).setMinWidth(140);
        JTable.getColumnModel().getColumn(2).setMaxWidth(140);
        JTable.getColumnModel().getColumn(3).setPreferredWidth(400);
        JTable.getColumnModel().getColumn(3).setMinWidth(400);
        JTable.getColumnModel().getColumn(3).setMaxWidth(400);
        JTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        JTable.getColumnModel().getColumn(4).setMinWidth(120);
        JTable.getColumnModel().getColumn(4).setMaxWidth(120);
        JTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTable.getColumnModel().getColumn(5).setMinWidth(100);
        JTable.getColumnModel().getColumn(5).setMaxWidth(100);
        JTable.getColumnModel().getColumn(6).setPreferredWidth(50);
        JTable.getColumnModel().getColumn(6).setMinWidth(50);
        JTable.getColumnModel().getColumn(6).setMaxWidth(50);
        JTable.getColumnModel().getColumn(7).setPreferredWidth(250);
        JTable.getColumnModel().getColumn(7).setMinWidth(250);
        JTable.getColumnModel().getColumn(7).setMaxWidth(250);
        JTable.getColumnModel().getColumn(8).setPreferredWidth(200);
        JTable.getColumnModel().getColumn(8).setMinWidth(200);
        JTable.getColumnModel().getColumn(8).setMaxWidth(200);
        RefreshTbl();
    }

    void RefreshTbl() {
        JTable.clearSelection();
        JTJenisBarang.setText("");
        JTKategoriBarang.setText("");
        JTNamaBarang.setText("");
        JTKategoriBarang.setText("");
        JTHargaBarang.setText("0");
        JTJumlahBarang.setText("0");
        JTSerialNumber.setText("");
        JTKeterangan.setText("");
        JTJumlahBarang.setEnabled(true);
    }

    void TambahData(boolean tutup) {
        if (checkInput()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                if (Berhasil) {
                    Berhasil = multiInsert.Excute("INSERT INTO `tbbarangmasuk`(`NomorBarangMasuk`, `TanggalBarangMasuk`, `NomorPurchaseRequest`, `IdVendor`, `UrlPurchaseRequest`, `UrlNotaBarangMasuk`, `Keterangan`) VALUES ('" + JTNomorBarangMasuk.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "','" + JCNomorPurchaseRequest.getSelectedItem() + "',(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),'" + JTUrlBuktiPurchaseRequest.getText() + "','" + JTUrlBuktiNota.getText() + "','" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `tbbarangmasukdetail`(`NomorBarangMasuk`, `NomorKolom`, `IdBarang`, `HargaBarang`, `JumlahBarang`, `SerialNumber`, `Keterangan`) VALUES ('" + JTNomorBarangMasuk.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang`a JOIN `tbmkategoribarang`b ON a.`IdKategoriBarang`=b.`IdKategoriBarang` JOIN `tbmjenisbarang`c ON b.`IdJenisBarang`=c.`IdJenisBarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 3) + "' AND `KategoriBarang` = '" + JTable.getValueAt(i, 2) + "' AND `JenisBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 4).toString().replace(".", "") + "','" + JTable.getValueAt(i, 5).toString().replace(".", "") + "','" + JTable.getValueAt(i, 7) + "','" + JTable.getValueAt(i, 8) + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                //////System.out.println("Rollback");
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Barang Masuk");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Barang Masuk");
                multiInsert.Commit();
                multiInsert.closecon();
                RefreshAll();
                if (tutup) {
                    dispose();
                }
                setNomorBarangMasuk();
            }
        }
    }

    void UbahData(boolean print) {
        if (checkUbah()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                if (Berhasil) {
                    Berhasil = multiInsert.Excute("UPDATE `tbbarangmasuk` SET `NomorBarangMasuk`='" + JTNomorBarangMasuk.getText() + "',`TanggalBarangMasuk`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`NomorPurchaseRequest`='" + JCNomorPurchaseRequest.getSelectedItem() + "',`IdVendor`=(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),`UrlPurchaseRequest`='" + JTUrlBuktiPurchaseRequest.getText() + "',`UrlNotaBarangMasuk`='" + JTUrlBuktiNota.getText() + "',`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdBarangMasuk` = '" + idEdit + "'", null);
                    if (Berhasil) {
                        Berhasil = multiInsert.Excute("DELETE FROM `tbbarangmasukdetail` WHERE `NomorBarangMasuk` = '" + JTNomorBarangMasuk.getText() + "'", null);
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `tbbarangmasukdetail`(`NomorBarangMasuk`, `NomorKolom`, `IdBarang`, `HargaBarang`, `JumlahBarang`, `SerialNumber`, `Keterangan`) VALUES ('" + JTNomorBarangMasuk.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang`a JOIN `tbmkategoribarang`b ON a.`IdKategoriBarang`=b.`IdKategoriBarang` JOIN `tbmjenisbarang`c ON b.`IdJenisBarang`=c.`IdJenisBarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 3) + "' AND `KategoriBarang` = '" + JTable.getValueAt(i, 2) + "' AND `JenisBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 4).toString().replace(".", "") + "','" + JTable.getValueAt(i, 5).toString().replace(".", "") + "','" + JTable.getValueAt(i, 7) + "','" + JTable.getValueAt(i, 8) + "')", null);
                            }
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                JOptionPane.showMessageDialog(this, "Gagal Ubah Data Barang Masuk");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Barang Masuk");
                multiInsert.Commit();
                multiInsert.closecon();
                dispose();
                RefreshAll();
            }
        }
    }

    boolean isAlphanumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a) {
                return false;
            }
        }
        return true;
    }

    void ubahtable() {
        if (checkTableUbah()) {
            JTable.setValueAt(JTJenisBarang.getText(), JTable.getSelectedRow(), 1);
            JTable.setValueAt(JTKategoriBarang.getText(), JTable.getSelectedRow(), 2);
            JTable.setValueAt(JTNamaBarang.getText(), JTable.getSelectedRow(), 3);
            JTable.setValueAt(JTHargaBarang.getText(), JTable.getSelectedRow(), 4);
            JTable.setValueAt(JTJumlahBarang.getText(), JTable.getSelectedRow(), 5);
            JTable.setValueAt(JTSerialNumber.getText(), JTable.getSelectedRow(), 7);
            JTable.setValueAt(JTKeterangan.getText(), JTable.getSelectedRow(), 8);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Detail Permintaan");
            RefreshTbl();
            JTNamaBarang.requestFocus();
        }
    }

    boolean checkSerialNumber() {
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (JTable.getValueAt(i, 6).equals("Ya") && JTable.getValueAt(i, 7).toString().replace(" ", "").isEmpty()) {
                JOptionPane.showMessageDialog(this, "Serial Number Pada Detail Permintaan Nomor " + (i + 1) + " Tidak Boleh Kosong");
                return false;
            }
        }
        return true;
    }

    boolean cekdoubleitem(String item1, int row1, String item2, int row2, String item3, int row3) {
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (item1.equals(JTable.getValueAt(i, row1)) && item2.equals(JTable.getValueAt(i, row2)) && item3.equals(JTable.getValueAt(i, row3))) {
                return true;
            }
        }
        return false;
    }
}
