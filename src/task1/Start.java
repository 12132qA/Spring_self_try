package task1;
import task1.in.Entrance;
import task1.stater.GenYonApplication;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * .
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1
 * @author: ZGY
 * @createTime: 2024-03-23  02:07
 * @version: 1.0
 */

public class Start {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException,
            InvocationTargetException, NoSuchMethodException,
            SQLException, ClassNotFoundException {
            // 调用启动类 系统启动
            GenYonApplication.run(Entrance.class);
    }

}