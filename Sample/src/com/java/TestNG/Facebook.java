package com.java.TestNG;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Facebook {

	WebDriver driver;
	@Parameters({"browserName"})
	@BeforeClass
	public void browserSetup(String browserName) {

		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}

		else {
			throw new IllegalArgumentException("Please check the browser configuration.");
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://www.facebook.com");
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	@Test(priority = 0, description = "This Test for printing webpage Title.")
	public void printTitle() 
	{
		System.out.println(driver.getTitle());
	}

	@Test(priority = 1)
	public void printCurrentUrl() 
	{
		System.out.println(driver.getCurrentUrl());
	}

	@Test(priority = 2)
	public void printLinksCount()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
	}

	@Test(priority = 3)
	public void printLinks()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement aa : links) {
			System.out.println(aa.getAttribute("href")+"----->"+ aa.getText());
		}
	}

	@Parameters({"userName", "passWord"})
	@Test(priority = 4)
	public void verifyLogin(String userName, String passWord)
	{
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("passWord")).sendKeys(passWord);
	}

}
