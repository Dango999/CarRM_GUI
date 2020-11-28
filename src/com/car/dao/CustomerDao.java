package com.car.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.model.Customer;
import com.car.util.StringUtil;

public class CustomerDao extends BaseDao {
	public boolean addCustomer(Customer customer) {
		String sql = "insert into c_customer values(?,?,?,?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getLicense());
			preparedStatement.setString(4, customer.getIdentity());
			preparedStatement.setString(5, customer.getSex());
			preparedStatement.setString(6, customer.getAge());
			preparedStatement.setString(7, customer.getPhone());
			preparedStatement.setString(8, customer.getAddress());
			preparedStatement.setString(9, customer.getMail());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Customer> getCustomerList(Customer customer){
		List<Customer> retList = new ArrayList<Customer>();
		StringBuffer sqlString = new StringBuffer("select * from c_customer");
		if(!StringUtil.isEmpty(customer.getName())){
			sqlString.append(" and name like '%"+customer.getName()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Customer c = new Customer();
				c.setId(executeQuery.getInt("id"));
				c.setName(executeQuery.getString("name"));
				c.setPassword(executeQuery.getString("password"));
				c.setLicense(executeQuery.getString("license"));
				c.setIdentity(executeQuery.getString("identity"));
				c.setSex(executeQuery.getString("sex"));
				c.setAge(executeQuery.getString("age"));
				c.setPhone(executeQuery.getString("phone"));
				c.setAddress(executeQuery.getString("address"));
				c.setMail(executeQuery.getString("mail"));
				retList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from c_customer where id=?";
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
	public boolean update(Customer customer){
		String sql = "update c_customer set name=?, password=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setInt(3, customer.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public String editPassword(Customer customer,String newPassword){
		String sql = "select * from c_customer where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, customer.getId());
			prst.setString(2, customer.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update c_customer set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把sql语句传给数据库操作对象
		return retString;
	}
	public Customer login(Customer customer){
		String sql = "select * from c_customer where name=? and password=?";
		Customer customerRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, customer.getName());
			prst.setString(2, customer.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				customerRst = new Customer();
				customerRst.setId(executeQuery.getInt("id"));
				customerRst.setName(executeQuery.getString("name"));
				customerRst.setPassword(executeQuery.getString("password"));
				customerRst.setLicense(executeQuery.getString("license"));
				customerRst.setIdentity(executeQuery.getString("identity"));
				customerRst.setSex(executeQuery.getString("sex"));
				customerRst.setAge(executeQuery.getString("age"));
				customerRst.setPhone(executeQuery.getString("phone"));
				customerRst.setMail(executeQuery.getString("mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerRst;
	}
}
