package login;

import bean.Employee;
import bean.User;
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
 * @create 2020-08-01 17:25
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            User user = userDao.findUsername(username, password);
            if(user==null){
                request.setAttribute("error","登录名或密码错误！");
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                //转发
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                //writer.print("登录成功");
                //重定向
                //response.sendRedirect("/SGGJAVAWEB01/index.jsp");
                List<Employee> emps =  userDao.findAllEmp();
                System.out.println(emps.toString());
                request.setAttribute("emps",emps);
                request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
