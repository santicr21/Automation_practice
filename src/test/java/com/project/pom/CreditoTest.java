package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreditoTest {
    private WebDriver driver;
    CreditoPage creditoPage;

    @BeforeClass
    public void setUp () {
        creditoPage = new CreditoPage(driver);
        driver = creditoPage.chromeDriverConnection();
        creditoPage.maximizeWindow();
        creditoPage.visit("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/simulador-credito-libre-inversion/");
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void testSimulateCredit () {
        creditoPage.simulateCredit();
        Assert.assertEquals(creditoPage.getAnswerMessage(), "En este momento estamos presentando fallas técnicas, por favor haz clic en \"calcular\" para enviar tu información nuevamente.", "Test failed");
    }
}
