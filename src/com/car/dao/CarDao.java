package com.car.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.model.Car;
import com.car.util.StringUtil;

public class CarDao extends BaseDao {
	public boolean addCar(Car car) {
		String sql = "insert into c_car values(?,?,?,?,?,0)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, car.getName());
			preparedStatement.setInt(2, car.getMax_num());
			preparedStatement.setString(3, car.getRent());
			preparedStatement.setString(4, car.getDeposit());
			preparedStatement.setString(5, car.getInfo());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Car> getCarList(Car car) {
		// TODO Auto-generated method stub
		List<Car> retList = new ArrayList<Car>();
		StringBuffer sqlString = new StringBuffer("select * from c_car");
		if(!StringUtil.isEmpty(car.getName())){
			sqlString.append(" and name like '%"+car.getName()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Car c = new Car();
				c.setId(executeQuery.getInt("id"));
				c.setName(executeQuery.getString("name"));
				c.setMax_num(executeQuery.getInt("max_num"));
				c.setRent(executeQuery.getString("rent"));
				c.setDeposit(executeQuery.getString("deposit"));
				c.setInfo(executeQuery.getString("info"));
				c.setSelected_num(executeQuery.getInt("selected_num"));
				retList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from c_car where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Car car) {
		// TODO Auto-generated method stub
		String sql = "update c_car set name=?, max_num=?, rent=?, deposit=?, info=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, car.getName());
			preparedStatement.setInt(2, car.getMax_num());
			preparedStatement.setString(3, car.getRent());
			preparedStatement.setString(4, car.getDeposit());
			preparedStatement.setString(5, car.getInfo());
			preparedStatement.setInt(6, car.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean selectedEnable(int car_id){
		String sql = "select * from c_car where id=?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, car_id);
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				int max_num = executeQuery.getInt("max_num");
				int selected_num = executeQuery.getInt("selected_num");
				if(selected_num >= max_num)return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public boolean updateSelectedNum(int car_id,int num){
		String sql = "update c_car set selected_num = selected_num + ? where id = ?";
		if(num < 0){
			sql = "update c_car set selected_num = selected_num - ? where id = ?";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, car_id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
}
