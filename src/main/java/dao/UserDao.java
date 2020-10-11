package dao;

import bean.User;

import java.sql.SQLException;

/**
 * @author darren
 * @create 2020-08-02 10:41
 */
public interface UserDao {
    User findUsername(String username, String password) throws SQLException;
    Boolean verifyUsername(String username) throws SQLException;
}
