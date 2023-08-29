package com.project.pom.avvillas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreditoTest extends BaseTest {

    @Test
    public void testSimulateCredit () {
        creditoPage.simulateCredit();
        Assert.assertEquals(creditoPage.getAnswerMessage(), "En este momento estamos presentando fallas técnicas, por favor haz clic en \"calcular\" para enviar tu información nuevamente.", "Test failed");
    }
}
