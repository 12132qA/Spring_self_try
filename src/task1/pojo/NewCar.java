package task1.pojo;

import task1.annotation.Component;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.dao
 * @author: ZGY
 * @createTime: 2024-03-23  02:22
 * @version: 1.0
 */


// 新式车辆 汽车


@Component
public class NewCar extends Car{

    @Override
    public String toString() {
        return "Car{ " +
                "ID: " + super.getId()+
                ", price: " + super.getPrice() + ", name: " + super.getName() + " " + ", type: " + super.getType() + " " + ", sale: " + super.getSale() + ", brand: " + super.getBrand() + " " +
                '}';
    }

    // 每公里耗电
    int electric = 0;

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }
}