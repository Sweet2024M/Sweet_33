package Acceptance;




import org.junit.runner. RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith (Cucumber.class)

@CucumberOptions(
 
features = "Features/mgt.feature",

plugin = {"summary", "html:target/cucumber/report.html"},

monochrome=true,

snippets = SnippetType.CAMELCASE,

glue = "acceptance")









public class AcceptanceTest {

}
