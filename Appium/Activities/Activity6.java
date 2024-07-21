import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("org.chromium.chrome.browser.ChromeTabbedActivity");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/");
        driver= new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/selenium/LazyLoading");
    }

    @Test
    public void chromeTest(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
        List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Before scroll: " + imageElements.size());
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(UiScrollable+ ".scrollTextIntoView(\"Helen\")")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+ ".scrollTextIntoView(\"Helen\")"));
        imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("After scroll: " + imageElements.size());
        Assert.assertEquals(imageElements.size(), 3);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
