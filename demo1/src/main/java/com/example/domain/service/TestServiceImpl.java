package com.example.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.form.SelectForm;
import com.example.domain.entity.TestEntity;
import com.example.domain.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestRepository testRepository;
	
	public List<SelectForm> getAllData(){
		List<SelectForm> list = new ArrayList<>();
 		List<TestEntity> empList = testRepository.getAll();
		/*
		 * //entityクラスでセットした値を追加するList List<TestEntity> list = new ArrayList<>();
		 * for(TestEntity str1 : empList) { TestEntity testEntity = new TestEntity();
		 * //empListから引っ張ってくる値はObject型なのでsetterの引数に合致する型にキャストをする必要がある
		 * testEntity.setEmpId(str1.getEmpId()); testEntity.setName(str1.getName());
		 * testEntity.setBranch(str1.getBranch()); testEntity.setAge(str1.getAge());
		 * testEntity.setHobname(str1.getHobname()); //セットされた値をTestEntity型のListに追加
		 * list.add(testEntity); }
		 */
 		for(TestEntity entity : empList) {
 			SelectForm form = new SelectForm();
 			form.setEmpid(entity.getEmpId());
 			form.setA_name(entity.getName());
 			form.setA_branch(entity.getBranch());
 			form.setA_age(entity.getAge());
 			form.setHobname(entity.getHobname());
 			list.add(form);
 		}
		return list;
	}
}
