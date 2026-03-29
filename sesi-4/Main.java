public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        System.out.println("=== METHOD OVERLOADING ===");
        bank.transferUang(100000, "123456");
        bank.transferUang(200000, "123456", "Mandiri");
        bank.transferUang(300000, "123456", "BRI", "Bayar Utang");
        bank.sukuBunga();

        System.out.println("\n=== METHOD OVERRIDING ===");
        bni.transferUang(400000, "987654", "Apa saja");
        bni.sukuBunga();

        bca.transferUang(500000, "567890", "Apa saja");
        bca.sukuBunga();
    }
}