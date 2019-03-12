package com.mtm.springdata.solr.controller.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.springdata.solr.controller.SolrSearchController;
import com.mtm.springdata.solr.document.SampleSolrDocument;
import com.mtm.springdata.solr.repo.SampleSolrDocumentRepository;

/**
 * @author Manjunath M T
 * 
 */
@RestController
public class SolrSearchControllerImpl implements SolrSearchController {

	private final static Logger logger = LoggerFactory.getLogger(SolrSearchControllerImpl.class);

	@Autowired
	private SolrClient solrClient;

	@Autowired
	private SampleSolrDocumentRepository sampleSolrDocumentRepository;

	@Override
	public String createSampleSolrDocument(@RequestBody SampleSolrDocument SampleSolrDocument) {
		String description = "SampleSolrDocument Created";
		sampleSolrDocumentRepository.save(SampleSolrDocument);
		return description;
	}

	@Override
	public SolrDocumentList searchQuery(@PathVariable String q) {

		logger.info("Started  execution of searchQuery() method, search for string " + "{" + q + "}	");
		SolrQuery query = new SolrQuery();
		// query.setStart(0);
		// query.setQuery("1");
		// query.addFilterQuery("1", "2");
		// query.setFields("id", "applicantid", "applicationnumber");
		query.set("q", "*:*");
		query.setRows(100);
		SolrDocumentList docsList = new SolrDocumentList();
		try {
			QueryResponse response = solrClient.query(query);
			if (null != response) {
				docsList = response.getResults();
			}
		} catch (SolrServerException | IOException e) {
			logger.error("Either SolrServerException or IOException occurred ", e);
		}

		logger.info("Completed execution of searchQuery() method");
		return docsList;
	}

	@Override
	public Optional<SampleSolrDocument> getSampleSolrDocumentForId(@PathVariable("id") Long id) {
		return sampleSolrDocumentRepository.findById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteSampleSolrDocument(@PathVariable Long id) {
		String description = "SampleSolrDocument Deleted";
		sampleSolrDocumentRepository.deleteById(id);
		return description;
	}

	@GetMapping("/{searchTerm}/{page}")
	public List<SampleSolrDocument> findAll(@PathVariable String searchTerm, @PathVariable int page) {
		return sampleSolrDocumentRepository.findByCustomQuery(searchTerm, PageRequest.of(page, 2)).getContent();
	}

}
