package com.example.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.application.form.AnotherTestForm;
import com.example.domain.entity.TestEntity;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class TestRepositoryImpl implements TestRepository {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<TestEntity> getAll() {
		List<TestEntity> results = new ArrayList<>();
		String sql = "SELECT e.empid,e.name,e.branch,e.age,h.hobname FROM employee e "
				+ "inner join hobby h"
				+ " on e.hobid = h.hobid";
		results = jdbc.query(sql, new BeanPropertyRowMapper<TestEntity>(TestEntity.class));
		return results;
	}

}
