package org.restfullbooker.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
@CucumberOptions(
        //you can provdie comma ,if you want any two feature file to run
        features={"src/test/resource/featurefiles/RestFullBookerPostivetestCases_05.feature"},
        glue={"org.restfullbooker.task.task_5_negative"},


        plugin = {
                "json:target/CucumberReports/CucumberReport4.json",
                "junit:target/CucumberReports/CucumberReport4.xml",
                "html:target/CucumberReport4.html","pretty"
        })




@Test
public class Runner4  extends AbstractTestNGCucumberTests {
}
