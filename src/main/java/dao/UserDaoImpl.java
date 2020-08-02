package dao;

import Utils.DaoUtil;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author darren
 * @create 2020-08-02 10:43
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User findUsername(String username, String password) throws SQLException {

        Connection connection = DaoUtil.getConnection();

        String sql = "select * from user where username= ? and password= ?";

        //preparedStatement;编辑报表
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();

        User user = new User();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));

        }

        return user;
    }
}
