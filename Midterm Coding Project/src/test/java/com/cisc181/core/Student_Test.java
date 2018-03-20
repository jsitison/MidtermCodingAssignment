package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	private static ArrayList<Student> students;
	private static ArrayList<Course> courses;
	private static ArrayList<Semester> semesters;
	private static ArrayList<Section> sections;
	private static ArrayList<Enrollment> enrollments;

	@BeforeClass
	public static void setup() {

		courses = new ArrayList<Course>();

		Course course1 = new Course("course1", 0, null);
		Course course2 = new Course("course2", 0, null);
		Course course3 = new Course("course3", 0, null);
		// Note: grades were set to 0; majors were set to null

		courses.add(course1);
		courses.add(course2);
		courses.add(course3);

		semesters = new ArrayList<Semester>();

		Calendar cal = Calendar.getInstance();

		cal.set(2017, 8, 29);
		Date fallStart = cal.getTime();
		cal.set(2017, 12, 16);
		Date fallEnd = cal.getTime();
		cal.set(2018, 2, 5);
		Date springStart = cal.getTime();
		cal.set(2018, 5, 24);
		Date springEnd = cal.getTime();

		Semester fall = new Semester(fallStart, fallEnd);
		Semester spring = new Semester(springStart, springEnd);

		semesters.add(fall);
		semesters.add(spring);

		sections = new ArrayList<Section>();

		Section section1 = new Section(course1.getCourseID(), fall.getSemesterID());
		Section section2 = new Section(course1.getCourseID(), spring.getSemesterID());
		Section section3 = new Section(course2.getCourseID(), fall.getSemesterID());
		Section section4 = new Section(course2.getCourseID(), spring.getSemesterID());
		Section section5 = new Section(course3.getCourseID(), fall.getSemesterID());
		Section section6 = new Section(course3.getCourseID(), spring.getSemesterID());

		sections.add(section1);
		sections.add(section2);
		sections.add(section3);
		sections.add(section4);
		sections.add(section5);
		sections.add(section6);

		students = new ArrayList<Student>();

		Student student1 = new Student("firstName1", "middleName1", "lastName1", null, null, "address1", "phoneNumber1",
				"email1");
		Student student2 = new Student("firstName2", "middleName2", "lastName2", null, null, "address2", "phoneNumber2",
				"email2");
		Student student3 = new Student("firstName3", "middleName3", "lastName3", null, null, "address3", "phoneNumber3",
				"email3");
		Student student4 = new Student("firstName4", "middleName4", "lastName4", null, null, "address4", "phoneNumber4",
				"email4");
		Student student5 = new Student("firstName5", "middleName5", "lastName5", null, null, "address5", "phoneNumber5",
				"email5");
		Student student6 = new Student("firstName6", "middleName6", "lastName6", null, null, "address6", "phoneNumber6",
				"email6");
		Student student7 = new Student("firstName7", "middleName7", "lastName7", null, null, "address7", "phoneNumber7",
				"email7");
		Student student8 = new Student("firstName8", "middleName8", "lastName8", null, null, "address8", "phoneNumber8",
				"email8");
		Student student9 = new Student("firstName9", "middleName9", "lastName9", null, null, "address9", "phoneNumber9",
				"email9");
		Student student10 = new Student("firstName10", "middleName10", "lastName10", null, null, "address10",
				"phoneNumber10", "email10");
		// Note: dates of birth and majors were all set to null

		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		students.add(student7);
		students.add(student8);
		students.add(student9);
		students.add(student10);
	}

	@Test
	public void StudentGPATest1() {
		enrollments = new ArrayList<Enrollment>();

		for (Student stu : students) {
			for (Section sec : sections) {
				enrollments.add(new Enrollment(stu.getStudentID(), sec.getSectionID()));
			}
		}
		int gradePointActual = 0;
		for (Enrollment enr : enrollments) {
			enr.setGrade(10 * (gradePointActual + 5)); // turns gradePointActual to grade with same letter grade
			if (gradePointActual < 4) {
				gradePointActual++;
			} else {
				gradePointActual = 0;
			}
		} // this loop with cycle through grades (five options) where each student has 6
		  // sections giving a different grade in each section (with 1 duplicate)
		
		/*
		 * student1 grades: 0,1,2,3,4,0; student1 GPA = 1.67 = 5/3
		 * student2 grades: 1,2,3,4,0,1; student2 GPA = 1.83 = 11/6
		 * student3 grades: 2,3,4,0,1,2; student3 GPA = 2.00 = 2
		 * student4 grades: 3,4,0,1,2,3; student4 GPA = 2.17 = 13/6
		 * student5 grades: 4,0,1,2,3,4; student5 GPA = 2.33 = 7/3
		 * student6 grades: 0,1,2,3,4,0; student6 GPA = 1.67 = 5/3
		 * student7 grades: 1,2,3,4,0,1; student7 GPA = 1.83 = 11/6
		 * student8 grades: 2,3,4,0,1,2; student8 GPA = 2.00 = 2
		 * student9 grades: 3,4,0,1,2,3; student9 GPA = 2.17 = 13/6
		 * student10 grades: 4,0,1,2,3,4; student10 GPA = 2.33 = 7/3
		 */

		double[] actualStudentGPAs = { 5.0 / 3.0, 11.0 / 6.0, 2.0, 13.0 / 6.0, 7.0 / 3.0, 5.0 / 3.0, 11.0 / 6.0, 2.0,
				13.0 / 6.0, 7.0 / 3.0 };

		double grade;
		int gradePoint;
		int totalGradePoints;
		double studentGPA;
		int studentIndex = 0;
		for (int stu = 0; stu < enrollments.size(); stu += 6) {
			totalGradePoints = 0;
			for (int i = stu; i < stu + 6; i++) {
				grade = enrollments.get(i).getGrade();
				if (grade >= 90) {
					gradePoint = 4;
				} else if (grade >= 80) {
					gradePoint = 3;
				} else if (grade >= 70) {
					gradePoint = 2;
				} else if (grade >= 60) {
					gradePoint = 1;
				} else {
					gradePoint = 0;
				}
				totalGradePoints += gradePoint;
			}
			studentGPA = (double) totalGradePoints / (double) sections.size();
			assertEquals(actualStudentGPAs[studentIndex], studentGPA, 0);
			studentIndex++;
		}
	}

	@Test
	public void SectionGPATest1() {
		enrollments = new ArrayList<Enrollment>();

		for (Section sec : sections) {
			for (Student stu : students) {
				enrollments.add(new Enrollment(stu.getStudentID(), sec.getSectionID()));
			}
		}
		int gradePointActual = 2;
		for (Enrollment enr : enrollments) {
			enr.setGrade(10 * (gradePointActual + 5)); // turns gradePointActual to grade with same letter grade
			if (gradePointActual < 4) {
				gradePointActual++;
			} else {
				gradePointActual = 2;
			}
		} // this loop with cycle through grades (five options) where each section has 10
		  // students giving a different grade for each student (no F's or D's were given so not
		  // every section would have the same set of grades as 10 is divisible by 5)

		/*
		 * section1 grades: 2,3,4,2,3,4,2,3,4,2; section1 GPA = 2.9
		 * section2 grades: 3,4,2,3,4,2,3,4,2,3; section2 GPA = 3.0
		 * section3 grades: 4,2,3,4,2,3,4,2,3,4; section3 GPA = 3.1
		 * section4 grades: 2,3,4,2,3,4,2,3,4,2; section4 GPA = 2.9
		 * section5 grades: 3,4,2,3,4,2,3,4,2,3; section5 GPA = 3.0
		 * section6 grades: 4,2,3,4,2,3,4,2,3,4; section6 GPA = 3.1
		 */
		
		double[] actualSectionGPAs = { 2.9, 3.0, 3.1, 2.9, 3.0, 3.1 };

		double grade;
		int gradePoint;
		int totalGradePoints;
		double sectionGPA;
		int sectionIndex = 0;
		for (int sec = 0; sec < enrollments.size(); sec += 10) {
			totalGradePoints = 0;
			for (int i = sec; i < sec + 10; i++) {
				grade = enrollments.get(i).getGrade();
				if (grade >= 90) {
					gradePoint = 4;
				} else if (grade >= 80) {
					gradePoint = 3;
				} else if (grade >= 70) {
					gradePoint = 2;
				} else {
					gradePoint = 1;
				}
				totalGradePoints += gradePoint;
			}
			sectionGPA = (double) totalGradePoints / (double) students.size();
			assertEquals(actualSectionGPAs[sectionIndex], sectionGPA, 0);
			sectionIndex++;
		}
	}
}