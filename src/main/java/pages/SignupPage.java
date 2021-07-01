/*
 * @author Sampad Rout

 * (C) Copyright 2021 by Accion Labs Inc.
 */

package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.core.framework.base.BasePage;
import com.ui.core.framework.utilities.Wait;

import io.qameta.allure.Step;

public class SignupPage extends BasePage {
    @AndroidFindBy(id = "label")
    @iOSXCUITFindBy(accessibility = "To create your new WordPress.com account, please enter your email address.")
    private WebElement lbl_SignupUsingEmail;

    @FindBy(xpath = "//button[contains(text(),'Create your account')]")
    @AndroidFindBy(id = "signup_email")
    @iOSXCUITFindBy(accessibility = "Sign up with Email Button")
    private WebElement btn_SignupWithEmail;

    @AndroidFindBy(id = "label")
    private WebElement lbl_LoginPage;

    Wait wait = new Wait();

    public SignupPage(WebDriver driver) throws InterruptedException {
        super(driver);
    }

    @Step("Sign up with email option displayed")
    public boolean verifySignupWithEmailOptionDisplayed() throws Exception {
        return checkElement(wait.waitForElementToBeVisible(btn_SignupWithEmail, webdriver));
//        return getLabel(wait.waitForElementToBeVisible(btn_SignupWithEmail, webdriver)).toLowerCase(Locale.ROOT).contains("SIGN UP WITH EMAIL");
    }

    @Step("Click on Sign up with email option")
    public void clickSignUpWithEmail() {
        click(wait.waitForElementToBeClickable(btn_SignupWithEmail, webdriver));
    }

    @Step("Enter email to create WP account page displayed")
    public boolean verifyCreateActWithEmailDisplayed() throws Exception {
        return checkElement(wait.waitForElementToBeVisible(lbl_SignupUsingEmail, webdriver));
//        return getLabel(wait.waitForElementToBeVisible(lbl_SignupUsingEmail, webdriver)).contains("To create your new WordPress.com account");
    }
}