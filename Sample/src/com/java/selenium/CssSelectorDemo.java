package com.java.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);

		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebElement fullNameField = driver.findElement(By.cssSelector("input[name^='name']"));

		fullNameField.sendKeys("admin");

		WebElement chooseMailField = driver.findElement(By.cssSelector("input[name^='log']"));

		chooseMailField.sendKeys("admin@mail.com");

		WebElement checkButton = driver.findElement(By.cssSelector("input.btn_checkavail"));

		checkButton.click();
	}

}
