/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class daftarBuku extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    void SearchByJenis(String jenis){
        DefaultTableModel model = (DefaultTableModel)Tabel_cari.getModel();
        int row = model.getRowCount();
        for(int i = 0; i<row;i++){
            model.removeRow(0);
        }
        if(tf_jenisBuku.getText().equals("")){
           SearchByName(tf_NamaBuku.getText());
        }else{
            SearchByName(tf_NamaBuku.getText());
            try{
                String sql = "select * from buku  where jenis_buku ='"+jenis+"' order by total_pinjam desc";
                Class.forName("com.mysql.jdbc.Driver");
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan","root","");
                Statement st = koneksi.createStatement();
                ResultSet res = st.executeQuery(sql);

                while(res.next()){
                    String id_buku = res.getString("id_buku");
                    String nama_buku = res.getString("nama_buku");
                    String  jumlah_buku= res.getString("jumlah_buku");
                    String jenis_buku = res.getString("jenis_buku");
                    String total = res.getString("total_pinjam");
                    String tbData[] = {id_buku,nama_buku,jumlah_buku,jenis_buku,total};
                 
                    model.addRow(tbData);
            } 
            }catch(ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
        }
        
    }
    
    void SearchByName(String NamaBuku){
        DefaultTableModel model = (DefaultTableModel)Tabel_cari.getModel();
        int row = model.getRowCount();
        for(int i = 0; i<row;i++){
            model.removeRow(0);
        }
        if(NamaBuku != null ){
           try{
                String sql = "select * from buku where nama_buku ='"+NamaBuku+"' order by total_pinjam desc";
                Class.forName("com.mysql.jdbc.Driver");
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan","root","");
                Statement st = koneksi.createStatement();
                ResultSet res = st.executeQuery(sql);

                while(res.next()){
                    String id_buku = res.getString("id_buku");
                    String nama_buku = res.getString("nama_buku");
                    String  jumlah_buku= res.getString("jumlah_buku");
                    String jenis_buku = res.getString("jenis_buku");
                    String total = res.getString("total_pinjam");
                    String tbData[] = {id_buku,nama_buku,jumlah_buku,jenis_buku,total};
                    
                    model.addRow(tbData);
            } 
            }catch(ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                } 
        }
    }
    
    void tampilkanData(){
        DefaultTableModel model = (DefaultTableModel)Tabel_cari.getModel();
        int row = model.getRowCount();
        for(int i = 0; i<row;i++){
            model.removeRow(0);
        }
        try{
            String sql = "select * from buku order by total_pinjam desc ";
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan","root","");
            Statement st = koneksi.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                String id_buku = res.getString("id_buku");
                String nama_buku = res.getString("nama_buku");
                String  jumlah_buku= res.getString("jumlah_buku");
                String jenis_buku = res.getString("jenis_buku");
                String total = res.getString("total_pinjam");
                String tbData[] = {id_buku,nama_buku,jumlah_buku,jenis_buku,total};
                
                model.addRow(tbData);
            }  
         
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public daftarBuku() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setResizable(false);
        tampilkanData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_data_anggota = new javax.swing.JButton();
        btn_daftar_buku = new javax.swing.JButton();
        btn_pinjam = new javax.swing.JButton();
        btn_tambahBuku = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_jenisBuku = new javax.swing.JTextField();
        tf_NamaBuku = new javax.swing.JTextField();
        Cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_cari = new javax.swing.JTable();
        btn_toPinjam = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(95, 210, 195));

        jPanel4.setBackground(new java.awt.Color(34, 45, 65));

        jPanel5.setBackground(new java.awt.Color(95, 210, 195));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ayo Baca Buku");

        btn_data_anggota.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        btn_data_anggota.setText("Data anggota");
        btn_data_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_anggotaActionPerformed(evt);
            }
        });

        btn_daftar_buku.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        btn_daftar_buku.setText("Cari Buku");
        btn_daftar_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftar_bukuActionPerformed(evt);
            }
        });

        btn_pinjam.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        btn_pinjam.setText("Peminjaman");
        btn_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pinjamActionPerformed(evt);
            }
        });

        btn_tambahBuku.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        btn_tambahBuku.setText("Tambah Buku");
        btn_tambahBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(56, 56, 56))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_data_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_daftar_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tambahBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addGap(141, 141, 141)
                .addComponent(btn_daftar_buku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pinjam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_data_anggota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tambahBuku)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Daftar Buku Perpustakaan");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jenis Buku");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Buku");

        tf_jenisBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_jenisBukuActionPerformed(evt);
            }
        });

        tf_NamaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NamaBukuActionPerformed(evt);
            }
        });

        Cari.setText("Cari");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        Tabel_cari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Buku", "Nama buku", "Jumlah buku", "Jenis Buku", "total pinjam"
            }
        ));
        Tabel_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_cariMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel_cari);
        if (Tabel_cari.getColumnModel().getColumnCount() > 0) {
            Tabel_cari.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        btn_toPinjam.setText("pinjam");
        btn_toPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toPinjamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(145, 145, 145))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_toPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(24, 24, 24)
                                    .addComponent(tf_NamaBuku))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(27, 27, 27)
                                    .addComponent(tf_jenisBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_jenisBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_NamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cari)
                    .addComponent(btn_toPinjam))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        if(tf_jenisBuku.getText().equals("") && tf_NamaBuku.getText().equals("")){
            JOptionPane.showMessageDialog(null, "isi salah satu field di atas");
        } else {
           SearchByJenis(tf_jenisBuku.getText()); 
        }
    }//GEN-LAST:event_CariActionPerformed

    private void tf_NamaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NamaBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NamaBukuActionPerformed

    private void tf_jenisBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jenisBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jenisBukuActionPerformed

    private void btn_tambahBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahBukuActionPerformed
        TambahBuku tambah = new TambahBuku();
        tambah.setVisible(true);
        CloseFrame();
    }//GEN-LAST:event_btn_tambahBukuActionPerformed

    private void btn_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pinjamActionPerformed

        Peminjaman pinjam = new Peminjaman();
        pinjam.setVisible(true);
        CloseFrame();
        
    }//GEN-LAST:event_btn_pinjamActionPerformed

    private void btn_daftar_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftar_bukuActionPerformed
        daftarBuku daftar = new daftarBuku();
        daftar.setVisible(true);
        CloseFrame();
    }//GEN-LAST:event_btn_daftar_bukuActionPerformed

    private void btn_data_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_anggotaActionPerformed
        daftarAnggota anggota = new daftarAnggota();
        anggota.setVisible(true);
        CloseFrame();
    }//GEN-LAST:event_btn_data_anggotaActionPerformed

    private void btn_toPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toPinjamActionPerformed
        Peminjaman pinjam = new Peminjaman();
        String nama = tf_NamaBuku.getText();
        pinjam.setNama(nama);
        pinjam.setVisible(true);
    }//GEN-LAST:event_btn_toPinjamActionPerformed

    private void Tabel_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_cariMouseClicked
        DefaultTableModel model = (DefaultTableModel)Tabel_cari.getModel();
        int i = Tabel_cari.getSelectedRow();
        if(i>-1){
            tf_NamaBuku.setText(model.getValueAt(i, 1).toString());
        }
    }//GEN-LAST:event_Tabel_cariMouseClicked
    void CloseFrame(){
        super.dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(daftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftarBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cari;
    private javax.swing.JTable Tabel_cari;
    private javax.swing.JButton btn_daftar_buku;
    private javax.swing.JButton btn_data_anggota;
    private javax.swing.JButton btn_pinjam;
    private javax.swing.JButton btn_tambahBuku;
    private javax.swing.JButton btn_toPinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tf_NamaBuku;
    private javax.swing.JTextField tf_jenisBuku;
    // End of variables declaration//GEN-END:variables
}
