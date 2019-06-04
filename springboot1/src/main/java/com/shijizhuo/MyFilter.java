package com.shijizhuo;/**
 * Created by jazzyshi on 2019/6/3.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/3 16:39
 * @Version 1.0
 **/
@WebFilter(filterName = "MyFilter",urlPatterns = "/getUserList")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开filter");
    }

    @Override
    public void destroy() {

    }
}
