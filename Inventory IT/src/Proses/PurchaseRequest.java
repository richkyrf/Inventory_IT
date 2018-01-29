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
import javafx.scene.input.KeyCode;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author riki
 */
public class PurchaseRequest extends javax.swing.JFrame {

    KomponenGUI.JtextF[] arrayBarang;

    /**
     * Creates new form BarangMasuk
     */
    public PurchaseRequest(Object NoPR) {
        initComponents();
        loadeditdata(NoPR);
        setTitle("Edit Purchase Request");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        BTNSimpan.setVisible(false);
        BTNSimpanDanTutup.setVisible(false);
        BTNSimpanDanPrint.setVisible(false);
        arrayBarang = new KomponenGUI.JtextF[]{JTJenisBarang, JTKategoriBarang, JTNamaBarang};
    }

    public PurchaseRequest() {
        initComponents();
        setNomorPurchaseRequest();
        setTitle("Purchase Request");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        BTNPrint.setVisible(false);
        BTNUbah.setVisible(false);
        BTNUbahPrint.setVisible(false);
        arrayBarang = new KomponenGUI.JtextF[]{JTJenisBarang, JTKategoriBarang, JTNamaBarang};
    }

    boolean checkInput() {
        if (JTNomorPurchaseRequest.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "No PR Tidak Boleh Kosong");
            return false;
        } else if (JTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "List Permintaan Tidak Boleh Kosong");
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
        } else if (JTHarga.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harga Tidak Boleh Kosong");
            JTHarga.requestFocus();
            return false;
        } else if (JTJumlah.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Tidak Boleh Kosong");
            JTJumlah.requestFocus();
            return false;
        } else if (JTable.getRowCount() >= 12) {
            JOptionPane.showMessageDialog(this, "Jenis Barang Yang Diinput Tidak Bisa Lebih Dari 12");
            return false;
        } else if (cekdoubleitem(JTNamaBarang.getText())) {
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
        } else if (JTJumlah.getText().replace("0", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Tidak Boleh Kosong");
            return false;
        } else {
            return true;
        }
    }

    void loadeditdata(Object NoPR) {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Panggil Data Edit");
        dRunSelctOne.setQuery("SELECT `IdProses`, `NoPR`, `Tanggal`, `NamaVendor`, `NamaPenerima`, a.`Keterangan` FROM `tbproses`a JOIN `tbmvendor`b ON a.`IdVendor`=b.`IdVendor` JOIN `tbmpenerima`c ON a.`IdPenerima`=c.`IdPenerima` WHERE `NoPR` = '" + NoPR + "' ");
        ArrayList<String> list = dRunSelctOne.excute();
        JTNomorPurchaseRequest.setText(list.get(1));
        JDTanggal.setDate(FDateF.strtodate(list.get(2), "yyyy-MM-dd"));
        JCVendor.setSelectedItem(list.get(3));
        JCPenerima.setSelectedItem(list.get(4));
        JTAKeterangan.setText(list.get(5));
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoColoum`, `NamaBarang`, a.`Keterangan`, FORMAT(`Harga`,0) as 'Harga', `Jumlah` FROM `tbprosesdetail`a JOIN `tbmbarang`b ON a.`IdBarang`=b.`IdBarang` WHERE `NoPR` = '" + list.get(1) + "'");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", ""});
                JTable.setValueAt(rs.getString(1), row, 0);
                JTable.setValueAt(rs.getString(2), row, 1);
                JTable.setValueAt(rs.getString(3), row, 2);
                JTable.setValueAt(rs.getString(4), row, 3);
                JTable.setValueAt(rs.getString(5), row, 4);
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
        BTNSimpan = new KomponenGUI.JbuttonF();
        BTNSimpanDanTutup = new KomponenGUI.JbuttonF();
        tambahtable = new KomponenGUI.JbuttonF();
        ubahtable = new KomponenGUI.JbuttonF();
        hapustable = new KomponenGUI.JbuttonF();
        JTNomorPurchaseRequest = new KomponenGUI.JtextF();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        jtextF12 = new KomponenGUI.JtextF();
        JTJumlah = new KomponenGUI.JNumberOnly();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF6 = new KomponenGUI.JlableF();
        BTNUbah = new KomponenGUI.JbuttonF();
        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        jlableF8 = new KomponenGUI.JlableF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF11 = new KomponenGUI.JlableF();
        JCPenerima = new KomponenGUI.JcomboboxF();
        jlableF12 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF13 = new KomponenGUI.JlableF();
        JTHarga = new KomponenGUI.JRibuanTextField();
        BTNSimpanDanPrint = new KomponenGUI.JbuttonF();
        BTNPrint = new KomponenGUI.JbuttonF();
        BTNUbahPrint = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jbuttonF6 = new KomponenGUI.JbuttonF();
        JTKategoriBarang = new KomponenGUI.JtextF();
        jtextF13 = new KomponenGUI.JtextF();
        JTJenisBarang = new KomponenGUI.JtextF();
        jtextF11 = new KomponenGUI.JtextF();
        JTKeterangan = new KomponenGUI.JtextF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jlableF1.setText("Nomor");

        jlableF2.setText("Vendor");

        JCVendor.load("SELECT `NamaVendor` FROM `tbmvendor` ");
        JCVendor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCVendorItemStateChanged(evt);
            }
        });
        JCVendor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JCVendorFocusLost(evt);
            }
        });
        JCVendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCVendorKeyPressed(evt);
            }
        });

        JTNamaBarang.setForeground(new java.awt.Color(102, 102, 102));
        JTNamaBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTNamaBarang.setNextFocusableComponent(JTHarga);
        JTNamaBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTNamaBarangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTNamaBarangFocusLost(evt);
            }
        });
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
                "No", "Kategori", "Nama Barang", "Harga", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            JTable.getColumnModel().getColumn(2).setMinWidth(400);
            JTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            JTable.getColumnModel().getColumn(2).setMaxWidth(400);
            JTable.getColumnModel().getColumn(3).setMinWidth(100);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTable.getColumnModel().getColumn(3).setMaxWidth(100);
            JTable.getColumnModel().getColumn(4).setMinWidth(60);
            JTable.getColumnModel().getColumn(4).setPreferredWidth(60);
            JTable.getColumnModel().getColumn(4).setMaxWidth(60);
        }
        JTable.setrender(3, "Number");
        JTable.setrender(4, "Number");

        jlableF4.setText("USER :");

        jlableF5.setText(GlobalVar.VarL.username);

        BTNSimpan.setText("SIMPAN");
        BTNSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSimpanActionPerformed(evt);
            }
        });

        BTNSimpanDanTutup.setText("SIMPAN & TUTUP");
        BTNSimpanDanTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSimpanDanTutupActionPerformed(evt);
            }
        });

        tambahtable.setText("TAMBAH");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement == null}"), tambahtable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        tambahtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahtableActionPerformed(evt);
            }
        });

        ubahtable.setText("UBAH");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), ubahtable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        ubahtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahtableActionPerformed(evt);
            }
        });

        hapustable.setText("HAPUS");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), hapustable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        hapustable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapustableActionPerformed(evt);
            }
        });

        JTNomorPurchaseRequest.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTNomorPurchaseRequest.setEnabled(false);

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        jScrollPane2.setViewportView(JTAKeterangan);

        jtextF12.setText("Kategori Barang");
        jtextF12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF12.setEnabled(false);

        JTJumlah.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTJumlah.setNextFocusableComponent(JTKategoriBarang);
        JTJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTJumlahKeyReleased(evt);
            }
        });

        JDTanggal.setDate(new Date());

        jlableF6.setText("Tanggal");

        BTNUbah.setText("UBAH");
        BTNUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNUbahActionPerformed(evt);
            }
        });

        jbuttonF1.setText("Kembali");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Search.png"))); // NOI18N
        jbuttonF2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbuttonF2FocusGained(evt);
            }
        });
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jbuttonF3.setText("REFRESH");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        jlableF8.setText("PURCHASE REQUEST");
        jlableF8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jlableF9.setText(":");

        jlableF11.setText("Penerima");

        JCPenerima.load("SELECT `NamaPenerima` FROM `tbmpenerima` ");
        JCPenerima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCPenerimaItemStateChanged(evt);
            }
        });
        JCPenerima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JCPenerimaFocusLost(evt);
            }
        });
        JCPenerima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPenerimaKeyPressed(evt);
            }
        });

        jlableF12.setText(":");

        jlableF10.setText(":");

        jlableF13.setText(":");

        JTHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTHargaKeyPressed(evt);
            }
        });

        BTNSimpanDanPrint.setText("SIMPAN & PRINT");
        BTNSimpanDanPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSimpanDanPrintActionPerformed(evt);
            }
        });

        BTNPrint.setText("Print");
        BTNPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNPrintActionPerformed(evt);
            }
        });

        BTNUbahPrint.setText("UBAH & PRINT");
        BTNUbahPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNUbahPrintActionPerformed(evt);
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

        JTKategoriBarang.setForeground(new java.awt.Color(102, 102, 102));
        JTKategoriBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTKategoriBarang.setNextFocusableComponent(JTHarga);
        JTKategoriBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTKategoriBarangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTKategoriBarangFocusLost(evt);
            }
        });
        JTKategoriBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKategoriBarangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTKategoriBarangKeyReleased(evt);
            }
        });

        jtextF13.setText("Jenis Barang");
        jtextF13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF13.setEnabled(false);

        JTJenisBarang.setForeground(new java.awt.Color(102, 102, 102));
        JTJenisBarang.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTJenisBarang.setNextFocusableComponent(JTHarga);
        JTJenisBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTJenisBarangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTJenisBarangFocusLost(evt);
            }
        });
        JTJenisBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJenisBarangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTJenisBarangKeyReleased(evt);
            }
        });

        jtextF11.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtextF11.setText("Keterangan");
        jtextF11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtextF11.setEnabled(false);

        JTKeterangan.setForeground(new java.awt.Color(102, 102, 102));
        JTKeterangan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        JTKeterangan.setNextFocusableComponent(JTHarga);
        JTKeterangan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTKeteranganFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTKeteranganFocusLost(evt);
            }
        });
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyReleased(evt);
            }
        });

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
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addComponent(BTNPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNUbahPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSimpanDanPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSimpanDanTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlableF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JCVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTNomorPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(JTJenisBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtextF13, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF12, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(JTKategoriBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtextF7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF9, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(JTHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtextF8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtextF11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(hapustable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ubahtable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tambahtable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
                    .addComponent(JCVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNomorPurchaseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextF13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtextF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtextF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ubahtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hapustable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 68, Short.MAX_VALUE)))
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
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNSimpanDanTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNSimpanDanPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNUbahPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahtableActionPerformed
        TambahTabel();
    }//GEN-LAST:event_tambahtableActionPerformed

    private void JTNamaBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if (JTable.getSelectedRow() != -1) {
                JTable.clearSelection();
                JTKategoriBarang.setText("");
                JTJumlah.setText("");
                JTNamaBarang.setText("");
                JTHarga.setText("");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            if (BTNUbah.isVisible()) {
                if (GlobalVar.Var.jCari == null) {
                    GlobalVar.Var.jCari = new JCari("SELECT `JenisBarang` AS 'Jenis Barang', `KategoriBarang` AS 'Kategori Barang', `NamaBarang` AS 'Nama Barang' FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `JenisBarang` ", "SELECT `JenisBarang` AS 'Jenis Barang', `KategoriBarang` AS 'Kategori Barang', `NamaBarang` AS 'Nama Barang' FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `KategoriBarang` ", "SELECT `JenisBarang` AS 'Jenis Barang', `KategoriBarang` AS 'Kategori Barang', `NamaBarang` AS 'Nama Barang' FROM `tbmbarang` AS A JOIN `tbmkategoribarang` AS B ON A.`IdKategoriBarang`=B.`IdKategoriBarang` JOIN `tbmjenisbarang` AS C ON B.`IdJenisBarang`=C.`IdJenisBarang` WHERE `NamaBarang` ", "Cari Barang", arrayBarang, JTNamaBarang.getText(), PurchaseRequest.JTNamaBarang);
                }
            } else {
                if (GlobalVar.Var.jCari == null) {
                    GlobalVar.Var.jCari = new Jcari("SELECT `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `JenisBarang` ", "SELECT  `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `NamaBarang` ", "Jenis Barang", "Nama Barang", "Cari Barang", 1, GlobalVar.Var.tambahPurchaseRequest.JTNamaBarang, null, JTKategoriBarang);
                }
            }
        } else if (isAlphanumeric(String.valueOf(evt.getKeyChar())) == true) {
            if (BTNUbah.isVisible()) {
                if (GlobalVar.Var.jCari == null) {
                    GlobalVar.Var.jCari = new Jcari("SELECT `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `JenisBarang` ", "SELECT  `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `NamaBarang` ", "Jenis Barang", "Nama Barang", "Cari Barang", 1, GlobalVar.Var.editPurchaseRequest.JTNamaBarang, JTNamaBarang.getText(), JTKategoriBarang);
                }
            } else {
                if (GlobalVar.Var.jCari == null) {
                    GlobalVar.Var.jCari = new Jcari("SELECT `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `JenisBarang` ", "SELECT  `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `NamaBarang` ", "Jenis Barang", "Nama Barang", "Cari Barang", 1, GlobalVar.Var.tambahPurchaseRequest.JTNamaBarang, JTNamaBarang.getText(), JTKategoriBarang);
                }
            }
        }
    }//GEN-LAST:event_JTNamaBarangKeyReleased

    private void ubahtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahtableActionPerformed
        ubahtable();
    }//GEN-LAST:event_ubahtableActionPerformed

    private void hapustableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapustableActionPerformed
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            for (int a = 0; a < JTable.getRowCount(); a++) {
                JTable.setValueAt(a + 1, a, 0);
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hapus List");
            RefreshTbl();
        }
        tambahtable.setEnabled(true);

        JTNamaBarang.requestFocus();
    }//GEN-LAST:event_hapustableActionPerformed

    private void JTJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahKeyReleased

    }//GEN-LAST:event_JTJumlahKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (BTNSimpan.isVisible()) {
            GlobalVar.Var.tambahPurchaseRequest = null;
        } else {
            GlobalVar.Var.editPurchaseRequest = null;
        }

    }//GEN-LAST:event_formWindowClosing

    private void BTNSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSimpanActionPerformed
        TambahData();
    }//GEN-LAST:event_BTNSimpanActionPerformed

    private void JTNamaBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTNamaBarangFocusLost

    }//GEN-LAST:event_JTNamaBarangFocusLost

    private void JTNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTHarga.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F12) {
            TambahData();
        }
    }//GEN-LAST:event_JTNamaBarangKeyPressed

    private void JTJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TambahTabel();
        }
    }//GEN-LAST:event_JTJumlahKeyPressed

    private void BTNUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNUbahActionPerformed
        UbahData();
    }//GEN-LAST:event_BTNUbahActionPerformed

    private void BTNSimpanDanTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSimpanDanTutupActionPerformed
        TambahDataKeluar();
    }//GEN-LAST:event_BTNSimpanDanTutupActionPerformed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        if (BTNUbah.isVisible()) {
            GlobalVar.Var.jCari = new Jcari("SELECT `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `JenisBarang` ", "SELECT  `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `NamaBarang` ", "Jenis Barang", "Nama Barang", "Cari Barang", 1, GlobalVar.Var.editPurchaseRequest.JTNamaBarang, null, JTKategoriBarang);
        } else {
            GlobalVar.Var.jCari = new Jcari("SELECT `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `JenisBarang` ", "SELECT  `JenisBarang`, `NamaBarang` FROM `tbmbarang`a JOIN `tbsmjenisbarang`b ON a.`IdJenisBarang`=b.`IdJenisBarang` WHERE `NamaBarang` ", "Jenis Barang", "Nama Barang", "Cari Barang", 1, GlobalVar.Var.tambahPurchaseRequest.JTNamaBarang, null, JTKategoriBarang);
        }
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        tambahtable.setEnabled(false);
        ubahtable.setEnabled(true);
        hapustable.setEnabled(true);
        if (JTable.getSelectedRow() != -1) {
            ubahtable.setEnabled(true);
            hapustable.setEnabled(true);
            JTNamaBarang.setText(JTable.getValueAt(JTable.getSelectedRow(), 1).toString());
            JTKategoriBarang.setText(JTable.getValueAt(JTable.getSelectedRow(), 2).toString());
            JTHarga.setText(String.valueOf(JTable.getValueAt(JTable.getSelectedRow(), 3)).replace(",", ""));
            JTJumlah.setText(JTable.getValueAt(JTable.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        if (BTNSimpan.isVisible()) {
            dispose();
            GlobalVar.Var.tambahPurchaseRequest = null;
        } else {
            dispose();
            GlobalVar.Var.editPurchaseRequest = null;
        }
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF3ActionPerformed
        RefreshTbl();
        tambahtable.setEnabled(true);


    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void JCVendorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCVendorItemStateChanged

    }//GEN-LAST:event_JCVendorItemStateChanged

    private void JCVendorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCVendorFocusLost

    }//GEN-LAST:event_JCVendorFocusLost

    private void JCVendorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCVendorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCPenerima.requestFocus();
            JCVendor.hidePopup();
        }
    }//GEN-LAST:event_JCVendorKeyPressed

    private void JTNamaBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTNamaBarangFocusGained

    }//GEN-LAST:event_JTNamaBarangFocusGained

    private void jbuttonF2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbuttonF2FocusGained

    }//GEN-LAST:event_jbuttonF2FocusGained

    private void JCPenerimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCPenerimaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_JCPenerimaItemStateChanged

    private void JCPenerimaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCPenerimaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_JCPenerimaFocusLost

    private void JCPenerimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPenerimaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTNamaBarang.requestFocus();
            JCPenerima.hidePopup();
        }
    }//GEN-LAST:event_JCPenerimaKeyPressed

    private void JTHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTHargaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlah.requestFocus();
        }
    }//GEN-LAST:event_JTHargaKeyPressed

    private void BTNSimpanDanPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSimpanDanPrintActionPerformed
        TambahDataPrint();
    }//GEN-LAST:event_BTNSimpanDanPrintActionPerformed

    private void BTNPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNPrintActionPerformed
        print();
    }//GEN-LAST:event_BTNPrintActionPerformed

    private void BTNUbahPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNUbahPrintActionPerformed
        UbahDataPrint();
    }//GEN-LAST:event_BTNUbahPrintActionPerformed

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        if (GlobalVar.Var.tambahMasterVendor == null) {
            GlobalVar.Var.tambahMasterVendor = new MasterVendor("0");
        }
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void jbuttonF6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF6ActionPerformed
        if (GlobalVar.Var.tambahMasterBarang == null) {
            GlobalVar.Var.tambahMasterBarang = new MasterBarang("0");
        }
    }//GEN-LAST:event_jbuttonF6ActionPerformed

    private void JTKategoriBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTKategoriBarangFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKategoriBarangFocusGained

    private void JTKategoriBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTKategoriBarangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKategoriBarangFocusLost

    private void JTKategoriBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKategoriBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTHarga.requestFocus();
        }
    }//GEN-LAST:event_JTKategoriBarangKeyPressed

    private void JTKategoriBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKategoriBarangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKategoriBarangKeyReleased

    private void JTJenisBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTJenisBarangFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JTJenisBarangFocusGained

    private void JTJenisBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTJenisBarangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_JTJenisBarangFocusLost

    private void JTJenisBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJenisBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTJenisBarangKeyPressed

    private void JTJenisBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJenisBarangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTJenisBarangKeyReleased

    private void JTKeteranganFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTKeteranganFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKeteranganFocusGained

    private void JTKeteranganFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTKeteranganFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKeteranganFocusLost

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKeteranganKeyPressed

    private void JTKeteranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKeteranganKeyReleased

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
            java.util.logging.Logger.getLogger(PurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF BTNPrint;
    private KomponenGUI.JbuttonF BTNSimpan;
    private KomponenGUI.JbuttonF BTNSimpanDanPrint;
    private KomponenGUI.JbuttonF BTNSimpanDanTutup;
    private KomponenGUI.JbuttonF BTNUbah;
    private KomponenGUI.JbuttonF BTNUbahPrint;
    public static KomponenGUI.JcomboboxF JCPenerima;
    public static KomponenGUI.JcomboboxF JCVendor;
    private KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JRibuanTextField JTHarga;
    public static KomponenGUI.JtextF JTJenisBarang;
    private KomponenGUI.JNumberOnly JTJumlah;
    public static KomponenGUI.JtextF JTKategoriBarang;
    public static KomponenGUI.JtextF JTKeterangan;
    public static KomponenGUI.JtextF JTNamaBarang;
    private KomponenGUI.JtextF JTNomorPurchaseRequest;
    private KomponenGUI.JtableF JTable;
    private KomponenGUI.JbuttonF hapustable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
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
    private KomponenGUI.JbuttonF tambahtable;
    private KomponenGUI.JbuttonF ubahtable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    void setNomorPurchaseRequest() {
        NumberFormat nf = new DecimalFormat("000000");
        String nomorPurchaseRequest = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NomorPurchaseRequest` FROM `tbpurchaserequest` ORDER BY `NomorPurchaseRequest` DESC LIMIT 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                nomorPurchaseRequest = "000001" + "/PR/PLT/" + getRomawi(datetostr(new Date(), "MM")) + "/" + datetostr(new Date(), "yyyy");
            }
            while (rs.next()) {
                String autonumbers = rs.getString("NomorPurchaseRequest");
                autonumbers = autonumbers.substring(0, 6);
                int p = parseInt(autonumbers) + 1;
                if (p == 999999) {
                    p = 1;
                }
                nomorPurchaseRequest = "000001" + "/PR/PLT/" + getRomawi(datetostr(new Date(), "MM")) + "/" + datetostr(new Date(), "yyyy");
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            JOptionPane.showMessageDialog(this, "Gagal Generate Nomor Penyesuaian Stok", "Information", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            runSelct.closecon();
        }
        JTNomorPurchaseRequest.setText(nomorPurchaseRequest);
    }

    void RefreshAll() {
        JTNomorPurchaseRequest.setText(GetNoPR());
        JTAKeterangan.setText("");
        JTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "No", "Nama Barang", "Keterangan", "Harga", "Jumlah"
                }
        ));
        JTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        JTable.getColumnModel().getColumn(0).setMinWidth(60);
        JTable.getColumnModel().getColumn(0).setMaxWidth(60);
        JTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTable.getColumnModel().getColumn(2).setMinWidth(100);
        JTable.getColumnModel().getColumn(2).setMaxWidth(100);
        JTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        JTable.getColumnModel().getColumn(3).setMinWidth(60);
        JTable.getColumnModel().getColumn(3).setMaxWidth(60);
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
        JTNamaBarang.setText("");
        JTKategoriBarang.setText("");
        JTJumlah.setText("0");
        JTHarga.setText("");
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
        dRunSelctOne.seterorm("Gagal Panggil Vendor");
        dRunSelctOne.setQuery("SELECT `NoHP` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        dRunSelctOne.seterorm("Gagal Panggil Penerima");
        dRunSelctOne.setQuery("SELECT `NoHP` FROM `tbmpenerima` WHERE `NamaPenerima` = '" + JCPenerima.getSelectedItem() + "'");
        ArrayList<String> list2 = dRunSelctOne.excute();
        hashs.put("Title", "PURCHASE REQUEST");
        hashs.put("PrintedBy", "Di Print Oleh " + GlobalVar.VarL.username + " Pada " + FDateF.datetostr(new Date(), "dd/MM/yyyy HH:mm"));
        hashs.put("NoPR", JTNomorPurchaseRequest.getText());
        hashs.put("Tanggal", FDateF.datetostr(JDTanggal.getDate(), "dd/MM/yyyy HH:mm"));
        hashs.put("Vendor", JCVendor.getSelectedItem());
        hashs.put("HPVendor", list.get(0));
        hashs.put("Penerima", JCPenerima.getSelectedItem());
        hashs.put("HPPenerima", list2.get(0));
        hashs.put("Keterangan", JTAKeterangan.getText());
        hashs.put("Terbilang", " # " + angkaToTerbilang(getGrandTotal()) + " RUPIAH # ");
        FLaporan fLaporan = new FLaporan();
        fLaporan.sethashmap(hashs);
        fLaporan.setfilename("PurchaseRequest");
        fLaporan.setErorm("Gagal Menampilkan Laporan " + this.getTitle());
        fLaporan.excute();
        History.simpanhistory(GlobalVar.VarL.username, "PurchaseRequest");
    }

    public String GetNoPR() {
        NumberFormat nf = new DecimalFormat("0000");
        String NoTransaksi = null;
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `NoPR` FROM `tbproses` order by `NoPR` desc limit 1");
        try {
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                NoTransaksi = "0001" + "/PR/PLT/" + getRomawi(datetostr(new Date(), "MM")) + "/" + datetostr(new Date(), "yyyy");
            }
            while (rs.next()) {
                String autonumbers = rs.getString("NoPR");
                ////System.out.println(autonumbers);
                autonumbers = autonumbers.substring(0, 4);
                ////System.out.println(autonumbers);
                int p = 1 + parseInt(autonumbers);
                if (p != 99999) {
                    NoTransaksi = nf.format(p) + "/PR/PLT/" + getRomawi(datetostr(new Date(), "MM")) + "/" + datetostr(new Date(), "yyyy");
                } else if (p == 99999) {
                    p = 1;
                    NoTransaksi = nf.format(p) + "/PR/PLT/" + getRomawi(datetostr(new Date(), "MM")) + "/" + datetostr(new Date(), "yyyy");
                }
            }
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Generate NO Purchase Request");
        } finally {
            runSelct.closecon();
        }
        return NoTransaksi;
    }

    Long getGrandTotal() {
        int GrandTotal = 0;
        for (int x = 0; x < JTable.getRowCount(); x++) {
            GrandTotal = GrandTotal + (Integer.valueOf(JTable.getValueAt(x, 3).toString().replace(",", "")) * Integer.valueOf(JTable.getValueAt(x, 4).toString().replace(",", "")));
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
            model.addRow(new Object[]{JTable.getRowCount() + 1, JTNamaBarang.getText(), JTKategoriBarang.getText(), JTHarga.getText(), JTJumlah.getText()});
            JOptionPane.showMessageDialog(this, "Berhasil Tambah List");
            JTNamaBarang.requestFocus();
            RefreshTbl();
        }
    }

    void TambahData() {
        if (checkInput()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                // query insert luar table
                //query insert dalam table ( ketentuan Hasil Harus True Baru jalan
                //cek inset gagal / berhasil 
                // jalankan koding di if paling bawah
                if (Berhasil) {

                    Berhasil = multiInsert.Excute("INSERT INTO `tbproses`(`NoPR`, `Tanggal`, `IdVendor`, `IdPenerima`, `Keterangan`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),(SELECT `IdPenerima` FROM `tbmpenerima` WHERE `NamaPenerima` = '" + JCPenerima.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `tbprosesdetail`(`NoPR`, `NoColoum`, `IdBarang`, `Keterangan`, `Harga`, `Jumlah`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2) + "','" + JTable.getValueAt(i, 3).toString().replace(",", "") + "','" + JTable.getValueAt(i, 4) + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                //////System.out.println("Rollback");
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Purchase");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Purchase");
                multiInsert.Commit();
                multiInsert.closecon();
                RefreshAll();
                JTNomorPurchaseRequest.setText(GetNoPR());

                tambahtable.setEnabled(true);
            }
        }
    }

    void TambahDataKeluar() {
        if (checkInput()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                // query insert luar table
                //query insert dalam table ( ketentuan Hasil Harus True Baru jalan
                //cek inset gagal / berhasil 
                // jalankan koding di if paling bawah
                if (Berhasil) {
                    Berhasil = multiInsert.Excute("INSERT INTO `tbproses`(`NoPR`, `Tanggal`, `IdVendor`, `IdPenerima`, `Keterangan`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),(SELECT `IdPenerima` FROM `tbmpenerima` WHERE `NamaPenerima` = '" + JCPenerima.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `tbprosesdetail`(`NoPR`, `NoColoum`, `IdBarang`, `Keterangan`, `Harga`, `Jumlah`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2) + "','" + JTable.getValueAt(i, 3).toString().replace(",", "") + "','" + JTable.getValueAt(i, 4) + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                //////System.out.println("Rollback");
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Barang Masuk  ");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Barang Masuk  ");
                multiInsert.Commit();
                multiInsert.closecon();
                RefreshAll();
                GlobalVar.Var.tambahPurchaseRequest.dispose();
                GlobalVar.Var.tambahPurchaseRequest = null;
            }
        }
    }

    void TambahDataPrint() {
        if (checkInput()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                // query insert luar table
                //query insert dalam table ( ketentuan Hasil Harus True Baru jalan
                //cek inset gagal / berhasil 
                // jalankan koding di if paling bawah
                if (Berhasil) {

                    Berhasil = multiInsert.Excute("INSERT INTO `tbproses`(`NoPR`, `Tanggal`, `IdVendor`, `IdPenerima`, `Keterangan`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),(SELECT `IdPenerima` FROM `tbmpenerima` WHERE `NamaPenerima` = '" + JCPenerima.getSelectedItem() + "'),'" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `tbprosesdetail`(`NoPR`, `NoColoum`, `IdBarang`, `Keterangan`, `Harga`, `Jumlah`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2) + "','" + JTable.getValueAt(i, 3).toString().replace(",", "") + "','" + JTable.getValueAt(i, 4) + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                //////System.out.println("Rollback");
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Barang Masuk  ");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Barang Masuk  ");
                multiInsert.Commit();
                multiInsert.closecon();
                print();
                RefreshAll();
            }
        }
    }

    void UbahData() {
        if (checkUbah()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                // query insert luar table
                //query insert dalam table ( ketentuan Hasil Harus True Baru jalan
                //cek inset gagal / berhasil 
                // jalankan koding di if paling bawah
                if (Berhasil) {
                    Berhasil = multiInsert.Excute("UPDATE `tbproses` SET `NoPR`='" + JTNomorPurchaseRequest.getText() + "',`Tanggal`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`IdVendor`=(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),`IdPenerima`=(SELECT `IdPenerima` FROM `tbmpenerima` WHERE `NamaPenerima` = '" + JCPenerima.getSelectedItem() + "'),`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `NoPR` = '" + JTNomorPurchaseRequest.getText() + "'", null);
                    if (Berhasil) {
                        Berhasil = multiInsert.Excute("DELETE FROM `tbprosesdetail` WHERE `NoPR` = '" + JTNomorPurchaseRequest.getText() + "'", null);
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `tbprosesdetail`(`NoPR`, `NoColoum`, `IdBarang`, `Keterangan`, `Harga`, `Jumlah`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2) + "','" + JTable.getValueAt(i, 3).toString().replace(",", "") + "','" + JTable.getValueAt(i, 4) + "')", null);
                            }
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                //////System.out.println("Rollback");
                JOptionPane.showMessageDialog(this, "Gagal Ubah Data Barang Masuk");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Barang Masuk");
                multiInsert.Commit();
                multiInsert.closecon();
                GlobalVar.Var.editPurchaseRequest.dispose();
                GlobalVar.Var.editPurchaseRequest = null;
                RefreshAll();
            }
        }
    }

    void UbahDataPrint() {
        if (checkUbah()) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                // query insert luar table
                //query insert dalam table ( ketentuan Hasil Harus True Baru jalan
                //cek inset gagal / berhasil 
                // jalankan koding di if paling bawah
                if (Berhasil) {

                    Berhasil = multiInsert.Excute("UPDATE `tbproses` SET `NoPR`='" + JTNomorPurchaseRequest.getText() + "',`Tanggal`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`IdVendor`=(SELECT `IdVendor` FROM `tbmvendor` WHERE `NamaVendor` = '" + JCVendor.getSelectedItem() + "'),`IdPenerima`=(SELECT `IdPenerima` FROM `tbmpenerima` WHERE `NamaPenerima` = '" + JCPenerima.getSelectedItem() + "'),`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `NoPR` = '" + JTNomorPurchaseRequest.getText() + "'", null);
                    if (Berhasil) {
                        Berhasil = multiInsert.Excute("DELETE FROM `tbprosesdetail` WHERE `NoPR` = '" + JTNomorPurchaseRequest.getText() + "'", null);
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `tbprosesdetail`(`NoPR`, `NoColoum`, `IdBarang`, `Keterangan`, `Harga`, `Jumlah`) VALUES ('" + JTNomorPurchaseRequest.getText() + "','" + JTable.getValueAt(i, 0) + "',(SELECT `IdBarang` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2) + "','" + JTable.getValueAt(i, 3).toString().replace(",", "") + "','" + JTable.getValueAt(i, 4) + "')", null);
                            }
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                //////System.out.println("Rollback");
                JOptionPane.showMessageDialog(this, "Gagal Ubah Data Barang Masuk");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Barang Masuk");
                multiInsert.Commit();
                multiInsert.closecon();
                print();
                GlobalVar.Var.editPurchaseRequest.dispose();
                GlobalVar.Var.editPurchaseRequest = null;
                RefreshAll();
            }
        }
    }

    /*void setsatuanstok(){
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Gagal Memanggil Kode Barang");
        dRunSelctOne.setQuery("SELECT `IdBarang`, `Satuan` FROM `tbmbarang` WHERE `NamaBarang` = '" + JTBarang.getText() + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JTHarga.setText(list.get(1));
        dRunSelctOne.seterorm("Eror gagal Menampilkan Data Stock");
        dRunSelctOne.setQuery("SELECT SUM(ifnull(Stock,0)) FROM ((SELECT sum(`Jumlah`) as 'Stock' FROM `tbprosesindetail` WHERE `IdBarang` = '" + list.get(0) +"') UNION ALL (SELECT sum(`Jumlah`)*-1 as 'Stock' FROM `tbprosesoutdetail` WHERE `IdBarang` = '" + list.get(0) +"') UNION ALL   (SELECT  sum(`Penyesuaian`) as 'Stock' FROM `tbpenyesuaian` WHERE  `IdBarang` = '" + list.get(0) +"')) t1");
        ArrayList<String> list2 = dRunSelctOne.excute();
        JTStok.setText(list2.get(0));
   }*/
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
            JTable.setValueAt(JTNamaBarang.getText(), JTable.getSelectedRow(), 1);
            JTable.setValueAt(JTKategoriBarang.getText(), JTable.getSelectedRow(), 2);
            JTable.setValueAt(JTHarga.getText(), JTable.getSelectedRow(), 3);
            JTable.setValueAt(JTJumlah.getText(), JTable.getSelectedRow(), 4);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah List");
            RefreshTbl();
            tambahtable.setEnabled(true);

            JTNamaBarang.requestFocus();
        }
    }

    boolean cekdoubleitem(String item) {
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (item.equals(JTable.getValueAt(i, 2))) {
                return true;
            }
        }
        return false;
    }

}
