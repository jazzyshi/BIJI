package com.shijizhuo;/**
 * Created by jazzyshi on 2019/6/3.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyServlet
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/3 16:18
 * @Version 1.0
 **/
@WebServlet(name="MyServlet",urlPatterns = {"/user"})
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("servlet..............");
        super.doGet(req,res);
    }
}
