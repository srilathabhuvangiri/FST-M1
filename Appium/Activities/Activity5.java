import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/");

        driver= new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void contactsTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("9742484961");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.messaging:id/message_text")));
        String sentMessage= driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/message_text")).getText();
        Assert.assertEquals(sentMessage, "Hello from Appium");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
