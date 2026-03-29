class BankBNI extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga BNI adalah 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BNI";
        System.out.println("Transfer sebesar " + jumlah + 
        " ke rekening " + rekeningTujuan + 
        " di bank " + bankTujuan);
    }
}