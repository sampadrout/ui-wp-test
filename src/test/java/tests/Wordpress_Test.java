/*
 * @author Sampad Rout

 * (C) Copyright 2021 by Accion Labs Inc.
 */

package tests;

import com.ui.core.framework.base.BaseTest;
import com.ui.core.framework.db.annotations.GetDataFromMongo;
import com.ui.core.framework.db.testng.TestNGMongoDataProvider;
import com.ui.core.framework.reporting.TestListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAccountPage;
import pages.SignupPage;

import java.util.Map;

@Listeners({ TestListener.class })
public class Wordpress_Test extends BaseTest {
	
	@GetDataFromMongo(dbName = "ui_test", collectionName = "environment_ui", appName = "ui_test", envName = "environment", tcName = "TC02", dataType = "testcaseData")
	@Test(description = "Verify Wordpress Login page Test", priority=1, dataProviderClass = TestNGMongoDataProvider.class, dataProvider = "dataProviderMongo")
	public void testLogin(Map<String, String> data, ITestContext context) throws Exception {
		String platform = context.getCurrentXmlTest().getParameter("platformType");

		if (platform.equalsIgnoreCase("web")) {
			page.getPageInstance(HomePage.class).navigateTo(data.get("url"));
		}
		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWPHomePageDisplayed(), "The Wordpress Homepage has not displayed");
		
		page.getPageInstance(HomePage.class).clickLogin();
		Assert.assertTrue(page.getPageInstance(LoginAccountPage.class).verifyLoginAccountPageDisplayed(), "'Login into your account' Page has not Displayed");
	}
	
	@GetDataFromMongo(dbName = "ui_test", collectionName = "environment_ui", appName = "ui_test", envName = "environment", tcName = "TC03", dataType = "testcaseData")
	@Test(description = "Verify Wordpress Signup page Test", priority=2, dataProviderClass = TestNGMongoDataProvider.class, dataProvider = "dataProviderMongo")
	public void testSignup(Map<String, String> data, ITestContext context) throws Exception {
		String platform = context.getCurrentXmlTest().getParameter("platformType");

		if (platform.equalsIgnoreCase("web")) {
			page.getPageInstance(HomePage.class).navigateTo(data.get("url"));
		}

		Assert.assertTrue(page.getPageInstance(HomePage.class).verifyWPHomePageDisplayed(), "The Wordpress Homepage has not displayed...");
		
		page.getPageInstance(HomePage.class).clickSignup();
		Assert.assertTrue(page.getPageInstance(SignupPage.class).verifySignupWithEmailOptionDisplayed(), "Sign up with Email option has not Displayed...");

		if (platform.equalsIgnoreCase("mobile")) {
			page.getPageInstance(SignupPage.class).clickSignUpWithEmail();
			Assert.assertTrue(page.getPageInstance(SignupPage.class).verifyCreateActWithEmailDisplayed(), "'Email field not displayed to create account");
		}
	}
}