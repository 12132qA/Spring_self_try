package task1.beanFactory;

//如果需要查询其他盘只需更改第三行的代码为File file = new File("D:\\");或其他即可。
 
import java.io.File;
import java.util.LinkedList;
/**
 * 遍历整个目录
 *    进行bean的注入
 *
 * @author 张根勇*/
public class ScanAllClass {



//  通过 递归遍历的方式 对所有的类进行遍历
    public static void diBeanByTraverseFile(File file, LinkedList<String> list) {
        // 加载对应的Bean 进入Bean工厂中

        if (file.isDirectory() && file.listFiles() != null) {
            File[] files = file.listFiles();
            assert files != null;
            for (File f1 : files) {
                if (f1.isDirectory()) {
                    diBeanByTraverseFile(f1,list); // 递归
                } else {
                    String path = f1.getAbsolutePath();
                    String pathStart = "src";
                    // D:\java源代码\src   \task_\tryy
                    String[] split = path.split(pathStart);
                    // 替代 为   chapter04.task1.pojo 的路径  以 获取类名
                    String replace= split[1].replace('\\', '.');
                    // 查看所有的 .java 文件 名称
                    if(replace.endsWith(".java") && !replace.contains("annotation") ){
                        String substring = replace.substring(1, split[1].length() - 5);
                        list.add(substring);
                    }

                }
            }
        }

    }

}