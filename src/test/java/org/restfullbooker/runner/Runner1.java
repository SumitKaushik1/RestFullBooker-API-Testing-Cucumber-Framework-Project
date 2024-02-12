package org.restfullbooker.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        //you can provdie comma ,if you want any two feature file to run
        features={"src/test/resource/featurefiles/RestfullBookerPositivetestCase_02.feature"},
        glue={"org.restfullbooker.task.task_2_positive"},


        plugin = {
                "json:target/CucumberReports/CucumberReport1.json",
                "junit:target/CucumberReports/CucumberReport1.xml",
                "html:target/CucumberReport1.html","pretty"
        })


@Test
public class Runner1 extends AbstractTestNGCucumberTests {
}
