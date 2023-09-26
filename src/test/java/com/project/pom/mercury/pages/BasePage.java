package com.project.pom.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait waiter;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void click (WebElement element) {
        this.waiter.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void type (String text, WebElement element) {
        this.waiter.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public String getText (WebElement element) {
        this.waiter.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void visit (String url) {
        this.driver.get(url);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
    public WebDriverWait getWaiter() {
        return this.waiter;
    }

    public void maximizeWindow() {
        this.driver.manage().window().maximize();
    }
}
