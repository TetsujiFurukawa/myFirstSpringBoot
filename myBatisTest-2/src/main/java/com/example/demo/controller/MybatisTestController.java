package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MFamily;
import com.example.demo.MFamilyMapper;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/")
@NoArgsConstructor
public class MybatisTestController {

	@Autowired
	MFamilyMapper mFamilyMapper;

	@GetMapping
	public MFamily getWorkItems() {
		MFamily res = mFamilyMapper.selectByPrimaryKey(1);
		return res;
	}

}
