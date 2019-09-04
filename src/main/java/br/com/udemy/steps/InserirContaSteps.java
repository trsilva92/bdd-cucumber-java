package br.com.udemy.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class InserirContaSteps {

    private WebDriver driver = new ChromeDriver();

    @Dado("^que estou acessando a aplicacao$")
    public void queEstouAcessandoAAplicacao() throws Throwable {
        driver.get("https://srbarriga.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @Quando("^informo o usuario \"([^\"]*)\"$")
    public void informoOUsuario(String arg1) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @E("^a senha \"([^\"]*)\"$")
    public void aSenha(String arg1) throws Throwable {
        driver.findElement(By.id("senha")).sendKeys(arg1);
    }

    @E("^seleciono entrar$")
    public void selecionoEntrar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Entao("^visualizo a pagina inicial$")
    public void visualizoAPaginaInicial() throws Throwable {
        String validaLogin = driver.findElement(By.xpath(".//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, wagner!", validaLogin);
    }

    @Quando("^seleciono Contas$")
    public void selecionoContas() throws Throwable {
        driver.findElement(By.linkText("Contas")).click();
    }

    @E("^seleciono Adicionar$")
    public void selecionoAdicionar() throws Throwable {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @E("^seleciono Listar$")
    public void selecionoListar() throws Throwable {
        driver.findElement(By.linkText("Listar")).click();
    }

    @E("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String arg1) throws Throwable {
        driver.findElement(By.id("nome")).sendKeys(arg1);
    }

    @E("^seleciono Salvar$")
    public void selecionoSalvar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Quando("^seleciono remover$")
    public void selecionoRemover() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='tabelaContas']/tbody/tr[8]/td[2]/a[2]/span")).click();
    }

    @Entao("^sou notificado que a conta foi removida com sucesso$")
    public void souNotificadoQueAContaFoiRemovidaComSucesso() throws Throwable {
        String msgContaRemovida = driver.findElement(By.xpath(".//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta removida com sucesso!", msgContaRemovida);
    }

    @Entao("^a conta e inserida com sucesso$")
    public void aContaEInseridaComSucesso() throws Throwable {
        String msgSucesso = driver.findElement(By.xpath(".//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", msgSucesso);
    }

    @Entao("^sou notificado que o nome da conta e obrigatorio$")
    public void souNotificadoQueONomeDaContaEObrigatorio() throws Throwable {
        String msgSemNome = driver.findElement(By.xpath(".//div[@class='alert alert-danger']")).getText();
        ;
        Assert.assertEquals("Informe o nome da conta", msgSemNome);
    }

    @Entao("^sou notificado que ja existe uma conta com esse nome$")
    public void souNotificadoQueJaExisteUmaContaComEsseNome() throws Throwable {
        String msgNomeRepetido = driver.findElement(By.xpath(".//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", msgNomeRepetido);
    }

    @Entao("^recebo a mensagem \"([^\"]*)\"$")
    public void recebo_a_mensagem(String arg1) throws Throwable {
        String texto = driver.findElement(By.xpath(".//div[starts-with(@class, 'alert alert-')]")).getText();
        Assert.assertEquals(arg1, texto);
    }

    @After(order = 1)
    public void screenShot(Scenario cenario) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Evidences/" + cenario.getId() + ".pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
    public void fecharBrowser() {
        driver.quit();
    }
}
