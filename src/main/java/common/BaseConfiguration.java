package common;

import java.util.Properties;

public class BaseConfiguration {
    Properties configFile;

    public BaseConfiguration()
    {
        configFile = new java.util.Properties();

        try {
            configFile.load(this.getClass().getClassLoader().getResourceAsStream("base.properties"));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        String value = this.configFile.getProperty(key);
        return value;
    }
}
