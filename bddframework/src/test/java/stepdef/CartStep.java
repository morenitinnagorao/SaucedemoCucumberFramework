package stepdef;

import config.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.CartPage;

public class CartStep {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;

    public CartStep() {
        driver = DriverFactory.getDriver();
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @When("User adds product to cart")
    public void user_adds_product_to_cart() {

        productPage.clickAddToCart();
        productPage.openCart();
    }

    @Then("Product should be visible in cart")
    public void product_should_be_visible_in_cart() {

        Assertions.assertTrue(
                cartPage.isProductDisplayed(),
                "Product is not visible in cart!"
        );

        System.out.println("Product successfully added to cart");
    }
}
