/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class koneksi {
    Connection koneksi = null;
    public static Connection koneksiDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan","root","");
            return koneksi;
        }catch(ClassNotFoundException | SQLException e){
           JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }
}
