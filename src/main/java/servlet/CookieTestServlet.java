package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author darren
 * @create 2020-10-17 7:30
 */
@WebServlet(name = "cookieTestServlet",urlPatterns = "/cookieTestServlet")
public class CookieTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("hello","world");
        cookie.setPath(request.getContextPath()+"/LoginServlet");
        response.addCookie(cookie);
        PrintWriter writer = response.getWriter();
        writer.print("success");
        writer.close();

    }
}
