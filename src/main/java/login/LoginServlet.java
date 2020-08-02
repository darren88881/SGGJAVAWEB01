package login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author darren
 * @create 2020-08-01 17:25
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();

        if(username.equals("") || password.equals("")){
            writer.print("username and password is null");
        }else{
            writer.print("username and password not is null");
        }
       // writer.close();
        System.out.println("post方法请求");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
