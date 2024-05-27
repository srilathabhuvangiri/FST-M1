import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7 {
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
    public void navigateToAllCourses(){
        driver.findElement(By.xpath("//a[text()='All Courses']")).click();
        String pageTitle = driver.getTitle();
        Reporter.log("Page Title : "+ pageTitle);
        System.out.println("Page Title :"+pageTitle);
        Assert.assertEquals(pageTitle,"All Courses – Alchemy LMS");
    }

    @Test(dependsOnMethods = "navigateToAllCourses")
    public void getNumberOfCourses(){
        List <WebElement> numberOfCourses= driver.findElements(By.xpath("//div[contains(@class,'ld_course_grid ')]"));
        System.out.println("Number of courses of the page are :"+numberOfCourses.size());
        Reporter.log("Number of courses of the page are :"+numberOfCourses.size());
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
