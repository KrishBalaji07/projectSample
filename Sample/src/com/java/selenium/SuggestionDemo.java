package com.java.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SuggestionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);
		
		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.google.co.in");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		WebElement searchBar = driver.findElement(By.name("q"));

		searchBar.sendKeys("infomats");

		List<WebElement> listBox = driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div/ul/li"));

		System.out.println(listBox.size());

		for(WebElement aa:listBox)
		{
			System.out.println(aa.getText());
		}

		for(WebElement aa:listBox)

		{
			if(aa.getText().equalsIgnoreCase("Infomats technologies salary for freshers"))

			{
				aa.click();

				break;
			}
		}
	}

}
