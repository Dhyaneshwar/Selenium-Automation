package com.home.testng.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGMethodd {
	@BeforeSuite
	public void bSuite() {
		System.out.println("bSuite");
	}

	@BeforeClass
	public void bClass() {
		System.out.println("bClass");
	}

	@BeforeMethod
	public void bMethod() {
		System.out.println("bMethod");
	}

	@BeforeTest
	public void bTest() {
		System.out.println("bTest");
	}

	@Test
	public void test1() {
		System.out.println("Test 1");
	}

	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3");
	}

	@AfterSuite
	public void aSuite() {
		System.out.println("aSuite");
	}

	@AfterClass
	public void aClass() {
		System.out.println("aClass");
	}

	@AfterMethod
	public void aMethod() {
		System.out.println("aMethod");
	}

	@AfterTest
	public void aTest() {
		System.out.println("aTest");
	}
}