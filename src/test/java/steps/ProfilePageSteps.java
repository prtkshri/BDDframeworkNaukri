package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.naukri.Utility.Base;
import org.naukri.pages.LoginPage;
import org.naukri.pages.HomePage;
import org.naukri.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.naukri.Utility.DriverManager;


public class ProfilePageSteps extends Base {
    DriverManager manager = new DriverManager();
    WebDriver driver;
    String url = getProperty("url");
    LoginPage loginPage=new LoginPage(driver);
    HomePage homePage=new HomePage(driver);
    ProfilePage profilePage=new ProfilePage(driver);

    public ProfilePageSteps() throws Exception {
        this.driver = manager.initializeDriver();
    }


    @Given("Open naukri website")
    public void openNaukriWebsite() throws Exception {
        manager.openPage(url, driver);
    }


    @When("user login to naukri.com")
    public void userLoginToNaukriCom() throws Exception {
        homePage = loginPage.loginUser(driver);
    }

    @And("user navigate to profile page")
    public void userNavigateToProfilePage() {
        homePage.navigateProfilePage(driver);
    }

    @And("user uploads cv")
    public void userUploadsCv() throws Exception {
        profilePage.uploadCV(driver);
    }


    @Then("Verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String message) {
        String SuccessText = profilePage.validateSuccessMessage(driver);
        org.testng.Assert.assertEquals(message, SuccessText);
        manager.tearDown();
    }
}
