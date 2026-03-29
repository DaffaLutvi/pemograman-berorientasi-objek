import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;

    void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM   : ");
        nim = input.nextLine();
        System.out.print("Masukkan Nama  : ");
        nama = input.nextLine();
    }
}

class NilaiMahasiswa extends Mahasiswa {
    int nilai;
    char grade;
    String status;

    void inputNilai() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nilai : ");
        nilai = input.nextInt();
    }

    void hitungGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = 'A';
            status = "Lulus";
        } else if (nilai >= 70) {
            grade = 'B';
            status = "Lulus";
        } else if (nilai >= 60) {
            grade = 'C';
            status = "Lulus";
        } else if (nilai >= 50) {
            grade = 'D';
            status = "Tidak Lulus";
        } else if (nilai >= 0) {
            grade = 'E';
            status = "Tidak Lulus";
        } else {
            System.out.println("Input nilai anda salah!");
            grade = '-';
            status = "-";
        }
    }

    void tampilData() {
        System.out.println("\n===== HASIL DATA MAHASISWA =====");
        System.out.println("NIM    : " + nim);
        System.out.println("Nama   : " + nama);
        System.out.println("Nilai  : " + nilai);
        System.out.println("Grade  : " + grade);
        System.out.println("Status : " + status);
    }
}

public class Main {
    public static void main(String[] args) {
        NilaiMahasiswa mhs = new NilaiMahasiswa();

        mhs.inputData();
        mhs.inputNilai();
        mhs.hitungGrade();
        mhs.tampilData();
    }
}