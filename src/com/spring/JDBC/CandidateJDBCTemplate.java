package com.spring.JDBC;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

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

}
