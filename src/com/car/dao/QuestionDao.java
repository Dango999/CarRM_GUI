package com.car.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.model.Question;
import com.car.util.StringUtil;

public class QuestionDao extends BaseDao {
	public boolean addEmployee(Question question) {
		String sql = "insert into c_question values(?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, question.getQuestion());
			preparedStatement.setString(2, question.getAnswer());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Question> getQuestionList(Question question) {
		// TODO Auto-generated method stub
		List<Question> retList = new ArrayList<Question>();
		StringBuffer sqlString = new StringBuffer("select * from c_question");
		if(!StringUtil.isEmpty(question.getQuestion())){
			sqlString.append(" and question like '%"+question.getQuestion()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Question q = new Question();
				q.setId(executeQuery.getInt("id"));
				q.setQuestion(executeQuery.getString("question"));
				q.setAnswer(executeQuery.getString("answer"));
				retList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean update(Question question) {
		// TODO Auto-generated method stub
		String sql = "update c_question set answer=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, question.getAnswer());
			preparedStatement.setInt(2, question.getId());
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
