/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class Peminjaman extends javax.swing.JFrame {
     int id = 0;
     int jumlahBuku;
     String namaBuku;
     Connection con = koneksi.koneksiDB();
    /**
     * Creates new form Peminjaman
     */
    void setNama(String Buku){
        this.namaBuku = Buku;
        tf_NamaBuku.setText(namaBuku);
        
    }
    void DeleteData(){
         String namaBuku=  tf_NamaBuku.getText();
         try {
             String sql = "delete from peminjaman where id_pinjam ='"+id+"'";
             jumlahBuku++;
             String Update = "update buku set jumlah_buku='"+jumlahBuku+"' where nama_buku ='"+namaBuku+"'";
             Statement st = con.createStatement();
             
             
             st.executeUpdate(sql);
             st.executeUpdate(Update);
             JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di hapus");
             TampilkanData();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
         }
        
    }
    void postData(){
       if(Tf_namaPeminjam.getText().isEmpty() || tf_NamaBuku.getText().isEmpty() ||tf_tahun.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane, "isi Seluruh Field");
       }else{
            try{
                String nama = Tf_namaPeminjam.getText();
                String namaBuku=  tf_NamaBuku.getText();
                String tahun = tf_tahun.getText();
                String bulan = tf_bulan.getText();
                String tanggal = tf_tanggal.getText();
                String checkExist = "Select * from buku where nama_buku ='"+namaBuku+"'";
                String checkAnggota = "Select nama from user where nama='"+nama+"'";
                //check apakah buku ada dalam database
                Statement st = con.createStatement();
                
                ResultSet checkanggota = st.executeQuery(checkAnggota);
                if(!checkanggota.next()){
                    JOptionPane.showMessageDialog(rootPane, "Anggota tidak ada");
                }else{
                    ResultSet res = st.executeQuery(checkExist);
                    if(!res.next()){
                        JOptionPane.showMessageDialog(rootPane, "Buku tidak ada");
                    }else{
                        String sql = "INSERT INTO peminjaman VALUES (null,'"+nama+"','"+namaBuku+"',null,'"+tahun+"-"+bulan+"-"+tanggal+"')";
                        String getCounter = "Select total_pinjam,jumlah_buku from buku where nama_buku = '"+namaBuku+"'";
                        ResultSet resTotal = st.executeQuery(getCounter);
                        if(resTotal.next()){
                            int total = resTotal.getInt("total_pinjam");
                            jumlahBuku = resTotal.getInt("jumlah_buku");
                            if(jumlahBuku > 0){
                                jumlahBuku--;
                                total++;
                                String Counter = "update buku SET total_pinjam = "+total+", jumlah_buku ='"+jumlahBuku+"' WHERE nama_buku = '"+namaBuku+"'";
                                st.executeUpdate(sql);
                                st.execute(Counter);
                                TampilkanData();
                            }else {
                                JOptionPane.showMessageDialog(rootPane, "mohon maaf buku yang anda pilih sudah habis");
                            }
                        }
                        
                    }
                }
               
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
       }
    }
    final void TampilkanData(){
        DefaultTableModel model = (DefaultTableModel)Tbl_pinjam.getModel();
        int row = Tbl_pinjam.getRowCount();
        for(int i = 0 ; i<row;i++){
            model.removeRow(0);
        }
        try {
            String sql = "select * from peminjaman";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
              
                String id = res.getString("id_pinjam");
                String namaPeminjam = res.getString("nama_peminjam");
                String namaBuku = res.getString("nama_buku");
                String tanggalPinjam = res.getString("tanggal_pinjam");
                String tanggalKembali = res.getString("tanggal_pengembalian");
                Object tbData[] = {id,namaPeminjam,namaBuku,tanggalPinjam,tanggalKembali};
                
                model.addRow(tbData);
                model.fireTableDataChanged();
            }
        } catch (SQLException ex) {
            
        }
    }
    public Peminjaman() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setResizable(false);
        TampilkanData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_daftar_buku = new javax.swing.JButton();
        btn_data_anggota = new javax.swing.JButton();
        btn_pinjam = new javax.swing.JButton();
        btn_tambahBuku = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Tf_namaPeminjam = new javax.swing.JTextField();
        tf_NamaBuku = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_tahun = new javax.swing.JTextField();
        btn_TambahData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_pinjam = new javax.swing.JTable();
        tf_tanggal = new javax.swing.JTextField();
        tf_bulan = new javax.swing.JTextField();
        btn_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 45, 65));

        jPanel2.setBackground(new java.awt.Color(95, 210, 195));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ayo Baca Buku");

        btn_daftar_buku.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        btn_daftar_buku.setText("Daftar Buku");
        btn_daftar_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftar_bukuActionPerformed(evt);
            }
        });

        btn_data_anggota.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        btn_data_anggota.setText("Data anggota");
        btn_data_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_anggotaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_data_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_daftar_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tambahBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel1)
                .addGap(198, 198, 198)
                .addComponent(btn_daftar_buku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pinjam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_data_anggota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_tambahBuku)
                .addGap(29, 29, 29))
        );

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Peminjaman Buku");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Peminjam  ");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama Buku  ");

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tanggal Pengembalian");

        tf_tahun.setText("Tahun");

        btn_TambahData.setText("Tambah");
        btn_TambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahDataActionPerformed(evt);
            }
        });

        Tbl_pinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id Pinjam", "Nama Peminjam", "Nama Buku", "tgl Pinjam", "Tgl Pengembalian"
            }
        ));
        Tbl_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_pinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbl_pinjam);
        if (Tbl_pinjam.getColumnModel().getColumnCount() > 0) {
            Tbl_pinjam.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        tf_tanggal.setText("Tanggal");

        tf_bulan.setText("Bulan");

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(175, 175, 175))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_TambahData, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_NamaBuku, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Tf_namaPeminjam, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tf_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tf_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tf_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(24, 24, 24))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tf_namaPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_NamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_TambahData)
                    .addComponent(btn_hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void CloseFrame(){
        super.dispose();
    }
    private void btn_daftar_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftar_bukuActionPerformed
        daftarBuku buku = new daftarBuku();
        buku.setVisible(true);
        CloseFrame();
    }//GEN-LAST:event_btn_daftar_bukuActionPerformed

    private void btn_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pinjamActionPerformed
        Peminjaman pinjam = new Peminjaman();
        pinjam.setVisible(true);
        CloseFrame();
    }//GEN-LAST:event_btn_pinjamActionPerformed

    private void btn_TambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahDataActionPerformed
        postData();  
    }//GEN-LAST:event_btn_TambahDataActionPerformed

    private void btn_tambahBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahBukuActionPerformed
        TambahBuku buku = new TambahBuku();
        buku.setVisible(true);
        CloseFrame();
    }//GEN-LAST:event_btn_tambahBukuActionPerformed

    private void btn_data_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_anggotaActionPerformed
        daftarAnggota anggota = new daftarAnggota();
        anggota.setVisible(true);
        CloseFrame();
    }//GEN-LAST:event_btn_data_anggotaActionPerformed

    private void Tbl_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_pinjamMouseClicked
        DefaultTableModel model = (DefaultTableModel)Tbl_pinjam.getModel();
        int i = Tbl_pinjam.getSelectedRow();
        if(i>-1){
            id = Integer.parseInt(model.getValueAt(i, 0).toString());
            Tf_namaPeminjam.setText(model.getValueAt(i,1).toString());
            tf_NamaBuku.setText(model.getValueAt(i, 2).toString());
        }
    }//GEN-LAST:event_Tbl_pinjamMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        DeleteData();
    }//GEN-LAST:event_btn_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tbl_pinjam;
    private javax.swing.JTextField Tf_namaPeminjam;
    private javax.swing.JButton btn_TambahData;
    private javax.swing.JButton btn_daftar_buku;
    private javax.swing.JButton btn_data_anggota;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_pinjam;
    private javax.swing.JButton btn_tambahBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf_NamaBuku;
    private javax.swing.JTextField tf_bulan;
    private javax.swing.JTextField tf_tahun;
    private javax.swing.JTextField tf_tanggal;
    // End of variables declaration//GEN-END:variables
}
