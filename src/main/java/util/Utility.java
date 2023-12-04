package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import static util.Wait.*;

public class Utility extends BaseClass{

    static Actions action = new Actions(BaseClass.getDriver());
    public static void setValue(By locator, String text) {
        waitForDisplayed(locator);
        WebElement element = getDriver().findElement(locator);
        element.sendKeys(text);
    }

    public static void clickElement(By locator) {
        waitForClickable(locator);
        WebElement element = getDriver().findElement(locator);
        element.click();
    }

    public static String windowHandle(){
        return getDriver().getWindowHandle();
    }

    public static void switchToOtherWindow(String mainWindow){
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                getDriver().switchTo().window(windowHandle);
            }
        }
    }

    public static void selectElementFromList(List<WebElement> elements, String text){
        for(WebElement element : elements){
            waitForElementToBeDisplayed(element);
            String product = element.getText();
            if(product.contains(text)){
                element.click();
                break;
            }
        }
    }

    public static List<WebElement> getListOfElements(By locator){
        waitForDisplayed(locator);
        return getDriver().findElements(locator);
    }

    public static String getTextFromElement(By locator) {
        waitForDisplayed(locator);
        WebElement element = getDriver().findElement(locator);
        return element.getText();
    }

    public static void moveToElement(By locator) {
        waitForDisplayed(locator);
        WebElement element = getDriver().findElement(locator);
        action.moveToElement(element).perform();
    }

    public static boolean checkIfElementIsDisplayed(By locator){
        waitForDisplayed(locator);
        WebElement element = getDriver().findElement(locator);
        return element.isDisplayed();
    }

    public static Properties readPropertiesFile() throws FileNotFoundException {
        Properties prop = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
