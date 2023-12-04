package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static util.Utility.*;
import static util.Wait.waitForDisplayed;

public class HomePage  {
    private WebDriver driver;

    // Locators
    private By searchInputField = By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
    private By allProducts = By.xpath("//a[contains(@href,'/Apple-iPhone')]/span[contains(text(),'iPhone')]");
    private By accountAndLists = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    private By startHereLink = By.xpath("//div[@id='nav-flyout-ya-newCust']/a");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void searchProduct(String product) {
        setValue(searchInputField,product);
        clickElement(searchBtn);
    }

    public void switchToNextWindow(String text) {
        String mainWindow = windowHandle();
        List<WebElement> productList = getListOfElements(allProducts);
        selectElementFromList(productList, text);
        switchToOtherWindow(mainWindow);
    }

    public void hoverToAccountAndLists(){
        moveToElement(accountAndLists);
    }

    public void clickOnStartHere(){
        clickElement(startHereLink);
    }
}
