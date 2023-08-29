package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {
    private WebDriver driver;
    RegisterPage registerPage;

    @BeforeClass
    public void setUp () {
        registerPage = new RegisterPage(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.maximizeWindow();
        registerPage.visit("https://demo.guru99.com/test/newtours/");
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void testRegisterUser () throws InterruptedException {
        registerPage.registerUser();
        Assert.assertEquals(registerPage.registeredMessage(), "Note: Your user name is santicr.", "Register failed");
    }
}
