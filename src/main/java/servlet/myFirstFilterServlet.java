package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author darren
 * @create 2020-10-20 22:29
 */
@WebServlet(name = "myFirstFilterServlet",urlPatterns = "/myFirstFilterServlet")
public class myFirstFilterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getParameter("info");
        System.out.println("Servlet info:"+info);
        response.getWriter().println("sessice");

    }
}
