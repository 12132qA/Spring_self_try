package task1.dao;

import task1.pojo.Car;
import task1.pojo.NewCar;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.dao
 * @author: ZGY
 * @createTime: 2024-03-23  02:56
 * @version: 1.0
 */

public interface NewCarDao {
    boolean insert(NewCar car) throws SQLException;
    public boolean update(NewCar car);
    public  boolean delete(long sid);
    public void query(NewCar car);
    public void queryAll();



    void sortBy(int judge);

    // 按 ID 进行 指定车辆 查询
    ResultSet queryByTid(long tid);
}