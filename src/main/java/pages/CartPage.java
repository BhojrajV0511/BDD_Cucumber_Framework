package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Utility.getTextFromElement;

public class CartPage {
    private WebDriver driver;

    //Locators
    private By productAddedInCart = By.xpath("//span[contains(text(),'iPhone 15 Pro (256 GB) - Natural Titanium')]/following-sibling::span");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String productIsDisplayedInCart(){
        return getTextFromElement(productAddedInCart);
    }
}
