package org.restfullbooker.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        //you can provdie comma ,if you want any two feature file to run
        features={"src/test/resource/featurefiles/RestFullBookerPostive3testCases.feature"},
        glue={"org.restfullbooker.task.task_4_positive"},


        plugin = {
                "json:target/CucumberReports/CucumberReport3.json",
                "junit:target/CucumberReports/CucumberReport3.xml",
                "html:target/CucumberReport3.html","pretty"
        })


@Test

public class Runner3 extends AbstractTestNGCucumberTests{
}
