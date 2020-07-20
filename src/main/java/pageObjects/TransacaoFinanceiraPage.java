package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public class TransacaoFinanceiraPage {

    private WebDriver driver;

    public TransacaoFinanceiraPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href='/movimentacao']")
    WebElement menuCriarMovimentacao;
    @FindBy(xpath = "//*[@id='tipo']")
    WebElement campoTipoMovimentacao;
    @FindBy(xpath = "//*[@value='REC']")
    WebElement tipoMovimentacaoReceita;
    @FindBy(xpath = "//*[@value='DESP']")
    WebElement tipoMovimentacaoDespesa;
    @FindBy(xpath = "//*[@id='data_transacao']")
    WebElement campoDataTransacao;
    @FindBy(xpath = "//*[@id='data_pagamento']")
    WebElement campoDataPagamento;
    @FindBy(xpath = "//*[@id='descricao']")
    WebElement campoDescricao;
    @FindBy(xpath = "//*[@id='interessado']")
    WebElement campoInteressado;
    @FindBy(xpath = "//*[@id='valor']")
    WebElement campoValor;
    @FindBy(xpath = "//*[@id='conta']")
    WebElement campoConta;
    @FindBy(xpath = "//*[text()='Teste']")
    WebElement contaTeste;
    @FindBy(xpath = "//*[@id='status_pago']")
    WebElement situacaoPago;
    @FindBy(xpath = "//*[@id='status_pendente']")
    WebElement situacaoPendente;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement botaoSalvar;

    public void clicarMenuCriarMovimentacao(){ menuCriarMovimentacao.click(); }

    public void validarCriarTransacaoFinanceira(String dataTransacao, String dataPagamento, String descricao, String interessado, String valor){
        tipoMovimentacaoDespesa.click();
        campoDataTransacao.sendKeys(dataTransacao);
        campoDataPagamento.sendKeys(dataPagamento);
        campoDescricao.sendKeys(descricao);
        campoInteressado.sendKeys(interessado);
        campoValor.sendKeys(valor);
        contaTeste.click();
        situacaoPago.click();
    }

}
