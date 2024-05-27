import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net");
        System.out.println("Page Title :"+driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        String title = driver.getTitle();
        System.out.println("Page Title :"+title);
        Assert.assertEquals(title,"Training Support");
        driver.findElement(By.id("about-link")).click();
        System.out.println("new page Title :"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"About Training Support");
    }
}
