package org.naukri.Utility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DriverManager extends Base{

    private static WebDriver driver; // Static WebDriver instance
    public final int TIMEOUT = 10;
    public final int Page_Load_Timeout = 20;

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    public DriverManager() throws Exception {
    }

    private static class CustomThread extends Thread {
        protected final WebDriver driver;

        private CustomThread(WebDriver driver) {
            this.driver = driver;
        }
    }

    public WebDriver initializeDriver(String browser) {
        LOGGER.info("Selenium.initializeDriver");

        switch (browser.toLowerCase()) {
            case "chrome":
                if (driver == null) {
                    String dir = System.getProperty("user.dir");
                    String downloadPath = dir + "/src/test/resources";
                    ChromeOptions options = new ChromeOptions();
                    java.util.HashMap<String, Object> prefs = new java.util.HashMap<>();
                    prefs.put("download.default_directory", downloadPath);
                    options.setExperimentalOption("prefs", prefs);
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Page_Load_Timeout));
                    return driver;
                }
                break;
            case "firefox":
                if (driver == null) {
                    String dir = System.getProperty("user.dir");
                    String downloadPath = dir + "/src/test/resources";
                    FirefoxOptions options = new FirefoxOptions();
                    options.setCapability("browser.download.folderList", 2); // 0: Desktop, 1: Downloads, 2: Custom Location
                    options.setCapability("browser.download.dir", downloadPath);
                    options.setCapability("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); // Specify MIME types to auto-download
                    driver = new FirefoxDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Page_Load_Timeout));
                    return driver;
                }
                break;
        }
        return driver;
    }

    public void openPage(String url, WebDriver driver) {
        driver.get(url);
    }

    public void tearDown() {
        driver.quit();
    }

}
