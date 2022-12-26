package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src\\main\\resources\\Features",
        glue ="stepDefinitions",
        plugin = {"pretty",
                "html:target\\resourses\\report.html",
                "json:target\\cucumber.json",
                "junit:target\\cukes.xml",
                "rerun:target\\rerun.txt"},
        tags = "@Smoke"
)

public class TestRunner extends AbstractTestNGCucumberTests {


}
