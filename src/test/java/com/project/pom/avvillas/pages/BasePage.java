package com.project.pom.avvillas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeWindow () {
        this.driver.manage().window().maximize();
    }
    public WebElement findElement(By locator) {
        return this.driver.findElement(locator);
    }

    public String getText (WebElement element) {
        return element.getText();
    }

    public String getText (By locator) {
        return this.driver.findElement(locator).getText();
    }

    public void type (String inputText, By locator) {
        this.driver.findElement(locator).clear();
        this.driver.findElement(locator).sendKeys(inputText);
    }

    public void click (By locator) {
        this.driver.findElement(locator).click();
    }

    public void visit (String url) {
        this.driver.get(url);
    }

    public void select (String optionToFind, By locator) {
        Select selector = new Select(this.driver.findElement(locator));
        selector.selectByVisibleText(optionToFind);
    }

    public void WaitUntil (int seconds, By locator) {
        try {
            new WebDriverWait (this.driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (Exception e) {
            System.out.println("Element not visible!");
        }
    }

}
