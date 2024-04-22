package org.naukri.pages;

import org.naukri.Utility.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base {
    WebDriver driver;
    public final By locateUserName = By.id("usernameField");
    public final By locatePassword = By.id("passwordField");
    public final By locateSubmit = By.xpath("//button[@type='submit']");
    String username = getProperty("username");
    String password = getProperty("password");

    public LoginPage(WebDriver driver) throws Exception {
        this.driver = driver;
    }


    public HomePage loginUser(WebDriver driver) throws Exception {

        WebElement usernameField = driver.findElement(locateUserName);
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(locatePassword);
        passwordField.sendKeys(password);

        WebElement submit = driver.findElement(locateSubmit);
        submit.click();

        return new HomePage(driver);
    }

}
