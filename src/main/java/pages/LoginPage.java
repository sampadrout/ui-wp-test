package pages;

import java.util.Map;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//div[@class='login__form-header']")
	@AndroidFindBy(id = "label")
	@iOSXCUITFindBy(accessibility = "Log in to WordPress.com using an email address to manage all your WordPress sites.")
	private WebElement lbl_LoginAccountPageTitle;

	@FindBy(xpath = "//input[@id='usernameOrEmail']")
	@AndroidFindBy(id = "input")
	private WebElement txt_EmailAddress;

	@FindBy(xpath = "//button[@class='button form-button is-primary'][contains(text(),'Continue')]")
	@AndroidFindBy(id = "primary_button")
	private WebElement btn_Continue;

	@AndroidFindBy(id = "login_enter_password")
	private WebElement link_EnterPassword;

	@FindBy(xpath = "//input[@id='password']")
	@AndroidFindBy(id = "input")
	private WebElement txt_Password;

	@FindBy(xpath = "//button[@class='button form-button is-primary'][contains(text(),'Log In')]")
	private WebElement btn_Login;
	
	@FindBy(xpath = "//input[@id='password']/../../div[2]/span")
	@AndroidFindBy(id = "textinput_error")
	private WebElement lbl_InvalidPasswordErrorMsg;

	@AndroidFindBy(id = "signup_email")
	private WebElement btn_SignupWithEmail;

	Wait wait = new Wait();

	public LoginPage(WebDriver driver) throws InterruptedException {
		super(driver);
	}

	@Step("'Login into your account' page displayed")
	public boolean verifyLoginAccountPageDisplayed() throws Exception {
		return getLabel(wait.waitForElementToBeVisible(lbl_LoginAccountPageTitle, webdriver)).contains("Log in to");
	}

	@Step("Enter Credentials & Login")
	public void login(Map<String, String> data) throws Exception {
		type(wait.waitForElementToBeClickable(txt_EmailAddress, webdriver), data.get("emailAddress"));
		wait.staticWait(2000);
		click(wait.waitForElementToBeClickable(btn_Continue, webdriver));
		wait.staticWait(2000);
		
		type(wait.waitForElementToBeClickable(txt_Password, webdriver), data.get("password"));
		wait.staticWait(2000);
		click(wait.waitForElementToBeClickable(btn_Login, webdriver));
	}
	
	@Step("Verify Invalid Password Error Message...")
	public boolean verifyInvalidPasswordErrorMsg() throws Exception {
		return checkElement(wait.waitForElementToBeVisible(lbl_InvalidPasswordErrorMsg, webdriver));
	}

}
