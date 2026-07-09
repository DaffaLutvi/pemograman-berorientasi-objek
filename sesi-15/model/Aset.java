package model;

public abstract class Aset {
    // Encapsulation: Menggunakan private modifier
    private String idAset;
    private String namaAset;
    private String statusPinjam;

    public Aset(String idAset, String namaAset, String statusPinjam) {
        this.idAset = idAset;
        this.namaAset = namaAset;
        this.statusPinjam = statusPinjam;
    }

    // Getter dan Setter
    public String getIdAset() { return idAset; }
    public String getNamaAset() { return namaAset; }
    public String getStatusPinjam() { return statusPinjam; }
    public void setStatusPinjam(String statusPinjam) { this.statusPinjam = statusPinjam; }

    // Polymorphism: Method abstrak yang akan di-override subclass
    public abstract String dapatkanAturanPeminjaman(); 
}