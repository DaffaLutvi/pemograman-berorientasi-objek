public class MahasiswaKu {
    public static void main(String[] args) {
        Mahasiswa<String, String, Integer> m = new Mahasiswa<>();
        m.setNim("1102020");
        m.setName("Ferdi");
        m.setClas(21);

        System.out.println(m.getNim());   // 1102020
        System.out.println(m.getName());  // Ferdi
        System.out.println(m.getClas());  // 21
    }
}