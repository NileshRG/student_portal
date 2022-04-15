package com.manage.StudentPortal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.manage.StudentPortal.model.Student;
import com.manage.StudentPortal.model.StudentSolr;
import com.manage.StudentPortal.repository.StudentSolrRepository;
import com.manage.StudentPortal.service.StudentService;



@RestController
public class SolrController {
	
//	@Autowired 
//	private SolrServices solrserv;
	
	@Autowired
	private StudentService stdservice;
	
	
	@Autowired
	private StudentSolrRepository repo;
	
	

	public void saveStudent(List<StudentSolr> listsolr)
	{
		System.out.println("in solr controller"+listsolr.size());
		repo.saveAll(listsolr);
		
	}
//	@PostMapping("/find/{id}")
	public List<Student> find( Long id)
	{
		System.out.println("In solr");
		Optional<StudentSolr> solrList=repo.findById(id);
		List<StudentSolr>  result=new ArrayList<>();
		Boolean find=true;
		solrList.ifPresent(result::add);
		List<Student> studentList=new ArrayList<>();
		if(result.isEmpty())
		{
			System.out.println("in if of solr");
			find=false;
			
		}
		else
		{
			Optional<Student> redisList=stdservice.getRedisById(id);
			
			 redisList.ifPresent(studentList::add);
			 System.out.println("in else of solr");
			
		}
		return studentList;
		
		
		
		
		
	}
	public List<StudentSolr> findByName(String student_name)
	{
		System.out.println("in search by name");
		return repo.findByfirstnameLike(student_name);
	}

	

}

