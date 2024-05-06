package task1.dao;

import task1.pojo.NewCar;
import task1.pojo.OldCar;

import java.sql.ResultSet;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.dao
 * @author: ZGY
 * @createTime: 2024-03-23  02:57
 * @version: 1.0
 */

public interface OldCarDao {
    boolean insert(OldCar car);
    public boolean update(OldCar car);
    public  boolean delete(long sid);
    public ResultSet query(OldCar car);
    public ResultSet queryAll();

    // 按 ID 进行 指定车辆 查询
    ResultSet queryByTid(long tid);
}