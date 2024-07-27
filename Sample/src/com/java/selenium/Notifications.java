package com.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Notifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		//syntax

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");

		WebDriver driver=new ChromeDriver(opt);//object creation

		driver.manage().window().maximize();

		driver.get("https://www.axisbank.com");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());
	}

}
