package com.java.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.omtamilcalendar.com/");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		JavascriptExecutor script=(JavascriptExecutor)driver; //type casting

		script.executeScript("window.scrollBy(0,1200)");

		List<WebElement> calendarTableRows = driver.findElements(By.xpath("/html/body/section[1]/div/div[2]/div[2]/div[2]/table/tbody/tr"));

		int calendarRowSize=calendarTableRows.size();

		for(int i=3; i<=calendarRowSize; i++)

		{
			List<WebElement> calendarTableColumn = driver.findElements(By.xpath("/html/body/section[1]/div/div[2]/div[2]/div[2]/table/tbody/tr["+i+"]/td"));

			int calendarColumnSize=calendarTableColumn.size();

			for(int j=1; j<calendarColumnSize; j++)

			{

				WebElement calendarData = driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div[2]/div[2]/table/tbody/tr["+i+"]/td["+j+"]"));

				System.out.print(calendarData.getText()+"|");

			}

			System.out.println();

		}



		for(int i=3; i<=calendarRowSize; i++)

		{

			List<WebElement> calendarTableColumn = driver.findElements(By.xpath("/html/body/section[1]/div/div[2]/div[2]/div[2]/table/tbody/tr["+i+"]/td"));

			int calendarColumnSize=calendarTableColumn.size();

			for(int j=1; j<calendarColumnSize; j++)

			{

				WebElement calendarData = driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div[2]/div[2]/table/tbody/tr["+i+"]/td["+j+"]"));

				if(calendarData.getText().equalsIgnoreCase("24"))

				{
					calendarData.click();
					break;

				}

			}
		}
	}

}
