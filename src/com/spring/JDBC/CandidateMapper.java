package com.spring.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CandidateMapper implements RowMapper<Candidate>{
	
	   @Override
	   public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Candidate candidate = new Candidate();
		   candidate.setName(rs.getString("name"));
		   candidate.setEmail(rs.getString("email"));
		   return candidate;
		   }
		}