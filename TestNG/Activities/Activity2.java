import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
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
        Assert.assertEquals(title,"Target Practice");

    }

    @Test
    public void test2(){
        String colorBtn = driver.findElement(By.xpath("//button[@class='ui black button']")).getText();
        System.out.println("Color button :"+colorBtn);
        Assert.assertEquals(colorBtn,"black");
    }

    @Test(enabled = false)
    public void test3(){
        System.out.println("This methods is skipped");
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test(enabled = false)
    public void test4() throws SkipException {
        String test ="test skip";
        if(test.equals("test skip")) {
            throw new SkipException("This tests skipped using in SkipException");
        }
        else {
            System.out.println("Test 4 successfully executed using skipException");
        }
    }
}
