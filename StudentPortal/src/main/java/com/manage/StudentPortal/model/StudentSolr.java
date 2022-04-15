package com.manage.StudentPortal.model;


import javax.persistence.Id;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@SolrDocument(collection = "student")
public class StudentSolr {
   
    @Id
    @Field
    public Long id;

   

	@Field
    private String firstname;
	
	@Field
    private String last_name;
	
	@Field
    private String father_name;
	
	@Field
    private String address;
	
	@Field
    private String dept;
	
	@Field
    private int  roll_no;
	
	
    
    
    public StudentSolr(Long id, String student_name, String last_name, String father_name, String address, String dept,
			int roll_no) {
		super();
		this.id = id;
		this.firstname = student_name;
		this.last_name = last_name;
		this.father_name = father_name;
		this.address = address;
		this.dept = dept;
		this.roll_no = roll_no;
	}



	public StudentSolr()
    {}
    
    

	public String getStudent_name() {
		return firstname;
	}



	public void setStudent_name(String student_name) {
		this.firstname = student_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getFather_name() {
		return father_name;
	}



	public void setFather_name(String father_name) {
		this.father_name = father_name;
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



	public void setId(Long id) {
		this.id = id;
	}





}