package view;

import config.KoneksiDB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class KelolaAsetFrame extends JFrame {
    private JTextField txtIdAset, txtNamaAset;
    private JComboBox<String> cbKategori, cbStatus;
    private JTable tabelAset;
    private DefaultTableModel model;
    private JButton btnTambah, btnUbah, btnHapus, btnClear;

    public KelolaAsetFrame() {
        // Penamaan judul aplikasi disesuaikan dengan konteks program studi
        setTitle("Kelola Aset - Teknik Informatika Nusa Putra");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // === PANEL INPUT (Utara) ===
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("ID Aset (ex: R001/E001):"));
        txtIdAset = new JTextField();
        panelInput.add(txtIdAset);

        panelInput.add(new JLabel("Nama Aset:"));
        txtNamaAset = new JTextField();
        panelInput.add(txtNamaAset);

        panelInput.add(new JLabel("Kategori:"));
        cbKategori = new JComboBox<>(new String[]{"Ruangan", "Elektronik"});
        panelInput.add(cbKategori);

        panelInput.add(new JLabel("Status Pinjam:"));
        cbStatus = new JComboBox<>(new String[]{"Tersedia", "Dipinjam"});
        panelInput.add(cbStatus);

        add(panelInput, BorderLayout.NORTH);

        // === PANEL TOMBOL (Tengah - Atas) ===
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnTambah = new JButton("Tambah (Create)");
        btnUbah = new JButton("Ubah (Update)");
        btnHapus = new JButton("Hapus (Delete)");
        btnClear = new JButton("Bersihkan Form");

        panelTombol.add(btnTambah);
        panelTombol.add(btnUbah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        // === PANEL TABEL (Tengah) ===
        model = new DefaultTableModel(new String[]{"ID Aset", "Nama Aset", "Kategori", "Status"}, 0);
        tabelAset = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelAset);
        
        // Menggabungkan panel tombol dan tabel
        JPanel panelCenter = new JPanel(new BorderLayout());
        panelCenter.add(panelTombol, BorderLayout.NORTH);
        panelCenter.add(scrollPane, BorderLayout.CENTER);
        
        add(panelCenter, BorderLayout.CENTER);

        // === EVENT LISTENERS (Aksi CRUD) ===
        
        // 1. READ: Tampilkan data ke tabel
        loadDataAset();

        // Menampilkan data ke form saat baris tabel diklik
        tabelAset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tabelAset.getSelectedRow();
                if (baris != -1) {
                    txtIdAset.setText(model.getValueAt(baris, 0).toString());
                    txtIdAset.setEditable(false); // ID tidak boleh diubah saat update
                    txtNamaAset.setText(model.getValueAt(baris, 1).toString());
                    cbKategori.setSelectedItem(model.getValueAt(baris, 2).toString());
                    cbStatus.setSelectedItem(model.getValueAt(baris, 3).toString());
                }
            }
        });

        // 2. CREATE: Menambah data baru
        btnTambah.addActionListener(e -> {
            try {
                Connection conn = KoneksiDB.getKoneksi();
                String sql = "INSERT INTO tb_aset (id_aset, nama_aset, kategori, status_pinjam) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, txtIdAset.getText());
                pst.setString(2, txtNamaAset.getText());
                pst.setString(3, cbKategori.getSelectedItem().toString());
                pst.setString(4, cbStatus.getSelectedItem().toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
                clearForm();
                loadDataAset();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Gagal menambah data: " + ex.getMessage());
            }
        });

        // 3. UPDATE: Mengubah data
        btnUbah.addActionListener(e -> {
            try {
                Connection conn = KoneksiDB.getKoneksi();
                String sql = "UPDATE tb_aset SET nama_aset=?, kategori=?, status_pinjam=? WHERE id_aset=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, txtNamaAset.getText());
                pst.setString(2, cbKategori.getSelectedItem().toString());
                pst.setString(3, cbStatus.getSelectedItem().toString());
                pst.setString(4, txtIdAset.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil diubah!");
                clearForm();
                loadDataAset();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + ex.getMessage());
            }
        });

        // 4. DELETE: Menghapus data
        btnHapus.addActionListener(e -> {
            int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus aset ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (konfirmasi == JOptionPane.YES_OPTION) {
                try {
                    Connection conn = KoneksiDB.getKoneksi();
                    String sql = "DELETE FROM tb_aset WHERE id_aset=?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, txtIdAset.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                    clearForm();
                    loadDataAset();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + ex.getMessage());
                }
            }
        });

        // Tombol Bersihkan Form
        btnClear.addActionListener(e -> clearForm());
    }

    // Method untuk Load Data (Read)
    private void loadDataAset() {
        model.setRowCount(0); 
        try {
            Connection conn = KoneksiDB.getKoneksi();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_aset");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_aset"),
                    rs.getString("nama_aset"),
                    rs.getString("kategori"),
                    rs.getString("status_pinjam")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error memuat data: " + e.getMessage());
        }
    }

    // Method untuk mereset input form
    private void clearForm() {
        txtIdAset.setText("");
        txtIdAset.setEditable(true);
        txtNamaAset.setText("");
        cbKategori.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        // Jalankan aplikasi menggunakan Look and Feel bawaan sistem agar tampilannya rapi
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new KelolaAsetFrame().setVisible(true);
        });
    }
}