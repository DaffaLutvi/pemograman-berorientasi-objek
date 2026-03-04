import javax.swing.JOptionPane;

public class TugasDua {
    public static void main(String[] args) {
        String pelajaran = JOptionPane.showInputDialog(null, "Anda sedang belajar apa?");
        
        if (pelajaran != null) {
            String pesan = "Belajar " + pelajaran + " sangat mudah";
            JOptionPane.showMessageDialog(null, pesan);
        }
    }
}