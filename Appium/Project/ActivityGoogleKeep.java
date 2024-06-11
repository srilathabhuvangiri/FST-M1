package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;

public class ActivityGoogleKeep {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass()
    public  void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        // Server Address
        URL serverURL = new URL("http://localhost:4723/");
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void googleKeep(){

        //Click the Create New Note button to add a new Note.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("new_note_button")));
        driver.findElement(AppiumBy.id("new_note_button")).click();

        //Add a title for the note and add a small description
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        String expectedTitle = "Activity Title";
        String expectedNote = "Activity Description ";
        driver.findElement(AppiumBy.id("editable_title")).sendKeys(expectedTitle);
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys(expectedNote);

        //Press the back button and make an assertion to ensure that the note was added.
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();

        String title = "resourceId(\"com.google.android.keep:id/index_note_title\")";
        String note = "resourceId(\"com.google.android.keep:id/index_note_text_description\")";
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("new_note_button")));
        String actualTitle = driver.findElement(AppiumBy.androidUIAutomator(title)).getText();
        String actualNote = driver.findElement(AppiumBy.androidUIAutomator(note)).getText();

        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertEquals(actualNote,expectedNote);

    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }


}