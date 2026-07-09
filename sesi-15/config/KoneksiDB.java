package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_assetbooking";
                String user = "root"; // Sesuaikan dengan user XAMPP/MySQL kamu
                String password = ""; // Sesuaikan jika ada password
                
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Database Berhasil!");
            } catch (SQLException e) {
                System.out.println("Koneksi Gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
}