package com.project.pom.avvillas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditPage extends BasePage {
    @FindBy(id = "i_monto_prestamo")
    private WebElement amountInput;

    @FindBy(id = "i_plazo_meses")
    private WebElement deadlineInput;

    @FindBy(id = "s_destinocredito")
    private WebElement destinyInput;

    @FindBy(id = "i_fecha_nacimiento")
    private WebElement dateInput;

    @FindBy(css = "#PanelRadioZona > label.text.ContSimuSiNo.BtnSi")
    private WebElement insuranceInput;

    @FindBy(css = "#layoutContainers > div > div:nth-child(2) > div > div > section > div.wpthemeOverflowAuto > div > div > section.simulator > div > div.gi.three-quarters > form > div:nth-child(6) > div > button:nth-child(2)")
    private WebElement calculateButton;

    @FindBy(css = "#i_fecha_nacimiento_root > div > div > div > div > div.picker__header > select.picker__select--year")
    private WebElement yearInput;

    @FindBy(css = "#i_fecha_nacimiento_root > div > div > div > div > div.picker__header > select.picker__select--month")
    private WebElement monthInput;

    @FindBy(css = "#i_fecha_nacimiento_table > tbody > tr:nth-child(4) > td:nth-child(2) > div")
    private WebElement dayInput;

    @FindBy(css = "#errorTecnico > span.msg-text")
    private WebElement answerMessageOutput;

    public CreditPage(WebDriver driver) {
        super(driver);
    }

    public void simulateCredit () {
        type ("1000000", amountInput);
        type ("12", deadlineInput);
        click (destinyInput);
        select ("Selecciona una opción", destinyInput);
        click (dateInput);
        select ("2001", yearInput);
        select ("septiembre", monthInput);
        click (dayInput);
        click (insuranceInput);
        click (calculateButton);
    }

    public String getAnswerMessage () {
        return getText(answerMessageOutput);
    }
}
