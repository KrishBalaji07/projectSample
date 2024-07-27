package com.java.TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Grouping {

	WebDriver driver;
	
	WebElement emailField;
	
	WebElement passwordField;
	
	WebElement loginButton;
	
	
	@BeforeClass(alwaysRun = true)
	public void browserSetup()
	{
		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.facebook.com");
	}
	
	@Test(priority = -89, description = "This test for printing title of webpages" , groups = "smoke")
	public void printTitle() 
	{
		System.out.println(driver.getTitle());
		
	}
	
	@Test(priority = 2 , groups = "sanity")
	public void printUrl() 
	{
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test(priority = 3 , groups = "sanity")
	public void verifyElementsStatus() 
	{
		System.out.println(emailField.isDisplayed());
		
		System.out.println(emailField.isEnabled());
		
		System.out.println(emailField.isSelected());
		
		System.out.println(passwordField.isDisplayed());
		
		System.out.println(passwordField.isEnabled());
		
		System.out.println(passwordField.isSelected());
		
		System.out.println(loginButton.isDisplayed());
		
		System.out.println(loginButton.isEnabled());
		
		System.out.println(loginButton.isSelected());
	}
	
	@Test(priority = 4 , groups = "sanity")
	public void printTagNameOfElements() 
	{
		System.out.println(emailField.getTagName());
		
		System.out.println(passwordField.getTagName());
		
		System.out.println(loginButton.getTagName());
	}
	
	@Test(priority = 5 ,  groups = "sanity")
	public void printAttributesOfElements() 
	{
		System.out.println(emailField.getAttribute("class"));
		
		System.out.println(passwordField.getAttribute("class"));
		
		System.out.println(loginButton.getAttribute("class"));
		
		System.out.println(emailField.getAttribute("placeholder"));
		
		System.out.println(passwordField.getAttribute("placeholder"));
	}
	
	@Test(priority = 6 , groups = "sanity")
	public void verifyLogin() 
	{
		emailField.sendKeys("admin@gmail.com");
		
		passwordField.sendKeys("admin@123");
		
		emailField.clear();
		
		passwordField.clear();
		
		emailField.sendKeys("tester@gmail.com");
		
		passwordField.sendKeys("tester@1234");
	}
	
	@Test(priority = 7 ,  groups = "regression")
	public void printTheValueOfElements() 
	{
		emailField.getAttribute("value");
		
		passwordField.getAttribute("value");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() 
	{
		driver.quit();
	}
}
