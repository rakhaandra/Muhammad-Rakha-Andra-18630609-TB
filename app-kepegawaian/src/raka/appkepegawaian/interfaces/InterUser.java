/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raka.appkepegawaian.interfaces;

import raka.appkepegawaian.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rakha
 */
public interface InterUser {

    User insert(User o)throws SQLException;

    void update(User o)throws SQLException;

    void delete(int o) throws SQLException;

    List<User>getAll() throws SQLException;

    User getByUsername(String o) throws SQLException;


}
