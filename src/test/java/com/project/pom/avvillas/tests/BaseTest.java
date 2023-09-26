package com.project.pom.avvillas.tests;

import com.project.pom.avvillas.pages.BasePage;
import com.project.pom.avvillas.pages.CreditPage;
import com.project.pom.avvillas.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private WebDriver driver;
    protected CreditPage creditPage;
    protected BasePage basePage;
    @BeforeSuite
    public void setUp () {
        driver = WebDriverUtils.getDriver();
        basePage = new BasePage(driver);
        basePage.maximizeWindow();
        basePage.visit("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/simulador-credito-libre-inversion/");
        creditPage = new CreditPage(driver);
    }

    @AfterSuite
    public void tearDown () {
        WebDriverUtils.quitDriver();
    }
}
