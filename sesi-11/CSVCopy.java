import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopy {
    public static void main(String[] args) {
        String sourceFile = "D:\\new_students.csv.csv";
        String destFile = "D:\\students_backup.csv";

        System.out.println("Memulai proses penyalinan file...");

        // Membuka file source untuk dibaca dan file destination untuk ditulis
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {
            
            String line;
            int totalLines = 0;

            // Baca baris demi baris dari source, langsung tulis ke destination
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                totalLines++;
            }

            System.out.println("Salin data berhasil!");
            System.out.println("File sumber  : " + sourceFile);
            System.out.println("File tujuan  : " + destFile);
            System.out.println("Total baris yang disalin: " + totalLines);

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyalin file.");
            e.printStackTrace();
        }
    }
}