import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Page Title :"+driver.getTitle());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }


    @Test(groups = {"HeaderTests","ButtonTests"})
    public void pageTitleTest(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void headerTest() {
        Assert.assertEquals(driver.findElement(By.id("third-header")).getText(), "Third header");
        Assert.assertEquals(driver.findElement(By.xpath("//h5[@class='ui green header']")).getText(), "Fifth header");
    }
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void buttonTest() {
        Assert.assertEquals(driver.findElement(By.xpath("//button[@class='ui olive button']")).getText(),"Olive");
        Assert.assertEquals(driver.findElement(By.xpath("//button[@class='ui brown button']")).getText(),"Brown");
    }
}
