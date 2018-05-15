package com.revature.tests;

import org.testng.annotations.*;

public class SeleniumTests {
	@BeforeClass
	public void setUp() {
		System.out.println("Starting SeleniumTests... " + SeleniumTests.class.getName());
	}

	@Test(groups = { "group1" })
	public void test1()
	{
		System.out.println("test1() " + SeleniumTests.class.getName());
	}
}
