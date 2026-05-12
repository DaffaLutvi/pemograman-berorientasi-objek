package model;

import interfaces.DapatDipinjam;

public class Buku extends Item implements DapatDipinjam {
    private String penulis;
    private boolean tersedia;
    private String peminjam;

    public Buku(String id, String judul, String penulis, int tahun) {
        super(id, judul, tahun);
        this.penulis  = penulis;
        this.tersedia = true;
    }

    public String getPenulis() { return penulis; }

    @Override
    public String getInfo() {
        return String.format("[BUKU] ID:%-6s | %-30s | Penulis: %-15s | Tahun: %d | %s",
            getId(), getJudul(), penulis, getTahun(),
            tersedia ? "Tersedia" : "Dipinjam oleh: " + peminjam);
    }

    @Override
    public void pinjam(String namaPeminjam) {
        if (!tersedia) {
            System.out.println("Buku '" + getJudul() + "' sedang dipinjam oleh " + peminjam);
            return;
        }
        tersedia = false;
        peminjam = namaPeminjam;
        System.out.println("✓ Buku '" + getJudul() + "' berhasil dipinjam oleh " + namaPeminjam);
    }

    @Override
    public void kembalikan() {
        System.out.println("✓ Buku '" + getJudul() + "' dikembalikan oleh " + peminjam);
        tersedia = true;
        peminjam = null;
    }

    @Override
    public boolean isTersedia() { return tersedia; }
}