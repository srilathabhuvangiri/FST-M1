package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"stepDefinition"},
        tags = "@smokeTest",
        plugin = {"html:test-reports/html-reports"},
        monochrome = true
)

public class ActivitiesRunner  {
    //Nothing is written here
}


