import java.sql.*;
import java.util.Scanner;

public class AppToko {
    // Konfigurasi Database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/toko_retail";
    static final String USER = "root";
    static final String PASS = ""; // Sesuaikan jika ada password di XAMPP

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("       MENU TOKO RETAIL       ");
            System.out.println("==============================");
            System.out.println("1. Tampil Semua Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Hapus Data");
            System.out.println("0. Keluar");
            System.out.println("==============================");
            System.out.print("Pilihan : ");
            
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1": tampilData(); break;
                case "2": tambahData(); break;
                case "3": cariData(); break;
                case "4": ubahData(); break;
                case "5": hapusData(); break;
                case "0": 
                    System.out.println("Keluar dari program. Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static Connection connectDB() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private static void tampilData() {
        String sql = "SELECT * FROM tbl_barang";
        try (Connection conn = connectDB();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n========================================================");
            System.out.println("               DAFTAR BARANG TOKO RETAIL                ");
            System.out.println("========================================================");
            System.out.printf("| %-2s | %-6s | %-20s | %-7s | %-4s |\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
            System.out.println("--------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                count++;
                // Sesuaikan dengan nama kolom di phpMyAdmin
                System.out.printf("| %-2d | %-6s | %-20s | %-7d | %-4d |\n",
                        count,
                        rs.getString("kode_barang"), 
                        rs.getString("nama_barang"),
                        rs.getInt("harga_barang"), 
                        rs.getInt("stok_barang")); 
            }
            System.out.println("========================================================");
            System.out.println("Total: " + count + " barang\n");

        } catch (SQLException e) {
            System.out.println("Error tampil data: " + e.getMessage());
        }
    }

    private static void tambahData() {
        System.out.println("\n--- Tambah Data Barang ---");
        System.out.print("Masukkan Kode: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan Stok: ");
        int stok = Integer.parseInt(scanner.nextLine());

        // Sesuaikan kolom INSERT
        String sql = "INSERT INTO tbl_barang (kode_barang, nama_barang, harga_barang, stok_barang) VALUES (?, ?, ?, ?)";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kode);
            pstmt.setString(2, nama);
            pstmt.setInt(3, harga);
            pstmt.setInt(4, stok);
            pstmt.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");

        } catch (SQLException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }
    }

    private static void cariData() {
        System.out.print("\nMasukkan Kode atau Nama Barang yang dicari: ");
        String keyword = scanner.nextLine();

        // Sesuaikan parameter pencarian WHERE
        String sql = "SELECT * FROM tbl_barang WHERE kode_barang LIKE ? OR nama_barang LIKE ?";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n--------------------------------------------------------");
            System.out.println("                    HASIL PENCARIAN                     ");
            System.out.println("--------------------------------------------------------");
            
            boolean found = false;
            while (rs.next()) {
                found = true;
                // Sesuaikan pengambilan data
                System.out.printf("Kode: %s, Nama: %s, Harga: %d, Stok: %d\n",
                        rs.getString("kode_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga_barang"),
                        rs.getInt("stok_barang"));
            }
            if (!found) {
                System.out.println("Barang tidak ditemukan.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error cari data: " + e.getMessage());
        }
    }

    private static void ubahData() {
        System.out.print("\nMasukkan Kode Barang yang ingin diubah: ");
        String kode = scanner.nextLine();

        System.out.println("Masukkan data baru (tekan Enter untuk melewati jika tidak ingin diubah):");
        System.out.print("Nama Barang Baru: ");
        String nama = scanner.nextLine();
        System.out.print("Harga Baru: ");
        String hargaStr = scanner.nextLine();
        System.out.print("Stok Baru: ");
        String stokStr = scanner.nextLine();

        try (Connection conn = connectDB()) {
            if (!nama.isEmpty()) {
                PreparedStatement ps = conn.prepareStatement("UPDATE tbl_barang SET nama_barang = ? WHERE kode_barang = ?");
                ps.setString(1, nama);
                ps.setString(2, kode);
                ps.executeUpdate();
            }
            if (!hargaStr.isEmpty()) {
                PreparedStatement ps = conn.prepareStatement("UPDATE tbl_barang SET harga_barang = ? WHERE kode_barang = ?");
                ps.setInt(1, Integer.parseInt(hargaStr));
                ps.setString(2, kode);
                ps.executeUpdate();
            }
            if (!stokStr.isEmpty()) {
                PreparedStatement ps = conn.prepareStatement("UPDATE tbl_barang SET stok_barang = ? WHERE kode_barang = ?");
                ps.setInt(1, Integer.parseInt(stokStr));
                ps.setString(2, kode);
                ps.executeUpdate();
            }
            System.out.println("Proses ubah data selesai!");
        } catch (SQLException e) {
            System.out.println("Error ubah data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format angka salah. Batal mengubah harga/stok.");
        }
    }

    private static void hapusData() {
        System.out.print("\nMasukkan Kode Barang yang ingin dihapus: ");
        String kode = scanner.nextLine();

        // Sesuaikan kolom WHERE
        String sql = "DELETE FROM tbl_barang WHERE kode_barang = ?";
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kode);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus!");
            } else {
                System.out.println("Barang tidak ditemukan!");
            }
            
        } catch (SQLException e) {
            System.out.println("Error hapus data: " + e.getMessage());
        }
    }
}