package test;

import main.support.Browsers;
import main.support.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NaoRealizaCadastro {

    private String url;
    public WebDriver driver;

    @Test
    public void naodeveCadastrarumasimulacao() throws InterruptedException {
        url = Utils.getPropertiesValue("url");

        driver = Browsers.openBrowser(driver, url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("valorAplicar")).sendKeys("1000");
        //sistema não submete o formulário informando na tela que o valor mínimo é de 20,00 no primeiro input
        Thread.sleep(1000);
        driver.findElement(By.id("valorAplicar")).sendKeys("\t");
        driver.findElement(By.id("valorInvestir")).sendKeys("60000000");
        Thread.sleep(1000);
        driver.findElement(By.id("valorAplicar")).sendKeys("\t");
        driver.findElement(By.id("tempo")).sendKeys("10");
        Thread.sleep(1000);
        driver.findElement(By.id("tempo")).sendKeys("\t");
        driver.findElement(By.className("simular")).click();
        driver.quit();
    }
}