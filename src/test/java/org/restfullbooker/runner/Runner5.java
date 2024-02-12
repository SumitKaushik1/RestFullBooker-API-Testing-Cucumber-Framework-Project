package org.restfullbooker.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
@CucumberOptions(
        //you can provdie comma ,if you want any two feature file to run
        features={"src/test/resource/featurefiles/RestFullBookerPostivetestCases_06.feature"},
        glue={"org.restfullbooker.task.task_6_negative"},


        plugin = {
                "json:target/CucumberReports/CucumberReport5.json",
                "junit:target/CucumberReports/CucumberReport5.xml",
                "html:target/CucumberReport5.html","pretty"
        })




@Test

public class Runner5 extends AbstractTestNGCucumberTests{
}
