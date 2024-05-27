package stepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Login page$")
    public void user_is_on_login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login Form");
    }
    @When("^User enters username and password$")
    public void enterUserCredentials(){
        //Enter Usernmae and password
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String confirmTxt = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmTxt,"Welcome Back, admin");
    }

   @Then("^Read the page title and confirmation message$")
    public void readTitleAndHeading(){
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String confirmTxt = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmTxt,"Welcome Back, admin");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login Form");
    }
    @And("^Close the Browser$")
    public void closeBrowser(){
        driver.close();
    }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String username, String password) {
        //Enter Usernmae and password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

    }
}
