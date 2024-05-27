package stepDefinition;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on google homepage$")
    public void user_is_on_google_home_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Google");
    }
    @When("^User types in Cheese and hits ENTER$")
    public void user_type_in_cheese_and_hit_enter(){

        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
    }
    @Then("^Show how many search results were shown$")
    public void show_how_many_search_results_were_shown(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='Cheese']")));
        String searchResult = driver.findElement(By.xpath("//h3[text()='Cheese']")).getText();
        Assert.assertEquals(searchResult,"Cheese");
    }

    @And("^close the browser$")
    public void close_browser(){
        driver.close();
    }
}
