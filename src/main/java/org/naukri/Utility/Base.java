package org.naukri.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Base {
    public String getProperty(String key) throws Exception {
        String currentDir = System.getProperty("user.dir");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(currentDir + "/src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }


}
