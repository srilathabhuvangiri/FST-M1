package stepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertSteps {

    WebDriver driver;
    Alert alert;
    WebDriverWait wait;
    @Given("^User is on the page$")
    public void openPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Page Title :" + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Javascript Alerts");
    }
    @When("^User clicks the Simple Alert button$")
    public void openSimple_alert(){
        WebElement simpleAlertBtn = driver.findElement(By.id("simple"));
        Assert.assertEquals(simpleAlertBtn.getText(),"Simple Alert");
        simpleAlertBtn.click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void confirm_alert(){
        WebElement simpleAlertBtn = driver.findElement(By.id("confirm"));
        Assert.assertEquals(simpleAlertBtn.getText(),"Confirmation");
        simpleAlertBtn.click();
    }
    @When("^User clicks the prompt Alert button$")
    public void prompt_alert(){
        WebElement simpleAlertBtn = driver.findElement(By.id("prompt"));
        Assert.assertEquals(simpleAlertBtn.getText(),"Prompt");
        simpleAlertBtn.click();
    }
    @Then("^Alert opens$")
    public void switchFocus(){
       alert =  driver.switchTo().alert();
    }
    @And("^Read the text from it and print it$")
    public void read_text_and_print(){
        String alertText = alert.getText();
        System.out.println("Simple alert text :"+ alertText);
    }

    @And("^Write a custom message in it$")
    public void writeToPrompt(){
        String alertText = alert.getText();
        System.out.println("Simple alert text :"+ alertText);
        alert.sendKeys("Hello prompt alert");
    }
    @And("^Close the alert$")
    public void close_alert(){
        driver.switchTo().alert().accept();
    }

    @And("^Close the alert with Cancel$")
    public void close_alert_cancel(){
        driver.switchTo().alert().dismiss();
    }

    @And("^Close Browser$")
    public void close_browser(){
        driver.close();
    }
}
