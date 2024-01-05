/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raka.appkepegawaian.implement;

import raka.appkepegawaian.entity.User;
import raka.appkepegawaian.koneksi.DatabaseUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import raka.appkepegawaian.interfaces.InterUser;

/**
 *
 * @author bahrie
 */
public class ImplemUser implements InterUser{

    public User insert(User o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("insert into user values(null,?,?,?,?,?,?,?)");
        ps.setString(1, o.getNama());
        ps.setString(2, o.getAlamat());
        ps.setString(3, o.getTelepon());
        ps.setString(4, o.getStatus());
        ps.setString(5, o.getUsername());
        ps.setString(6, o.getPassword());
        ps.setString(7, o.getAkses());
        ps.executeUpdate();
        return o;
    }

    public void update(User o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("update user set nama=?,alamat=?,telepon=?,status=?,"
                + "username=?,password=?,akses=? where id_user=?");
        ps.setString(1, o.getNama());
        ps.setString(2, o.getAlamat());
        ps.setString(3, o.getTelepon());
        ps.setString(4, o.getStatus());
        ps.setString(5, o.getUsername());
        ps.setString(6, o.getPassword());
        ps.setString(7, o.getAkses());
        ps.setInt(8, o.getId());
        ps.executeUpdate();
    }

    public void delete(int o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("delete from user where id_user=?");
        ps.setInt(1, o);
        ps.executeUpdate();
    }

    public List<User> getAll() throws SQLException {
        Statement st=DatabaseUtilities.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select *from user");
        List<User>list=new ArrayList<User>();
        while(rs.next()){
            User o=new User();
            o.setId(rs.getInt("id_user"));
            o.setNama(rs.getString("nama"));
            o.setAlamat(rs.getString("alamat"));
            o.setTelepon(rs.getString("telepon"));
            o.setStatus(rs.getString("status"));
            o.setUsername(rs.getString("username"));
            o.setPassword(rs.getString("password"));
            o.setAkses(rs.getString("akses"));
            list.add(o);
        }
        return list;
    }

    public User getByUsername(String o) throws SQLException {
        PreparedStatement ps=DatabaseUtilities.getConnection().prepareStatement("select *from user where username=?");
        ps.setString(1, o);
        ResultSet rs=ps.executeQuery();
        User kasir=new User();
        if(rs.next()){
            kasir.setId(rs.getInt("id_user"));
            kasir.setNama(rs.getString("nama"));
            kasir.setAlamat(rs.getString("alamat"));
            kasir.setTelepon(rs.getString("telepon"));
            kasir.setStatus(rs.getString("status"));
            kasir.setUsername(rs.getString("username"));
            kasir.setPassword(rs.getString("password"));
            kasir.setAkses(rs.getString("akses"));
        }
        return kasir;
    }

}
