package stepdef;

import config.DriverFactory;
import io.cucumber.java.Before;
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
        driver=DriverFactory.getDriver();
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

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should navigate to products page")
    public void user_should_navigate_to_products_page() {
        System.out.println("Login successful");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.enterUsername("abcd");
        loginPage.enterPassword("147852");
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {

            String actualError = loginPage.getErrorMessage();

            String expectedError = "Epic sadface: Username and password do not match any user in this service";

            Assertions.assertEquals(expectedError, actualError);

            System.out.println("Invalid login error validated successfully");

    }
    //approach:1
//        String actualError = loginPage.getErrorMessage();
//
//        if(actualError.contains("Epic sadface")){
//            System.out.println("error message displayed correctly");
//        }
//        else {
//            System.out.println("error message not displayed");
//        }
//    }


    //approach:2
//    @Then("Error message should be displayed")
//    public void error_message_should_be_displayed() {
//        String actualError = loginPage.getErrorMessage();
//
//        Assertions.assertTrue(
//                actualError.contains("Epic sadface"),
//                "Expected error message not displayed!"
//        );
//    }



    @io.cucumber.java.After
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
