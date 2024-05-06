package task1.beanFactory;

import task1.annotation.*;
import task1.log.LoggerImp;
import task1.config.DbConfig;
import task1.log.LogAop;


import java.io.File;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;

/***
 *  2. 实现Bean容器和工厂
 *  创建Bean 工厂
 *
 * @author 张根勇
 */

public class BeanContainer {

    // 定义 Bean 工厂
    public static Map<String, Object> BeansFactory = new HashMap<>();



    public BeanContainer(){
    }
    public static void registerBean(String name, Object instance) {
        BeansFactory.put(name, instance);
    }

    public static Object getBean(String name) {
        return BeansFactory.get(name);
    }
   // insert
   // 正式将 Bean 注入到 容器中
    public static void loadBean(String path) { // task.tryy.pojo.Course
        try {
            Class<?> aClass = Class.forName(path);
            String name = aClass.getName();
            // 切分 得到 类名
            String[] split = name.split("\\.");
            int n = split.length;

            // 获取注解
            Component a = aClass.getAnnotation(Component.class);
            Service service = aClass.getAnnotation(Service.class);
            Start start = aClass.getAnnotation(Start.class);

            Aop aop = aClass.getAnnotation(Aop.class);


            if (a != null) { // 对对应的Bean 进行注入
                // 反射机制 创建对象
                Object o = aClass.newInstance();
               if(a.value().isEmpty()){
                   // 按类名 注入
                   BeansFactory.put(split[n-1],o);
               }else{
                   // 按 自定义名称 注入
                   BeansFactory.put(a.value(),o);
               }
                LoggerImp.staticPrintInfo("loaded entity Bean: "+path+" hashCode="+o.hashCode());
            }

            if(service!=null){
                // 反射机制
                Object o = aClass.newInstance();
                if(service.value().isEmpty()){
                    // 按类名 注入
                    BeansFactory.put(split[n-1],o);
                }else{
                    // 按 自定义名称 注入
                    BeansFactory.put(service.value(),o);
                }
                LoggerImp.staticPrintInfo("loaded service Bean: "+path+" hashCode="+o.hashCode());
            }

            if(aop!=null){
                // 反射机制 创建对象 要是使用 了 Aop 那一定就要使用 component 注解
                String key =   a.value().isEmpty()?split[n-1]:a.value();
                // 将 值获取出来
                Object  o= BeansFactory.get(key);
                 // 得到增强对象
                Object aopObject =  LogAop.getProxy(o);
                //
                Class<?>[] interfaces = aopObject.getClass().getInterfaces();
                // 获取接口
                Class<?> anInterface = interfaces[0];
                 // 将 对象接口名称 放入其中
                // 将 增强对象 重新注入到 IOC 容器中  // 对日志进行增强
                BeansFactory.put(anInterface.getSimpleName(),aopObject);

                LoggerImp.staticPrintInfo("complete Aop : "+path+" hashCode="+o.hashCode());
            }

            if(start!=null){
                // 反射机制
                Object o = aClass.newInstance();
                // 启动类
                BeansFactory.put("StartApplication", o);
                //
                LoggerImp.staticPrintInfo("loaded service Bean: "+path+" hashCode="+o.hashCode());
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initBeanContainer() throws SQLException, ClassNotFoundException { //  初始化Bean 工厂
        LinkedList<String> list = new LinkedList<>();
        // 操找所有的 类文件
        ScanAllClass.
                diBeanByTraverseFile(new File
                        // 设置 绝对路径 task1 为至
                        ("D:\\genyonTask\\myTak\\src\\task1"),list);

       // 获取Bean 将去注入到 Bean 容器中
        list.forEach(BeanContainer::loadBean);
        //@TODO  最后手动将 数据库连接 会话 对象   注入到容器当中
//        registerBean("Statement", new DbConfig().getConnection().createStatement() );
        // 对数据库连接 进行对象注入
        registerBean("dbConnect", new DbConfig().getConnection() );
        registerBean("Timer", new Timer());

        // 从容器中 拿出 Bean 并将其 注入到  对应属性中
        list.forEach(BeanContainer::injectBean);

    }


    // 对Bean 进行注入
    // 正式将 Bean 从 容器中拿出来 注入到 类的属性中
    public static void injectBean(String path) {
        try {
            // 获取Class 对象
            Class<?> aClass = Class.forName(path);
            // 获取注解
            Component a = aClass.getAnnotation(Component.class);
            Service b = aClass.getAnnotation(Service.class);
            Start start = aClass.getAnnotation(Start.class);
             // 对对应的Bean 进行注入
            //   Component 注解的 对象 进行属性注入
            if (a != null ) {
                // 反射机制
                Object o ;
                // 对 Bean 进行属性依赖 的注入
                //如果 属性 不为空
                if(!a.value().isEmpty()){
                     o = BeansFactory.get(a.value());
                }else{
                    String[] split = path.split("\\.");
                    int n = split.length;
                    // 将类的名称进行注入
                    o = BeansFactory.get(split[n-1]);
                }
                // 遍历属性 进行属性注入

                beanInjection(o);
            }
            // Service 注解的对象 进行属性注入
            String[] split1 = null;
            int nn = 0;
            if(b!=null){
                // 反射机制
                Object o ;
                if(!b.value().isEmpty()){
                    o = BeansFactory.get(b.value());
                }else{
                      split1 = path.split("\\.");
                     nn = split1.length;
                    // 获取类名注入
                    o = BeansFactory.get(split1[nn-1]);
                }
                // 遍历属性 进行属性注入
                beanInjection(o);
            }

            if(start!=null){
                //启动类的依赖注入 否则会报空指针
                Object springApplication = getBean("StartApplication");
                beanInjection(springApplication);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    // 属性的注入
    public static  void beanInjection(Object instance) {

        Class<?> clazz = instance.getClass();
        // 循环遍历 类中的全部变量
        for (Field field : clazz.getDeclaredFields()) {
            // 出现了 Autowired 注解
            if (field.isAnnotationPresent(Autowired.class)) {
                // 获取注解
                Autowired diAnnotation = field.getAnnotation(Autowired.class);
                String beanName = diAnnotation.value();



                if(beanName.isEmpty()){
                    // 获取该 属性变量的类名
                    String name = String.valueOf(field.getType());
                    String[] split = name.split("\\.");
                    int n = split.length;
                    // 按类名进行注入
                    beanName = split[n-1];
                }


                Object bean = getBean(beanName);

                // 将Bean 注入到 属性中
                LoggerImp.staticPrintInfo("inject Bean: "+ beanName + " hashcode: "+ bean.hashCode());



                // 将 Bean
                field.setAccessible(true); // Accessable属性是继承自

                try {
                    field.set(instance, bean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}