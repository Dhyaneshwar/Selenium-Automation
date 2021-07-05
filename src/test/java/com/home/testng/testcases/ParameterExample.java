package com.home.testng.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExample {
	@Test(groups={"Arithematic","ArithematicLow"})
	@Parameters({"name","pass"})
	public void sum(String name,String pass1) {
		System.out.println("IN PARAMETER EXAMPLE CLASS");
		System.out.println("sum1");
		System.out.println(name);
		System.out.println(pass1);
	}
	
	@Test
	@Parameters({"name","quit"})
	public void sum2(String name,String quit) {
		System.out.println("sum2");
		System.out.println(name);
		System.out.println(quit);
	}
	
}
