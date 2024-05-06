package task1.in;

import task1.annotation.Autowired;
import task1.annotation.Start;
import task1.dao.impl.NewCarImpl;
import task1.dao.impl.OldCarImpl;
import task1.pojo.Car;
import task1.pojo.NewCar;
import task1.pojo.OldCar;

import java.io.IOException;
import java.util.Scanner;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.in
 * @author: ZGY
 * @createTime: 2024-03-23  13:16
 * @version: 1.0
 */
@Start
public class Entrance {
    @Autowired
    private NewCar newCar;
    @Autowired
    OldCar oldCar;
    @Autowired
    private Car car;
    @Autowired
    private NewCarImpl newCarImpl;
    @Autowired
    private OldCarImpl oldCarImpl;

    private final Scanner sc = new Scanner(System.in);
    public  void entranceMenu() throws IOException {

//        System.out.println("欢迎进入 --- --->  ");
        System.out.println("  ==================================       车辆优购系统        ==================================");
        // 33 黄色   36 绿色
        System.out.println("\033[37m=================================== A.新式式车辆 B. 旧式车辆  =================================== \033[32m");

        System.out.println("==============================================================================================");
        String  c  =  sc.next();
        if(c.charAt(0) == 'A'){
            System.out.println("A. 新式车辆 ");
        }else{
            System.out.println("B. 旧式车辆");
        }
       while(true){
           System.out.println("\033[36m 1-新增车辆  2-修改车辆  3-删除车辆  4-车辆推荐 5-退出  \033[32m");

           int read = sc.nextInt();
           if(read == 1){
               System.out.println("==== 车辆新增 ===== ");
               System.out.print("Price(价格): ");
                newCar.setPrice(sc.nextInt());
               System.out.print("Name(名称): ");
               newCar.setName( sc.next());
               System.out.print("Sale(销量): ");
               newCar.setSale(sc.nextInt());
               System.out.print("brand(品牌): ");
               newCar.setBrand(sc.next());
               System.out.print("electric(每公里耗电量): ");
               newCar.setElectric(sc.nextInt());
               newCarImpl.insert(newCar);
           }else if(read ==2){
               System.out.println("==== 车辆信息修改 ===== ");
               newCarImpl.queryAll();
               System.out.println("请输入 你要修改的字段 ID: ");
               int updateId = sc.nextInt();
               NewCar updateCar = newCarImpl.queryById(updateId);

               System.out.println("  1- 价格  2- 名称  3- 销量  4- 品牌  5- 每公里耗电量 ");
               int updateValue = sc.nextInt();
               if(updateValue==1){
                   updateCar.setPrice(sc.nextInt());
               }else if(updateValue==2){
                   updateCar.setName(sc.next());
               }else if(updateValue==3){
                   updateCar.setSale(sc.nextInt());
               }else if(updateValue==4){
                   updateCar.setBrand(sc.next());
               }else{
                   updateCar.setElectric(sc.nextInt());
               }
               // 更新方法
               newCarImpl.update(updateCar);
           }else if(read == 3){
               System.out.println("==== 车辆信息删除 ===== ");
               newCarImpl.queryAll();
               System.out.print("请输入ID: ");
               int id = sc.nextInt();
               newCarImpl.delete(id);
           }else if(read == 4){
               System.out.println("==== 车辆信息推荐 ===== ");
               System.out.println(" 1- 根据销量排序推荐,  2- 根据价格排序推荐");
               int sort = sc.nextInt();
               newCarImpl.sortBy(sort);
           }else{


           }
       }



    }
}