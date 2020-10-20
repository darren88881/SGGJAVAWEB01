package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author darren
 * @create 2020-10-20 22:52
 */
@WebFilter(filterName = "myLastFilter",urlPatterns = "/*")
public class MyLastFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("MyLastFilter destroy()");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String info = req.getParameter("info");
        System.out.println("MyLastFilter info="+info);
        chain.doFilter(req, resp);
        System.out.println("MyLastFilter doFilter()执行完毕！");

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("MyLastFilter init");
    }

}
