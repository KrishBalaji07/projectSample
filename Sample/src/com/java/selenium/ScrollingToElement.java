package com.java.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingToElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);

		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.facebook.com/legal/terms/update");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebElement livePolicies = driver.findElement(By.linkText("Live policies"));

		JavascriptExecutor script=(JavascriptExecutor)driver;//typecasting

		script.executeScript("arguments[0].scrollIntoView();",livePolicies);

		Thread.sleep(3000);

		script.executeScript("arguments[0].click();",livePolicies);

		WebElement emailField = driver.findElement(By.name("email"));

		script.executeScript("arguments[0].value=('email@mail.com');",emailField);

	}

}
