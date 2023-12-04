package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Utility.clickElement;
import static util.Utility.getTextFromElement;
import static util.Wait.waitForDisplayed;

public class ProductDetailsPage {
    private WebDriver driver;

    //Locators
    private By productPrice = By.xpath("//div[@id='centerCol']/descendant::span[@class='a-price-whole']");
    private By addToCartBtn = By.xpath("//div[@id='addToCart_feature_div']/following::input[@id='add-to-cart-button']");
    private By proceedToCheckoutBtn = By.xpath("//span[contains(text(),'Proceed to checkout')]");
    private By closeLink = By.xpath("//a[@id='attach-close_sideSheet-link']");
    private By cartCount = By.xpath("//span[@id='nav-cart-count']");
    private By cartContainer = By.xpath("//div[@id='nav-cart-count-container']");

    // Constructor
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    public String storeProductPrice(){
        return getTextFromElement(productPrice);
    }

    public void addProductToCart(){
        clickElement(addToCartBtn);
        waitForDisplayed(proceedToCheckoutBtn);
        clickElement(closeLink);
    }

    public int productsInCart(){
        String count = getTextFromElement(cartCount);
        return Integer.parseInt(count);
    }

    public void navigateToCart(){
        clickElement(cartContainer);
    }
}
