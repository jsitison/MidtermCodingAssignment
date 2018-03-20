package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	private static ArrayList<Staff> staffs;

	@BeforeClass
	public static void setup() {
		staffs = new ArrayList<Staff>();
		
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, 1900);
		Date staff1DOB = cal.getTime();
				
		Staff staff1 = new Staff("firstName1", "middleName1", "lastName1", staff1DOB, "address1", "phoneNumber1", "email1",
				"officeHours1", 0, 1000.00, null, null);
		Staff staff2 = new Staff("firstName2", "middleName2", "lastName2", null, "address2", "phoneNumber2", "email2",
				"officeHours2", 0, 2000.00, null, null);
		Staff staff3 = new Staff("firstName3", "middleName3", "lastName3", null, "address3", "phoneNumber3", "email3",
				"officeHours3", 0, 3000.00, null, null);
		Staff staff4 = new Staff("firstName4", "middleName4", "lastName4", null, "address4", "phoneNumber4", "email4",
				"officeHours4", 0, 4000.00, null, null);
		Staff staff5 = new Staff("firstName5", "middleName5", "lastName5", null, "address5", "phoneNumber5", "email5",
				"officeHours5", 0, 5000.00, null, null);
		// Note: dates of birth, hire dates, and titles were all set to null; ranks were
		// set to 0

		staffs.add(staff1);
		staffs.add(staff2);
		staffs.add(staff3);
		staffs.add(staff4);
		staffs.add(staff5);
	}

	@Test
	public void MeanSalaryTest() {
		double total = 0.00;
		for (Staff staff : staffs) {
			total = total + staff.getSalary();
		}
		double meanSalary = total / (double) staffs.size();

		assertEquals(meanSalary, 3000.00, 0);
	}
	
	@Test
	public void DOBTest() throws PersonException {
		try {
			staffs.get(0).PrintAge();
			fail("Didn't throw DOB PersonException");
		} catch (PersonException e) {
			if (!(e instanceof PersonException)) {
                throw e;
            }
		}
	}

	@Test
	public void PhoneNumberTest() throws PersonException {
		try {
			staffs.get(0).PrintPhoneNumber();
			fail("Didn't throw phone number PersonException");
		} catch (PersonException e) {
			if (!(e instanceof PersonException)) {
                throw e;
            }
		}
	}
	
}
