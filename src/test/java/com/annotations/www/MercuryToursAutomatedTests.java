package com.annotations.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class MercuryToursAutomatedTests {
    private WebDriver driver;
    private String userName = "santicr";
    private String password = "prueba1234";
    private String registerMsgSelector = "body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(3) > font > b";
    private String signInMsgSelector = "body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > h3";

    @BeforeClass
    public void startDriver() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void registerUser() {
        WebElement registerButton = driver.findElement(By.linkText("REGISTER"));
        registerButton.click();

        WebElement userNameInput = driver.findElement(By.id("email"));
        userNameInput.clear();
        userNameInput.sendKeys(userName);


        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);


        WebElement confirmPasswordInput = driver.findElement(By.name("confirmPassword"));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String msg = driver.findElement(By.cssSelector(registerMsgSelector)).getText();
        Assert.assertEquals(msg, "Note: Your user name is " + userName + '.', "Register failed");
    }

    @Test
    public void signIn () {
        driver.navigate().to("https://demo.guru99.com/test/newtours/index.php");

        WebElement signOnButton = driver.findElement(By.linkText("SIGN-ON"));
        signOnButton.click();

        WebElement userNameInput = driver.findElement(By.name("userName"));
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String msg = driver.findElement(By.cssSelector(signInMsgSelector)).getText();
        Assert.assertEquals(msg, "Login Successfully", "Login failed");
    }
}
