package com.rapid.gitlab;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuite {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.out.println("########################## Execution in GitLab Started #########################");
		System.out.println("Automation Script Running on " + System.getProperty("os.name"));

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + new File("/chromedriver"));
		driver = new ChromeDriver(options);
		System.out.println("Automation Driver is " + driver);
	}

	@Test
	public void TC_001_GoogleSearch() {
		System.out.println("########################## Test Case Execution Started #########################");
		driver.get("https://google.com");
		WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));
		searchBox.sendKeys("RapidValue");
		System.out.println("Your Website Title is " + driver.getTitle());
		System.out.println("########################## Test Case Execution Completed #########################");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
