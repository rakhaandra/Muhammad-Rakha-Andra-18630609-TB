/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raka.appkepegawaian.interfaces;

import raka.appkepegawaian.entity.Pegawai;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rakha
 */
public interface InterPegawai {

    Pegawai insert(Pegawai o) throws SQLException;

    void update(Pegawai o) throws SQLException;

    void delete(String o) throws SQLException;
    
    List<Pegawai>getAll() throws SQLException;

    List<Pegawai> getByNama(String penu) throws SQLException;

    List<Pegawai> getByAlamat(String pener) throws SQLException;

    List<Pegawai> getByKode(String o) throws SQLException;

    Pegawai getByOne(String o) throws SQLException;
}
