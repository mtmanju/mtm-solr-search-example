package com.mtm.springdata.solr.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Data;

/**
 * @author Manjunath M T
 */
@Data
@SolrDocument(collection = "SampleSolrDocument")
public class SampleSolrDocument {

	@Id
	@Indexed(name = "id", type = "long")
	private Long id;

	@Indexed(name = "name", type = "string")
	private String name;

	@Indexed(name = "company", type = "string")
	private String company;

	@Indexed(name = "contactnumber", type = "string")
	private String contactnumber;

}