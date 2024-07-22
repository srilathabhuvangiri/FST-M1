package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/");
        driver= new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void googleKeep() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("New text note")));
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Activities");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("All appium activities completed");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("browse_note_interior_content")));
        boolean noteAdded= driver.findElement(AppiumBy.id("browse_note_interior_content")).isDisplayed();
        Assert.assertTrue(noteAdded);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
