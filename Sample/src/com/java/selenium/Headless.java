package com.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";
		
		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";
		
		System.setProperty(chromeKey, chromeValue);
//		WebDriver driver = new ChromeDriver();
		//syntax

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--headless");

		WebDriver driver=new ChromeDriver(opt);//object creation

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.navigate().to("https://www.google.co.in");

		driver.navigate().back();

		driver.navigate().forward();

		Thread.sleep(3000);

		driver.navigate().refresh();

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.quit();//It closes the entire browser

		//driver.close();//It closes the current Tab
	}

}
