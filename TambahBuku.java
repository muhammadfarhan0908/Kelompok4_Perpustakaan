/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class TambahBuku extends javax.swing.JFrame {
    Connection con = koneksi.koneksiDB();
    int idBuku = 0;
    
    /**
     * Creates new form TambahBuku
     */
    
    void DeleteData(){
        try {
            String sql = "delete from buku where id_buku = '"+idBuku+"'";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "data berhasil di hapus");
            TampilkanData();
        } catch (SQLException ex) {
            Logger.getLogger(TambahBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void UpdateData(){
        try {
            String nama = tf_namaBuku.getText();
            int jumlah = Integer.parseInt(tf_jumlahBuku.getText());
            String jenisBuku = tf_JenisBuku.getText();
            String penerbit = tf_penerbit.getText();
            int tahunTerbit = Integer.parseInt(tf_tahunTerbit.getText());
            String sql = "Update buku set nama_buku ='"+nama+"',jumlah_buku ='"+jumlah+"',jenis_buku='"+jenisBuku+"',Penerbit='"+penerbit+"',Tahun_Tebit='"+tahunTerbit+"' where id_buku='"+idBuku+"'";
            Statement st = con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(rootPane, "data berhasil di update");
            TampilkanData();
            
        } catch (SQLException ex) {
//            Logger.getLogger(TambahBuku.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }
    void postData(){
        if(tf_namaBuku.getText().isEmpty()||tf_jumlahBuku.getText().isEmpty()||tf_JenisBuku.getText().isEmpty()||tf_penerbit.getText().isEmpty()||tf_tahunTerbit.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Isi Seluruh Field");
        }else{
            String nama = tf_namaBuku.getText();
            int jumlah = Integer.parseInt(tf_jumlahBuku.getText());
            String jenisBuku = tf_JenisBuku.getText();
            String penerbit = tf_penerbit.getText();
            int tahunTerbit = Integer.parseInt(tf_tahunTerbit.getText());
        
            String CheckData = "select * from buku where nama_buku ='"+nama+"' and Penerbit= '"+penerbit+"'";
            try{
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(CheckData);
                if(res.next()){
                    JOptionPane.showMessageDialog(rootPane, "Buku sudah Ada");
                }else {
                    String sql = "insert into buku values (null,'"+nama+"','"+jumlah+"','"+jenisBuku+"','"+penerbit+"','"+tahunTerbit+"',0)";
                    st.executeUpdate(sql);
                    
                    JOptionPane.showMessageDialog(rootPane, "Data Berhasil di tambahkan");
                    TampilkanData();
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }
    void TampilkanData(){
        DefaultTableModel model = (DefaultTableModel)tbl_dataBuku.getModel();
        int row = model.getRowCount();
        for(int i=0;i<row;i++){
            model.removeRow(0);
        }
        try{
            String sql = "Select * from buku";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                int id = res.getInt("id_buku");
                String nama = res.getString("nama_buku");
                int jumlah = res.getInt("jumlah_buku");
                String jenisBuku = res.getString("jenis_buku");
                String penerbit = res.getString("Penerbit");
                int tahun = res.getInt("Tahun_Tebit");
                int totalPinjam = res.getInt("total_pinjam");
                
                Object tbData[] =  {id,nama,jumlah,jenisBuku,penerbit,tahun,totalPinjam};
                
                model.addRow(tbData);
            }   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
 
    void CloseFrame(){
        super.dispose();
    }
    public TambahBuku() {
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

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dataBuku = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_data_anggota = new javax.swing.JButton();
        btn_daftar_buku = new javax.swing.JButton();
        btn_pinjam = new javax.swing.JButton();
        btn_tambahBuku = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_namaBuku = new javax.swing.JTextField();
        tf_jumlahBuku = new javax.swing.JTextField();
        tf_JenisBuku = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_penerbit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_tahunTerbit = new javax.swing.JTextField();
        Tambah = new javax.swing.JButton();
        Tambah1 = new javax.swing.JButton();
        Tambah2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(34, 45, 65));

        tbl_dataBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id ", "Nama buku ", "Jumlah Buku", "Jenis Buku", "Penerbit", "Tahun Terbit", "Total Pinjam"
            }
        ));
        tbl_dataBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dataBuku);
        if (tbl_dataBuku.getColumnModel().getColumnCount() > 0) {
            tbl_dataBuku.getColumnModel().getColumn(0).setMaxWidth(30);
        }

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
        btn_daftar_buku.setText("Daftar Buku");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_daftar_buku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pinjam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_data_anggota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tambahBuku)
                .addGap(27, 27, 27))
        );

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tambah Data Buku");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Buku");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah Buku");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jenis Buku");

        tf_namaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaBukuActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Penerbit");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tahun Terbit");

        Tambah.setText("Update");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });

        Tambah1.setText("Tambah");
        Tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tambah1ActionPerformed(evt);
            }
        });

        Tambah2.setText("Delete");
        Tambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tambah2ActionPerformed(evt);
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
                        .addGap(222, 222, 222)
                        .addComponent(Tambah2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(223, 223, 223))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tf_JenisBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tf_jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(35, 35, 35)
                                        .addComponent(tf_namaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tf_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tf_tahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_namaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_JenisBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_tahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tambah)
                    .addComponent(Tambah2)
                    .addComponent(Tambah1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tambah2ActionPerformed
        DeleteData();
    }//GEN-LAST:event_Tambah2ActionPerformed

    private void Tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tambah1ActionPerformed
        postData();
    }//GEN-LAST:event_Tambah1ActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        UpdateData();
    }//GEN-LAST:event_TambahActionPerformed

    private void tf_namaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaBukuActionPerformed

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

    private void tbl_dataBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataBukuMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbl_dataBuku.getModel();
        int i = tbl_dataBuku.getSelectedRow();
        
        if(i>-1){
            idBuku = Integer.parseInt(model.getValueAt(i,0).toString());
            tf_namaBuku.setText(model.getValueAt(i, 1).toString());
            tf_jumlahBuku.setText(model.getValueAt(i, 2).toString());
            tf_JenisBuku.setText(model.getValueAt(i, 3).toString());
            tf_penerbit.setText(model.getValueAt(i, 4).toString());
            tf_tahunTerbit.setText(model.getValueAt(i, 5).toString()); 
        }
    }//GEN-LAST:event_tbl_dataBukuMouseClicked

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
            java.util.logging.Logger.getLogger(TambahBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Tambah;
    private javax.swing.JButton Tambah1;
    private javax.swing.JButton Tambah2;
    private javax.swing.JButton btn_daftar_buku;
    private javax.swing.JButton btn_data_anggota;
    private javax.swing.JButton btn_pinjam;
    private javax.swing.JButton btn_tambahBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_dataBuku;
    private javax.swing.JTextField tf_JenisBuku;
    private javax.swing.JTextField tf_jumlahBuku;
    private javax.swing.JTextField tf_namaBuku;
    private javax.swing.JTextField tf_penerbit;
    private javax.swing.JTextField tf_tahunTerbit;
    // End of variables declaration//GEN-END:variables
}
