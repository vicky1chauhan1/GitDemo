package com.dev.devString.pages;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.dev.devString.utils.Utils;

public class Dashboard {

	By sideWindow = By.cssSelector(".moduleName_text.ng-star-inserted");
	By drpDwn = By.cssSelector("#createColumnBtn");
	By opt = By.xpath("//button[contains(@class,'create-dropdown-width m')]");
	public By pop_up = By.cssSelector("#mat-chip-list-0");
	public By emailText = By.xpath("//mat-chip[contains(@class,'mat-chip m')]");
	By outClick = By.cssSelector("#mat-dialog-0");
	By sendBtn = By.cssSelector("#sendbtn");
	By crossbtn = By.xpath("//i[@id='dltIcon']");
	public By userList = By.cssSelector("#userEmail");

	public void getManageUsersAndGroups() {

		List<WebElement> path = Utils.path(sideWindow);
		for (WebElement p : path) {

			if (p.getText().equalsIgnoreCase("Manage Users & Groups")) {
				p.click();
				break;
			}
		}

	}

	public void getInviteUser() throws IOException, InterruptedException {

		Utils.click(drpDwn);
		List<WebElement> path = Utils.path(opt);
		for (WebElement p : path) {
			System.out.println(p.getText());
			if (p.getText().equalsIgnoreCase("Invite User")) {
				p.click();
				break;
			}
		}
		Thread.sleep(2000);
		Utils.sendKeys(pop_up, RandomStringUtils.randomAlphabetic(5, 8) + "@gmail.com" + Keys.SPACE);
		String userEmail = Utils.singleElementPath(emailText, "id");

		Utils.click(sendBtn);
		Utils.click(crossbtn);

		List<WebElement> userlist = Utils.path(userList);
		for (WebElement p : userlist) {
			if (p.getText().equalsIgnoreCase(userEmail)) {
				System.out.println(p.getText());
				Assert.assertEquals(userEmail, p.getText());
				break;
			}
		}
		Utils.getScreenShot();
	}
}