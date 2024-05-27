import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class Activity9 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("Starting Test |");
        Reporter.log("Page Title :" + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Javascript Alerts");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Reporter.log("Ending Test |");
        driver.quit();
    }

    @BeforeMethod
    public void switchDefault() {
        Reporter.log("Test Case switch to default mathod |");
    driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlter() {
        WebElement simpleAlertBtn = driver.findElement(By.id("simple"));
        Assert.assertEquals(simpleAlertBtn.getText(),"Simple Alert");
        simpleAlertBtn.click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"This is a JavaScript Alert!");
        Reporter.log("Alert text :"+alertText);
        driver.switchTo().alert().accept();
    }

    @Test(priority = 1)
    public void prompt() {
        WebElement simpleAlertBtn = driver.findElement(By.id("prompt"));
        Assert.assertEquals(simpleAlertBtn.getText(),"Prompt");
        simpleAlertBtn.click();
        Reporter.log("Simple Alert opened |");
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"This is a JavaScript Prompt!");
        Reporter.log("Alert text :"+alertText);
        driver.switchTo().alert().sendKeys("TestNg scripting");
        driver.switchTo().alert().dismiss();

    }

    @Test(priority = 3)
    public void confirmation() {

        WebElement simpleAlertBtn = driver.findElement(By.id("confirm"));
        Assert.assertEquals(simpleAlertBtn.getText(),"Confirmation");
        simpleAlertBtn.click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"This is a JavaScript Confirmation!");
        Reporter.log("Alert text :"+alertText);
        driver.switchTo().alert().accept();
    }
}