package com.java.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SuggestionNew {

		// TODO Auto-generated method stub

		String ChromeKey = "webdriver.chrome.driver";

		String ChromeValue = "D:\\\\Apps\\\\chromedriver-win64\\\\chromedriver.exe";
		

		static WebDriver driver;

		static By countryCodeButtonXpath=By.xpath("/html/body/center/form/div/table[2]/tbody/tr[20]/td/div/table/tbody/tr/td[3]/div[2]");

		static By countryCodeListXpath=By.xpath("/html/body/center/form/div/table[2]/tbody/tr[20]/td/div/table/tbody/tr/td[3]/div[1]/ul/li");

		public static void launchBrowser(String browserName)
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}

			else if(browserName.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}

			else if(browserName.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}

			else
			{
				throw new IllegalArgumentException("Please check the Browser Configuration");
			}
		}
		
		

		public static void maximize()
		{
			driver.manage().window().maximize();
		}

		public static void implictWait(int wait)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
		}

		public static void enterPageURL(String pageURL)
		{
			driver.get(pageURL);
		}

		public static String printTitle()
		{
			return driver.getTitle();
		}

		public static String printCurrentURL()
		{
			return driver.getCurrentUrl();
		}

		public static void clickElement(By locator)
		{
			WebElement element = driver.findElement(locator);
			element.click();
		}

		public static void enterCountryCode(String countryCode)
		{
			clickElement(countryCodeButtonXpath);

			List<WebElement> countryCodeList = driver.findElements(countryCodeListXpath);

			System.out.println(countryCodeList.size());

			for (WebElement aa : countryCodeList) {
				System.out.println(aa.getText());
			}

			for (WebElement aa : countryCodeList) {
				if(aa.getText().endsWith("("+countryCode+")"))
				{
					aa.click();
					break;
				}
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			launchBrowser("edge");

			maximize();

			implictWait(3);

			enterPageURL("https://register.rediff.com/register/register.php?FormName=user_details");

			System.out.println(printTitle());

			System.out.println(printCurrentURL());

			enterCountryCode("+91");
		}
}