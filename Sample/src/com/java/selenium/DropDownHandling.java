package com.java.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class DropDownHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.facebook.com");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebElement createNewButton = driver.findElement(By.partialLinkText("Creat"));

		createNewButton.click();

		WebElement dayDropDown = driver.findElement(By.id("day"));//find the webelement

		Select dayDrop=new Select(dayDropDown);//create an object for select class and pass the webelement as an argument to select class object

		dayDrop.selectByIndex(0);

		Thread.sleep(2000);

		dayDrop.selectByValue("10");

		Thread.sleep(2000);

		dayDrop.selectByVisibleText("30");

		WebElement monthDropDown = driver.findElement(By.id("month"));//find the webelement

		Select monthDrop=new Select(monthDropDown);//create an object for select class and pass the webelement as argument to select class object

		monthDrop.selectByIndex(0);

		Thread.sleep(2000);

		monthDrop.selectByValue("5");

		Thread.sleep(2000);

		monthDrop.selectByVisibleText("Dec");

		WebElement yearDropDown = driver.findElement(By.id("year"));//find the webelement

		Select yearDrop=new Select(yearDropDown);//create an object for select class and pass the webelement as argument to select class object

		yearDrop.selectByIndex(0);

		Thread.sleep(2000);

		yearDrop.selectByValue("2010");

		Thread.sleep(2000);

		yearDrop.selectByVisibleText("1992");

		List<WebElement> allYears = yearDrop.getOptions();

		System.out.println(allYears.size());

		for (WebElement aa : allYears) {
		System.out.println(aa.getText());
		}
	}

}
