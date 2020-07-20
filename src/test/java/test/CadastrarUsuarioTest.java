package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CadastrarUsuarioPage;

public class CadastrarUsuarioTest extends BaseTest{

    @Test(testName = "CT07 - Validate create New user")
    public void validateCreateNewUser() throws InterruptedException {
        CadastrarUsuarioPage newUser = new CadastrarUsuarioPage(driver);
        newUser.acessarMenuNovoUsuario();
        newUser.preencherCampoNome("Anna Silva");
        newUser.preencherCampoEmail("akmsilva@hotmail.com");
        newUser.preencherCampoSenha("654321");
        newUser.clicarBotaoCadastrar();

        Assert.assertEquals(newUser.mensagemCadastroRealizadoComSucesso(), "Usuário inserido com sucesso");
    }


    @Test(testName = "CT08 - Validate required name field in New User form")
    public void validateRequiredNameFieldNewUserForm() throws InterruptedException {
        CadastrarUsuarioPage newUser = new CadastrarUsuarioPage(driver);
        newUser.acessarMenuNovoUsuario();
        newUser.preencherCampoNome("");
        newUser.preencherCampoEmail("akmsilva@hotmail.com");
        newUser.preencherCampoSenha("654321");
        newUser.clicarBotaoCadastrar();

        Assert.assertEquals(newUser.mensagemDeErroEmCadastroNovoUsuario(), "Nome é um campo obrigatório");
    }
    @Test(testName = "CT09 - Validate required email field in New User form")
    public void validateRequiredEmailFieldNewUserForm() throws InterruptedException {
        CadastrarUsuarioPage newUser = new CadastrarUsuarioPage(driver);
        newUser.acessarMenuNovoUsuario();
        newUser.preencherCampoNome("Anna Matos");
        newUser.preencherCampoEmail("");
        newUser.preencherCampoSenha("654321");
        newUser.clicarBotaoCadastrar();

        Assert.assertEquals(newUser.mensagemDeErroEmCadastroNovoUsuario(), "Email é um campo obrigatório");
    }
    @Test(testName = "CT10 - Validate required senha field in New User form")
    public void validateRequiredSenhaFieldNewUserForm() throws InterruptedException {
        CadastrarUsuarioPage newUser = new CadastrarUsuarioPage(driver);
        newUser.acessarMenuNovoUsuario();
        newUser.preencherCampoNome("Anna Matos");
        newUser.preencherCampoEmail("akmsilva@gmail.com");
        newUser.preencherCampoSenha("");
        newUser.clicarBotaoCadastrar();

        Assert.assertEquals(newUser.mensagemDeErroEmCadastroNovoUsuario(), "Senha é um campo obrigatório");
    }
//    @Test(testName = "CT11 - Validate email in invalid format")
//    public void validateEmailInvalidFormat() throws InterruptedException {
//        CadastrarUsuarioPage newUser = new CadastrarUsuarioPage(driver);
//        newUser.acessarMenuNovoUsuario();
//        newUser.preencherCampoNome("Anna Matos");
//        newUser.preencherCampoEmail("akmsilvagmail.com");
//        newUser.preencherCampoSenha("123456");
//        newUser.clicarBotaoCadastrar();
//
//        Assert.assertEquals(newUser.mensagemDeErroEmCadastroNovoUsuario(), "Senha é um campo obrigatório");
//    }

}
