package task1.dao.impl;

import task1.annotation.Autowired;
import task1.annotation.Service;
import task1.log.Logger;
import task1.dao.NewCarDao;
import task1.pojo.NewCar;

import java.sql.*;

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
public class NewCarImpl implements NewCarDao {
    @Autowired("dbConnect")
    private Connection dbConnection;

    @Autowired
    private Logger loggerImp;


    /**
     * .
     *
     * @author zgy
     * @date 2024/3/26 20:32
     * @param car
     * @return insert
     * @methodName insert
     *
     *
     **/
    @Override
    public boolean insert(NewCar car)  {

//  0  car.getPrice() car.getName() car.getSale()  car.getBrand() car.getElectric()
        String sql = "insert into new_car values ( ?,?,?, ?, ?, ?)";
        int insert = -1;
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,car.getPrice());
            preparedStatement.setString(3,car.getName());
            preparedStatement.setInt(4,car.getSale());
            preparedStatement.setString(5,car.getBrand());
            preparedStatement.setInt(6,car.getElectric());

             insert = preparedStatement.executeUpdate();
            loggerImp.printInfoDB(": ===> " +sql+" "+ car);
            if(insert>0){
                loggerImp.printInfoDB("插入数据成功");
            }else{
                loggerImp.printInfoDB("插入数据失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return insert>0; // 插入成功 or 失败
    }

    @Override
    public boolean update(NewCar car) {

        String updateSql = "update new_car set price=?,name=?,sale=?,brand=?,electric=? where id= ?";

        int update = -1;
        try {
            // 打印查询语句

            PreparedStatement preparedStatementUpdate = dbConnection.prepareStatement(updateSql);

            preparedStatementUpdate.setInt(1,car.getPrice());

            preparedStatementUpdate.setString(2, car.getName());

            preparedStatementUpdate.setInt(3,car.getSale());

            preparedStatementUpdate.setString(4,car.getBrand());

            preparedStatementUpdate.setInt(5,car.getElectric());

            preparedStatementUpdate.setInt(6,car.getId());

            loggerImp.printInfoDB(": ===> " +updateSql+" ");

            update = preparedStatementUpdate.executeUpdate();

            if(update>0){
                loggerImp.printInfoDB("修改数据成功");
            }else{
                loggerImp.printInfoDB("修改数据失败");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return update>0; //删除 成功 or 失败
    }

    @Override
    public boolean delete(long sid) {
        String sql = "delete  from new_car where id  = ?";
        int delete = -1;
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(1,(int)sid);

            delete = preparedStatement.executeUpdate();
            loggerImp.printInfoDB(": ===> " +sql+" ");
            if(delete>0){
                loggerImp.printInfoDB("删除数据成功");
            }else{
                loggerImp.printInfoDB("删除数据失败");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return delete>0; //删除 成功 or 失败
    }
     //
    public NewCar queryById(int id) {
        // ID 的值
        String sql = "select * from new_car where id = ?";
        NewCar newCar =  new NewCar();
        try {
            loggerImp.printInfoDB(": ===> " +sql+" ");
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                newCar.setPrice(res.getInt("price"));
                newCar.setElectric(res.getInt("electric"));
                newCar.setBrand(res.getString("brand"));
                newCar.setSale(res.getInt("sale"));
                newCar.setId(res.getInt("id"));
                newCar.setName(res.getString("name"));
            }


            //查询 成功 or 失败
        } catch (SQLException e) {
            String message = e.getMessage();
            // 查询失败 写入日志
            loggerImp.printError(message);
            throw new RuntimeException(e);
        }
        return newCar;
    }

    @Override
    public void query(NewCar car) {
        String sql = "select * from new_car where name  = ?";

        try {
            loggerImp.printInfoDB(": ===> " +sql+" ");
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setString(1,car.getName());
            ResultSet res = preparedStatement.executeQuery();

            //查询 成功 or 失败
        } catch (SQLException e) {
            String message = e.getMessage();
            // 查询失败 写入日志
            loggerImp.printInfo(message);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void queryAll() {
        String sql = "select * from new_car";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            loggerImp.printInfoDB(": ===> " +sql);
            showQuery(preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortBy(int judge) {
        String sortV1 = "price";
        String sortV2 = "sale";
        String sql =  "select * from new_car order by ?";
        try {

            PreparedStatement statement = dbConnection.prepareStatement(sql);
            loggerImp.printInfoDB(" :===> " +sql);
           if(judge==1) statement.setString(1,sortV1);
           else statement.setString(1,sortV2);

           showQuery(statement);
        } catch (SQLException e) {
            loggerImp.printErrorDB(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    private void showQuery(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + "   ");
            System.out.print(resultSet.getInt("price") + "   ");
            System.out.print(resultSet.getString("name") + "   ");
            System.out.print(resultSet.getInt("sale") + "   ");
            System.out.print(resultSet.getString("brand")+ "   ");
            System.out.println(resultSet.getInt("electric")+ "   ");
        }
    }

    @Override
    public ResultSet queryByTid(long tid) {

        return null;
    }
}