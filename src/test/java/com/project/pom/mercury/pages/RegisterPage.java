package com.project.pom.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    By registerLinkLocator = By.linkText("REGISTER");
    By userNameInputLocator = By.id("email");
    By passwordInputLocator = By.name("password");
    By confirmPasswordInputLocator = By.name("confirmPassword");
    By submitButtonLocator = By.name("submit");

    By registerMsgLocator = By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(3) > font > b");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() {
        String password = "123456";
        String userName = "santicr";
        click (registerLinkLocator);
        waitUntil (4, userNameInputLocator);
        type (userName, userNameInputLocator);
        type (password, passwordInputLocator);
        type (password, confirmPasswordInputLocator);
        click (submitButtonLocator);
    }

    public String registeredMessage () {
        waitUntil (4, registerMsgLocator);
        return getText(registerMsgLocator);
    }

}
