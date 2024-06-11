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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ActivityGoogleChrome {

    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
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
    public  void testToDoList(){
        driver.get("https://www.training-support.net/selenium");
        //Scroll to find the To-Do List card and click it.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(
                AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward().scrollIntoView(text(\"To-Do List\"))"));
        driver.findElement(
                AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward().scrollIntoView(text(\"To-Do List\"))")).click();

        //Once the page loads, find the input field on the page and enter the following three tasks:
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.webkit.WebView[@text='Todo List']")));
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Todo List']")).isDisplayed();
        List<String> tasksListToAdd = new ArrayList<>();
        tasksListToAdd.add("Add tasks to list");
        tasksListToAdd.add("Get number of tasks");
        tasksListToAdd.add("Clear the list");
        String taskBox = "resourceId(\"taskInput\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(taskBox)));
        driver.findElement(AppiumBy.androidUIAutomator(taskBox)).click();
        driver.findElement(AppiumBy.androidUIAutomator(taskBox)).sendKeys(tasksListToAdd.get(0));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.androidUIAutomator(taskBox)).sendKeys(tasksListToAdd.get(1));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.androidUIAutomator(taskBox)).sendKeys(tasksListToAdd.get(2));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        //Click on each of the tasks added to strike them out
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Add tasks to list\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Get number of tasks\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Clear the list\")")).click();

        //Finally, clear the list.
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[2][contains(@text,'Clear List')]")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Clear List')]")).click();
        String actual = driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text, '')]")).getText();
        String expected = "";

        Assert.assertEquals(actual, expected);


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}