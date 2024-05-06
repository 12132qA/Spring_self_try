package task1.stater;

import task1.band.ReadTitle;
import task1.beanFactory.BeanContainer;
import task1.log.LoggerImp;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.stater
 * @author: ZGY
 * @createTime: 2024-03-23  15:27
 * @version: 1.0
 */



public class GenYonApplication {

    // 通过反射创建对象
    public static void run(Class<?> target ) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, SQLException, ClassNotFoundException {
        // 输出  标记
        // 获取系统时间
       long userTime =  System.currentTimeMillis();
        ReadTitle.readAndInput();
        // 初始化Bean容器 将所有的Bean 注入到 Bean容器中 并进行了 属性的注入
        BeanContainer.initBeanContainer();
        // 通过 反射获取方法 方法
        userTime = System.currentTimeMillis() - userTime;
         // 对加载的Bean 进行日志的打印
        LoggerImp.staticPrintInfo("system init is complete !!! all Bean be loaded and inject use time is " + userTime+" ms" );
        // 从Bean容器中取出 计时器对象
        Timer timer = (Timer)BeanContainer.BeansFactory.get("Timer");
        LoggerImp.staticPrintInfo(" === 日志定时任务启动 ==  ");
        timer.schedule((TimerTask) BeanContainer.BeansFactory.get("TimerTasker"),
                0,5000*5);

        Method method = target.getMethod("entranceMenu");
        // 调用方法
        // 从 Bean 容器中 获取启动类的对象
        Object o = BeanContainer.BeansFactory.get("StartApplication");
        method.invoke(o);
        // 调用 ji方法


    }


}