import java.util.ArrayList;
import java.util.ArrayDeque;

public class ContohCollection {
    public static void main(String[] args) {

        // ── ArrayList ──────────────────────────────────────
        System.out.println("=== ArrayList ===");
        ArrayList<String> listMhs = new ArrayList<>();
        listMhs.add("Andi");
        listMhs.add("Budi");
        listMhs.add("Citra");
        listMhs.add("Dewi");

        System.out.println("Semua mahasiswa : " + listMhs);
        System.out.println("Mahasiswa ke-2  : " + listMhs.get(1));

        listMhs.remove("Budi");
        System.out.println("Setelah hapus Budi: " + listMhs);
        System.out.println("Jumlah mahasiswa  : " + listMhs.size());

        // ── ArrayDeque ─────────────────────────────────────
        System.out.println("\n=== ArrayDeque ===");
        ArrayDeque<String> antrian = new ArrayDeque<>();
        antrian.offer("Mahasiswa A");   // enqueue (masuk antrian)
        antrian.offer("Mahasiswa B");
        antrian.offer("Mahasiswa C");

        System.out.println("Antrian    : " + antrian);
        System.out.println("Peek (peek tanpa hapus): " + antrian.peek());
        System.out.println("Poll (ambil + hapus)   : " + antrian.poll());
        System.out.println("Sisa antrian           : " + antrian);

        // Pakai sebagai Stack (LIFO)
        System.out.println("\n-- ArrayDeque sebagai Stack --");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack : " + stack);
        System.out.println("Pop   : " + stack.pop());
        System.out.println("Sisa  : " + stack);
    }
}