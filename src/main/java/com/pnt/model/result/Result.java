package com.pnt.model.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double lecturePoint;
	private Double instructorPoint;
	private Double totalPoint;
	private String comment;
	private String userCode;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(Double lecturePoint, Double instructorPoint, Double totalPoint, String comment, String userCode) {
		super();
		this.lecturePoint = lecturePoint;
		this.instructorPoint = instructorPoint;
		this.totalPoint = totalPoint;
		this.comment = comment;
		this.userCode = userCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLecturePoint() {
		return lecturePoint;
	}

	public void setLecturePoint(Double lecturePoint) {
		this.lecturePoint = lecturePoint;
	}

	public Double getInstructorPoint() {
		return instructorPoint;
	}

	public void setInstructorPoint(Double instructorPoint) {
		this.instructorPoint = instructorPoint;
	}

	public Double getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Double totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
