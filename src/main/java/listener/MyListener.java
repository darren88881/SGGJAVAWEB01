package listener; /**
 * @author darren
 * @create 2020-10-25 12:45
 */

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class MyListener implements  HttpSessionListener{

    public MyListener(){

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        Integer count =(Integer) sc.getAttribute("count");
        if(count==null){
            sc.setAttribute("count",1);
        }else{
             sc = httpSessionEvent.getSession().getServletContext();
             count =(Integer) sc.getAttribute("count");
             count++;
            sc.setAttribute("count",count);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        Integer count =(Integer) sc.getAttribute("count");
        count--;
        sc.setAttribute("count",count);
    }
}
