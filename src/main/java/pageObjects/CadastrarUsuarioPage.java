package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastrarUsuarioPage {

    private WebDriver driver;

    public CadastrarUsuarioPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Novo usuário?']")
    WebElement menuNovoUsuario;
    @FindBy(xpath = "//input[@placeholder='Nome']")
    WebElement campoNome;
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement campoEmail;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement campoSenha;
    @FindBy(xpath = "//input[@value='Cadastrar']")
    WebElement botaoCadastrar;
    @FindBy(xpath = "//*[@class='alert alert-success']")
    WebElement usuarioInseridoComSucesso;
    @FindBy(xpath = "//*[@class='alert alert-danger']")
    WebElement mensagemDeErro;

    public void acessarMenuNovoUsuario() { menuNovoUsuario.click(); }
    public void preencherCampoNome(String valor){  campoNome.sendKeys(valor); }
    public void preencherCampoEmail(String valor) { campoEmail.sendKeys(valor);}
    public void preencherCampoSenha(String valor) {campoSenha.sendKeys(valor);}
    public void clicarBotaoCadastrar() { botaoCadastrar.click(); }
    public String mensagemCadastroRealizadoComSucesso() { return usuarioInseridoComSucesso.getText(); }
    public String mensagemDeErroEmCadastroNovoUsuario() { return mensagemDeErro.getText(); }


}
