package com.java.selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotDemo {

	public static void main(String[] args) throws IOException {
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

		WebElement firstnameField = driver.findElement(By.name("firstname"));

		firstnameField.sendKeys("Balaji");

		TakesScreenshot screen=(TakesScreenshot)driver;//typecasting

		File screenshotAs = screen.getScreenshotAs(OutputType.FILE);//screenshot capture

		File screenshotTo=new File("C:\\Users\\BALAJI\\OneDrive\\Pictures\\Screenshots\\screen"+System.currentTimeMillis()+".png");//location

		FileHandler.copy(screenshotAs, screenshotTo);
	}

}
