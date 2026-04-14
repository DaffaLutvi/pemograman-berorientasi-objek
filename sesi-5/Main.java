import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Object
        Mahasiswa mhs = new Mahasiswa();
        Dosen dosen = new Dosen();
        MataKuliah mk = new MataKuliah();

        // Input Mahasiswa
        System.out.print("Nama Mahasiswa: ");
        mhs.setNama(input.nextLine());

        System.out.print("NIM Mahasiswa: ");
        mhs.setNim(input.nextLine());

        // Input Dosen
        System.out.print("Nama Dosen: ");
        dosen.setNama(input.nextLine());

        System.out.print("NIP Dosen: ");
        dosen.setNip(input.nextLine());

        // Input Mata Kuliah
        System.out.print("Nama Mata Kuliah: ");
        mk.setNamaMK(input.nextLine());

        System.out.print("Jumlah SKS: ");
        mk.setSks(input.nextInt());

        // Output
        System.out.println("\n=== DATA AKADEMIK ===");
        System.out.println("Mahasiswa: " + mhs.getNama() + " (" + mhs.getNim() + ")");
        System.out.println("Dosen: " + dosen.getNama() + " (" + dosen.getNip() + ")");
        System.out.println("Mata Kuliah: " + mk.getNamaMK() + " - " + mk.getSks() + " SKS");
    }
}