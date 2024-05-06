package task1.common;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import task1.annotation.Component;


import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1.Utils
 * @author: ZGY
 * @createTime: 2024-03-24  18:18
 * @version: 1.0
 *
 *   自定义的 内存使用的 类
 *
 */

@Component
public class SelfCaffineCache {

     // 对 数据 进行存储  (高速缓存)
   public   Cache<String, List<String>> cache = Caffeine.newBuilder()
          // 默认在内存中存在的时间 是 6 小时
           .expireAfterWrite(6, TimeUnit.HOURS)
           .maximumSize(10_000) // 创建缓存 时间
           .build(); //

   public List<String> keyList = new ArrayList<>();
   public  List<String> cacheValueList = new ArrayList<>();

   // 对日志数据 进行 存储
   public  void addToCache(String log){
        // 缓存列表
       cacheValueList.add(log);

       // 大于100  存入到 缓存中
       if(cacheValueList.size()>=5){
           // 写入数据 到内存当中
           String key = "log_"+System.currentTimeMillis();
           keyList.add(key);
           put(key);
           // 将缓存 列表删除;
           cacheValueList.clear();
       }
    }

    //
    public static void writeStringToFile(FileWriter writer, String content) {

        try {
            if(writer == null){
                System.out.println("FileWriter对象 是 null");
            }
            if(content == null){
                System.out.println(" content 是 null ");
            }
            // 写入字符串
//            assert writer != null;
//            assert content != null;
            writer.write(content);
            // 如果希望在字符串末尾追加换行符，可以添加：
            writer.write(System.lineSeparator());
            // 刷新缓冲区确保数据立即写入文件
            writer.flush();
        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }


    // 写入 指定 文件夹中
    public  void readToFile()  {
        // 遍历所有的方法
        // 打开一个文件夹

        // 文件的写入路径
        String writerPath = "D:/log_GenYon";
        // 对文件 进行写入
        File folder = new File(writerPath);
        // 对系统文件的保存
        if(!folder.exists()){
            folder.mkdir();
//                LoggerImp.staticPrintInfo("log folder was build !");

        }

//        LoggerImp.staticPrintInfo("log中的 key的数量:" + keyList.size());
        // 获取 写入的数据流
        FileWriter finalFileWriter = getFileWriter(writerPath);
       // 遍历所有缓存中的 日志
        List<String> into = new ArrayList<>();
        // 对数据 的
        for (String key : keyList) {
            // 从高速缓存中 获取全部日志数据
            List<String> value = cache.getIfPresent(key);

//            System.out.println("--------------------=============---------------");
//            System.out.println(value);
            if (value != null) {
                into.addAll(value);
            }
        }
//        System.out.println("在缓存中所以日志的数量: "+ into.size());
        // 写入到日志文件中
        into.forEach(e->writeStringToFile(finalFileWriter,e));

    }



    // 获取输出 流的 对象
    private  FileWriter getFileWriter(String writerPath) {
        String currentTime = Long.toString(System.currentTimeMillis());
        String filePath = writerPath +"/"+ currentTime +".txt"  ;

        File file = new File(filePath);

        FileWriter fileWriter = null;

        if(!file.exists()) {
           try {
               boolean newFile = file.createNewFile();
               //  创建 日志文档
//               if(newFile){
//                   LoggerImp.staticPrintInfo("build log txt document is success !");
//               }else{
//                   LoggerImp.staticPrintInfo("build log txt document is failure !");
//               }
               //
               fileWriter = new FileWriter(filePath);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }

        // 使用 lambda表达式 的 变量 重新赋值
        return fileWriter;
    }



    public void put(String key){
        // 构建caffeine的缓存对象，并指定在写入后的10分钟内有效，且最大允许写入的条目数为10000
        // 存在10个小时
        // 存放在指定的 地点 存放一百条记录
        // 为了便于调试 可以将日志数量 变为 4 3 2 条
       if(cacheValueList.size()>=5) {
           cache.put(key,cacheValueList);
//           LoggerImp.staticPrintInfo(" 日志得到已缓存 ");
       }else{

       }


    }


    public List<String> getByKey(String key){
        // 构建caffeine的缓存对象，并指定在写入后的10分钟内有效，且最大允许写入的条目数为10000
        // 存在10个小时
        // 存放在指定的 地点 存放一百条记录
        return  cache.getIfPresent(key);
    }


//    public  static List<String>  create(String key){

//        return  new ArrayList<String>();
//
//    }




}