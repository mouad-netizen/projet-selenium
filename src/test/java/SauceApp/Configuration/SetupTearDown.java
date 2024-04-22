
package SauceApp.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class SetupTearDown {
    public static WebDriver driver;

    @BeforeMethod
    public void lunchBrowser() {
        System.out.println("------------------------------> je prépare l'enviremnemt de travail");
        System.setProperty("webdriver.edge.driver", "C:\\bin\\msedgedriver.exe");
        /*
        String browser = System.getenv("Browser");
        if(browser.contentEquals("edge")){
            //System.setProperty("webdriver.edge.driver", "C:\\bin\\msedgedriver.exe");
             driver = new EdgeDriver();
        }

        else  {

            driver = new FirefoxDriver();

        }*/
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.avito.ma");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("------------------------------> je ferme l'envirenment de travail ");
        driver.quit();
    }
}
