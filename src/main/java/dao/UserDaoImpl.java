package dao;

import Utils.DaoUtil;
import bean.Employee;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        User user = null;
        while(resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));

        }
        DaoUtil.closeConnection();
        return user;
    }

    @Override
    public Boolean verifyUsername(String username) throws SQLException {
        Connection connection = DaoUtil.getConnection();

        String sql = "select * from user where username= ?";

        //preparedStatement;编辑报表
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,username);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){

            return true;
        }

        DaoUtil.closeConnection();

        return false;
    }

    @Override
    public List<Employee> findAllEmp() throws SQLException {
        List<Employee> emps = new ArrayList<Employee>();

        Connection connection = DaoUtil.getConnection();

        String sql = "select * from tbl_employee";

        //preparedStatement;编辑报表
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
          Employee e =   new Employee();
            int id = resultSet.getInt("id");
            String lastName = resultSet.getString("last_name");
            String gender   = resultSet.getString("gender");
            String email    = resultSet.getString("email");
            e.setId(id);
            e.setLastName(lastName);
            e.setGender(gender);
            e.setEmail(email);
            emps.add(e);

        }
        DaoUtil.closeConnection();
        return emps;
    }
}
