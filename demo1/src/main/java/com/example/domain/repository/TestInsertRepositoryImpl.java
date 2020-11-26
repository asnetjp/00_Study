package com.example.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.application.form.AnotherTestForm;

@Repository
public class TestInsertRepositoryImpl implements TestInsertRepository {
	@Autowired
	JdbcTemplate jdbc;
	
	public int insert(AnotherTestForm form) {
		int results = jdbc.update("INSERT INTO employee(name, branch,age,hobid) "
				+ "VALUES(?, ?, ?, ?) ",
                form.getA_name(),
                form.getA_branch(),
                form.getA_age(),
				form.getHobid());
		return results;
	}
		
}
