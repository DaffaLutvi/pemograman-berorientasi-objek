package model;

import interfaces.DapatDipinjam;

public class Majalah extends Item implements DapatDipinjam {
    private int edisi;
    private boolean tersedia;
    private String peminjam;

    public Majalah(String id, String judul, int edisi, int tahun) {
        super(id, judul, tahun);
        this.edisi    = edisi;
        this.tersedia = true;
    }

    public int getEdisi() { return edisi; }

    @Override
    public String getInfo() {
        return String.format("[MAJALAH] ID:%-4s | %-30s | Edisi: %-5d | Tahun: %d | %s",
            getId(), getJudul(), edisi, getTahun(),
            tersedia ? "Tersedia" : "Dipinjam oleh: " + peminjam);
    }

    @Override
    public void pinjam(String namaPeminjam) {
        if (!tersedia) {
            System.out.println("Majalah '" + getJudul() + "' sedang dipinjam.");
            return;
        }
        tersedia = false;
        peminjam = namaPeminjam;
        System.out.println("✓ Majalah '" + getJudul() + "' berhasil dipinjam oleh " + namaPeminjam);
    }

    @Override
    public void kembalikan() {
        System.out.println("✓ Majalah '" + getJudul() + "' dikembalikan oleh " + peminjam);
        tersedia = true;
        peminjam = null;
    }

    @Override
    public boolean isTersedia() { return tersedia; }
}