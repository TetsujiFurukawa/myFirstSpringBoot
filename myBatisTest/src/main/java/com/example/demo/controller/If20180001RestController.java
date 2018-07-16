package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.WorkItem;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkItemListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018001Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180001")
@NoArgsConstructor
public class If20180001RestController {

	@Autowired
	If2018001Service if2018001Service;

	@GetMapping
	public WorkItemListDto getWorkItems() {
		List<WorkItem> workItems = if2018001Service.getWorkItems();

		// 労働アイテムを取得し返却する。
		WorkItemListDto workItemListDto = new WorkItemListDto(workItems);

		return workItemListDto;
	}

}
