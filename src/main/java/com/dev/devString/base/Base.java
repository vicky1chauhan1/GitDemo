package com.dev.devString.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver initializeDriver() throws IOException {

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		prop = new Properties();

		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\dev\\devString\\utils\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);
		}

		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		return driver;
	}

}
