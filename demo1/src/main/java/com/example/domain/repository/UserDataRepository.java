package com.example.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.controller.JsonModel;
import com.example.domain.entity.UserData;

public interface UserDataRepository {
	public List<UserData> getAll(UserData user);
}
