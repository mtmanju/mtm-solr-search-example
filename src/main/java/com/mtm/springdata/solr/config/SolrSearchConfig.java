package com.mtm.springdata.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

@Configuration
public class SolrSearchConfig {

	@Value("spring.data.solr.host")
	private String solrURL;

	@Bean
	public SolrClient solrClient() {
		return new HttpSolrClient.Builder(solrURL).build();
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient client) throws Exception {
		return new SolrTemplate(client);
	}
}