package com.java.TestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Class2 {

	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void browserSetup()
	{
		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.instagram.com/");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
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
}
