import bean.User;
import dao.UserDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author darren
 * @create 2020-08-02 11:51
 */
public class TestDriver {

    @Test
    public void test01() throws SQLException {

        User user = new UserDaoImpl().findUsername("zhangsan","123456");
        System.out.println(user);

    }
}
