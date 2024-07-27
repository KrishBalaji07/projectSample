package com.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.navigate().to("https://www.google.com");

		driver.navigate().back();

		driver.navigate().forward();

		Thread.sleep(3000);

		driver.navigate().refresh();

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.quit(); // It close the entire browser

		// driver.close(); // It closes the current Tab
	}

}
