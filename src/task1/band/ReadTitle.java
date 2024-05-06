package task1.band;

import task1.log.LoggerImp;

import java.io.*;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1.band
 * @author: ZGY
 * @createTime: 2024-03-24  01:12
 * @version: 1.0
 *
 *  标题的打印
 */

public class ReadTitle {
    public static void readAndInput(){
        File file = new File("D:\\genyonTask\\myTak\\src\\task1\\band\\title.txt");
        // 输出流
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 追加换行符保持原文件格式
                content.append(line).append(System.lineSeparator());
            }
            // 输出文件内容到控制台
            System.out.println(content.toString());

        } catch (FileNotFoundException e) {
            LoggerImp.staticPrintInfo("找不到文件：" + file.getAbsolutePath());
            e.printStackTrace();
        } catch (IOException e) {
            LoggerImp.staticPrintInfo("读取文件时发生错误");
            e.printStackTrace();
        }

    }

}