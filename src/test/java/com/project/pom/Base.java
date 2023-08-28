package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
public class Base {
    private WebDriver driver;

    public Base (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection () {
        this.driver = new ChromeDriver();
        return this.driver;
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

}
