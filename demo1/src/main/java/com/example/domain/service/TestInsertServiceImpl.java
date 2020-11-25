package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.form.AnotherTestForm;
import com.example.domain.repository.TestInsertRepository;

@Service
public class TestInsertServiceImpl implements TestInsertService {
	@Autowired
	TestInsertRepository testInsert;
	
	public int insertData(AnotherTestForm form) {
		int results = testInsert.insert(form);
		return results;
	}
}
