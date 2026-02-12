package stepdef;

import config.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setup(){
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage.openURL();
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.enterUsername("abcd");
        loginPage.enterPassword("147852");
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should navigate to products page")
    public void user_should_navigate_to_products_page() {
        System.out.println("Login successful");
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {

        String actualError = loginPage.getErrorMessage();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        Assertions.assertEquals(expectedError, actualError);
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
