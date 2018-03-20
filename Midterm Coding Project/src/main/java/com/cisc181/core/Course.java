package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor eMajor;
	
	public Course() {
		this.CourseID = UUID.randomUUID();
	}
	public Course(String CourseName, int GradePoints, eMajor eMajor) {
		this();
		this.CourseName = CourseName;
		this.GradePoints = GradePoints;
		this.eMajor = eMajor;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public int getGradePoints() {
		return GradePoints;
	}

	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}

	public eMajor geteMajor() {
		return eMajor;
	}

	public void seteMajor(eMajor eMajor) {
		this.eMajor = eMajor;
	}
	
	
}
