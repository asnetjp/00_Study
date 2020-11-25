package com.example.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.application.form.AnotherTestForm;

@Repository
public class TestInsertRepositoryImpl implements TestInsertRepository {
	@Autowired
	JdbcTemplate jdbc;
	@Override
	public int insert(AnotherTestForm form) {
		int results = jdbc.update("INSERT INTO employee(name, branch,age,hobid) "
				+ "VALUES(?, ?, ?, ?) ",
                form.getAnother(),
                form.getBranch(),
                form.getAge(),
				form.getHobid());
		return results;
	}
		
}
