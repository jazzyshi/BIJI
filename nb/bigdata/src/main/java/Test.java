/**
 * Created by jazzyshi on 2019/10/18.
 */

import javax.swing.*;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;

import java.lang.Thread;

/**
 * @ClassName Test
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/18 16:33
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver");
            Thread.currentThread().setContextClassLoader(Test.class.getClassLoader().getParent());//打破双亲委派
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT", "root","123456");
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            Statement stmt = connection.createStatement();
            String sql;
            sql = "SELECT * FROM t_user";
            ResultSet rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
