package com.pnt.model.intern;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pnt.model.company.Company;
import com.pnt.model.user.User;

@Entity
@Table(name = "intern")
public class Intern {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String classInfo;
	private String major;
	private Double gpa;
	private String instructorName;
	private String instructorPosition;
	private String instructorEmail;
	private String instructorPhone;
	private String fieldOfIntern;
	private boolean accept = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;

	public Intern() {
		// TODO Auto-generated constructor stub
	}

	public Intern(String classInfo, String major, Double gpa, String instructorName, String instructorPosition,
			String instructorEmail, String instructorPhone, String fieldOfIntern, boolean accept, String userCode,
			Company company) {
		super();
		this.classInfo = classInfo;
		this.major = major;
		this.gpa = gpa;
		this.instructorName = instructorName;
		this.instructorPosition = instructorPosition;
		this.instructorEmail = instructorEmail;
		this.instructorPhone = instructorPhone;
		this.fieldOfIntern = fieldOfIntern;
		this.accept = accept;
		this.userCode = userCode;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorPosition() {
		return instructorPosition;
	}

	public void setInstructorPosition(String instructorPosition) {
		this.instructorPosition = instructorPosition;
	}

	public String getInstructorEmail() {
		return instructorEmail;
	}

	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}

	public String getInstructorPhone() {
		return instructorPhone;
	}

	public void setInstructorPhone(String instructorPhone) {
		this.instructorPhone = instructorPhone;
	}

	public String getFieldOfIntern() {
		return fieldOfIntern;
	}

	public void setFieldOfIntern(String fieldOfIntern) {
		this.fieldOfIntern = fieldOfIntern;
	}

//	@ManyToOne(fetch = FetchType.EAGER)
//	private User user;
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	private String userCode;
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

}
