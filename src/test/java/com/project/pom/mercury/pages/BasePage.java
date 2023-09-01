package com.project.pom.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click (By locator) {
        this.driver.findElement(locator).click();
    }

    public void waitUntil (int seconds, By locator) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (Exception e) {
            System.out.println("Element not visible!");
        }
    }

    public void type (String text, By locator) {
        WebElement textInput = this.driver.findElement(locator);
        textInput.clear();
        textInput.sendKeys(text);
    }

    public String getText (By locator) {
        return this.driver.findElement(locator).getText();
    }

    public void visit (String url) {
        this.driver.get(url);
    }

    public void maximizeWindow() {
        this.driver.manage().window().maximize();
    }
}
