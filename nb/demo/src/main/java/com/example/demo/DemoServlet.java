package com.example.demo;/**
 * Created by jazzyshi on 2019/9/19.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName DemoServlet
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/19 15:00
 * @Version 1.0
 **/
@WebServlet(name = "dServlet",urlPatterns = "/first")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("00x0x0x0x0x0x0x0efhfhfhfh");
        super.doGet(req, resp);
    }
}
