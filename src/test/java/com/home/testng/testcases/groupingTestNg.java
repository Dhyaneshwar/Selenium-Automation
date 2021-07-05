package com.home.testng.testcases;

import org.testng.annotations.Test;

public class groupingTestNg {
	
	@Test(priority = 1, dependsOnMethods = {"sum"})
	public void  general() {
		System.out.println("============Grouping=============");
	}

	@Test(groups = {"Arithematic"})
	public void  sum() {
		System.out.println("sum");
	}
	
	@Test(groups = {"Arithematic"})
	public void  difference() {
		System.out.println("difference");
	}
	
	@Test(groups = {"ArithematicHigh"})
	public void  multiply() {
		System.out.println("multiply");
	}
	
	@Test(groups = {"ArithematicHigh"})
	public void  divide() {
		System.out.println("divide");
	}
}