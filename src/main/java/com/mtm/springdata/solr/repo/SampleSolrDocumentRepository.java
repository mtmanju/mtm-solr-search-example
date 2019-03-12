package com.mtm.springdata.solr.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.mtm.springdata.solr.document.SampleSolrDocument;

/**
 * @author ManjunathMT
 *
 */
public interface SampleSolrDocumentRepository extends SolrCrudRepository<SampleSolrDocument, Long> {

	@Query("id:*?0* OR name:*?0*")
	public Page<SampleSolrDocument> findByCustomQuery(String searchTerm, Pageable pageable);

	@Query(name = "SampleSolrDocument.findByNamedQuery")
	public Page<SampleSolrDocument> findByNamedQuery(String searchTerm, Pageable pageable);
}