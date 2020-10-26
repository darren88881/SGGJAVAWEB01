package servlet;

import bean.Employee;
import com.google.gson.Gson;
import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @author darren
 * @create 2020-10-26 23:59
 */
@WebServlet(name = "FindAllEmpServlet",urlPatterns = "/FindAllEmpServlet")
public class FindAllEmpServlet extends HttpServlet {

    private UserDao dao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Employee> allEmp = dao.findAllEmp();
            System.out.println(allEmp);
            Gson gson = new Gson();
            String jsonStr = gson.toJson(allEmp);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(jsonStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
