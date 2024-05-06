package task1.pojo;

import task1.annotation.Component;


/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.dao
 * @author: ZGY
 * @createTime: 2024-03-23  02:26
 * @version: 1.0
 */
// 老式车辆
@Component
public class OldCar  extends Car{
     // 每公里油耗
     int oil =  0;

     @Override
     public String toString() {
          return "OldCar{" +
                  "oil=" + oil +
                  ", id=" + id +
                  ", price=" + price +
                  ", name='" + name + '\'' +
                  ", type='" + type + '\'' +
                  ", sale=" + sale +
                  ", brand='" + brand + '\'' +
                  '}';
     }

     public void setOil(int oil) {
          this.oil = oil;
     }

}