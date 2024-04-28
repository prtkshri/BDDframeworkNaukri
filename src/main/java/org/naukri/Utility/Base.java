package org.naukri.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Base {
     static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    public String getProperty(String key) throws Exception {
        String currentDir = System.getProperty("user.dir");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(currentDir + "/src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public void waitForFileToDownload(String downloadPath) {
        // Specify the maximum time to wait for the file to be downloaded
        long endTime = System.currentTimeMillis() + 50000; // 10 seconds timeout

        // Check if the file exists in the download directory within the specified timeout
        File file = new File(downloadPath);
        while (!file.exists()) {
            // Check if the timeout has been reached
            if (System.currentTimeMillis() > endTime) {
                throw new RuntimeException("File download timed out.");
            }
        }
    }


}
