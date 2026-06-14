import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "D:\\new_students.csv";
        Scanner scanner = new Scanner(System.in);

        // Menggunakan append mode (true) agar data baru tidak menghapus data lama
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            System.out.println("--- Input Data Mahasiswa Baru ---");
            
            System.out.print("Masukkan NIM   : ");
            String nim = scanner.nextLine();
            
            System.out.print("Masukkan Nama  : ");
            String nama = scanner.nextLine();
            
            System.out.print("Masukkan Umur  : ");
            String umur = scanner.nextLine();
            
            System.out.print("Masukkan Prodi : ");
            String prodi = scanner.nextLine();

            // Gabungkan menjadi format CSV
            String line = nim + ", " + nama + ", " + umur + ", " + prodi;

            // Tulis ke file
            bw.write(line);
            bw.newLine();
            
            System.out.println("Data berhasil ditambahkan ke " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}