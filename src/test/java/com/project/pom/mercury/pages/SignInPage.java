package com.project.pom.mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(css = "body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(2) > font > a")
    private WebElement signInButton;

    @FindBy(name = "userName")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(css = "body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > h3")
    private WebElement signInMsg;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signInUser () {
        String userName = "santicr";
        String password = "123456";
        type (userName, userNameInput);
        type (password, passwordInput);
        click (submitButton);
    }

    public String successSignIn () {
        return getText(signInMsg);
    }
}
