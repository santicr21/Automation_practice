package com.project.pom.avvillas.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreditTest extends BaseTest {

    @Test
    public void testSimulateCredit () {
        creditPage.simulateCredit();
        Assert.assertEquals(creditPage.getAnswerMessage(), "En este momento estamos presentando fallas técnicas, por favor haz clic en \"calcular\" para enviar tu información nuevamente.", "Test failed");
    }
}
