package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContaPage;
import pageObjects.LoginPage;

public class ContaTest extends BaseTest{

    @Test(testName = "CT - Validate access to the account menu")
    public void validateAccessAccountMenu() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        ContaPage conta = new ContaPage(driver);
        login.informarLoginValido();
        conta.clicarMenuConta();

        Assert.assertEquals(conta.validarExibicaoSubmenuListarConta(), "Listar");
        Assert.assertEquals(conta.validarExibicaoSubmenuAdicionarConta(), "Adicionar");
    }
    @Test(testName = "CT - Validate the view of the list of accounts")
    public void validateViewListAccounts() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        ContaPage conta = new ContaPage(driver);
        login.informarLoginValido();
        conta.clicarMenuConta();
        conta.clicarSubmenuListarConta();

        Assert.assertEquals(conta.validarExibicaoColunaConta(), "Conta");
//        Assert.assertTrue(conta.validarTabelaGridContasVisivel(), "A tabela de conta não foi exibida");
    }

    @Test(testName = "CT - Validate access add account")
    public void validateAccessAddAccount() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        ContaPage conta = new ContaPage(driver);
        login.informarLoginValido();
        conta.clicarMenuConta();
        conta.clicarSubmenuAdicionarConta();
        conta.preencherNomeDaConta("Aluguel 2019");
        conta.clicarBotaoSalvar();

        Assert.assertEquals(conta.validarExibicaoMensagemDeSucesso(),"Conta adicionada com sucesso!");
    }
    @Test(testName = "CT - Validate creating an existing account")
    public void validateCreatingExistingAccount() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        ContaPage conta = new ContaPage(driver);
        login.informarLoginValido();
        conta.clicarMenuConta();
        conta.clicarSubmenuAdicionarConta();
        conta.preencherNomeDaConta("Aluguel 2020");
        conta.clicarBotaoSalvar();

        Assert.assertEquals(conta.validarExibicaoMensagemDeErro(),"Já existe uma conta com esse nome!");
    }
}
