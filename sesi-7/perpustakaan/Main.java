import model.Buku;
import model.Majalah;
import service.PerpustakaanService;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   SISTEM PERPUSTAKAAN SEDERHANA      ║");
        System.out.println("╚══════════════════════════════════════╝");

        PerpustakaanService ps = new PerpustakaanService();

        // Tambah buku
        System.out.println("\n--- Menambah Data ---");
        ps.tambahBuku(new Buku("B001", "Clean Code",            "Robert C. Martin", 2008));
        ps.tambahBuku(new Buku("B002", "The Pragmatic Programmer","Dave Thomas",     2019));
        ps.tambahBuku(new Buku("B003", "Design Patterns",       "Gang of Four",     1994));

        // Tambah majalah
        ps.tambahMajalah(new Majalah("M001", "National Geographic", 245, 2024));
        ps.tambahMajalah(new Majalah("M002", "Forbes Indonesia",    120, 2024));

        // Tampil katalog awal
        ps.tampilSemuaKatalog();

        // Proses peminjaman
        System.out.println("\n--- Proses Peminjaman ---");
        Buku b1 = ps.cariBuku("B001");
        Buku b2 = ps.cariBuku("B002");
        Majalah m1 = ps.cariMajalah("M001");

        ps.pinjamItem(b1, "Andi");
        ps.pinjamItem(b2, "Budi");
        ps.pinjamItem(m1, "Citra");
        ps.pinjamItem(b1, "Dina"); // coba pinjam yang sudah dipinjam

        // Tampil katalog setelah dipinjam
        ps.tampilSemuaKatalog();

        // Pengembalian
        System.out.println("\n--- Proses Pengembalian ---");
        ps.kembalikanItem(b1);
        ps.pinjamItem(b1, "Dina"); // sekarang bisa dipinjam

        // Tampil akhir & log
        ps.tampilSemuaKatalog();
        ps.tampilLog();
    }
}