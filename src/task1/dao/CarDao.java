package task1.dao;

import task1.pojo.Car;
import task1.pojo.NewCar;


import java.sql.ResultSet;

/**
 * @author 张根勇
 */ //对该数据进行增删改查操作
public interface CarDao {
     boolean insert(Car car);
    public boolean update(Car car);
    public  boolean delete(long sid);
    public ResultSet query(Car car);
    public ResultSet queryAll();
    // 按 ID 进行 指定车辆 查询
    ResultSet queryByTid(long tid);
}