package com.manage.StudentPortal.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.manage.StudentPortal.model.StudentSolr;
import com.manage.StudentPortal.repository.StudentSolrRepository;


@Component
public class SolrServices {
	
	
	private StudentSolrRepository prodrepo;
	
	public void save(List<StudentSolr> listprod)
	{
		prodrepo.saveAll(listprod);
	}
	
	

		
}
