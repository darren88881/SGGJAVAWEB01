package login;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author darren
 * @create 2020-08-01 17:25
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            User user = userDao.findUsername(username, password);
            if(user==null){
                writer.print("用户名或密码错误");
            }else{
                writer.print("登录成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
