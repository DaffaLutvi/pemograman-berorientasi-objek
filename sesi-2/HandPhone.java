public class HandPhone { // Perbaikan: Menggunakan kurung kurawal '{' bukan '('

    // Deklarasi atribut
    String jenis_hp;
    int tahun_pembuatan;

    // Perbaikan: Urutan 'public void', parameter yang benar, dan penggunaan 'this'
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;             // Mengisi variabel class dengan parameter
        this.tahun_pembuatan = tahun_pembuatan; // Mengisi variabel class dengan parameter
    }

    // Perbaikan: Menambahkan tipe return 'String' dan return statement
    public String getJenisHP() {
        return jenis_hp;
    }

    // Perbaikan: Menambahkan tipe return 'int' (sesuai variabel) dan return statement
    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    // Perbaikan: Syntax main method 'public static void main'
    public static void main(String[] args) {
        // Perbaikan: Menambahkan '=' untuk inisialisasi objek
        HandPhone hp = new HandPhone();

        // Perbaikan: Memberikan nilai konkret (String dan int) saat memanggil method
        hp.setDataHP("Samsung", 2023);

        // Perbaikan: Menambahkan System.out.println untuk melihat hasil
        System.out.println(hp.getJenisHP());
        System.out.println(hp.getTahunPembuatan());
    }
}