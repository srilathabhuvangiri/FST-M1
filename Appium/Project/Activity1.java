package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/");
        driver= new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void googleTasks() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("tasks_list")));
        List<WebElement> tasksCreated= driver.findElements(AppiumBy.id("task_name"));
        System.out.println("Total tasks: "+tasksCreated.size());
        System.out.println("List of tasks created: ");
        for(WebElement task:tasksCreated){
            System.out.println(task.getText());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
