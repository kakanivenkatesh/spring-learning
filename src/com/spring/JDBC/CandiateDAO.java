package com.spring.JDBC;

import java.util.List;
import javax.sql.DataSource;

public interface CandiateDAO {

	public void setDataSource(DataSource datasource);
	public void create(String name, String email);
	public List<Candidate> listCandidates();
	public void delete(String email);
	public void update(String email, String name);
}
