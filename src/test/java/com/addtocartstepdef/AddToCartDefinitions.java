package com.addtocartstepdef;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import util.BaseClass;
import java.io.FileNotFoundException;
import static util.Utility.readPropertiesFile;

public class AddToCartDefinitions extends BaseClass {

    HomePage homePage = new HomePage(getDriver());
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
    CartPage cartPage = new CartPage(getDriver());

    @Given("^I am on the Amazon webpage$")
    public void i_am_on_the_Amazon_webpage() throws FileNotFoundException {
        initializeDriver();
        getDriver().get(readPropertiesFile().getProperty("url"));
    }

    @When("^user searched iphone$")
    public void user_searched_iphone() throws FileNotFoundException {
        homePage.searchProduct(readPropertiesFile().getProperty("product"));
    }

    @And("^selected an iphone from list and navigated to product details page$")
    public void selectedAnIphoneFromListAndNavigatedToProductDetailsPage() throws FileNotFoundException {
        homePage.switchToNextWindow(readPropertiesFile().getProperty("product"));
    }

    @And("^select and store price in a variable$")
    public void select_and_store_price_in_a_variable() {
        String productPrice = productDetailsPage.storeProductPrice();
        System.out.println(productPrice);
    }

    @And("^added it to cart$")
    public void added_it_to_cart(){
        productDetailsPage.addProductToCart();
    }

    @Then("^product should be added to cart$")
    public void product_should_be_added_to_cart() throws FileNotFoundException {
        int productCount = productDetailsPage.productsInCart();
        Assert.assertTrue(productCount > 0, "Product is not added to cart");
        productDetailsPage.navigateToCart();
        String productName = cartPage.productIsDisplayedInCart();
        Assert.assertTrue(productName.contains(readPropertiesFile().getProperty("cartProduct")),"Product is not available in Cart.");
        quitDriver();
    }
}