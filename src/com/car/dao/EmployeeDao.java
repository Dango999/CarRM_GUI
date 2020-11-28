package com.car.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.model.Employee;
import com.car.util.StringUtil;

public class EmployeeDao extends BaseDao {
	public boolean addEmployee(Employee employee) {
		String sql = "insert into c_employee values(?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getPhone());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Employee> getEmployeeList(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> retList = new ArrayList<Employee>();
		StringBuffer sqlString = new StringBuffer("select * from c_employee");
		if(!StringUtil.isEmpty(employee.getName())){
			sqlString.append(" and name like '%"+employee.getName()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Employee e = new Employee();
				e.setId(executeQuery.getInt("id"));
				e.setName(executeQuery.getString("name"));
				e.setPassword(executeQuery.getString("password"));
				e.setPhone(executeQuery.getString("phone"));
				retList.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from c_employee where id=?";
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

	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "update c_employee set name=?, password=?, phone=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setInt(4, employee.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "select * from c_employee where name=? and password=?";
		Employee employeeRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, employee.getName());
			prst.setString(2, employee.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				employeeRst = new Employee();
				employeeRst.setId(executeQuery.getInt("id"));
				employeeRst.setName(executeQuery.getString("name"));
				employeeRst.setPassword(executeQuery.getString("password"));
				employeeRst.setPhone(executeQuery.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeRst;
	}
	public String editPassword(Employee employee,String newPassword){
		String sql = "select * from c_employee where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, employee.getId());
			prst.setString(2, employee.getPassword());
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
		String sqlString = "update c_employee set password = ? where id = ?";
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
}
