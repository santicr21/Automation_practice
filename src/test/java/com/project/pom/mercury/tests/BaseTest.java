package com.project.pom.mercury.tests;

import com.project.pom.mercury.pages.BasePage;
import com.project.pom.mercury.pages.RegisterPage;
import com.project.pom.mercury.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {
    BasePage basePage;
    RegisterPage registerPage;
    SignInPage signInPage;
    WebDriver driver;

    @BeforeClass
    public void setUp () {
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        basePage.maximizeWindow();
        basePage.visit("https://demo.guru99.com/test/newtours/");
        registerPage = new RegisterPage(driver);
        signInPage = new SignInPage(driver);
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }
}
