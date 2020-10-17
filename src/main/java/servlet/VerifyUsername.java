package servlet;

import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author darren
 * @create 2020-10-11 11:59
 */
@WebServlet(name = "verifyUsername", urlPatterns = {"/verifyUsername"})
public class VerifyUsername extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies){
            System.out.println("Cookie-key:"+c.getName()+"===>"+c.getValue());
        }
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        PrintWriter writer = response.getWriter();
        try {
            Boolean aBoolean = userDao.verifyUsername(username);
            if(aBoolean){
                writer.print("");
            }else{
                System.out.println("用户名不存在!");

                writer.print("用户名不存在！");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
