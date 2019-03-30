package com.study.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.elasticsearch.service.ElasticsearchService;

@Controller
public class LowLevelController {
	@Autowired
	private ElasticsearchService searchService;
	
	@GetMapping("/low-level")
	public String lowLevelSearch() throws Exception {
		searchService.lowLevelSearch();
		return "";
	}
}
