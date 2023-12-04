package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static util.Utility.*;

public class UserRegistrationPage {

    private WebDriver driver;

    // Locators
    private By yourNameInputField = By.xpath("//input[@id='ap_customer_name']");
    private By mobileNumberInputField = By.xpath("//input[@id='ap_phone_number']");
    private By passwordInputField = By.xpath("//input[@id='ap_password']");
    private By verifyMobileNumberBtn = By.xpath("//input[@id='continue']");
    private By getVerifyMobileNumberText = By.xpath("//h1[contains(text(),'Verify mobile number')]");


    // Constructor
    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterDetails(String name, String mobileNumber, String password){
        setValue(yourNameInputField, name);
        setValue(mobileNumberInputField, mobileNumber);
        setValue(passwordInputField, password);
    }

    public void clickVerifyMobileButton(){
        clickElement(verifyMobileNumberBtn);
    }

    public boolean checkVerifyMobileTextIsDisplayed(){
        return checkIfElementIsDisplayed(getVerifyMobileNumberText);
    }

}
