package org.restfullbooker.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        //you can provdie comma ,if you want any two feature file to run
        features={"src/test/resource/featurefiles/RestfullBookerPositive2testCase.feature"},
        glue={"org.restfullbooker.task.task_3_positive"},


        plugin = {
                "json:target/CucumberReports/CucumberReport2.json",
                "junit:target/CucumberReports/CucumberReport2.xml",
                "html:target/CucumberReport2.html","pretty"
        })


@Test
public class Runner2 extends AbstractTestNGCucumberTests {
}
