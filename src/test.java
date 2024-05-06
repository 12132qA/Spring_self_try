import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException {

//        Class<?> aClass = Class.forName("task1.config.DbConfig");
//
//        Field[] fields = aClass.getDeclaredFields();
//        for (Field field : fields) {
//            // 允许访问私有字段
//            field.setAccessible(true);
//
//        }
        String writerPath = "D:/log_GenYon";

        String currentTime = Long.toString( System.currentTimeMillis());
        String filePath = writerPath +"/"+ currentTime +".txt"  ;
        System.out.println(filePath);
        File file = new File(filePath);
//        FileWriter fileWriter = null;

        if(!file.exists()) {
            try {
                boolean newFile = file.createNewFile();

                if(newFile){
                    System.out.println("创建txt 成功");
                }else{
                    System.out.println("创建txt 失败");
                }
//                fileWriter = new FileWriter(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }





    }
}