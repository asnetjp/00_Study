package com.example.domain.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.controller.JsonModel;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UserData;

@Repository
public class UserDataRepositoryImpl implements UserDataRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<UserData> getAll(UserData user) {
			List<UserData> results = new ArrayList<>();
			String sql = "SELECT name FROM employee WHERE empid = ?",
					;
			results = jdbc.query(sql, new BeanPropertyRowMapper<UserData>(UserData.class));
			return results;
		}
	}

