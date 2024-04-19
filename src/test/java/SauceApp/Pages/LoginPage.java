package SauceApp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class LoginPage {

    @FindBy(xpath = "//label[text()='E-mail']//following::input")
    private WebElement emailField;

    @FindBy(xpath = "//label[text()='Mot de passe']//following::input")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement boutonConnecter;

    @FindBy(css = ".sc-isyk1s-7.ixbHGI")
    private WebElement lienSInscrireGratuitement;

    @FindBy(id = "swal2-html-container")
    private WebElement messageErreur;


    private final By TEXTE_SE_CONNECTER = By.xpath("");

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void seConnecter(String username, String password) {
        System.out.println("------------------------------> : je me connecte");
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        boutonConnecter.click();
    }

    public String verifierMessageErreur() {
        System.out.println("getting text .....");
        return messageErreur.getText();
    }

    public void clickSinscrireGratuitement() {
        System.out.println("------------------------------> : je clic sur le lien s'incrire !!");
        lienSInscrireGratuitement.click();
    }


}
