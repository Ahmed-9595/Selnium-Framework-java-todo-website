package Utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;
    private ConfigUtils(){
        String env= System.getProperty("env","PRODUCTION");
        switch (env){
            case "PRODUCTION" :
                properties=ProperiesUtils.loadProperties("src\\test\\java\\Config\\production.properties");
            break;
            case "LOCAL":
                properties=ProperiesUtils.loadProperties("src\\test\\java\\Config\\local.properties");
            break;
            default:
                throw new RuntimeException("Environment is not supported");

        }

    }
    public static ConfigUtils getInstance(){
        if (configUtils==null){
            configUtils=new ConfigUtils();
        }
        return configUtils;
    }
    public String getbaseUrl(){
        String prop=properties.getProperty("baseUrl");
        if (prop!=null)
            return prop;
        throw new RuntimeException("Could not find Baseurl from properties file");
    }
    public String getEmail(){
        String prop=properties.getProperty("email");
        if (prop!=null)
            return prop;
        throw new RuntimeException("Could not find email from properties file");
}
    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null)
            return prop;
        throw new RuntimeException("Could not find password from properties file");
    }}