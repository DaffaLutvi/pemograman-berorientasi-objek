package collection;

import model.Item;
import java.util.ArrayList;

// Generic class dengan bounded type parameter
public class Katalog<T extends Item> {
    private String namaKatalog;
    private ArrayList<T> daftarItem;

    public Katalog(String namaKatalog) {
        this.namaKatalog = namaKatalog;
        this.daftarItem  = new ArrayList<>();
    }

    public void tambah(T item) {
        daftarItem.add(item);
        System.out.println("+ Ditambahkan ke katalog: " + item.getJudul());
    }

    public void hapus(String id) {
        daftarItem.removeIf(item -> item.getId().equals(id));
    }

    public T cariById(String id) {
        for (T item : daftarItem) {
            if (item.getId().equals(id)) return item;
        }
        return null;
    }

    public void tampilSemua() {
        System.out.println("\n══════════ " + namaKatalog + " ══════════");
        if (daftarItem.isEmpty()) {
            System.out.println("  (Katalog kosong)");
            return;
        }
        for (T item : daftarItem) {
            System.out.println("  " + item.getInfo());
        }
    }

    public int jumlahItem() { return daftarItem.size(); }
    public ArrayList<T> getDaftarItem() { return daftarItem; }
}