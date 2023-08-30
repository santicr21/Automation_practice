package com.project.pom.avvillas.tests;

import com.project.pom.avvillas.pages.CreditPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private WebDriver driver;
    CreditPage creditPage;

    @BeforeSuite
    public void setUp () {
        creditPage = new CreditPage(driver);
        driver = creditPage.chromeDriverConnection();
        creditPage.maximizeWindow();
        creditPage.visit("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/simulador-credito-libre-inversion/");
    }

    @AfterSuite
    public void tearDown () {
        driver.quit();
    }
}
