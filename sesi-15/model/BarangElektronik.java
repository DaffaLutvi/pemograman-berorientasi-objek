package model;

public class BarangElektronik extends Aset {

    public BarangElektronik(String idAset, String namaAset, String statusPinjam) {
        super(idAset, namaAset, statusPinjam);
    }

    @Override
    public String dapatkanAturanPeminjaman() {
        return "Barang elektronik wajib dikembalikan ke Tata Usaha maksimal 1x24 Jam.";
    }
}