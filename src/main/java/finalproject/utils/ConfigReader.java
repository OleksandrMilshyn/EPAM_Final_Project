package finalproject.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

                properties.load(inputStream);
        } catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
