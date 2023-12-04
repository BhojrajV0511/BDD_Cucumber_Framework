package com.registerstepdef;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import util.BaseClass;
import java.io.FileNotFoundException;
import static util.Utility.readPropertiesFile;

public class RegisterUserDefinitions extends BaseClass {
    HomePage homePage = new HomePage(getDriver());
    UserRegistrationPage userRegistrationPage = new UserRegistrationPage(getDriver());

    @Given("^amazon webpage is opened$")
    public void amazonWebpageIsOpened() throws FileNotFoundException {
        initializeDriver();
        getDriver().get(readPropertiesFile().getProperty("url"));
    }

    @When("^user navigated to Account & List$")
    public void navigateToAccountAndList() {
        homePage.hoverToAccountAndLists();
    }

    @And("^clicked on Start here$")
    public void clickStartHere() {
        homePage.clickOnStartHere();
    }

    @And("^entered name, mobile number, password$")
    public void enterDetails() throws FileNotFoundException {
        userRegistrationPage.enterDetails(readPropertiesFile().getProperty("name"),readPropertiesFile().getProperty("contactNumber"),readPropertiesFile().getProperty("password"));
    }

    @And("^clicked to verify mobile number$")
    public void verifyMobileNumber() {
        userRegistrationPage.clickVerifyMobileButton();
    }

    @Then("^verify mobile number is displayed$")
    public void verifyMobileNumberIsDisplayed() {
        Assert.assertTrue(userRegistrationPage.checkVerifyMobileTextIsDisplayed(),"Verify mobile number text is not displayed");
        quitDriver();
    }

}
