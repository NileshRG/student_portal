package com.manage.StudentPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manage.StudentPortal.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query(value="select Max(student_id) from student ")
	Long getByLastId();

}