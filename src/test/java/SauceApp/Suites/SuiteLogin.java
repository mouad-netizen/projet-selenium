package SauceApp.Suites;

import SauceApp.Configuration.SetupTearDown;
import SauceApp.DataSet.Constante;
import SauceApp.Pages.LoginPage;
import SauceApp.Pages.SinscrirePage;
import SauceApp.Pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteLogin extends SetupTearDown {



    public void Test01_loginInvalide() throws InterruptedException {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.click_se_connecter_button();
        LoginPage pageLogin = new LoginPage(driver);
        pageLogin.seConnecter(Constante.email,Constante.password);
        String actuelMessage= pageLogin.verifierMessageErreur();

        Assert.assertEquals(actuelMessage, Constante.errorMessage);
    }

    @Test
    public void Test02_sinscrire_gratuitement(){

        //1.Allez à :https://www.avito.ma/
        WelcomePage welcomePage = new WelcomePage(driver);
        LoginPage pageLogin = new LoginPage(driver);
        //welcomePage.remove_welcome_popup();

        //2.Cliquez sur lien Se connecter
        welcomePage.click_se_connecter_button();

        // 3.Vérifiezaffichage titre «Connectez-vous à Avito»

        //4.Cliquezsur le lien S'inscrire gratuitement.
        pageLogin.clickSinscrireGratuitement();

        //5.Remplissezle formulaire avec des données valide sans préciser la ville
        SinscrirePage sinscrire = new SinscrirePage(driver);
        sinscrire.remplirFormulaire(Constante.nom,Constante.email,Constante.telephone,Constante.password,Constante.passwordConfirmation);

        //6.Vérifiez que le bouton «Créer un compte» est désactivé
        Assert.assertFalse(sinscrire.verifierEtatButton());

        //7.Acceptez les conditions
        sinscrire.accepterCondition();

        //8.Cliquez sur le bouton «Créer un compte»
        sinscrire.cliquerButtonCreerUnCompte();

        //9.Vérifiez si la valeur saisie dans le champ nom s’affiche toujours
        Assert.assertTrue(sinscrire.verifierChampEstRempli("name",Constante.nom));

        //10.Vérifiez si la valeur saisie dans le champ télephone s’affiche toujours
        Assert.assertTrue(sinscrire.verifierChampEstRempli("phone",Constante.telephone));

        //10.Vérifiez l’affichage du message d’erreur Veuillez Sélectionner une ville avec le couleur rouge
        Assert.assertTrue(sinscrire.verifierColorElement());

        //11.Vérifiez que checkbox est toujours coché
        Assert.assertTrue(sinscrire.verifierEtatCheckbox());

        //12.Vérifiez que le bouton «Créer un compte» est activé
        Assert.assertTrue(sinscrire.verifierEtatButton());



    }


}
