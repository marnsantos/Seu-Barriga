package test;


import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TransacaoFinanceiraPage;

public class TransacaoFinanceiraTest extends BaseTest{

    @Test(testName = "CT - Validate access to the Create Financial Transaction menu")
    public void validateAccessCreateFinancialTransactionMenu() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.informarLoginValido();
        TransacaoFinanceiraPage transacao = new TransacaoFinanceiraPage(driver);
        transacao.clicarMenuCriarMovimentacao();
        transacao.validarCriarTransacaoFinanceira("19/07/2020", "29/10/2020",
                "Pagamento Teste", "Manoel Santos", "1500");


//        Assert.assertEquals(conta.validarExibicaoMensagemDeErro(),"Já existe uma conta com esse nome!");
    }
}
