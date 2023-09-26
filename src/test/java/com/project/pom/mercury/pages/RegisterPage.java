package com.project.pom.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    @FindBy(linkText = "REGISTER")
    private WebElement registerLink;

    @FindBy(id = "email")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(css = "body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(3) > font > b")
    private WebElement registerMsg;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() {
        String password = "123456";
        String userName = "santicr";
        click (registerLink);
        type (userName, userNameInput);
        type (password, passwordInput);
        type (password, confirmPasswordInput);
        click (submitButton);
    }

    public String registeredMessage () {
        return getText(registerMsg);
    }

    public SignInPage goToSignInPage() {
        click (signInLink);
        return new SignInPage(getDriver());
    }

}
