package com.java.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ChromeKey = "webdriver.chrome.driver";
		
		String ChromeValue = "D:\\\\Apps\\\\chromedriver-win64\\\\chromedriver.exe";
		
		System.setProperty(ChromeKey, ChromeValue);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> tableHeadingRow = driver.findElements(By.xpath("/html/body/div[2]/div[5]/table/thead/tr"));
		
		for(int i=1; i<=tableHeadingRow.size(); i++) 
		{
			List<WebElement> tableHeading = driver.findElements(By.xpath("/html/body/div[2]/div[5]/table/thead/tr["+i+"]/th"));
			
			for(int j=1; j<=tableHeading.size(); j++) 
			{
				WebElement headingData = driver.findElement(By.xpath("/html/body/div[2]/div[5]/table/thead/tr[\"+i+\"]/th[\"+j+\"]"));
				
				System.out.print(headingData.getText()+"|");
			}
			System.out.println();
		}
		
List<WebElement> tableBodyRow = driver.findElements(By.xpath("/html/body/div[2]/div[5]/table/tbody/tr"));

		
		for(int i=1;i<=tableBodyRow.size();i++)//row wise shift 490
		{

			 List<WebElement> tableBody = driver.findElements(By.xpath("/html/body/div[2]/div[5]/table/tbody/tr["+i+"]/td"));

			 
			 for(int j=1;j<=tableBody.size();j++)//column wise shift

			 {

				 WebElement tableBodyData = driver.findElement(By.xpath("/html/body/div[2]/div[5]/table/tbody/tr["+i+"]/td["+j+"]"));

				 System.out.print(tableBodyData.getText()+"|");

			 }

			 System.out.println();
		}
	}

}
