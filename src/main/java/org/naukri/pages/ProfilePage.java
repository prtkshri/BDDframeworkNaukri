package org.naukri.pages;

import org.naukri.Utility.Base;
import org.naukri.Utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProfilePage extends Base {
    WebDriver driver;
    public final By fileInput = By.xpath("//section/div/div/input[@id='attachCV']");
    public final By successXpath = By.xpath("//div/p[@class='head']");
    String currentDir = System.getProperty("user.dir");
    String getPath = getProperty("filepath");
    String filePath = currentDir + getPath;

    public ProfilePage(WebDriver driver) throws Exception {
        this.driver = driver;
    }

    public void uploadCV(WebDriver driver) throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement fileInputElement = driver.findElement(fileInput);
        fileInputElement.sendKeys(filePath);
    }

    public String validateSuccessMessage(WebDriver driver) {
        return driver.findElement(successXpath).getText();
    }

}
