package org.naukri.pages;

import org.naukri.Utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Base {
    WebDriver driver;
    public final By menu = By.xpath("//div[@class='nI-gNb-drawer']");
    public final By profile = By.xpath("//div/a[@class='nI-gNb-info__sub-link']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateProfilePage(WebDriver driver){
        WebElement menuElement = driver.findElement(menu);
        menuElement.click();

        WebElement profileElement = driver.findElement(profile);
        profileElement.click();
    }



}
