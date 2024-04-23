package org.naukri.Utility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class DriverManager {

    private static WebDriver driver; // Static WebDriver instance
    public final int TIMEOUT = 10;
    public final int Page_Load_Timeout = 20;

    public DriverManager() {

    }

    public WebDriver initializeDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Page_Load_Timeout));
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
