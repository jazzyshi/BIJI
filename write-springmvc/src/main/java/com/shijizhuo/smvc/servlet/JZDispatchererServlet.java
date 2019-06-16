package com.shijizhuo.smvc.servlet;

import com.shijizhuo.smvc.annotation.JZAutoWrited;
import com.shijizhuo.smvc.annotation.JZController;
import com.shijizhuo.smvc.annotation.JZRequestMapping;
import com.shijizhuo.smvc.annotation.JZService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * Created by jzshi on 2019/6/16.
 */
public class JZDispatchererServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private List<String> classNames = new ArrayList<>();

    private Map<String,Object> ioc =  new HashMap<>();

    private Map<String,Method> handlerMapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        doDispacther(req,res);

    }

    private void doDispacther(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String url = req.getRequestURI();
        String context = req.getContextPath();
        url = url.replace(context,"").replaceAll("/+","/");

        if(!this.handlerMapping.containsKey(url)){
            res.getWriter().write("404 NOT FOUND");
            return;
        }

        Method method = this.handlerMapping.get(url);

        //页面上传参没有实现
        //方法调用没有实现
        //方法返回值没有实现
    }


    @Override
    public void init(ServletConfig config){
        //搭框架
        //1.加载配置文件(contextConfigLocation为spring配置文件的key,在web.xml中)
        String aa = config.getInitParameter("contextConfigLocation");
        doLoadConfig(aa);

        //2.扫描所有相关的类
        doScanner(contextConfig.getProperty("scanner.package"));

        //3.初始化所有的相关联的类，并且将所有的扫描到的类实例化放入到IOC容器中
        doInstance();

        //4.自动化的依赖注入
        doAutowired();

        //5.初始化HandlerMapping
        initHandlerMapping();

    }


    private void initHandlerMapping() {
        if(ioc.isEmpty()) return ;

        for (Map.Entry<String,Object> s : ioc.entrySet()) {
            Class<?> clazz = s.getValue().getClass();

            if(!clazz.isAnnotationPresent(JZController.class)) continue;

            String baseUrl = "";
            if(clazz.isAnnotationPresent(JZRequestMapping.class)){

                JZRequestMapping jzrm = clazz.getAnnotation(JZRequestMapping.class);
                baseUrl =  jzrm.value();
            }

            Method[] methods = clazz.getMethods();
            for(Method method : methods){
                if(!method.isAnnotationPresent(JZRequestMapping.class)) continue;
                JZRequestMapping jzrm = method.getAnnotation(JZRequestMapping.class);

                String url = (baseUrl + jzrm.value()).replaceAll("/+","/");

                handlerMapping.put(url,method);

                System.out.println(url+"="+method);

            }
        }

    }

    private void doAutowired() {

        if(ioc.isEmpty()){return;}
        for (Map.Entry<String,Object> s : ioc.entrySet()) {
          Field[] fields =  s.getValue().getClass().getDeclaredFields();
          for(Field field : fields){
              if(!field.isAnnotationPresent(JZAutoWrited.class)){continue;}
              JZAutoWrited autoWrited = field.getAnnotation(JZAutoWrited.class);
              String beanName = autoWrited.value().trim();
              if("".equals(beanName)){
                  beanName = field.getType().getName();
              }

              //暴力 对于private
              field.setAccessible(true);

              try {
                  field.set(s.getValue(),ioc.get(beanName));
              } catch (IllegalAccessException e) {
                  e.printStackTrace();
              }
          }
        }
    }

    private void doInstance() {

        if(classNames.isEmpty()){ return; }

        for(String clasName : classNames){
            try {
                Class<?> clazz = Class.forName(clasName);
                //通过反射把类的实例搞出来
                if(clazz.isAnnotationPresent(JZController.class)){
                    String key = lowFirstName(clazz.getSimpleName());
                    Object instance = clazz.newInstance();
                    ioc.put(key,instance);
                }else if(clazz.isAnnotationPresent(JZService.class)){

                    //1.类名首字母小写
                    //2.如果自定义了beanId.优先使用自定义
                    JZService s = clazz.getAnnotation(JZService.class);
                    String beanName = s.value();
                    if("".equals(beanName.trim())){
                        beanName = lowFirstName(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName,instance);
                    //3.根据接口类型来进行实例化
                    Class<?>[] interfaces =   clazz.getInterfaces();
                    for(Class<?> i : interfaces){
                        ioc.put(i.getName(),instance);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private String lowFirstName(String simpleName) {
        char[] aa = simpleName.toCharArray();
        aa[0] += 32;

        return String.valueOf(aa);
    }


    private void doScanner(String scanerPackage) {
        String aa = "/"+scanerPackage.replaceAll("\\.","/");
        URL url = this.getClass().getResource(aa);
        File classDir = new File(url.getFile());

        for (File file : classDir.listFiles()){
            if(file.isDirectory()){
               doScanner(scanerPackage + "." + file.getName());
            }else{
                String className = (scanerPackage + "." + file.getName()).replace(".class","");
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        //拿到配置文件路径，读取文件中的所有类容
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
