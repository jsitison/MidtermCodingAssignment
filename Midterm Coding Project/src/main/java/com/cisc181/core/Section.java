package com.cisc181.core;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public Section() {
		this.SectionID = UUID.randomUUID();
		this.RoomID = new Random().nextInt();
	}
	public Section(UUID CourseID, UUID SemesterID) {
		this();
		this.CourseID = CourseID;
		this.SemesterID = SemesterID;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public int getRoomID() {
		return RoomID;
	}

}
