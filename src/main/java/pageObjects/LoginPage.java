package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement campoEmail;
    @FindBy(id = "senha")
    WebElement campoSenha;
    @FindBy(xpath = "//button[text()='Entrar']")
    WebElement botaoEntrar;
    @FindBy(xpath = "//*[@class='alert alert-success']")
    WebElement mensagemSucesso;
    @FindBy(xpath = "//*[@class='alert alert-danger']")
    WebElement mensagemDeErro;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    WebElement nomeSeuBarriga;
    @FindBy(xpath = "//footer[@class='footer']")
    WebElement rodapeNaPaginaPrincipal;


    public void preencherEmail(String valor){  campoEmail.sendKeys(valor); }
    public void preencherSenha(String value) { campoSenha.sendKeys(value);}
    public void clicarBotaoEntrar() { botaoEntrar.click(); }
    public String validarMensagemDeSucesso() { return mensagemSucesso.getText(); }
    public String validarMensagemDeErro() { return mensagemDeErro.getText(); }

    public String validarExibicaoNomeSeuBarriga() { return nomeSeuBarriga.getText(); }
    public String validarExibicaoRodapeNaPaginaPrincipal() { return rodapeNaPaginaPrincipal.getText(); }

    public void informarLoginValido() {
        preencherEmail("magnosilva7135@gmail.com");
        preencherSenha("123456");
        clicarBotaoEntrar();
    }
    public boolean verificarExibicaoNomeDaAplicacaoSeuBarriga() {
        return validarElementoVisivel(nomeSeuBarriga,"Nome da aplicação não foi exibida");
    }

    public boolean validarElementoVisivel(WebElement elemento, String msgErro) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elemento));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}