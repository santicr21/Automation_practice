package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SignInPage extends Base {

    By signOnButtonLocator = By.linkText("SIGN-ON");
    By userNameInput = By.name("userName");
    By passwordInputLocator = By.name("password");
    By submitButtonLocator = By.name("submit");
    By signInMsgSelector = By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > h3");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signInUser () throws InterruptedException {
        String userName = "santicr";
        String password = "123456";
        Thread.sleep(2000);
        type (userName, userNameInput);
        type (password, passwordInputLocator);
        click (submitButtonLocator);

        Thread.sleep(2000);
    }

    public String getLoggingMessage () {
        return getText(signInMsgSelector);
    }
}
