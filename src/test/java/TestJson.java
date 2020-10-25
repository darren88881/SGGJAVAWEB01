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
    public void JavaToJson() throws SQLException {

        Gson gson = new Gson();

        List<Employee> allEmp = dao.findAllEmp();
        String Empjson = gson.toJson(allEmp);
        System.out.println(Empjson);
    }

    @Test
    public void JsonToJava() throws SQLException {

        Gson gson = new Gson();

        List<Employee> allEmp = dao.findAllEmp();
        String Empjson = gson.toJson(allEmp);
        System.out.println("JSON对象："+Empjson);
        List<Employee> object= (List<Employee>)gson.fromJson(Empjson, List.class);
        System.out.println("JAVA对象："+object.toString());
    }
}
