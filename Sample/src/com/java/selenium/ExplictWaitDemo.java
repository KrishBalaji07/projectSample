package com.java.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ChromeKey = "webdriver.chrome.driver";

		String ChromeValue = "D:\\\\Apps\\\\chromedriver-win64\\\\chromedriver.exe";

		System.setProperty(ChromeKey, ChromeValue);

		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.get("https://www.tnpsc.gov.in/");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement registerUserButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/a/div/ul/li/h3"));

		registerUserButton.click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> windows = driver.getWindowHandles(); //total tab or windows

		System.out.println(windows.size()); //count

		ArrayList<String> list=new ArrayList<String>(windows); //list object windows order

		driver.switchTo().window(list.get(1));//switch

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());
	}

}
