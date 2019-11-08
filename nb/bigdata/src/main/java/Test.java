/**
 * Created by jazzyshi on 2019/10/18.
 */

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
public class Test {
    private static AtomicInteger count = new AtomicInteger();

    ConcurrentLinkedQueue aeea = new ConcurrentLinkedQueue<Integer>();
    LinkedBlockingDeque<String> cc = new LinkedBlockingDeque<>();
    ArrayBlockingQueue aaaa = new ArrayBlockingQueue<String>(10);

    ConcurrentHashMap aa = new ConcurrentHashMap(10);
    Hashtable<String,String> a = new Hashtable(10);
    public static void main(String[] args) {
        count.addAndGet(1);
    }

    List<String> bb = new CopyOnWriteArrayList<>();

}
