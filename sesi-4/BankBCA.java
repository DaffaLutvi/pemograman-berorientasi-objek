class BankBCA extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga BCA adalah 4.5%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BCA";
        System.out.println("Transfer sebesar " + jumlah + 
        " ke rekening " + rekeningTujuan + 
        " di bank " + bankTujuan);
    }
}