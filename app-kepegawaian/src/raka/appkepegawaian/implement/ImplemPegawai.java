/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raka.appkepegawaian.implement;

import raka.appkepegawaian.entity.Pegawai;
import raka.appkepegawaian.koneksi.DatabaseUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import raka.appkepegawaian.interfaces.InterPegawai;

/**
 *
 * @author rakha
 */
public class ImplemPegawai implements InterPegawai{

    public Pegawai insert(Pegawai o) throws SQLException {
       PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("insert pegawai values(?,?,?,?,?,?)");
       ps.setString(1, o.getKode());
       ps.setString(2, o.getNama());
       ps.setString(3, o.getTempat());
       ps.setString(4, o.getAlamat());
       ps.setString(5, o.getTahun());
       ps.setString(6, o.getNotelpon());
       ps.executeUpdate();
        return o;
    }

    public void update(Pegawai o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("update pegawai set nama=?,tempattanggallahir=?,alamat=?,tahunmasuk=?,notelpon=? where kode_pegawai=?");
        ps.setString(1, o.getNama());
       ps.setString(2, o.getTempat());
       ps.setString(3, o.getAlamat());
       ps.setString(4, o.getTahun());
       ps.setString(5, o.getNotelpon());
       ps.setString(6, o.getKode());
       ps.executeUpdate();
    }

    public void delete(String o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("delete from pegawai where kode_pegawai=?");
        ps.setString(1, o);
        ps.executeUpdate();
    }

    public List<Pegawai> getAll() throws SQLException {
        Statement st=DatabaseUtilities.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select *from pegawai");
        List<Pegawai> list=new ArrayList<Pegawai>();
        while(rs.next()){
            Pegawai o=new Pegawai();
            o.setKode(rs.getString("kode_pegawai"));
            o.setNama(rs.getString("nama"));
            o.setTempat(rs.getString("tempattanggallahir"));
            o.setAlamat(rs.getString("alamat"));
            o.setTahun(rs.getString("tahunmasuk"));
            o.setNotelpon(rs.getString("notelpon"));
            list.add(o);
        }
        return list;
    }

    public List<Pegawai> getByNama(String penu) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("select *from pegawai where nama like ?");
        ps.setString(1, "%"+penu+"%");
        ResultSet rs=ps.executeQuery();
        List<Pegawai> list=new ArrayList<Pegawai>();
        while(rs.next()){
            Pegawai o=new Pegawai();
            o.setKode(rs.getString("kode_pegawai"));
            o.setNama(rs.getString("nama"));
            o.setTempat(rs.getString("tempattanggallahir"));
            o.setAlamat(rs.getString("alamat"));
            o.setTahun(rs.getString("tahunmasuk"));
            o.setNotelpon(rs.getString("notelpon"));
            list.add(o);
        }
        return list;
    }

    public List<Pegawai> getByAlamat(String pener) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("select *from pegawai where alamat like ?");
        ps.setString(1, "%"+pener+"%");
        ResultSet rs=ps.executeQuery();
        List<Pegawai> list=new ArrayList<Pegawai>();
        while(rs.next()){
            Pegawai o=new Pegawai();
            o.setKode(rs.getString("kode_pegawai"));
            o.setNama(rs.getString("nama"));
            o.setTempat(rs.getString("tempattanggallahir"));
            o.setAlamat(rs.getString("alamat"));
            o.setTahun(rs.getString("tahunmasuk"));
            o.setNotelpon(rs.getString("notelpon"));
            list.add(o);
        }
        return list;
    }

    public List<Pegawai> getByKode(String o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("select *from pegawai where kode_pegawai like ?");
        ps.setString(1,"%"+o+"%");
        ResultSet rs=ps.executeQuery();
        List<Pegawai> list=new ArrayList<Pegawai>();
        if(rs.next()){
            Pegawai bk=new Pegawai();
            bk.setKode(rs.getString("kode_pegawai"));
            bk.setNama(rs.getString("nama"));
            bk.setTempat(rs.getString("tempattanggallahir"));
            bk.setAlamat(rs.getString("alamat"));
            bk.setTahun(rs.getString("tahunmasuk"));
            bk.setNotelpon(rs.getString("notelpon"));
            list.add(bk);
        }
        return list;

    }

    public Pegawai getByOne(String o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("select *from pegawai where kode_pegawai=?");
        ps.setString(1,o);
        ResultSet rs=ps.executeQuery();
        Pegawai bk=new Pegawai();
        if(rs.next()){
            bk.setKode(rs.getString("kode_buku"));
            bk.setNama(rs.getString("nama"));
            bk.setTempat(rs.getString("tempattanggallahir"));
            bk.setAlamat(rs.getString("alamat"));
            bk.setTahun(rs.getString("tahunmasuk"));
            bk.setNotelpon(rs.getString("notelpon"));

        }
        return bk;
    }

    public List<Pegawai> getByPenulis(String penu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pegawai> getByPenerbit(String pener) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pegawai> getById(String o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pegawai> getByKode() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
