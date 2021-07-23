package com.dev.devString.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dev.devString.base.Base;

public class Utils {

	public static WebDriver driver = Base.driver;

	public static Properties prop = Base.prop;

	static WebDriverWait wait = new WebDriverWait(driver, 30);
	
	

	public static void sendKeys(By locator, String abc) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(abc);

	}

	public static void sendKeys1(By locator, String abc) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(abc);
	}

	public static void click(By locator) {

		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();

	}

	public static List<WebElement> path(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public static List<WebElement> path1(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}
	
	
	public static String singleElementPath(By locator, String AttributeName) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(AttributeName);
	}

	public static void hitURL() {
		driver.get(prop.getProperty("url"));
	}

	public static void alert() {

		driver.switchTo().alert().dismiss();
	}

	public static void frame_In(By locator) {

		driver.switchTo().frame(driver.findElement(locator));
	}

	public static void frame_comeOut() {
		driver.switchTo().defaultContent();
	}

	public static void select(WebElement webelement, int intValue) {
		Select s = new Select(webelement);
		s.selectByIndex(intValue);
	}
	
	public static void getScreenShot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File(".\\src\\main\\java\\SS\\test1.png"));
	}

	

}
