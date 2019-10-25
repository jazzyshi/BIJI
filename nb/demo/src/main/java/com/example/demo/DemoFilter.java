package com.example.demo;/**
 * Created by jazzyshi on 2019/9/19.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName DemoFilter
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/19 15:15
 * @Version 1.0
 **/
@WebFilter(filterName = "dFilter",urlPatterns = "/first")
public class DemoFilter implements Filter{

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
