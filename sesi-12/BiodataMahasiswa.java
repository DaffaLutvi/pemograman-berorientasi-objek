import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiodataMahasiswa extends JFrame {

    // Deklarasi Komponen
    private JTextField txtNim, txtNama, txtProdi;
    private JTextArea txtOutput;
    private JButton btnTampilkan, btnReset;

    public BiodataMahasiswa() {
        // 1. Pengaturan Dasar Frame
        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Membuat jendela tampil di tengah layar
        setLayout(new BorderLayout(10, 10));

        // 2. Panel Input Data (Atas)
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data"));

        panelInput.add(new JLabel("NIM"));
        txtNim = new JTextField();
        panelInput.add(txtNim);

        panelInput.add(new JLabel("Nama"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Program Studi"));
        txtProdi = new JTextField();
        panelInput.add(txtProdi);

        // 3. Panel Tombol (Tengah)
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnTampilkan = new JButton("Tampilkan");
        btnReset = new JButton("Reset");
        
        panelTombol.add(btnTampilkan);
        panelTombol.add(btnReset);

        // 4. Panel Output (Bawah)
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBorder(BorderFactory.createTitledBorder("Output"));
        
        txtOutput = new JTextArea();
        txtOutput.setEditable(false); // Agar text area tidak bisa diedit manual oleh user
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Menggunakan font monospaced agar titik dua rata
        
        // Menambahkan scroll bar jika teks terlalu panjang
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        // Menggabungkan Panel Input dan Tombol di satu tempat
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // Menambahkan seluruh panel ke Frame Utama
        add(panelAtas, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        // 5. Event Listener untuk Tombol Tampilkan
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil nilai dari text field
                String nim = txtNim.getText();
                String nama = txtNama.getText();
                String prodi = txtProdi.getText();

                // Menyusun format output
                String hasil = "========== BIODATA MAHASISWA ==========\n\n" +
                               "NIM           : " + nim + "\n" +
                               "Nama          : " + nama + "\n" +
                               "Program Studi : " + prodi + "\n";
                
                // Menampilkan ke JTextArea
                txtOutput.setText(hasil);
            }
        });

        // 6. Event Listener untuk Tombol Reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengosongkan text field dan text area
                txtNim.setText("");
                txtNama.setText("");
                txtProdi.setText("");
                txtOutput.setText("");
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BiodataMahasiswa().setVisible(true);
            }
        });
    }
}