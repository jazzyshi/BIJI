/**
 * Created by jazzyshi on 2019/10/18.
 */

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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
        new Thread(() -> System.out.println("测试")).start();
    }

}
