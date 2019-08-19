package br.com.udemy;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/report-html", "json:target/report.json"},
        features = "src/main/resources/features",
        glue = "br.com.udemy.steps",
        tags = {""},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class RunTest {
}
