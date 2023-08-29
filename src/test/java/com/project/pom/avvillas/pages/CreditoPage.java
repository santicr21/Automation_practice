package com.project.pom.avvillas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditoPage extends BasePage {

    By montoInputLocator = By.id("i_monto_prestamo");
    By plazoInputLocator = By.id("i_plazo_meses");
    By destinoInputLocator = By.id("s_destinocredito");
    By fechaInputLocator = By.id("i_fecha_nacimiento");
    By seguroInputLocator = By.cssSelector("#PanelRadioZona > label.text.ContSimuSiNo.BtnSi");
    By calcularButtonLocator = By.cssSelector("#layoutContainers > div > div:nth-child(2) > div > div > section > div.wpthemeOverflowAuto > div > div > section.simulator > div > div.gi.three-quarters > form > div:nth-child(6) > div > button:nth-child(2)");
    By anoInputSelector = By.cssSelector("#i_fecha_nacimiento_root > div > div > div > div > div.picker__header > select.picker__select--year");
    By mesInputSelector = By.cssSelector("#i_fecha_nacimiento_root > div > div > div > div > div.picker__header > select.picker__select--month");
    By diaInputSelector = By.cssSelector("#i_fecha_nacimiento_table > tbody > tr:nth-child(4) > td:nth-child(2) > div");
    By answerMessageOutputSelector = By.cssSelector("#errorTecnico > span.msg-text");


    public CreditoPage(WebDriver driver) {
        super(driver);
    }

    public void simulateCredit () {
        type ("1000000", montoInputLocator);
        type ("12", plazoInputLocator);
        click (destinoInputLocator);
        select ("Gastos Personales", destinoInputLocator);
        click (fechaInputLocator);
        select ("2001", anoInputSelector);
        select ("septiembre", mesInputSelector);
        click (diaInputSelector);
        click (seguroInputLocator);
        click (calcularButtonLocator);
    }

    public String getAnswerMessage () {
        WaitUntil (4, answerMessageOutputSelector);
        return getText(answerMessageOutputSelector);
    }
}
