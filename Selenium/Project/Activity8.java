import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title :"+pageTitle);
        System.out.println("Page Title :"+pageTitle);
    }


    @Test
    public void navigateToContact(){
        driver.findElement(By.xpath("//a[text()='Contact']")).click();
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title : "+ pageTitle);
        System.out.println("Page Title :"+pageTitle);
        Assert.assertEquals(pageTitle,"Contact – Alchemy LMS");
    }

    @Test(dependsOnMethods = "navigateToContact")
    public void sendMessageToContactUs(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='uagb-ifb-title']")));
        String needHelp = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
        Assert.assertEquals(needHelp,"Need Help?");

        String pageHeading = driver.findElement(By.xpath("//h2[contains(text(),'Send us a message')]")).getText();
        Assert.assertEquals(pageHeading,"Send us a message");

        //Fill the details
        driver.findElement(By.xpath("(//input[starts-with(@id,'wpforms')])[1]")).sendKeys("srilathab");
        driver.findElement(By.xpath("(//input[starts-with(@id,'wpforms')])[2]")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("(//input[starts-with(@id,'wpforms')])[3]")).sendKeys("Selenium test automation");
        driver.findElement(By.xpath("//textarea[starts-with(@id,'wpforms')]")).sendKeys("Thanks for the wonderful training");
        driver.findElement(By.xpath("//button[starts-with(@id,'wpforms-submit')]")).click();

        String emailConfirmationText = driver.findElement(By.xpath("//div[starts-with(@id,'wpforms-confirmation')]")).getText();
        Assert.assertEquals(emailConfirmationText,"Thanks for contacting us! We will be in touch with you shortly.");
        System.out.println("Email send Confirmation message : "+ emailConfirmationText);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
