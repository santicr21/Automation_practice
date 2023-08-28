package com.annotations.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AnnotationsPractice {
    private WebDriver driver;

    @BeforeClass
    public void startDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/simulador-credito-libre-inversion/");
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod1(){
        String expectedRes = "En este momento estamos presentando fallas técnicas, por favor haz clic en \"calcular\" para enviar tu información nuevamente.";
        // Id locators
        String montoInputId = "i_monto_prestamo";
        String plazoInputId = "i_plazo_meses";
        String destinoInputId = "s_destinocredito";
        String fechaNacimientoInputId = "i_fecha_nacimiento";

        // Css locators
        String diaLocator = "#i_fecha_nacimiento_table > tbody > tr:nth-child(4) > td:nth-child(2) > div";
        String anoLocator = "#i_fecha_nacimiento_root > div > div > div > div > div.picker__header > select.picker__select--year";
        String mesLocator = "#i_fecha_nacimiento_root > div > div > div > div > div.picker__header > select.picker__select--month";
        String calcularLocator = "#layoutContainers > div > div:nth-child(2) > div > div > section > div.wpthemeOverflowAuto > div > div > section.simulator > div > div.gi.three-quarters > form > div:nth-child(6) > div > button:nth-child(2)";
        String seguroLocator = "#PanelRadioZona > label.text.ContSimuSiNo.BtnSi";
        String msgLocator = "#errorTecnico > span.msg-text";

        //All operations
        WebElement montoInput = driver.findElement(By.id(montoInputId));
        montoInput.clear();
        montoInput.sendKeys("1000000");
        WebElement plazoInput = driver.findElement(By.id(plazoInputId));
        plazoInput.clear();
        plazoInput.sendKeys("12");
        Select destinoSelect = new Select(driver.findElement(By.id(destinoInputId)));
        destinoSelect.selectByVisibleText("Gastos Personales");
        WebElement fechaNacimientoInput = driver.findElement(By.id(fechaNacimientoInputId));
        fechaNacimientoInput.click();
        Select anoSelect = new Select(driver.findElement(By.cssSelector(anoLocator)));
        anoSelect.selectByVisibleText("2001");
        Select mesSelect = new Select(driver.findElement(By.cssSelector(mesLocator)));
        mesSelect.selectByVisibleText("septiembre");
        WebElement diaInput = driver.findElement(By.cssSelector(diaLocator));
        diaInput.click();
        WebElement seguroRadio = driver.findElement(By.cssSelector(seguroLocator));
        seguroRadio.click();
        WebElement calcularBoton = driver.findElement(By.cssSelector(calcularLocator));
        calcularBoton.click();

        // Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(msgLocator)));

        WebElement msg = driver.findElement(By.cssSelector(msgLocator));
        String actualRes = msg.getText();

        //Conditions
        Assert.assertEquals(actualRes, expectedRes, "The text is not working");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
