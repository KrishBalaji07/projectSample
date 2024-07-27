package com.java.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://www.facebook.com");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebElement createNewButton = driver.findElement(By.partialLinkText("Creat"));

		createNewButton.click();

		WebElement firstnameField = driver.findElement(By.name("firstname"));

		firstnameField.sendKeys("admin");

		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='2']"));

		System.out.println(maleRadioButton.isDisplayed());

		System.out.println(maleRadioButton.isEnabled());

		System.out.println(maleRadioButton.isSelected());

		maleRadioButton.click();

		System.out.println(maleRadioButton.isSelected());

	}

}
