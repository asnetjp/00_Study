package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.application.form.AnotherTestForm;
import com.example.domain.repository.TestInsertRepository;

@Service
public class TestInsertServiceImpl implements TestInsertService {
	@Autowired
	TestInsertRepository testInsert;
	@Transactional
	public int insertData(AnotherTestForm form) {
		int results = 0;
		results = testInsert.insert(form);
		/*
		 * results == 1 例外が発生する
		 * results != 1 例外が発生しない  
		 */
		if(results == 1) {	
			throw new RuntimeException();
		}
		return results;
	}
}
