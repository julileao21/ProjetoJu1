package test;

import main.support.Browsers;
import main.support.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertTrue;

public class RealizarCadastro {

    private String url;
    public WebDriver driver;

    @Test
    public void deveCadastrarumasimulacao() throws InterruptedException {
        url = Utils.getPropertiesValue("url");

        driver = Browsers.openBrowser(driver, url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(By.id("valorAplicar")).sendKeys("10000");
        Thread.sleep(1000);
        driver.findElement(By.id("valorAplicar")).sendKeys("\t");
        driver.findElement(By.id("valorInvestir")).sendKeys("500000");
        Thread.sleep(1000);
        driver.findElement(By.id("valorInvestir")).sendKeys("\t");
        driver.findElement(By.id("tempo")).sendKeys("24");
        Thread.sleep(1000);
        driver.findElement(By.id("tempo")).sendKeys("\t");
        driver.findElement(By.className("simular")).click();

        // Validacao dos dados após o cadastro
        boolean achoutempo = driver.getPageSource().contains("tempo");
        boolean achouvaloraplicar = driver.getPageSource().contains("valorAplicar");
        boolean achouvalorinvestir = driver.getPageSource().contains("valorInvestir");

        assertTrue(achoutempo);
        assertTrue(achouvaloraplicar);
        assertTrue(achouvalorinvestir);
        driver.close();

    }
}
