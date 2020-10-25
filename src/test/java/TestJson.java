import bean.Employee;
import com.google.gson.Gson;
import dao.UserDao;
import dao.UserDaoImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author darren
 * @create 2020-10-25 13:26
 */
public class TestJson {

    private UserDao dao = new UserDaoImpl();

    @Test
    public void StringToJson() throws SQLException {

        Gson gson = new Gson();

        List<Employee> allEmp = dao.findAllEmp();
        String Empjson = gson.toJson(allEmp);
        System.out.println(Empjson);


    }
}
