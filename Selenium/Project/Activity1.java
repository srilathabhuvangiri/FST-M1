import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title :"+pageTitle);
        System.out.println("Page Title :"+pageTitle);
    }


    @Test
    public void titleValidation(){
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Alchemy LMS – An LMS Application")){
            driver.close();
        }
    }
}
