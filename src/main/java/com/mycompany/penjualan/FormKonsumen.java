/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.penjualan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insomnia
 */
public class FormKonsumen extends javax.swing.JFrame {
    
    Connection Con;
    ResultSet RsKons;
    Statement stm;
    Boolean ada = false;
    String sSatuan;
    Boolean edit = false;
    private Object[][] dataTable = null;
    private String[] header = {"Kode", "Nama Konsumen", "Alamat", "Kota", "Kode Pos", "Telepon", "Email"};

    /**
     * Creates new form FormKonsumen
     */
    public FormKonsumen() {
        initComponents();
        open_db();
        baca_data();
        aktif(false);
        setTombol(true);
    }

    private void setField()
    {
        int row = tblKons.getSelectedRow();
        txtKode.setText((String) tblKons.getValueAt(row, 0));
        txtNama.setText((String) tblKons.getValueAt(row, 1));
        txtAlamat.setText((String) tblKons.getValueAt(row, 2));
        txtKota.setText((String) tblKons.getValueAt(row, 3));
        txtPos.setText((String) tblKons.getValueAt(row, 4));
        txtTelp.setText((String) tblKons.getValueAt(row, 5));
        txtEmail.setText((String) tblKons.getValueAt(row, 6));
    }
    
    private void open_db()
    { 
        try{
            KoneksiMysql kon = new KoneksiMysql("localhost","root","","pbo");
            Con = kon.getConnection();
        }catch (Exception e) {
            System.out.println("Error : "+e);
        }
    }

    private void baca_data()
    {
        try {
            stm = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            stm = Con.createStatement();
            RsKons = stm.executeQuery("select * from konsumen");
            ResultSetMetaData meta = RsKons.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (RsKons.next()) {
                baris = RsKons.getRow();
            }

            dataTable = new Object[baris][col];
            int x = 0;
            RsKons.beforeFirst();

            while (RsKons.next()) {
                dataTable[x][0] = RsKons.getString("kd_kons");
                dataTable[x][1] = RsKons.getString("nm_kons");
                dataTable[x][2] = RsKons.getString("alm_kons");
                dataTable[x][3] = RsKons.getString("kota_kons");
                dataTable[x][4] = RsKons.getString("kd_pos");
                dataTable[x][5] = RsKons.getString("phone");
                dataTable[x][6] = RsKons.getString("email");
                x++;
            }

            tblKons.setModel(new DefaultTableModel(dataTable, header));
//            DefaultTableModel model = (DefaultTableModel) tblKons.getModel();
//            model.setDataVector(dataTable, header);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void kosong()
    {
        txtKode.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtKota.setText("");
        txtPos.setText("");
        txtTelp.setText("");
        txtEmail.setText("");
    }

    //mengset aktif tidak isian data
    private void aktif(boolean x)
    {
        txtKode.setEnabled(x);
        txtNama.setEnabled(x);
        txtAlamat.setEnabled(x);
        txtKota.setEnabled(x);
        txtPos.setEnabled(x);
        txtTelp.setEnabled(x);
        txtEmail.setEnabled(x);
    }

    //mengset tombol on/off
    private void setTombol(boolean t)
    {
        cmdTambah.setEnabled(t);
        cmdKoreksi.setEnabled(t);
        cmdHapus.setEnabled(t);
        cmdSimpan.setEnabled(!t);
        cmdBatal.setEnabled(!t);
        cmdKeluar.setEnabled(t);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKons = new javax.swing.JTable();
        cmdTambah = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        cmdKoreksi = new javax.swing.JButton();
        cmdHapus = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdKeluar = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Data Konsumen");

        jLabel2.setText("Kode Konsumen");

        jLabel3.setText("Nama Konsumen");

        jLabel4.setText("Alamat");

        jLabel5.setText("Kota");

        jLabel6.setText("Kode Pos");

        jLabel7.setText("Nomor Telepon");

        jLabel8.setText("Email");

        tblKons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Konsumen", "Nama Konsumen", "Alamat", "Kota", "Kode Pos", "Phone", "Email"
            }
        ));
        tblKons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKonsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKons);

        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        cmdSimpan.setText("Simpan");
        cmdSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdSimpanMouseClicked(evt);
            }
        });

        cmdKoreksi.setText("Koreksi");
        cmdKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKoreksiActionPerformed(evt);
            }
        });

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdKeluar.setText("Keluar");
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(cmdTambah)
                                .addGap(18, 18, 18)
                                .addComponent(cmdSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(cmdKoreksi)
                                .addGap(18, 18, 18)
                                .addComponent(cmdHapus)
                                .addGap(18, 18, 18)
                                .addComponent(cmdBatal)
                                .addGap(18, 18, 18)
                                .addComponent(cmdKeluar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(txtTelp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPos, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKota, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTambah)
                    .addComponent(cmdSimpan)
                    .addComponent(cmdKoreksi)
                    .addComponent(cmdHapus)
                    .addComponent(cmdBatal)
                    .addComponent(cmdKeluar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_cmdKeluarActionPerformed

    private void cmdSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSimpanMouseClicked
        String tKode=txtKode.getText();
        String tNama=txtNama.getText();
        String tAlamat = txtAlamat.getText();
        String tKota = txtKota.getText();
        String tPos = txtPos.getText();
        String tTelp = txtTelp.getText();
        String tEmail = txtEmail.getText();

        try{
            if (edit==true)
            {
                stm.executeUpdate("update konsumen set nm_kons='"+tNama+"',alm_kons='"+tAlamat+"',"
                    + "kota_kons='"+tKota+"',kd_pos='"+tPos+"',phone='"+tTelp+"',email='"+tEmail+"' where kd_kons='" + tKode + "'"
                );
            }else
            {
                stm.executeUpdate(
                    "INSERT into konsumen(kd_kons, nm_kons, alm_kons, kota_kons, kd_pos, phone, email) "
                    + "VALUES('"+tKode+"','"+tNama+"','"+tAlamat+"','"+tKota+"','"+tPos+"','"+tTelp+"','"+tEmail+"')"
                );
            }

            tblKons.setModel(new DefaultTableModel(dataTable,header));
            baca_data();
            aktif(false);
            setTombol(true);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmdSimpanMouseClicked

    private void cmdKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKoreksiActionPerformed
        edit=true;
        aktif(true);
        setTombol(false);
        txtKode.setEditable(false);
    }//GEN-LAST:event_cmdKoreksiActionPerformed

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        try{
            String sql="delete from konsumen where kd_kons='" + txtKode.getText()+ "'";
            stm.executeUpdate(sql);
            baca_data();

            edit=false;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmdHapusActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        aktif(false);
        setTombol(true);
    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        aktif(true);
        setTombol(false);
        kosong();
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void tblKonsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKonsMouseClicked
        setField();
    }//GEN-LAST:event_tblKonsMouseClicked

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
            java.util.logging.Logger.getLogger(FormKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKonsumen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdKoreksi;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblKons;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtKota;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPos;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
