package com.conga.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		// Code to set config.property file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\conga\\config\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void intialize() {
		// Setting up system property for chrome driver
		if(System.getProperty("browser").equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
		}else if(System.getProperty("browser").equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
		}else if(System.getProperty("browser").equalsIgnoreCase("IE")) {
			
			WebDriverManager.iedriver().setup();
			
		} 
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		//Manage browser window and time
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
