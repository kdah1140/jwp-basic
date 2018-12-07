package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import core.jdbc.JdbcTemplate;
import next.model.Answer;
import next.model.Question;

public class AnswerDao {
	
	public void delete(long answerId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "DELETE FROM ANSWERS WHERE answerId=?";
		jdbcTemplate.update(sql, answerId);
	}
	
	public List<Answer> findAll(long questionId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();           	
        
        String sql = "SELECT answerId, writer, contents, createdDate, questionId FROM ANSWERS, WHERE questionId=?, ORDER BY answerID DESC";
        return jdbcTemplate.query(sql, 
        		(ResultSet rs) ->{
        			return new Answer(
        					rs.getLong("answerId"), 
        					rs.getString("writer"),  
        					rs.getString("contents"), 
        					rs.getTimestamp("createdDate"), 
        					rs.getInt("questionId"));       	
        		}, questionId);
    }

    public Answer findById(Long answerId) throws SQLException {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(); 
    	        
        String sql = "SELECT answerId, writer, contents, createdDate, questionId FROM ANSWERS, WHERE answerId=?";
        return jdbcTemplate.queryForObject(sql, 
        		(ResultSet rs) ->{
        			return new Answer(
        					rs.getLong("questionId"), 
        					rs.getString("writer"),  
        					rs.getString("contents"), 
        					rs.getTimestamp("createdDate"),
        					rs.getInt("questionId"));       	
        		}, answerId);
   	}	
}
