import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Page Title :"+driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest(){
        String title = driver.getTitle();
        System.out.println("Page Title :"+title);
        Assert.assertEquals(title,"Login Form");

        //Enter Usernmae and password
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String confirmTxt = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmTxt,"Welcome Back, admin");

    }
}
