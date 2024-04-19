package SauceApp.Pages;

import SauceApp.Utils.BaseTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BaseTools {

    @FindBy(css = ".sc-1610tp6-0.bwiScQ")
    private WebElement  buttonSeConnecter;

    @FindBy(xpath = "//p[text()='Autoriser']")
    private WebElement  buttonPopUp;

    WebDriver driver ;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click_se_connecter_button(){
        waitAndClick(buttonSeConnecter);
    }

    public void remove_welcome_popup(){
        waitAndClick( buttonPopUp);
    }




}
