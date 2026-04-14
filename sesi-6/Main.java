import java.util.Scanner;
import laptop.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Laptop laptop;

        System.out.println("Pilih Laptop:");
        System.out.println("1. Toshiba");
        System.out.println("2. MacBook");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            laptop = new Toshiba();
        } else {
            laptop = new MacBook();
        }

        LaptopUser user = new LaptopUser(laptop) {};

        String aksi;
        do {
            System.out.println("\nKetik perintah: ON | OFF | UP | DOWN | EXIT");
            System.out.print("Input: ");
            aksi = input.nextLine().toUpperCase();

            switch (aksi) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                case "OFF":
                    user.turnOffLaptop();
                    break;
                case "UP":
                    user.makeLaptopLouder();
                    break;
                case "DOWN":
                    user.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenal!");
            }

        } while (!aksi.equals("EXIT"));

        input.close();
    }
}