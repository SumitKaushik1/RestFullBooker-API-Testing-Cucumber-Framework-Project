package org.restfullbooker.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/restfullbooker"},
        glue={"org.restfullbooker.task_1_positive_createtoken"},
        monochrome=true,
        dryRun=false,
        plugin={
                "json:build/cucumber-reports/cucumber.json",
                "rerun:build/cucumber-reports/rerun.txt"
        }

)
public class TestRunner {

}
