/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputUser.java
 *
 * Created on Mar 14, 2011, 5:24:48 AM
 */
package raka.appkepegawaian.view;

import raka.appkepegawaian.entity.User;
import raka.appkepegawaian.implement.ImplemUser;
import raka.appkepegawaian.koneksi.DatabaseUtilities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import raka.appkepegawaian.interfaces.InterUser;

/**
 *
 * @author rakha
 */
public class InputUser extends javax.swing.JInternalFrame {

    private int id = 0;
    private List<User> records = new ArrayList<User>();
    private InterUser daoKasir;

    /** Creates new form InputKasir */
    public InputUser() {
        initComponents();
        daoKasir = new ImplemUser();
        statusAwal();

        tabelUser.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                btnTambahUpdate.setText("Ubah");
                int row = tabelUser.getSelectedRow();
                if (row != -1) {
                    isiTeks();
                }
            }
        });
    }

    int cariID() {
        try {
            String sql = "select id_user from user order by id_user desc";
            Statement st = DatabaseUtilities.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("id_user");
            }

        } catch (SQLException ex) {

            Logger.getLogger(InputUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }

    void loadAllKasir() {
        try {
            records = daoKasir.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(InputUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void isiTabel() {
        Object data[][] = new Object[records.size()][5];
        int x = 0;
        for (User k : records) {
            data[x][0] = k.getId();
            data[x][1] = k.getNama();
            data[x][2] = k.getTelepon();
            data[x][3] = k.getUsername();
            data[x][4] = k.getAkses();
            x++;
        }
        String judul[] = {"ID", "Nama", "Telepon", "Username", "Akses"};
        tabelUser.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabelUser);
    }

    void kosongkanTeks() {
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelepon.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
    }

    void isiTeks() {
        User k = records.get(tabelUser.getSelectedRow());
        txtID.setText(String.valueOf(k.getId()));
        txtNama.setText(k.getNama());
        txtAlamat.setText(k.getAlamat());
        txtTelepon.setText(k.getTelepon());
        txtUsername.setText(k.getUsername());
        txtPassword.setText(k.getPassword());
        if (k.getStatus().equals("Aktif")) {
            cmbStatus.setSelectedIndex(0);
        } else {
            cmbStatus.setSelectedIndex(1);
        }
        if (k.getAkses().equals("Admin")) {
            cmbAkses.setSelectedIndex(0);
        } else {
            cmbAkses.setSelectedIndex(1);
        }
    }

    boolean tidakBolehKosong() {
        if (!txtNama.getText().isEmpty()
                && !txtAlamat.getText().isEmpty()
                && !txtTelepon.getText().isEmpty()
                && !txtUsername.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    void statusAwal() {
        kosongkanTeks();
        loadAllKasir();
        isiTabel();
        btnTambahUpdate.setText("Tambah");
        txtID.setText(String.valueOf(cariID()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtTelepon = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        cmbStatus = new javax.swing.JComboBox();
        cmbAkses = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnTambahUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Master Data User");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Transaction_64px.png"))); // NOI18N
        jLabel16.setText("DATA USER");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data User"));

        jLabel1.setText("ID :");

        jLabel2.setText("Nama :");

        jLabel3.setText("Alamat :");

        jLabel4.setText("Telepon :");

        jLabel5.setText("Status :");

        jLabel6.setText("Username :");

        jLabel7.setText("Password :");

        jLabel8.setText("Akses :");

        txtID.setEditable(false);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aktif", "Tidak Aktif" }));

        cmbAkses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Pegawai" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama)
                    .addComponent(txtAlamat)
                    .addComponent(txtTelepon)
                    .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword)
                    .addComponent(cmbAkses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tombol"));

        btnTambahUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32px.png"))); // NOI18N
        btnTambahUpdate.setText("Tambah");
        btnTambahUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahUpdateActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_32px_1.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel9.setText("Untuk Ubah, klik tabel terlebih dahulu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambahUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahUpdate)
                    .addComponent(btnHapus)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Pegawai"));
        jPanel3.setName(""); // NOI18N

        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelUser);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Input Data User");
        jPanel3.getAccessibleContext().setAccessibleName("Tabel User");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahUpdateActionPerformed
        try {
            // TODO add your handling code here:
            if (btnTambahUpdate.getText().equals("Tambah")) {
                if (tidakBolehKosong()) {
                    User k = new User();
                    k.setId(Integer.parseInt(txtID.getText()));
                    k.setNama(txtNama.getText());
                    k.setAlamat(txtAlamat.getText());
                    k.setTelepon(txtTelepon.getText());
                    k.setUsername(txtUsername.getText());
                    k.setPassword(txtPassword.getText());
                    k.setStatus((String) cmbStatus.getSelectedItem());
                    k.setAkses((String) cmbAkses.getSelectedItem());
                    daoKasir.insert(k);
                } else {
                    JOptionPane.showMessageDialog(this, "text tidak boleh ada yang kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            } else if (tidakBolehKosong()) {
                User k = new User();
                k.setId(Integer.parseInt(txtID.getText()));
                k.setNama(txtNama.getText());
                k.setAlamat(txtAlamat.getText());
                k.setTelepon(txtTelepon.getText());
                k.setUsername(txtUsername.getText());
                k.setPassword(txtPassword.getText());
                k.setStatus((String) cmbStatus.getSelectedItem());
                k.setAkses((String) cmbAkses.getSelectedItem());
                daoKasir.update(k);
            } else {
                JOptionPane.showMessageDialog(this, "text tidak boleh ada yang kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InputUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusAwal();
    }//GEN-LAST:event_btnTambahUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            // TODO add your handling code here:

            if (tidakBolehKosong()) {
                if (JOptionPane.showConfirmDialog(this, "Apakah Anda yakin untuk menghapus user", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    User k = records.get(tabelUser.getSelectedRow());
                    daoKasir.delete(k.getId());
                }

            } else {
                JOptionPane.showMessageDialog(this, "Klik data pada tabel terlebih dahulu", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }


        } catch (SQLException ex) {
            Logger.getLogger(InputUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusAwal();
    }//GEN-LAST:event_btnHapusActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambahUpdate;
    private javax.swing.JComboBox cmbAkses;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelUser;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
