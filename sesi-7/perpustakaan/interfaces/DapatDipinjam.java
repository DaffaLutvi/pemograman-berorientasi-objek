package interfaces;

public interface DapatDipinjam {
    void pinjam(String namaPeminjam);
    void kembalikan();
    boolean isTersedia();
}