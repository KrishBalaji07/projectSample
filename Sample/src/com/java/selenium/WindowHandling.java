package com.java.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.facebook.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		WebElement instagramLink = driver.findElement(By.xpath("html/body/div/div/div[2]/div/div/div[2]/ul/li[13]/a"));
		
		instagramLink.click();
		
		Set<String> windows = driver.getWindowHandles();
		
		System.out.println(windows.size());
		
		ArrayList<String> list = new ArrayList<String>(windows);
		
		driver.switchTo().window(list.get(1));
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(list.get(0));
		
		WebElement emailField = driver.findElement(By.id("email"));
		
		emailField.sendKeys("admin@gmail.com");
	}

}
