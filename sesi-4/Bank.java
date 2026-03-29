class Bank {

    // 1. Transfer ke rekening lain
    void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer sebesar " + jumlah + 
        " ke rekening " + rekeningTujuan);
    }

    // 2. Transfer ke bank lain
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer sebesar " + jumlah + 
        " ke rekening " + rekeningTujuan + 
        " di bank " + bankTujuan);
    }

    // 3. Transfer dengan berita
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer sebesar " + jumlah + 
        " ke rekening " + rekeningTujuan + 
        " di bank " + bankTujuan + 
        " dengan berita: " + berita);
    }

    // Method suku bunga
    void sukuBunga() {
        System.out.println("Suku bunga standar adalah 3%");
    }
}