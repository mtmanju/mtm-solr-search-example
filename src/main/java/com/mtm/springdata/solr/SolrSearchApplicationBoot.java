package com.mtm.springdata.solr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EnableSolrRepositories(basePackages = "com.mtm.springdata.solr")
public class SolrSearchApplicationBoot {
	private static final Logger LOGGER = LoggerFactory.getLogger(SolrSearchApplicationBoot.class);

	public static void main(String[] args) {
		LOGGER.info("############# Solr Search Service: Start ###############");

		SpringApplication.run(SolrSearchApplicationBoot.class, args);
	}

}