package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest {
    private WebDriver driver;
    private SignInPage signInPage;

    @BeforeClass
    public void setUp () {
        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.maximizeWindow();
        signInPage.visit("https://demo.guru99.com/test/newtours/");
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void test1 () throws InterruptedException {
        signInPage.signInUser();
        Assert.assertEquals(signInPage.getLoggingMessage(), "Login Successfully", "Login failed");
    }
}
