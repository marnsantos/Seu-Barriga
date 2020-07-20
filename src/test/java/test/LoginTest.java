package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;


public class LoginTest extends BaseTest {

    //CT - Validate top menu of home page
    //CT - Validate footer on homepage
    @Test(testName = "CT - Validate registered user")
    public void validateRegisteredUser() throws InterruptedException {
        LoginPage accessPage = new LoginPage(driver);
        accessPage.preencherEmail("magnosilva7135@gmail.com");
        accessPage.preencherSenha("123456");
        accessPage.clicarBotaoEntrar();

        Assert.assertEquals(accessPage.validarMensagemDeSucesso(), "Bem vindo, Magno Silva!");
        Assert.assertEquals(accessPage.validarExibicaoNomeSeuBarriga(), "Seu Barriga");
        Assert.assertEquals(accessPage.validarExibicaoRodapeNaPaginaPrincipal(), "Seu Barriga. Nunca mais esqueça de pagar o aluguel.reset");

    }
    @Test(testName = "CT - Validate unregistered user")
    public void validateUnregisteredUser() throws InterruptedException {
        LoginPage accessPage = new LoginPage(driver);
        accessPage.preencherEmail("marciamnsanalista@gmail.com");
        accessPage.preencherSenha("123456");
        accessPage.clicarBotaoEntrar();

        Assert.assertEquals(accessPage.validarMensagemDeErro(), "Problemas com o login do usuário");
    }
    //    @Test(testName = "CT - Validate inform email in invalid format")
//    public void validateInformEmailInvalidFormat() throws InterruptedException {
//        LoginPage accessPage = new LoginPage(driver);
//        accessPage.inputEmail("marciamnsanalistagmail.com");
//        accessPage.inputPassword("123456");
//        accessPage.clickEnterButton();
//
//        Assert.assertEquals(accessPage.invalidLogin(), "Problemas com o login do usuário");
//    }
    @Test(testName = "CT - Validate invalid password report")
    public void validateInvalidPassword() throws InterruptedException {
        LoginPage accessPage = new LoginPage(driver);
        accessPage.preencherEmail("marciamnsanalista@gmail.com");
        accessPage.preencherSenha("teste");
        accessPage.clicarBotaoEntrar();

        Assert.assertEquals(accessPage.validarMensagemDeErro(), "Problemas com o login do usuário");
    }

    @Test(testName = "CT - Validate required email field")
    public void validateRequiredEmailFields() throws InterruptedException {
        LoginPage accessPage = new LoginPage(driver);
        accessPage.preencherEmail(" ");
        accessPage.preencherSenha("123456");
        accessPage.clicarBotaoEntrar();

        Assert.assertEquals(accessPage.validarMensagemDeErro(), "Email é um campo obrigatório");
    }
    @Test(testName = "CT - Validate required password field")
    public void validateRequiredPassworFields() throws InterruptedException {
        LoginPage accessPage = new LoginPage(driver);
        accessPage.preencherEmail("magnosilva7135@gmail.com");
        accessPage.preencherSenha("");
        accessPage.clicarBotaoEntrar();

        Assert.assertEquals(accessPage.validarMensagemDeErro(), "Senha é um campo obrigatório");
    }

}
