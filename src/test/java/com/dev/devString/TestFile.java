package com.dev.devString;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dev.devString.base.Base;
import com.dev.devString.pages.Dashboard;
import com.dev.devString.pages.LoginPage;
import com.dev.devString.utils.Utils;

public class TestFile {

	@BeforeTest
	public void browserLaunch() throws IOException {
		Base.initializeDriver();
		Utils.hitURL();
	}

	@Test
	public void login() {
		new LoginPage().getLogin();
	}

	@Test(dependsOnMethods = "login")
	public void dashboard() throws InterruptedException, IOException {

		new Dashboard().getManageUsersAndGroups();
		new Dashboard().getInviteUser();
		

	}

}
