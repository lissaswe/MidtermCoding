package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;


public class Staff_Test {
	private static ArrayList<Staff> StaffJawn = new ArrayList<Staff>();

	@BeforeClass
	public static void setup() throws PersonException {
		
	StaffJawn.add(new Staff ("Ray", "Joseph", "Sweeney", new Date(1965, 6, 5), 
			"445 Dorothy Drive, King of Prussia, PA, 19406", "(784)-681-3290", 
			"RSweeney@gmail.com", "MWF 1-2", 9, 65000.0, new Date(2014,4,12), eTitle.MRS));
	StaffJawn.add(new Staff ("Liz", "Strunk", "Sweeney", new Date(1975, 12, 3), 
			"445 Dorothy Drive, King of Prussia, PA, 19406", "(484)-681-3290", 
			"LSSweeney@gmail.com", "TTH 5-7", 8, 95000.0, new Date(2014,4,12), eTitle.MS));
	StaffJawn.add(new Staff ("Melody", "Nicole", "Sweeney", new Date(2000, 12, 4), 
			"445 Dorothy Drive, King of Prussia, PA, 19406", "(484)-681-3290", 
			"M.N.Sweeney@umasd.net", "MWF 9-11", 3, 3000.0, new Date(2014,4,12), eTitle.MS));
	StaffJawn.add(new Staff ("Melanie", "Anne", "Sweeney", new Date(1965, 6, 5), 
			"445 Dorothy Drive, King of Prussia, PA, 19406", "(484)-681-3290", 
			"MelanieASweeney@gmail.com", "TTH 7-8", 8, 25000.0, new Date(2014,4,12), eTitle.MS));
	StaffJawn.add(new Staff ("Lissa", "Rose", "Sweeney", new Date(1965, 6, 5), 
			"445 Dorothy Drive, King of Prussia, PA, 19406", "(484)-681-3290", 
			"lissarsweeney@gmail.com", "MWF 4-5", 10, 95000.0, new Date(2014,4,12), eTitle.MS));
			
		}
	
	@Test
	public void test() {
		
		double totalIncome = 0.0;
		for(Staff staff: StaffJawn)
		{
			totalIncome += staff.getSalary();
		}
		double salaryAverage = totalIncome / StaffJawn.size();
		assertEquals(salaryAverage,56600.0,.01);
		
		boolean throwJawn = false;
		try {
			Staff bS = new Staff("Lissa", "Rose", "Sweeney", new Date(1854, 6, 5), 
					"445 Dorothy Drive, King of Prussia, PA, 19406", "(484)-681-3290", 
					"lissarsweeney@gmail.com", "MWF 4-5", 10, 95000.0, new Date(2014,4,12), eTitle.MS);
		}
		catch(PersonException ex)
		{
			throwJawn = true;
		}
		assertTrue(throwJawn);
		boolean throwJawn2 = false;
		try {
			Staff wrongPhone = new Staff("Lissa", "Rose", "Sweeney", new Date(1965, 6, 5), 
					"445 Dorothy Drive, King of Prussia, PA, 19406", "(6521)-231-58222", 
					"lissarsweeney@gmail.com", "MWF 4-5", 10, 95000.0, new Date(2014,4,12), eTitle.MS);
		}
		catch(PersonException ex)
		{
			throwJawn2 = true;
		}
		assertTrue(throwJawn2);
	}	
}
