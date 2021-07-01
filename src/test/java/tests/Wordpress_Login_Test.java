/*
 * @author Ajith H

 * (C) Copyright 2021 by Accion Labs Inc.
 */
package tests;

import java.util.Map;

import com.ui.core.framework.db.testng.TestNGMongoDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.core.framework.base.BaseTest;
import com.ui.core.framework.db.annotations.GetDataFromMongo;
import com.ui.core.framework.reporting.TestListener;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

@Listeners({ TestListener.class })
public class Wordpress_Login_Test extends BaseTest {
	
	@GetDataFromMongo(dbName = "ui_test", collectionName = "environment_ui", appName = "ui_test", envName = "environment", tcName = "TC02", dataType = "testcaseData")
	@Test(description = "Wordpress Valid_Login Test", priority=1, dataProviderClass = TestNGMongoDataProvider.class, dataProvider = "dataProviderMongo")
	public void testValidLogin(Map<String, String> data) throws Exception {

		page.getPageInstance(HomePage.class).navigateTo(data.get("url"));
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWPHomePageDisplayed(), "The Wordpress Homepage has not displayed...");
		
		page.getPageInstance(HomePage.class).clickLogin();
		Assert.assertTrue(page.getPageInstance(LoginPage.class).verifyLoginAccountPageDisplayed(), "'Login into your account' Page has not Displayed...");

		page.getPageInstance(LoginPage.class).login(data);
		Assert.assertTrue(page.getPageInstance(LandingPage.class).verifyLandingPageDisplayed(), "Login is Unsuccessful...");

		page.getPageInstance(LandingPage.class).logout();
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWPHomePageDisplayed(), "The Wordpress Homepage has not displayed...");
	}
	
	@GetDataFromMongo(dbName = "ui_test", collectionName = "environment_ui", appName = "ui_test", envName = "environment", tcName = "TC03", dataType = "testcaseData")
	@Test(description = "Wordpress Invalid_Login Test", priority=2, dataProviderClass = TestNGMongoDataProvider.class, dataProvider = "dataProviderMongo")
	public void testInvalidLogin(Map<String, String> data) throws Exception {

		page.getPageInstance(HomePage.class).navigateTo(data.get("url"));
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWPHomePageDisplayed(), "The Wordpress Homepage has not displayed...");
		
		page.getPageInstance(HomePage.class).clickLogin();
		Assert.assertTrue(page.getPageInstance(LoginPage.class).verifyLoginAccountPageDisplayed(), "'Login into your account' Page has not Displayed...");

		page.getPageInstance(LoginPage.class).login(data);
		Assert.assertTrue(page.getPageInstance(LandingPage.class).verifyLandingPageDisplayed(), "Login is Unsuccessful...");

	}
}