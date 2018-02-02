package Proses;

import static KomponenGUI.FDateF.datetostr;
import KomponenGUI.FDateF;
import LSubProces.MultiInsert;
import LSubProces.DRunSelctOne;
import LSubProces.FLaporan;
import LSubProces.History;
import LSubProces.RunSelct;
import Master.MasterBarang;
import Master.MasterVendor;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author riki
 */
public class PurchaseRequest extends javax.swing.JFrame {

    KomponenGUI.JtextF[] arrayBarang;
    String idEdit;

    /**
     * Creates new form BarangMasuk
     */
    public PurchaseRequest(Object id) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        idEdit = id.toString();
        arrayBarang = new KomponenGUI.JtextF[]{JTJenisBarang, JTKategoriBarang, JTNamaBarang};
        if (idEdit.equals("0")) {
            setTitle("Tambah Purchase Request");
            setNomorPurchaseRequest();
            JBUbahPrint.setVisible(false);
            JBUbah.setVisible(false);
        } else {
            setTitle("Ubah Purchase Request");
            loadData();
            JBTambah.setVisible(false);
            JBTambahTutup.setVisible(false);
            JBTambahPrint.setVisible(false);
        }
        setVisible(true);
    }

    boolean checkInput() {
        if (JTNomorPurchaseRequest.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor Purchase Request Tidak Boleh Kosong");
            return false;
        } else if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Purchase Request Tidak Boleh Kosong");
            return false;
        } else if (JTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Detail Permintaan Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    boolean checkUbah() {
        if (JTNomorPurchaseRequest.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "No PR Tidak Boleh Kosong");
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
        } else if (JTHargaBarang.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harga Tidak Boleh Kosong");
            JTHargaBarang.requestFocus();
            return false;
        } else if (JTJumlahBarang.getText().replace("0", "").isEmpty()) {
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
        } else if (JTJumlahBarang.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Barang Tidak Boleh Kosong");
            return false;
        } else if (JTHargaBarang.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harga Barang Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    void loadData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Panggil Data Edit");
        dRunSelctOne.setQuery("SELECT `IdPurchaseRequest` as 'ID', `NomorPurchaseRequest` as 'No. PR', `TanggalPurchaseRequest` as 'Tanggal', `NamaVendor`, a.`Keterangan` FROM `tbpurchaserequest`a JOIN `tbmvendor`b ON a.`IdVendor`=b.`IdVendor` WHERE `IdPurchaseRequest` = '" + idEdit + "' ");
        ArrayList<String> list = dRunSelctOne.excute();
        JTNomorPurchaseRequest.setText(list.get(1));
        JDTanggal.setDate(FDateF.strtodate(list.get(2), "yyyy-MM-dd"));
        JCVendor.setSelectedItem(list.get(3));
        JTAKeterangan.setText(list.get(4));
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NomorKolom` as 'No Kolom', `JenisBarang` AS 'Jenis Barang', `KategoriBarang` AS 'Kategori Barang', `NamaBarang` as 'Nama Barang', FORMAT(`HargaBarang`,0) as 'Harga', FORMAT(`JumlahBarang`,0) as 'Jumlah', a.`Keterangan` FROM `tbpurchaserequestdetail`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` JOIN `tbmkategoribarang`c ON b.`IdKategoriBarang`=c.`IdKategoriBarang` JOIN `tbmjenisbarang`d ON c.`IdJenisBarang`=d.`IdJenisBarang` WHERE `NomorPurchaseRequest` = '" + list.get(1) + "'");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", "", "", ""});
                JTable.setValueAt(rs.getString(1), row, 0);
                JTable.setValueAt(rs.getString(2), row, 1);
                JTable.setValueAt(rs.getString(3), row, 2);
                JTable.setValueAt(rs.getString(4).replace(",", "."), row, 3);
                JTable.setValueAt(rs.getString(5).replace(",", "."), row, 4);
                JTable.setValueAt(rs.getString(6), row, 5);
                JTable.setValueAt(rs.getString(7), row, 6);
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

        jcomCari1 = new KomponenGUI.JcomCari();
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
        JBTambahDetail = new KomponenGUI.JbuttonF();
        JBUbahDetail = new KomponenGUI.JbuttonF();
        JBHapusDetail = new KomponenGUI.JbuttonF();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        jtextF12 = new KomponenGUI.JtextF();
        JTJumlahBarang = new KomponenGUI.JNumberOnly();
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
        JTHargaBarang = new KomponenGUI.JRibuanTextField();
        JBTambahPrint = new KomponenGUI.JbuttonF();
        JBPrint = new KomponenGUI.JbuttonF();
        JBUbahPrint = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jbuttonF6 = new KomponenGUI.JbuttonF();
        JTKategoriBarang = new KomponenGUI.JtextF();
        jtextF13 = new KomponenGUI.JtextF();
        JTJenisBarang = new KomponenGUI.JtextF();
        jtextF11 = new KomponenGUI.JtextF();
        JTKeterangan = new KomponenGUI.JtextF();
        JTPenerima = new KomponenGUI.JtextF();
        JTNomorPurchaseRequest = new KomponenGUI.JtextF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlableF1.setText("Nomor");

        jlableF2.setText("Penerima");

        JCVendor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Nama Vendor --" }));
        JCVendor.load("SELECT '-- Pilih Nama Vendor --' UNION SELECT `NamaVendor` FROM `tbmvendor` ");
        JCVendor.setNextFocusableComponent(JTNamaBarang);
        JCVendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCVendorKeyPressed(evt);
            }
        });

        JTNamaBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTNamaBarang.setNextFocusableComponent(JTHargaBarang);
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

        jtextF9.setText("Harga");
        jtextF9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF9.setEnabled(false);

        jtextF10.setText("Keterangan");
        jtextF10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF10.setEnabled(false);

        JTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTable.getTableHeader().setReorderingAllowed(false);
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Jenis Barang", "Kategori Barang", "Nama Barang", "Harga", "Jumlah", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            JTable.getColumnModel().getColumn(4).setMinWidth(120);
            JTable.getColumnModel().getColumn(4).setPreferredWidth(120);
            JTable.getColumnModel().getColumn(4).setMaxWidth(120);
            JTable.getColumnModel().getColumn(5).setMinWidth(100);
            JTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(5).setMaxWidth(100);
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

        JBTambahDetail.setText("Tambah");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement == null}"), JBTambahDetail, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        JBTambahDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahDetailActionPerformed(evt);
            }
        });

        JBUbahDetail.setText("Ubah");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), JBUbahDetail, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        JBUbahDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahDetailActionPerformed(evt);
            }
        });

        JBHapusDetail.setText("Hapus");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), JBHapusDetail, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        JBHapusDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHapusDetailActionPerformed(evt);
            }
        });

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        jScrollPane2.setViewportView(JTAKeterangan);

        jtextF12.setText("Kategori Barang");
        jtextF12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF12.setEnabled(false);

        JTJumlahBarang.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTJumlahBarang.setNextFocusableComponent(JTKeterangan);
        JTJumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahBarangKeyPressed(evt);
            }
        });

        JDTanggal.setDate(new Date());

        jlableF6.setText("Tanggal");

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

        jlableF8.setText("PURCHASE REQUEST");
        jlableF8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jlableF9.setText(":");

        jlableF11.setText("Vendor");

        jlableF12.setText(":");

        jlableF10.setText(":");

        jlableF13.setText(":");

        JTHargaBarang.setNextFocusableComponent(JTJumlahBarang);
        JTHargaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTHargaBarangKeyPressed(evt);
            }
        });

        JBTambahPrint.setText("Simpan & Print");
        JBTambahPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahPrintActionPerformed(evt);
            }
        });

        JBPrint.setText("Print");
        JBPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPrintActionPerformed(evt);
            }
        });

        JBUbahPrint.setText("Ubah & Print");
        JBUbahPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahPrintActionPerformed(evt);
            }
        });

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
        JTKategoriBarang.setNextFocusableComponent(JTHargaBarang);

        jtextF13.setText("Jenis Barang");
        jtextF13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF13.setEnabled(false);

        JTJenisBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTJenisBarang.setEnabled(false);
        JTJenisBarang.setNextFocusableComponent(JTHargaBarang);

        jtextF11.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtextF11.setText("Keterangan");
        jtextF11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF11.setEnabled(false);

        JTKeterangan.setForeground(new java.awt.Color(102, 102, 102));
        JTKeterangan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTKeterangan.setNextFocusableComponent(JTHargaBarang);
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyPressed(evt);
            }
        });

        JTPenerima.setText("PELITA GROUP");
        JTPenerima.setEnabled(false);

        JTNomorPurchaseRequest.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlableF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                        .addComponent(JBPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBUbahPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambahPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                                .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNomorPurchaseRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                    .addComponent(jtextF9, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(JTHargaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF8, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(JTJumlahBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtextF11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JBHapusDetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBUbahDetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBTambahDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBRefreshDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
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
                    .addComponent(JTNomorPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBSearchNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTambahDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBUbahDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBHapusDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBRefreshDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 174, Short.MAX_VALUE)))
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
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambahPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbahPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTambahDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahDetailActionPerformed
        TambahTabel();
    }//GEN-LAST:event_JBTambahDetailActionPerformed

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

    private void JBHapusDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHapusDetailActionPerformed
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Berhasil Hapus List");
            RefreshTbl();
            JTNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_JBHapusDetailActionPerformed

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        TambahData(false, false);
    }//GEN-LAST:event_JBTambahActionPerformed

    private void JTJumlahBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahBarangKeyPressed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        UbahData(false);
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JBTambahTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahTutupActionPerformed
        TambahData(true, false);
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
            JTKeterangan.setText(JTable.getValueAt(JTable.getSelectedRow(), 6).toString());
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

    private void JTHargaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTHargaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlahBarang.requestFocus();
        }
    }//GEN-LAST:event_JTHargaBarangKeyPressed

    private void JBTambahPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahPrintActionPerformed
        TambahData(false, true);
    }//GEN-LAST:event_JBTambahPrintActionPerformed

    private void JBPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPrintActionPerformed
        print();
    }//GEN-LAST:event_JBPrintActionPerformed

    private void JBUbahPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahPrintActionPerformed
        UbahData(true);
    }//GEN-LAST:event_JBUbahPrintActionPerformed

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
            if (JBTambahDetail.isEnabled()) {
                TambahTabel();
            } else {
                ubahtable();
            }
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (idEdit.equals("0")) {
            GlobalVar.Var.tambahPurchaseRequest = null;
        } else {
            GlobalVar.Var.editPurchaseRequest = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void JTNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (JTNamaBarang.getText().replace(" ", "").isEmpty()) {
                cariBarang(null);
            } else {
                JTHargaBarang.requestFocus();
            }
        }
    }//GEN-LAST:event_JTNamaBarangKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseRequest("0").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBHapusDetail;
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBPrint;
    private KomponenGUI.JbuttonF JBRefreshDetail;
    private KomponenGUI.JbuttonF JBSearchNamaBarang;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahDetail;
    private KomponenGUI.JbuttonF JBTambahPrint;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JbuttonF JBUbahDetail;
    private KomponenGUI.JbuttonF JBUbahPrint;
    public static KomponenGUI.JcomboboxF JCVendor;
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTHargaBarang;
    public static KomponenGUI.JtextF JTJenisBarang;
    private KomponenGUI.JNumberOnly JTJumlahBarang;
    public static KomponenGUI.JtextF JTKategoriBarang;
    public static KomponenGUI.JtextF JTKeterangan;
    public static KomponenGUI.JtextF JTNamaBarang;
    private KomponenGUI.JtextF JTNomorPurchaseRequest;
    private KomponenGUI.JtextF JTPenerima;
    private KomponenGUI.JtableF JTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JbuttonF jbuttonF6;
    private KomponenGUI.JcomCari jcomCari1;
    private KomponenGUI.JlableF jlableF1;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF11;
    private KomponenGUI.JlableF jlableF12;
    private KomponenGUI.JlableF jlableF13;
    private KomponenGUI.JlableF jlableF2;
    private KomponenGUI.JlableF jlableF4;
    private KomponenGUI.JlableF jlableF5;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF8;
    private KomponenGUI.JlableF jlableF9;
    private KomponenGUI.JtextF jtextF10;
    private KomponenGUI.JtextF jtextF11;
    private KomponenGUI.JtextF jtextF12;
    private KomponenGUI.JtextF jtextF13;
    private KomponenGUI.JtextF jtextF7;
    private KomponenGUI.JtextF jtextF8;
    private KomponenGUI.JtextF jtextF9;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    void setNomorPurchaseRequest() {
        NumberFormat nf = new DecimalFormat("0000");
        String nomorTransaksi = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NomorPurchaseRequest`, RIGHT(`NomorPurchaseRequest`, 4) as 'Year' FROM `tbpurchaserequest` ORDER BY `NomorPurchaseRequest` DESC LIMIT 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                nomorTransaksi = "0001" + "/PR/PLT/" + getRomawi(datetostr(new Date(), "MM")) + "/" + datetostr(new Date(), "yyyy");
            }
            while (rs.next()) {
                String lastNomorTransaksi = rs.getString("NomorPurchaseRequest");
                String subNomorTransaksi = lastNomorTransaksi.substring(0, 4);
                int generatedNumber = parseInt(subNomorTransaksi) + 1;
                if (generatedNumber == 9999 || Integer.valueOf(rs.getString("Year")) < Integer.valueOf(datetostr(new Date(), "yyyy"))) {
                    generatedNumber = 1;
                }
                nomorTransaksi = nf.format(generatedNumber) + "/PR/PLT/" + getRomawi(datetostr(new Date(), "MM")) + "/" + datetostr(new Date(), "yyyy");
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            JOptionPane.showMessageDialog(this, "Gagal Generate Nomor Purchase Request", "Information", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            runSelct.closecon();
        }
        JTNomorPurchaseRequest.setText(nomorTransaksi);
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
        setNomorPurchaseRequest();
        JTAKeterangan.setText("");
        JTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "No", "Jenis Barang", "Kategori Barang", "Nama Barang", "Harga", "Jumlah", "Keterangan"
                }
        ));
        JTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        JTable.getColumnModel().getColumn(0).setMinWidth(60);
        JTable.getColumnModel().getColumn(0).setMaxWidth(60);
        JTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTable.getColumnModel().getColumn(1).setMinWidth(100);
        JTable.getColumnModel().getColumn(1).setMaxWidth(100);
        JTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTable.getColumnModel().getColumn(2).setMinWidth(100);
        JTable.getColumnModel().getColumn(2).setMaxWidth(100);
        JTable.getColumnModel().getColumn(3).setPreferredWidth(400);
        JTable.getColumnModel().getColumn(3).setMinWidth(400);
        JTable.getColumnModel().getColumn(3).setMaxWidth(400);
        JTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTable.getColumnModel().getColumn(4).setMinWidth(100);
        JTable.getColumnModel().getColumn(4).setMaxWidth(100);
        JTable.getColumnModel().getColumn(5).setPreferredWidth(60);
        JTable.getColumnModel().getColumn(5).setMinWidth(60);
        JTable.getColumnModel().getColumn(5).setMaxWidth(60);
        RefreshTbl();
    }

    void RefreshTbl() {
        JTable.clearSelection();
        JTJenisBarang.setText("");
        JTKategoriBarang.setText("");
        JTNamaBarang.setText("");
        JTKategoriBarang.setText("");
        JTJumlahBarang.setText("0");
        JTHargaBarang.setText("0");
        JTKeterangan.setText("");
    }

    public static String angkaToTerbilang(Long angka) {
        String[] huruf = {"", "SATU", "DUA", "TIGA", "EMPAT", "LIMA", "ENAM", "TUJUH", "DELAPAN", "SEMBILAN", "SEPULUH", "SEBELAS"};
        if (angka < 12) {
            return huruf[angka.intValue()];
        }
        if (angka >= 12 && angka <= 19) {
            return huruf[angka.intValue() % 10] + " BELAS";
        }
        if (angka >= 20 && angka <= 99) {
            return angkaToTerbilang(angka / 10) + " PULUH " + huruf[angka.intValue() % 10];
        }
        if (angka >= 100 && angka <= 199) {
            return "SERATUS " + angkaToTerbilang(angka % 100);
        }
        if (angka >= 200 && angka <= 999) {
            return angkaToTerbilang(angka / 100) + " RATUS " + angkaToTerbilang(angka % 100);
        }
        if (angka >= 1000 && angka <= 1999) {
            return "SERIBU " + angkaToTerbilang(angka % 1000);
        }
        if (angka >= 2000 && angka <= 999999) {
            return angkaToTerbilang(angka / 1000) + " RIBU " + angkaToTerbilang(angka % 1000);
        }
        if (angka >= 1000000 && angka <= 999999999) {
            return angkaToTerbilang(angka / 1000000) + " JUTA " + angkaToTerbilang(angka % 1000000);
        }
        if (angka >= 1000000000 && angka <= 999999999999L) {
            return angkaToTerbilang(angka / 1000000000) + " MILYAR " + angkaToTerbilang(angka % 1000000000);
        }
        if (angka >= 1000000000000L && angka <= 999999999999999L) {
            return angkaToTerbilang(angka / 1000000000000L) + " TRILIUN " + angkaToTerbilang(angka % 1000000000000L);
        }
        if (angka >= 1000000000000000L && angka <= 999999999999999999L) {
            return angkaToTerbilang(angka / 1000000000000000L) + " QUADRILYUN " + angkaToTerbilang(angka % 1000000000000000L);
        }
        return "";
    }

    void print() {
        HashMap hashs = new HashMap();
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Panggil No Telepon Vendor");
        dRunSelctOne.setQuery("SELECT `NomorTelepon` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        hashs.put("Title", "PURCHASE REQUEST");
        hashs.put("PrintedBy", "Di Print Oleh " + GlobalVar.VarL.username + " Pada " + FDateF.datetostr(new Date(), "dd/MM/yyyy HH:mm"));
        System.out.println(JTNomorPurchaseRequest.getText());
        hashs.put("NomorPurchaseRequest", JTNomorPurchaseRequest.getText());
        hashs.put("Tanggal", FDateF.datetostr(JDTanggal.getDate(), "dd/MM/yyyy HH:mm"));
        hashs.put("NamaVendor", JCVendor.getSelectedItem());
        hashs.put("NomorTeleponVendor", list.get(0));
        hashs.put("Keterangan", JTAKeterangan.getText());
        hashs.put("Terbilang", " # " + angkaToTerbilang(getGrandTotal()) + " RUPIAH # ");
        FLaporan fLaporan = new FLaporan();
        fLaporan.sethashmap(hashs);
        fLaporan.setfilename("PurchaseRequest");
        fLaporan.setErorm("Gagal Menampilkan Laporan " + this.getTitle());
        fLaporan.excute();
        History.simpanhistory(GlobalVar.VarL.username, "PurchaseRequest");
    }

    Long getGrandTotal() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + (Integer.valueOf(JTable.getValueAt(x, 4).toString().replace(".", "")) * Integer.valueOf(JTable.getValueAt(x, 5).toString().replace(".", "")));
        }
        return Long.valueOf(GrandTotal);
    }

    String getRomawi(String No) {
        switch (No) {
            case "01":
                return "I";
            case "02":
                return "II";
            case "03":
                return "III";
            case "04":
                return "IV";
            case "05":
                return "V";
            case "06":
                return "VI";
            case "07":
                return "VII";
            case "08":
                return "VIII";
            case "09":
                return "IX";
            case "10":
                return "X";
            case "11":
                return "XI";
            case "12":
                return "XII";
            default:
                return "Error getRomawi()";
        }
    }

    void TambahTabel() {
        if (checkTable()) {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.addRow(new Object[]{JTable.getRowCount() + 1, JTJenisBarang.getText(), JTKategoriBarang.getText(), JTNamaBarang.getText(), JTHargaBarang.getText(), JTJumlahBarang.getText(), JTKeterangan.getText()});
            JOptionPane.showMessageDialog(this, "Berhasil Tambah List");
            JTNamaBarang.requestFocus();
            RefreshTbl();
        }
    }

    void TambahData(boolean tutup, boolean print) {
        if (checkInput()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                if (Berhasil) {
                    Berhasil = multiInsert.Excute("INSERT INTO `tbpurchaserequest`(`NomorPurchaseRequest`, `TanggalPurchaseRequest`, `IdVendor`, `Keterangan`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `tbpurchaserequestdetail`(`NomorPurchaseRequest`, `NomorKolom`, `IdBarang`, `HargaBarang`, `JumlahBarang`, `Keterangan`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang`a JOIN `tbmkategoribarang`b ON a.`IdKategoriBarang`=b.`IdKategoriBarang` JOIN `tbmjenisbarang`c ON b.`IdJenisBarang`=c.`IdJenisBarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 3) + "' AND `KategoriBarang` = '" + JTable.getValueAt(i, 2) + "' AND `JenisBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 4).toString().replace(".", "") + "','" + JTable.getValueAt(i, 5).toString().replace(".", "") + "','" + JTable.getValueAt(i, 6) + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                //////System.out.println("Rollback");
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Purchase Request");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Purchase Request");
                multiInsert.Commit();
                multiInsert.closecon();
                RefreshAll();
                if (tutup) {
                    dispose();
                }
                if (print) {
                    print();
                }
                setNomorPurchaseRequest();
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
                    Berhasil = multiInsert.Excute("UPDATE `tbpurchaserequest` SET `NomorPurchaseRequest`='" + JTNomorPurchaseRequest.getText() + "',`TanggalPurchaseRequest`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`IdVendor`=(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdPurchaseRequest` = '" + idEdit + "'", null);
                    if (Berhasil) {
                        Berhasil = multiInsert.Excute("DELETE FROM `tbpurchaserequestdetail` WHERE `NomorPurchaseRequest` = '" + JTNomorPurchaseRequest.getText() + "'", null);
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `tbpurchaserequestdetail`(`NomorPurchaseRequest`, `NomorKolom`, `IdBarang`, `HargaBarang`, `JumlahBarang`, `Keterangan`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang`a JOIN `tbmkategoribarang`b ON a.`IdKategoriBarang`=b.`IdKategoriBarang` JOIN `tbmjenisbarang`c ON b.`IdJenisBarang`=c.`IdJenisBarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 3) + "' AND `KategoriBarang` = '" + JTable.getValueAt(i, 2) + "' AND `JenisBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 4).toString().replace(".", "") + "','" + JTable.getValueAt(i, 5).toString().replace(".", "") + "','" + JTable.getValueAt(i, 6) + "')", null);
                            }
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                JOptionPane.showMessageDialog(this, "Gagal Ubah Data Purchase Request");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Purchase Request");
                multiInsert.Commit();
                multiInsert.closecon();
                if (print) {
                    print();
                }
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
            JTable.setValueAt(JTKeterangan.getText(), JTable.getSelectedRow(), 6);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Detail Permintaan");
            RefreshTbl();
            JTNamaBarang.requestFocus();
        }
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
