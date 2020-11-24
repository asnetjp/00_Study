package com.example.domain.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class RandomServiceImpl implements RandomService{
	public ArrayList<Integer> random(){
		int dice = 0;
    	ArrayList<Integer> randomList = new ArrayList<Integer>();
    	for(int i = 0; i<5; i++) {
    		/*
    		 * Math.floor 与えられた数値以下の最大の整数を返す
    		 * Math.floorがlong型なのでintに変換
    		 */
    		dice = (int)Math.floor(Math.random() * 100);
    		randomList.add(dice);
    	}
    	return randomList;
	}
}
