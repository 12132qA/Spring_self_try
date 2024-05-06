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

// 普通汽车
@Component
public class Car {

    // ID标识
    public int id;
    // 车辆价格
    public int price;
     // 车辆名称
    public String name;

    @Override
    public String toString() {
        return "Car{ " +
                "ID: " + id +
                ", price: " + price + ", name: " + name + " " + ", type: " + type + " " + ", sale: " + sale + ", brand: " + brand + " " +
                '}';
    }

    public Car(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // 车辆
    public String type;
    //销量
    public int sale;
    // 车辆品牌
    public String brand;

}