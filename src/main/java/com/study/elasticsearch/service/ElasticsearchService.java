package com.study.elasticsearch.service;

import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchService {
	@Autowired
	private RestClient restClient;
	
	public void lowLevelSearch() throws Exception {
		Request request = new Request(
			    "GET",  
			    "bigginsight/usageReport/_search?size=1");   
		Response response = restClient.performRequest(request);
		
		System.out.println(111);
	}
}
