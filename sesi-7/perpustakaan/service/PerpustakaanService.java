package service;

import collection.Katalog;
import interfaces.DapatDipinjam;
import model.Buku;
import model.Item;
import model.Majalah;
import java.util.ArrayDeque;

public class PerpustakaanService {
    private Katalog<Buku>    katalogBuku;
    private Katalog<Majalah> katalogMajalah;
    private ArrayDeque<String> logAktivitas;   // riwayat aksi (Queue)

    public PerpustakaanService() {
        katalogBuku    = new Katalog<>("Katalog Buku");
        katalogMajalah = new Katalog<>("Katalog Majalah");
        logAktivitas   = new ArrayDeque<>();
    }

    public void tambahBuku(Buku b) {
        katalogBuku.tambah(b);
        logAktivitas.offer("TAMBAH BUKU: " + b.getJudul());
    }

    public void tambahMajalah(Majalah m) {
        katalogMajalah.tambah(m);
        logAktivitas.offer("TAMBAH MAJALAH: " + m.getJudul());
    }

    // Polimorfisme — menerima semua Item yang DapatDipinjam
    public void pinjamItem(Item item, String namaPeminjam) {
        if (item instanceof DapatDipinjam dp) {
            dp.pinjam(namaPeminjam);
            logAktivitas.offer("PINJAM: " + item.getJudul() + " → " + namaPeminjam);
        }
    }

    public void kembalikanItem(Item item) {
        if (item instanceof DapatDipinjam dp) {
            dp.kembalikan();
            logAktivitas.offer("KEMBALI: " + item.getJudul());
        }
    }

    public Buku cariBuku(String id) {
        return katalogBuku.cariById(id);
    }

    public Majalah cariMajalah(String id) {
        return katalogMajalah.cariById(id);
    }

    public void tampilSemuaKatalog() {
        katalogBuku.tampilSemua();
        katalogMajalah.tampilSemua();
    }

    public void tampilLog() {
        System.out.println("\n══════════ Log Aktivitas ══════════");
        if (logAktivitas.isEmpty()) {
            System.out.println("  (Belum ada aktivitas)");
            return;
        }
        int no = 1;
        for (String log : logAktivitas) {
            System.out.println("  " + no++ + ". " + log);
        }
    }
}