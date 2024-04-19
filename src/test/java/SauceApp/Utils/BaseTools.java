package SauceApp.Utils;

import SauceApp.Configuration.SetupTearDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTools extends SetupTearDown {

    private WebDriverWait wait;

    private final int DEFAULT_TIME = 30;

    public  boolean verifier_texte_element(By by, String value){
        return driver.findElement(by).getText().equals(value);
    }

    public void waitAndSendKeys(WebElement webElement, String text){
        wait = new WebDriverWait(driver,DEFAULT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);
    }

    public void waitAndClick(WebElement webElement){
        wait = new WebDriverWait(driver,DEFAULT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}
