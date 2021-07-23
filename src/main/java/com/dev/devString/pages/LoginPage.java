package com.dev.devString.pages;

import org.openqa.selenium.By;

import com.dev.devString.utils.Utils;

public class LoginPage {
	
	
	By email = By.cssSelector("#email");
	By pass  = By.cssSelector("#password");
	By login_button = By.cssSelector(".submit-button.mat-raised-button");
	
	
	
	
	
	
	public void getLogin() {
		Utils.sendKeys(email, "qa.sudhanshu@gmail.com");
		Utils.sendKeys(pass, "123456");
		Utils.click(login_button);
		System.out.println("2nd commit");
	}

}
