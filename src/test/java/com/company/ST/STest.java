package com.company.ST;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class STest {
	private static WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		String appUrl = System.getProperty("react.app");
		driver.get(appUrl);
		System.out.println("Navigating the appUrl"+appUrl);
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Email Id']/input"));
		element.sendKeys("pk@gmail.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement elementp = driver.findElement(By.xpath("//div[normalize-space()='Password']/input"));
		elementp.sendKeys("pwd");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement elements = driver.findElement(By.xpath("//div[normalize-space()='Password']/parent::*/button"));
		elements.submit();
		System.out.println("Entered Email and Password.");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement elementpd = driver
				.findElement(By.xpath("//div[normalize-space()='React Insurance']/parent::*/div/div/div/div/a[3]/a"));
		elementpd.click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		System.out.println("Logging out of application.");
	}

	@BeforeMethod
	public void beforeMethod() {
		// String nodeUrl = "http://192.168.99.100:4444/wd/hub";
		String nodeUrl = System.getProperty("jenkins.nodeUrl");
		System.out.println("Capability firefox:");
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setPlatform(org.openqa.selenium.Platform.ANY);
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), capability);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("firefox quited");
	}

}
