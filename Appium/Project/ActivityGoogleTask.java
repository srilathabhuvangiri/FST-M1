package project;

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
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ActivityGoogleTask {

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
    public void googleTask(){


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));
        //Click the button to add a new task
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        //Add the following tasks:Complete Activity with Google Tasks ,Complete Activity with Google Keep,Complete the second Activity Google Keep
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).click();
        List<String> taskListtoAdd = new ArrayList<>();
        taskListtoAdd.add("Complete Activity with Google Tasks");
        taskListtoAdd.add("Complete Activity with Google Keep");
        taskListtoAdd.add("Complete the second Activity Google Keep");

        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(taskListtoAdd.get(0).trim());
        //After each task is added, the Save button should be clicked
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_done")));
        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(taskListtoAdd.get(1).trim());
        //After each task is added, the Save button should be clicked
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_done")));
        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(taskListtoAdd.get(2).trim());
        //After each task is added, the Save button should be clicked
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_done")));
        driver.findElement(AppiumBy.id("add_task_done")).click();


        //Write an assertion to ensure all three tasks have been added to the list.
        String tasks = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.androidUIAutomator(tasks)));
        List<WebElement> taskList =  driver.findElements(AppiumBy.androidUIAutomator(tasks));
        System.out.println("Size of the task list : " + taskList.size());


        boolean hasTasks = false;
        for(WebElement task: taskList){
            System.out.println(" Task Name  : " + task.getText());
            if(taskListtoAdd.contains(task.getText())){
                hasTasks= true;
            }
        }
        Assert.assertEquals(hasTasks,true);
    }

    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

}