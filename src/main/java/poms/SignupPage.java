package poms;

import java.util.Map;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Step;

public class SignupPage extends BasePage {
    @AndroidFindBy(id = "signup_email")
    private WebElement btn_SignupWithEmail;

    @AndroidFindBy(id = "label")
    private WebElement lbl_LoginPage;

    Wait wait = new Wait();

    public SignupPage(WebDriver driver) throws InterruptedException {
        super(driver);
    }

    @Step("Sign up with email option displayed")
    public boolean verifySignupWithEmailOptionDisplayed() throws Exception {
        return getLabel(wait.waitForElementToBeVisible(btn_SignupWithEmail, webdriver)).contains("SIGN UP WITH EMAIL");
    }

    @Step("Click on Sign up with email option")
    public void clickSignUpWithEmail() {
        click(wait.waitForElementToBeClickable(btn_SignupWithEmail, webdriver));
    }

    @Step("Enter email to create WP account page displayed")
    public boolean verifyCreateActWithEmailDisplayed() throws Exception {
        return getLabel(wait.waitForElementToBeVisible(btn_SignupWithEmail, webdriver)).contains("To create your new WordPress.com account, please enter your email address.");
    }
}