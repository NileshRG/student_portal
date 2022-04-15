package com.manage.StudentPortal.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.manage.StudentPortal.model.StudentSolr;

public interface StudentSolrRepository extends SolrCrudRepository<StudentSolr, Long> {

	   // public List<Product> findByName(String name);

		public List<StudentSolr> findByfirstnameLike(String Name);
		

	    

	}