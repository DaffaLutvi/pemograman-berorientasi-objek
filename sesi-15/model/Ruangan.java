package model;

// Inheritance: Mewarisi class Aset
public class Ruangan extends Aset {
    
    public Ruangan(String idAset, String namaAset, String statusPinjam) {
        super(idAset, namaAset, statusPinjam);
    }

    // Polymorphism: Override method dari superclass
    @Override
    public String dapatkanAturanPeminjaman() {
        return "Ruangan kampus hanya dapat dipinjam maksimal hingga pukul 17:00 WIB.";
    }
}