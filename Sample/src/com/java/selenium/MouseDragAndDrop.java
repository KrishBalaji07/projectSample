package com.java.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chromeKey="webdriver.chrome.driver";

		String chromeValue="D:\\Apps\\chromedriver-win64\\chromedriver.exe";

		System.setProperty(chromeKey, chromeValue);

		WebDriver driver=new ChromeDriver();//object creation

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://jqueryui.com/droppable/");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.switchTo().frame(0);

		WebElement dragOption = driver.findElement(By.cssSelector("div#draggable"));

		WebElement dropOption = driver.findElement(By.cssSelector("div#droppable"));

		Actions act=new Actions(driver);

		act.dragAndDrop(dragOption, dropOption).perform();
	}

}
