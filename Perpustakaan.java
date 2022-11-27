/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import java.sql.Connection;
/**
 *
 * @author Lenovo
 */
public class Perpustakaan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = koneksi.koneksiDB();
        daftarBuku daftar = new daftarBuku();
        daftar.setVisible(true);
    }
    
}
