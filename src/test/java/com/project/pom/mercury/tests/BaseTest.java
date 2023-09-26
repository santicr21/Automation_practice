package com.project.pom.mercury.tests;

import com.project.pom.mercury.pages.BasePage;
import com.project.pom.mercury.pages.RegisterPage;
import com.project.pom.mercury.pages.SignInPage;
import com.project.pom.mercury.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {
    protected BasePage basePage;
    protected RegisterPage registerPage;
    protected static SignInPage signInPage;
    private WebDriver driver;

    @BeforeSuite
    public void setUp () {
        driver = WebDriverUtils.getDriver();
        basePage = new BasePage(driver);
        basePage.maximizeWindow();
        basePage.visit("https://demo.guru99.com/test/newtours/");
        registerPage = new RegisterPage(driver);
    }

    @AfterSuite
    public void tearDown () {
        WebDriverUtils.quitDriver();
    }
}
