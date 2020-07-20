package test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import report.ReportListener;


import static utils.CommonUtils.retornarValorArquivoConfiguracao;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {


    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void preCondition() {
        driver = new DriverFactory().criarInstancia();
        driver.get(retornarValorArquivoConfiguracao("url.base"));
    }

    @AfterMethod
    public void postCondition(){
        driver.quit();
    }
}