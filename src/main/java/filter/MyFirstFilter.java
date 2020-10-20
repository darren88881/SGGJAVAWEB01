package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author darren
 * @create 2020-10-20 22:17
 * urlPatterns:过滤的请求
 * servletNames：对哪些servlet过滤
 * Filter链顺序是根据filterName 字母排序，按filter文件夹中类的顺序，谁靠前谁先过滤
 */
@WebFilter(filterName = "myFirstFilter",urlPatterns ="/*",servletNames = "myFirstFilterServlet")
public class MyFirstFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("MyFirstFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String info = req.getParameter("info");
        System.out.println("MyFirstFilter info:"+info);
        chain.doFilter(req, resp);
        System.out.println("MyFirstFilter doFilter()执行完毕！");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        System.out.println("MyFirstFilter init");

    }

}
