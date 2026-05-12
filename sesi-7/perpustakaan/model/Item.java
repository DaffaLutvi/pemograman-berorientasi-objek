package model;

public abstract class Item {
    private String id;
    private String judul;
    private int tahun;

    public Item(String id, String judul, int tahun) {
        this.id    = id;
        this.judul = judul;
        this.tahun = tahun;
    }

    // Getters & Setters
    public String getId()        { return id; }
    public String getJudul()     { return judul; }
    public int getTahun()        { return tahun; }
    public void setJudul(String judul) { this.judul = judul; }

    // Abstract method → Polimorfisme
    public abstract String getInfo();

    @Override
    public String toString() { return getInfo(); }
}