package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.id("user-name");
    By password = By.id("password");

    By login = By.id("login-button");

    By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void openURL(){
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String user){
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

}
