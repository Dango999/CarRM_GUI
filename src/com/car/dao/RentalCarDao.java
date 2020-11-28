package com.car.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.model.RentalCar;

public class RentalCarDao extends BaseDao {
	public boolean addRentalCar(RentalCar rentalCar){
		String sql = "insert into c_rentalCar values(?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, rentalCar.getCustomer_id());
			preparedStatement.setInt(2, rentalCar.getCar_id());
			preparedStatement.setString(3, rentalCar.getRental_ststus());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateRentalCar(RentalCar rentalCar){
		String sql = "update c_rentalCar set customer_id = ?, car_id = ?, rental_ststus = ? where id = ?";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, rentalCar.getCustomer_id());
			preparedStatement.setInt(2, rentalCar.getCar_id());
			preparedStatement.setString(3, rentalCar.getRental_ststus());
			preparedStatement.setInt(4, rentalCar.getId());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<RentalCar> getRentalCarList(RentalCar rentalCar){
		List<RentalCar> retList = new ArrayList<RentalCar>();
		StringBuffer sqlString = new StringBuffer("select * from c_rentalCar");
		if(rentalCar.getCustomer_id() != 0){
			sqlString.append(" and customer_id = "+rentalCar.getCustomer_id());
		}
		if(rentalCar.getCar_id() != 0){
			sqlString.append(" and car_id ="+rentalCar.getCar_id());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				RentalCar rc = new RentalCar();
				rc.setId(executeQuery.getInt("id"));
				rc.setCustomer_id(executeQuery.getInt("customer_id"));
				rc.setCar_id(executeQuery.getInt("car_id"));
				rc.setRental_ststus(executeQuery.getString("rental_ststus"));
				retList.add(rc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean isSelected(RentalCar rentalCar){
		String sql = "select * from c_rentalCar where customer_id=? and car_id = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, rentalCar.getCustomer_id());
			prst.setInt(2, rentalCar.getCar_id());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id){
		String sql = "delete from c_rentalCar where id=?";
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
}
