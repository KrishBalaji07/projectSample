package com.java.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.naukri.com/");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		WebElement jobsMenu = driver.findElement(By.xpath("//div[text()='Jobs']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(jobsMenu).perform();
		
		WebElement WalkInJobsMenu = driver.findElement(By.xpath("//div[text()='Walk-in jobs']"));
		
		act.click(WalkInJobsMenu).perform();
	}

}
