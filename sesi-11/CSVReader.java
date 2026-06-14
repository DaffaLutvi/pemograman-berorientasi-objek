import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        // Sesuaikan path file dengan direktori di komputer kamu
        String csvFile = "D:\\new_students.csv"; 
        String line;
        String csvSplitBy = ",";
        int indeks = 0;

        System.out.println("NIM, NAMA, UMUR, PRODI");
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                indeks++;
                
                // Lewati baris pertama (header) saat menampilkan data individu
                if (indeks > 1) {
                    String[] student = line.split(csvSplitBy);
                    // Menampilkan data agar rapi menggunakan format string
                    System.out.println(student[0].trim() + ", " + 
                                       student[1].trim() + ", " + 
                                       student[2].trim() + ", " + 
                                       student[3].trim());
                }
            }
            
            // Menampilkan jumlah baris data (tidak menghitung header)
            System.out.println("\n---------------------------------");
            System.out.println("Total baris data mahasiswa: " + (indeks - 1));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}