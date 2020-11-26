package com.example.domain.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.application.form.AnotherTestForm;


public interface TestInsertService {
	public int insertData(AnotherTestForm form);
}
