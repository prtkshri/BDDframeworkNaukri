package org.naukri.pages;

import org.naukri.Utility.Base;
import org.naukri.Utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.time.Duration;

public class ProfilePage extends Base {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    WebDriver driver;
    public final By fileInput = By.xpath("//section/div/div/input[@id='attachCV']");
    public final By successXpath = By.xpath("//div/p[@class='head']");
    String currentDir = System.getProperty("user.dir");
    String getPath = getProperty("filepath");
    String filePath = currentDir + getPath;
    String currentDirPath = currentDir + "/src/test/resources/prateek_shrivastava.pdf";
    // String fileName = "";

    public ProfilePage(WebDriver driver) throws Exception {
        this.driver = driver;
    }

    public void uploadCV(WebDriver driver) throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement fileInputElement = driver.findElement(fileInput);
        Thread.sleep(1000);
        fileInputElement.sendKeys(currentDirPath);
        Thread.sleep(1000);
        //deleteFile();
    }

    public void deleteFile() throws InterruptedException {
        File fileToDelete = new File(currentDirPath);
        Thread.sleep(1000);
        if (fileToDelete.exists()) {
            boolean isDeleted = fileToDelete.delete();
            if (isDeleted) {
                LOGGER.info("File deleted !");
            } else {
                LOGGER.info("File to delete !");
            }
        } else {
            LOGGER.info("File does not exist. !");
        }
    }

    public String validateSuccessMessage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver.findElement(successXpath).getText();
    }

    public void downloadCV(WebDriver driver) {
        WebElement downloadButton = driver.findElement(By.xpath("//i[@data-title='download-resume']"));
        downloadButton.click();
        waitForFileToDownload(currentDirPath);
    }

}
