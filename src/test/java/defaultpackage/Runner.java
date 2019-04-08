package defaultpackage;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = ".",
        monochrome = true,
        snippets = SnippetType.CAMELCASE
)
public class Runner {

}
