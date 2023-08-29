package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base {

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
        WaitUntil (4, userNameInputLocator);
        type (userName, userNameInputLocator);
        type (password, passwordInputLocator);
        type (password, confirmPasswordInputLocator);
        click (submitButtonLocator);
    }

    public String registeredMessage () {
        WaitUntil(4, registerMsgLocator);
        WebElement registerMessageElement = findElement(registerMsgLocator);
        return getText(registerMessageElement);
    }

}
