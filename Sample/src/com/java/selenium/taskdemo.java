package com.java.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class taskdemo {
	
	static WebDriver driver;
	
	static By totalResultsXpath = By.xpath("/html/body/div[1]/div[1]/span[2]/div/h1/div/div[1]/div/div");
	
	static By totalListResultsXpath = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span");
	
	public static void launchBrowser(String browserName) {
		
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
		
		else 
		{
			throw new IllegalArgumentException("Please check the browser configuration");
		}
	}
	
	 public static void maximize() 
	 {
		 driver.manage().window().maximize();
	 }
	 
	 public static void implicitWait(int wait) 
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	 }
	 
	 public static void enterpageURL(String pageUrl) {
		 driver.get(pageUrl);
	 }
	 
	 public static String printTitle() {
		 return driver.getTitle();
	 }
	 
	 public static String printCurrentUrl() {
		 return driver.getCurrentUrl();
	 }
	 
	 public static void clickElement(By locator) 
	 {
		WebElement element = driver.findElement(locator);
		element.click();
	 }

	 public static void enterTotalResults(String totalResults ) {
		 clickElement(totalResultsXpath);
		 
		List<WebElement> totalListResults = driver.findElements(totalListResultsXpath);
		
		System.out.println(totalListResults.size());
		
		for (WebElement aa : totalListResults) {
			System.out.println(aa.getText());
		}
		
//		for (WebElement webElement : totalListResults) {
//			
//		}
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launchBrowser("edge");
		
		maximize();
		
		implicitWait(3);
		
		enterpageURL("https://www.amazon.in/s?bbn=4363895031&rh=n%3A4363895031%2Cp_90%3A6741118031&dc&qid=1718271372&rnid=6741116031&ref=lp_4363895031_nr_p_90_0");
		
		System.out.println(printTitle());
		
		System.out.println(printCurrentUrl());
		
		
	}

}
