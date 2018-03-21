package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test	 
{
	private static ArrayList<Course> course = new ArrayList<Course>();
	private static ArrayList<Semester> semester = new ArrayList<Semester>();
	private static ArrayList<Section> sect = new ArrayList<Section>();
	private static ArrayList<Student> csize = new ArrayList<Student>();
	
	private static ArrayList<Enrollment> enroll = new ArrayList<Enrollment>();
	
	@BeforeClass
	public static void setup() throws PersonException 
	{
		final UUID PHYS207 = UUID.randomUUID();	
		final UUID CISC181 = UUID.randomUUID();
		final UUID MEDS101 = UUID.randomUUID();
		
		final UUID SPRING = UUID.randomUUID();
		final UUID FALL = UUID.randomUUID();
		
		Semester Fall = new Semester(FALL, new Date(2017, 8, 29), new Date(2017, 12, 16));
		Semester Spring = new Semester(SPRING, new Date(2018, 2, 5), new Date(2018, 5, 24));
		
		Course class1 = new Course(PHYS207, "Physics 207", 4, eMajor.PHYSICS);
		Course class2 = new Course(CISC181, "Intro to Computer Science 181", 4, eMajor.COMPSI);
		Course class3 = new Course(MEDS101, "Medical 101", 4, eMajor.NURSING);
		
		semester.add(Spring);
		semester.add(Fall);
		
		course.add(class1); 
		course.add(class2);
		course.add(class3);
			
		csize.add(new Student("Alexander", "N", "Ho", new Date(1999, 01, 20), eMajor.COMPSI,
				"422 General Learned Road", "(484)-533-4739", "alexander.n.ho@umasd.net"));
		csize.add(new Student("Lissa", "R", "Sweeney", new Date(1999, 01, 15), eMajor.COMPSI,
				"446 South Gulph Rd", "(484)-681-3290", "lissarsweeney@gmail.com"));
		csize.add(new Student("Jordan", "M", "Egan", new Date(1998, 02, 17), eMajor.NURSING,
				"1407 University Crossings", "(610)-394-1294", "joranmommyegan@gmail.com"));
		csize.add(new Student("Julius", "H", "Park", new Date(1998, 03, 24), eMajor.COMPSI,
				"140 Somewhere in Phoenixville", "(484)-385-3939", "juliusthotpark@gmail.com"));
		csize.add(new Student("Joe", "A", "Galdi", new Date(2001, 11, 22), eMajor.BUSINESS,
				"294 Idk Where You Live", "(484)-385-2393", "joe.a.galdi@umasd.net"));
		csize.add(new Student("Melody", "N", "Sweeney", new Date(2000, 12, 04), eMajor.NURSING,
				"446 South Gulph Rd", "(484)-681-2389", "melody.n.sweeney@umasd.org"));
		csize.add(new Student("Ricky", "R", "Christman", new Date(1999, 01, 13), eMajor.NURSING,
				"100 Something Place", "(484)-349-3854", "richard.r.christman@umasd.net"));
		csize.add(new Student("Chichi", "A", "Amefuna", new Date(1999, 03, 02), eMajor.CHEM,
				"384 Idk Even", "(484)-293-4967", "CAmefuna@gmail.com"));
		csize.add(new Student("Nashita", "Z", "Akanda", new Date(1999, 03, 10), eMajor.CHEM,
				"4759 Somewhere Someplace", "(484)-681-3239", "Nashita_Akanda@gmail.com"));
		csize.add(new Student("Andrew", "H", "Johnson", new Date(1999, 01, 12), eMajor.COMPSI,
				"101 Compsci Lane", "(484)-838-2944", "AndrewJohnson99@gmail.com"));
		
		int roomNumber = 100;
		for(Semester s: semester)
		{
			for(Course c: course)
			{
				sect.add(new Section(c.getCourseID(), s.getSemesterID(), UUID.randomUUID(), roomNumber));
			}
			roomNumber += 2;
		}
		
		for(Section sec: sect)
		{
			for(Student stu: csize)
			{
				
				Enrollment enrollment = new Enrollment(sec.getSectionID(), stu.getStudentID());
				enroll.add(enrollment);
				
				for(Enrollment en: enroll)
				{
					en.SetGrade(75.00);
				}
			}
		}
		
	} 
	
	@Test
	public void test() 
	{	
		double creditsTaken = 0;
		double creditsEarned = 0;
		
		double numOfStudents = 0;
		double allGrades = 0;
		
		for(Enrollment e: enroll)
		{
			numOfStudents += 1;
			allGrades += e.getGrade();
			
			for(Course c: course)
			{
				creditsEarned += c.getGradePoints() * e.getGrade();
				creditsTaken += c.getGradePoints();
			}
		}
		
		double gpa = creditsEarned / creditsTaken;
		assertEquals(gpa, 75.00, 0.01);
		
		double courseAvgGrade = allGrades / numOfStudents;
		assertEquals(courseAvgGrade, 75.00, 0.01);
		
	}
}