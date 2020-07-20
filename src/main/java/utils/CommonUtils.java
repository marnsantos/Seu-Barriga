package utils;

import exception.NoPropertiesException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {

    private CommonUtils() {}

    public static String retornarValorArquivoConfiguracao(String propriedade) {

        Properties properties = new Properties();

        try(InputStream propFileInpStream = CommonUtils.class.getClassLoader()
                .getResourceAsStream("conf/test/config.properties")) {

            properties.load(propFileInpStream);

            return properties.getProperty(propriedade);
        } catch (IOException e) {
            throw new NoPropertiesException("Sem arquivo de configuração!");
        }
    }
}
