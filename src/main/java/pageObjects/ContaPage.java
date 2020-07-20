package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContaPage {

    private WebDriver driver;
    protected WebDriverWait wait;

    public ContaPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='dropdown']")
    WebElement menuConta;
    @FindBy(xpath = "//a[@href='/addConta']")
    WebElement submenuAdicionarConta;
    @FindBy(xpath = "//a[@href='/contas']")
    WebElement submenuListarConta;

    @FindBy(xpath = "//table[@id='tabelaContas']")
    WebElement tabelaGridContas;
    @FindBy(xpath = "//th[text()='Conta']")
    WebElement colunaConta;
    @FindBy(xpath = "//*[@id='nome']")
    WebElement campoNome;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement botaoSalvar;
    @FindBy(xpath = "//*[@class='alert alert-success']")
    WebElement mensagemSucesso;
    @FindBy(xpath = "//*[@class='alert alert-danger']")
    WebElement mensagemDeErro;

    public void clicarMenuConta() {
        menuConta.click();
    }

    public void clicarSubmenuListarConta() {
        submenuListarConta.click();
    }

    public void clicarSubmenuAdicionarConta() {
        submenuAdicionarConta.click();
    }

    public String validarExibicaoSubmenuListarConta() {
        return submenuListarConta.getText();
    }

    public String validarExibicaoSubmenuAdicionarConta() {
        return submenuAdicionarConta.getText();
    }

    public String validarExibicaoColunaConta() { return colunaConta.getText(); }

    public boolean validarTabelaGridContasVisivel() {
        return validarElementoVisivel(tabelaGridContas,"Tabela de contas não foi exibida");
    }

    public boolean validarElementoVisivel(WebElement element, String msnErro) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {

            return false;
        }
        return true;
    }
    public void preencherNomeDaConta(String nome) { campoNome.sendKeys(nome);}
    public void clicarBotaoSalvar() { botaoSalvar.click(); }
    public String validarExibicaoMensagemDeSucesso() { return mensagemSucesso.getText();}
    public String validarExibicaoMensagemDeErro() { return mensagemDeErro.getText();}

}