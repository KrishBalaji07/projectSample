package com.java.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Training {

	@AfterMethod
	public void afterAllBatches()
	{
	System.out.println("<<<<<<<<<< Taking two minutes of rest >>>>>>>>>");
	System.out.println("<<<<<<<<<< Drinking Water >>>>>>>>>>>");
	}

	@Test
	public void batch1()
	{
	System.out.println("Taking Manual Session");
	}

	@Test
	public void batch2()
	{
	System.out.println("Taking Java Session");
	}

	@Test
	public void batch3()
	{
	System.out.println("Taking Selenium Session");
	}

	@Test
	public void batch4()
	{
	System.out.println("Taking TestNG Session");
	}

	@Test
	public void batch5()
	{
	System.out.println("Taking DataDriven Session");
	}

	@BeforeMethod
	public void beforeAllBatches()
	{
	System.out.println("<<<<<<<<< Connect with the batch >>>>>>>>>");
	}

	@BeforeClass
	public void beforeClass()
	{
	System.out.println("<<<<<<<<< Wants to Reach Office >>>>>>>>>");
	System.out.println("<<<<<<<<< Open the Main door of office >>>>>>>>>");
	System.out.println("<<<<<<<<< Switch on the System >>>>>>>>>");
	}
}
