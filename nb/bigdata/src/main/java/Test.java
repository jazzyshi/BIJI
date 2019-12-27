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
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Test
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/18 16:33
 * @Version 1.0
 **/
public class Test implements InvocationHandler{
    private static AtomicInteger count = new AtomicInteger();

    ConcurrentLinkedQueue aeea = new ConcurrentLinkedQueue<Integer>();
    LinkedBlockingDeque<String> cc = new LinkedBlockingDeque<>();
    ArrayBlockingQueue aaaa = new ArrayBlockingQueue<String>(10);

    ConcurrentHashMap aa = new ConcurrentHashMap(10);
    Hashtable<String,String> a = new Hashtable(10);

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
       // System.out.println(Test.class.getPackage().getName());
       // count.addAndGet(1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        try {
            System.out.println(sdf.parse("2019"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String good(){
return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

}
