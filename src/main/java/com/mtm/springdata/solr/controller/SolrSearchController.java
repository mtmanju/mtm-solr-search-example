package com.mtm.springdata.solr.controller;

import java.util.Optional;

import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtm.springdata.solr.document.SampleSolrDocument;

@RequestMapping("/search")
public interface SolrSearchController {

	@PostMapping
	String createSampleSolrDocument(@RequestBody SampleSolrDocument SampleSolrDocument);

	@GetMapping("/{id}")
	Optional<SampleSolrDocument> getSampleSolrDocumentForId(@PathVariable Long id);

	@RequestMapping(value = "/{q}")
	public SolrDocumentList searchQuery(@PathVariable String q);

}