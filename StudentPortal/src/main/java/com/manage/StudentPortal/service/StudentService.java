package com.manage.StudentPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.manage.StudentPortal.model.Student;
import com.manage.StudentPortal.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	//@Cacheable(value="student")
	public List<Student> listAll() {
		System.out.println("in listAll");
        return repo.findAll();
    }
	
	public void saveStudent(Student std)
	{
		 repo.save(std);
		// pr.save(pf);
		
		
		
	}
	
	
	@Cacheable(value="student_details",key="#student_id")
	public Optional<Student> getRedisById(Long student_id)
	{
		System.out.println("in redis id= "+student_id);
		return repo.findById(student_id);
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
		
	}

	public Student get(long id) {
		// TODO Auto-generated method stub
		
		return repo.findById(id).get();
	}
	public Long getLatestId()
	{
		return repo.getByLastId();
	}
	
	

}
