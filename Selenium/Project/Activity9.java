import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    Actions a;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        a = new Actions(driver);
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title :"+pageTitle);
        System.out.println("Page Title :"+pageTitle);
    }


    @Test
    public void navigateToAllCourses(){
        driver.findElement(By.xpath("//a[text()='All Courses']")).click();
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title : "+ pageTitle);
        System.out.println("Page Title :"+pageTitle);
        Assert.assertEquals(pageTitle,"All Courses – Alchemy LMS");
    }

    @Test(dependsOnMethods = "navigateToAllCourses")
    public void navigateToFirstCourse(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='uagb-ifb-title']")));
        String pageHeading = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
        Assert.assertEquals(pageHeading,"All Courses");

        //get the first course name
        String firstCourse = driver.findElement(By.xpath("(//h3[@class='entry-title'])[1]")).getText();
        System.out.println("First course :"+firstCourse );

        driver.findElement(By.xpath("(//a[@class='btn btn-primary'])[1]")).click();
      WebElement DevelopingStrategyTooltip = driver.findElement(By.xpath("(//div[@data-ld-tooltip])[1]"));
        a.moveToElement(DevelopingStrategyTooltip).build().perform();
        String toolTipText = DevelopingStrategyTooltip.getAttribute("data-ld-tooltip");
        System.out.println("toolTipText-->"+toolTipText);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
