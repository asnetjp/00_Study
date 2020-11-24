package com.example.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.TestEntity;
import com.example.domain.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestRepository testRepository;
	
	public List<TestEntity> getAllData(){
		List<Map<String,Object>> empList = testRepository.getAll();
		//entityクラスでセットした値を追加するList
		List<TestEntity> list = new ArrayList<>();
		for(Map<String,Object> str1 : empList) {
			TestEntity testEntity = new TestEntity();
			//empListから引っ張ってくる値はObject型なのでsetterの引数に合致する型にキャストをする必要がある
			testEntity.setEmpId((int) str1.get("empid"));
			testEntity.setName((String)str1.get("name"));
			testEntity.setBranch((String) str1.get("branch"));
			testEntity.setAge((int)str1.get("age"));
			testEntity.setHobname((String) str1.get("hobname"));
			//セットされた値をTestEntity型のListに追加
			list.add(testEntity);
		}
		return list;
	}
}
