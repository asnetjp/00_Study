package com.example.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.application.form.AnotherTestForm;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class TestRepositoryImpl implements TestRepository {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Map<String,Object>> getAll() {
		String sql = "SELECT e.empid,e.name,e.branch,e.age,h.hobname FROM employee e "
				+ "inner join hobby h"
				+ " on e.hobid = h.hobid";
		List<Map<String, Object>>empList = jdbc.queryForList(sql);
		return empList;
	}

}
