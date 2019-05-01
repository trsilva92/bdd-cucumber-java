package br.com.udemy.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        features = "src/test/resources/features",
        glue = "br.com.udemy.steps",
        tags = {"@PontuacaoPorCategoria"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE
)
public class Runner {

}
