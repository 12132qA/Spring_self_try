package task1.log;

import task1.beanFactory.BeanContainer;
import task1.common.SelfCaffineCache;

import java.lang.reflect.Proxy;


/**
 * @author 张根勇
 *
 * 创建代理对象的工厂类
 */

public class LogAop {


    public static Object getProxy(Object target) {

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                   // 将  高速缓存的 Bean 其注入
                    SelfCaffineCache o = (SelfCaffineCache)BeanContainer.BeansFactory.get("SelfCaffineCache");

                    // 调用目标方法
                    Object result = method.invoke(target, args);
                    if( args!=null&&args.length>=1&& args[0] instanceof String){
                        // 添加
                        o.addToCache(args[0].toString());
//                        LoggerImp.staticPrintInfo(" 增强日志 --> 对日志进行保存 ");
                    }

                    return result;
                }
        );

    }
}