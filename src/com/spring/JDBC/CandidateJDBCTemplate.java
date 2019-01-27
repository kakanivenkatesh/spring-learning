package com.spring.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CandidateJDBCTemplate implements CandiateDAO{
	
	private DataSource datasource;
	private JdbcTemplate jdbctemplate;
	

	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource= datasource;
		this.jdbctemplate = new JdbcTemplate(datasource);
		
	}

	@Override
	public void create(String name, String email) {
		String SQL = "insert into Candidate (name, email) values (?, ?)";
    
		jdbctemplate.update( SQL, name, email);
	    System.out.println("Created Record Name = " + name + " Email = " + email);
	    return;
		
	}

	@Override
	public List<Candidate> listCandidates() {
		String SQL = "select * from Candidate";
	      List <Candidate> candidate = jdbctemplate.query(SQL, new CandidateMapper());
	      return candidate;
	}

	@Override
	public void delete(String email) {
		String SQL="delete from Candidate where email=?";
		jdbctemplate.update(SQL,email);
        System.out.println("Deleted record with email_id: "+email);
        return ;
		
	}

	@Override
	public void update(String email, String name) {
		String SQL = "update Candidate set name=? where email=?";
		jdbctemplate.update(SQL, name, email);
        System.out.println("Updated record with email_id: "+email);
        return ; 
		
	}

	
	public List<Candidate> listCandidatesInfo(){
		String SQL = "select * from Candidate";
	      List <Candidate> candidates = jdbctemplate.query(SQL,  new ResultSetExtractor<List<Candidate>>(){
	         
	    	 @Override
	         public List<Candidate> extractData(ResultSet rs) throws SQLException, DataAccessException {
	            
	            List<Candidate> list = new ArrayList<Candidate>();  
	            while(rs.next()){  
	            	Candidate candidate = new Candidate();
	            	candidate.setName(rs.getString("name"));
	            	candidate.setEmail(rs.getString("email"));
	               list.add(candidate);  
	            }  
	            return list;  
	         }    	  
	      });
	   return candidates;
	}
	
	
	public boolean insertCandidateInfoByPreparedStatement(Candidate candidate){
		String query="insert into Candidate values(?,?,?)";  
		return jdbctemplate.execute(query, new PreparedStatementCallback<Boolean>(){
			
			@Override
			public Boolean doInPreparedStatement(PreparedStatement preparestatment)  
		            throws SQLException, DataAccessException { 
				preparestatment.setInt(1, candidate.getId());
				preparestatment.setString(2, candidate.getName());
				preparestatment.setString(3, candidate.getEmail());
				return preparestatment.execute();
			}
			
				});
		
	}
	
}
