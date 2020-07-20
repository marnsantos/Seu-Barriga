package driver;

import org.openqa.selenium.chrome.ChromeOptions;

class ChromeOptionsFactory {

    ChromeOptions build(){

        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("start-maximized");
        optionsChrome.addArguments("lang=pt-BR");

    return optionsChrome;
    }
}
