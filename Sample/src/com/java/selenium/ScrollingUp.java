package com.java.selenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);

	 	WebDriver driver = new ChromeDriver();
	 	
	 	driver.manage().window().maximize();
	 	
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 	
	 	driver.get("https://www.facebook.com/legal/terms/update");
	 	
	 	System.out.println(driver.getTitle());
	 	
	 	System.out.println(driver.getCurrentUrl());
	 	
	 	JavascriptExecutor script = (JavascriptExecutor)driver;
	 	
	 	script.executeScript("window.scrollBy(0, 14000)");
	 	
	 	Thread.sleep(3000);
	 	
	 	script.executeScript("window.scrollBy(0,-7000)");
	}

}
