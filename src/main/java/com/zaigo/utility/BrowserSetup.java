package com.zaigo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {
	
	public static WebDriver startBrowser() {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	// options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "window-size=1920,1200", "--disable-gpu");
		driver = new ChromeDriver(options);
    	driver.manage().window().maximize();
		return driver;
		
		
	}

	public static WebDriverWait createWebDriverWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait;
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
