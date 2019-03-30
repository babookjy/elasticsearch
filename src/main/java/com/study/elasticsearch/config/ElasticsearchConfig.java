package com.study.elasticsearch.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Setter;

@Configuration
@ConfigurationProperties("elasticsearch")
public class ElasticsearchConfig {
	@Setter
	private String hosts;
	
	@Setter
	private Integer port;
	
	@Bean(name="restClient", destroyMethod="close")
	public RestClient restClient() {
		RestClientBuilder builder = RestClient.builder(new HttpHost(hosts, port, "http"));
		
		builder.setMaxRetryTimeoutMillis(10000);
		
		Header[] defaultHeaders = new Header[]{new BasicHeader("header", "value")};
		builder.setDefaultHeaders(defaultHeaders);
		
		builder.setFailureListener(new RestClient.FailureListener() {
			@Override
		    public void onFailure(Node node) {
		        System.out.println(111);
		    }
		});
		
		builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
		    @Override
		    public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
		        return requestConfigBuilder.setSocketTimeout(10000); 
		    }
		});
		
		return builder.build();
	}
}
