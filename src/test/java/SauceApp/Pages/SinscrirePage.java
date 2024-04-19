package SauceApp.Pages;

import SauceApp.Utils.BaseTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SinscrirePage extends BaseTools {

    @FindBy(id = "name")
    private WebElement champNom;

    @FindBy(id = "email")
    private WebElement champEmail;

    @FindBy(id = "phone")
    private WebElement champTelephone;

    @FindBy(id = "password")
    private WebElement champMotDePasse;

    @FindBy(id = "passwordConfirmation")
    private WebElement champConfirmationMotDePasse;

    @FindBy(xpath = "//input[@class='sc-cbdw5v-4 iwxmpW']")
    private WebElement champVille;

    @FindBy(xpath = "//input[@class='sc-1nv0bef-0 jVkNQt']")
    private WebElement checkboxAccepterCondition;

    @FindBy(xpath = "//span[text()='Veuillez Sélectionner une ville']")
    private WebElement texteErreurMessageVille;

    @FindBy(xpath = "//button[@class='sc-uoqswv-0 sc-uoqswv-1 sc-uoqswv-2 btGlai uyOfO']")
    private WebElement buttonCreerUnCompte;

    WebDriver driver;

    public SinscrirePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void remplirFormulaire(String nom, String email, String telephone, String password, String passwordConfirmation) {
        System.out.println("------------------------------> : je rempli le formulaire");
        waitAndSendKeys(champNom,nom);
        waitAndSendKeys(champEmail,email);
        waitAndSendKeys(champTelephone,telephone);
        waitAndSendKeys(champMotDePasse,password);
        waitAndSendKeys(champConfirmationMotDePasse,passwordConfirmation);
    }

    public boolean verifierEtatButton() {
        System.out.println("------------------------------> : je vérifie l'etat du button");
        return buttonCreerUnCompte.isEnabled();
    }

    public void accepterCondition() {
        System.out.println("------------------------------> : j'accepte les condition d'utilisation");
        waitAndClick(checkboxAccepterCondition);
    }

    public void cliquerButtonCreerUnCompte() {
        System.out.println("------------------------------> : je clic sur le button pour créer un compte ");
        waitAndClick(buttonCreerUnCompte);
    }

    public boolean verifierChampEstRempli(String id, String value) {
        System.out.println("------------------------------> : je vérifie les champs sont rempli");
        WebElement champ = driver.findElement(By.id(id));
        return champ.getAttribute("value").equals(value);
    }

    public boolean verifierEtatCheckbox() {
        System.out.println("------------------------------> : je vérifie le checkbox");
        return checkboxAccepterCondition.isSelected();
    }

    public boolean verifierColorElement() {
        System.out.println("------------------------------> : je vérifie la couleur de la ville ");
        return texteErreurMessageVille.getCssValue("color").equals("rgba(209, 54, 73, 1)");
    }

    public boolean verifierAffichageMessageErreurDeLaVilleEnRouge() {
        System.out.println("------------------------------> : je véfie le message de la ville  ");
        return texteErreurMessageVille.isDisplayed() && verifierColorElement();
    }
}
