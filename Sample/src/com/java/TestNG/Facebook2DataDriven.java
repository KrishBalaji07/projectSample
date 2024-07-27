package com.java.TestNG;

import java.io.Reader;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Facebook2DataDriven {

	WebDriver driver;
	Reader excel;

	@BeforeClass
	public void browserSetup()
	{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.get("https://www.facebook.com/");
	//excel=new Reader("C:\\Users\\BALAJI\\OneDrive\\Desktop\\Book1.xlsx","Sheet1");
	}

	@Test(priority =0)
	public void printTitle()
	{
	System.out.println(driver.getTitle());
	}

	@Test(priority =1)
	public void printURL()
	{
	System.out.println(driver.getCurrentUrl());
	}

	@Test(priority =2)
	public void printLinksCount()
	{
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	}

	@Test(priority =3)
	public void printLinks()
	{
	List<WebElement> links = driver.findElements(By.tagName("a"));
	for (WebElement aa : links) {
	System.out.println(aa.getAttribute("href")+"------->"+aa.getText());
	}
	}

	@Test(priority =4,enabled = false)
	public void verifyLogin()
	{
//	driver.findElement(By.id("email")).sendKeys(excel.getValue(0, 0));
//	driver.findElement(By.id("pass")).sendKeys(excel.getValue(0, 1));
	}

	@Test(priority =4,dataProvider = "data")
	public void verifyLoginwithAllExcelData(String userName,String passWord) throws InterruptedException
	{

	WebElement emailField = driver.findElement(By.id("email"));
	WebElement passwordField = driver.findElement(By.id("pass"));
	emailField.clear();
	passwordField.clear();
	Thread.sleep(3000);
	emailField.sendKeys(userName);
	passwordField.sendKeys(passWord);
	}

	//@DataProvider(name="data")
	//public String[][] getData()
	{
//	int rowCount = excel.getRowCount();
//	int columnCount = excel.getColumnCount();
//
//	return excel.getValues(rowCount, columnCount);
	}
	
}
