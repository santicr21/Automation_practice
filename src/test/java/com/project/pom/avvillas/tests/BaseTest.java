package com.project.pom.avvillas.tests;

import com.project.pom.avvillas.pages.CreditoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private WebDriver driver;
    CreditoPage creditoPage;

    @BeforeSuite
    public void setUp () {
        creditoPage = new CreditoPage(driver);
        driver = creditoPage.chromeDriverConnection();
        creditoPage.maximizeWindow();
        creditoPage.visit("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/simulador-credito-libre-inversion/");
    }

    @AfterSuite
    public void tearDown () {
        driver.quit();
    }
}
