package task1.dao.impl;

import task1.annotation.Service;
import task1.dao.OldCarDao;
import task1.pojo.OldCar;

import java.sql.ResultSet;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.dao.impl
 * @author: ZGY
 * @createTime: 2024-03-23  02:58
 * @version: 1.0
 */
@Service
public class OldCarImpl implements OldCarDao {

    @Override
    public boolean insert(OldCar car) {
        return false;
    }

    @Override
    public boolean update(OldCar car) {
        return false;
    }

    @Override
    public boolean delete(long sid) {
        return false;
    }

    @Override
    public ResultSet query(OldCar car) {
        return null;
    }

    @Override
    public ResultSet queryAll() {
        return null;
    }

    @Override
    public ResultSet queryByTid(long tid) {
        return null;
    }
}