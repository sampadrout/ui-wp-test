package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Step;

public class HomePage extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Welcome to the world’s most')]")
	@AndroidFindBy(id = "promo_text")
	@iOSXCUITFindBy(accessibility = "Publish from the park. Blog from the bus. Comment from the café. WordPress goes where you do.")
	private WebElement lbl_HomepageHeader;

	@FindBy(xpath = "//a[@id='lpc-button']")
	@AndroidFindBy(id = "create_site_button")
	@iOSXCUITFindBy(accessibility = "Sign up for WordPress.com")
	private WebElement btn_Signup;
	
	@FindBy(xpath = "//li[@class='x-nav-item x-nav-item--wide']/a[@title='Log In']")
	@AndroidFindBy(id = "login_button")
	@iOSXCUITFindBy(accessibility = "Log In Button")
	private WebElement btn_Login;

	Wait wait = new Wait();

	public HomePage(WebDriver driver) throws InterruptedException {
		super(driver);
	}
	
	@Step("Navigate to Wordpress")
	public void navigateTo(String url) throws Exception {
		gotoURL(url);
	}

	@Step("WordPress HomePage displayed")
	public boolean verifyWPHomePageDisplayed() throws Exception {
		return checkElement(lbl_HomepageHeader);
	}
	
	@Step("Click on the 'Start Your Site Button'")
	public void clickSignup() {
		click(wait.waitForElementToBeClickable(btn_Signup, webdriver));
	}
	
	@Step("Click on the 'Login Button'")
	public void clickLogin() {
		click(wait.waitForElementToBeClickable(btn_Login, webdriver));
	}

}