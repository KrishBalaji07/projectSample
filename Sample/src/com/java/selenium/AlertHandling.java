package com.java.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebElement signinButton = driver.findElement(By.className("signinbtn"));

		signinButton.click();

		Alert alt = driver.switchTo().alert();

		System.out.println(alt.getText());

		alt.accept();
	}

}
