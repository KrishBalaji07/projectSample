package com.java.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebElement emailField = driver.findElement(By.id("email"));

		emailField.sendKeys("admin@gmail.com");

		emailField.clear();

		WebElement passwordField = driver.findElement(By.name("pass"));

		passwordField.sendKeys("pass@1234");

		emailField.sendKeys("tester@gmail.com");

		WebElement loginButton = driver.findElement(By.name("login"));

		loginButton.click();
	}

}
