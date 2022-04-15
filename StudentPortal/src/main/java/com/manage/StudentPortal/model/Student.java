package com.manage.StudentPortal.model;








import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@SolrDocument(collection = "student")

@Entity(name="student")


public class Student implements Serializable {
	
	
	private static final long serialVersionUID = -4439114469417994311L;
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	private Long student_id;
	@Field
	
	public String 	student_name;
	@Field
	
	private String  father_name;
	@Field
	
	private String  last_name;
	@Field

	private String  address;
	@Field
	
	private String  dept;
	@Field
	
	private int roll_no;
	
	public Student() {
		
	}
//	public Student(Long id, String studentname, String father_name,String last_name, int fee) {
//		this.id = id;
//		this.studentname = studentname;
//		this.course = course;
//		this.fee = fee;
//		}

	
	public Long getStudent_id() {
		System.out.println("in student id"+student_id);
		return student_id;
	}

	public Student(Long student_id, String student_name, String father_name, String last_name, String address,
			String dept, int roll_no) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.father_name = father_name;
		this.last_name = last_name;
		this.address = address;
		this.dept = dept;
		this.roll_no = roll_no;
	}


	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	
	
	

}
