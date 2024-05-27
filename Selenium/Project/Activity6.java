import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title :"+pageTitle);
        System.out.println("Page Title :"+pageTitle);
    }


    @Test
    public void navigateToMyAccount(){
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title : "+ pageTitle);
        System.out.println("Page Title :"+pageTitle);
        Assert.assertEquals(pageTitle,"My Account – Alchemy LMS");
    }

    @Test(dependsOnMethods = "navigateToMyAccount")
    public void navigateToLoginPage(){
        driver.findElement(By.xpath("//a[contains(@class,'login')]")).click();
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");
        System.out.println("Page Title after clicking on Login button :"+driver.getTitle());
    }

    @Test(dependsOnMethods = "navigateToLoginPage")
    public void login(){
        driver.findElement(By.id("user_login")).sendKeys("srilatha.bhuvangiri@ibm");
        driver.findElement(By.id("user_pass")).sendKeys("password");
        driver.findElement(By.id("wp-submit")).click();

        if(driver.findElement(By.xpath("//div[@class='ld-alert ld-alert-warning']")).isDisplayed()){
        System.out.println(driver.findElement(By.xpath("//div[@class='ld-alert ld-alert-warning']")).getText());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
