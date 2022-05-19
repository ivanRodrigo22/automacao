package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyStep {

    private WebDriver driver;
    @Dado("que acesso o conexaoQA")
    public void queAcessoOConexaoQA() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.get("https://conexaoqa.herokuapp.com/");




    }

    @E("clico no login")
    public void clicoNoLogin() {
        driver.findElement(By.xpath("//a[@class='btn btn-light']")).click();
    }

    @Quando("coloco {string} e {string}")
    public void colocoE(String usuario, String senha) {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("regi-ryan@hotmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("82772660re");
        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();

    }

    @Entao("e exibido tela de dashboard")
    public void eExibidoTelaDeDashboard() {

    }

    @E("o botao de criar perfil estara sendo exibido")
    public void oBotaoDeCriarPerfilEstaraSendoExibido() {
        driver.findElement(By.xpath("//a[@class='btn btn-primary my-1']")).click();


    }

    @E("visualizo a tela de criacao do perfil")
    public void visualizoATelaDeCriacaoDoPerfil() throws IOException {
        imprimirEvidencia();
        //driver.quit();
    }
    public void imprimirEvidencia() throws IOException {
        File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printFinal, new File("target/evidencia.png"));



    }
}
