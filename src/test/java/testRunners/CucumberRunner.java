package testRunners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/", glue = "steps",
        plugin = {"json:target/cucumber.json"}, tags = {"@All"}, strict = true)
public class CucumberRunner {
}