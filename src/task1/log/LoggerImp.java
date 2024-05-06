package task1.log;

import task1.annotation.Aop;
import task1.annotation.Component;

import javax.print.attribute.standard.JobPriority;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.common
 * @author: ZGY
 * @createTime: 2024-03-23  09:18
 * @version: 1.0
 */

@Aop  // 这里注意使用了 这个 注解就一定要使用 @Component注解
@Component
public class LoggerImp implements Logger{
    //  获取当前时间

    public static String  staticCurrentTime(){
        Date day = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "  :\033[35m  " +sdf.format(day) +"\033[32m ";

    }
    @Override
    public  String  currentTime(){
        Date day = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "  :\033[35m  " +sdf.format(day) +"\033[32m ";
    }

    /**
     * */
    public static void staticPrintInfo(String value){
        String s = "\033[34mINFO:  "+"\033[36m"+" "+  value+   "\033[32m ";

        System.out.print("\033[34mINFO:  "+"\033[36m"+" "+  value+   "\033[32m "  );
        int n = s.length();
        n = 110-n;

        while(n-->=0){
            System.out.print(" ");
        }
        System.out.println(staticCurrentTime());
    }

        public void last(int n){
        Properties properties = new Properties();

        // 打印空格 和 时间
        n = 110-n;
        while(n-->=0){
            System.out.print(" ");
        }
        System.out.println(currentTime() );
    }
    @Override
    public  void printInfo(String value){
        String s = "\033[34mINFO:  "+"\033[36m"+" "+  value+   "\033[32m ";
        System.out.print(s);
        int n = s.length();
        last(n);
    }
    @Override
    public void printError(String value){
        String s = "\033[31mERROR: " +value + "\033[32m ";
        System.out.print(s);
        last(s.length());
    }

    @Override
    public void print(String[] values){
         // 打印
        System.out.print("\033[34mINFO:   ");
        Arrays.stream(values).forEach(e->{
        });
        System.out.println("\033[32m "+currentTime());
    }
    @Override
    // 数据库操作 打印
    public void printInfoDB(String value){
        // 打印
        String s  ="\033[33mINFO:  "+value +"  \033[32m ";
        System.out.print(s);
        last(s.length());
    }
    @Override
    // 数据库操作 打印
    public  void printErrorDB(String value){
        // 打印
        String s = "\033[34mINFO:  "+value +"  \033[32m ";
        System.out.print(s);
        last(s.length());
    }

    @Override
    public void printInfo(String[] values){
        // 打印
        System.out.print("\033[34mINFO:   ");
        Arrays.stream(values).forEach(e->
            System.out.print(e+" ")
        );
        System.out.println("\033[32m "+currentTime());
    }
    @Override
    // 错误打印
    public void printError(String[] values){
        System.out.print("\033[31mERROR:   ");
        Arrays.stream(values).forEach(e->
                System.out.print(e+" ")
        );

        System.out.println("\033[32m "+currentTime());
    }
}