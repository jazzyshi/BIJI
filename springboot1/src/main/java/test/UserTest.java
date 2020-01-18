package test;/**
 * Created by jazzyshi on 2019/6/5.
 */

import com.shijizhuo.Springboot1Application;
import com.shijizhuo.demo.service.UserServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName UserTest
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/5 9:19
 * @Version 1.0
 **/

/**
 * @RunWith:启动器
 * SpringJUnit4ClassRunner.class ：让junit与spring环境整合
 * @SpringBootTestclasses={Springboot1Application.class}
 * 1.当前类为springboot的测试类
 * 2.加载springboot启动类。启动springboot
 * @ContextConfiguration("classpath:application.yml")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Springboot1Application.class})
public class UserTest {
    @Autowired
    private UserServer userServer;

    @Test
    public void testSe(){

        System.out.println(userServer.Se(3));
        System.out.println("第一次结束");

        System.out.println(userServer.Se(4));
        System.out.println("再一次结束");
        try {
            System.out.println("休眠3s");
            Thread.sleep(3000);
            System.out.println(userServer.Se(3));
            System.out.println("再一次结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
}
