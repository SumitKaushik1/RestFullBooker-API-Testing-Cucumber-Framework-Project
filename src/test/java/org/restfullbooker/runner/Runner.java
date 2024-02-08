package org.restfullbooker.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//feature to tell feature file where it is
//glue to attach feature file to it
//preety to show colourfull output on console
//html:target/CucumberReport.html to give the cucumber report

@RunWith(Cucumber.class)
@CucumberOptions(
        //you can provdie comma ,if you want any two feature file to run
        features={"src/test/resource/featurefiles"},
        glue={"org.restfullbooker.task"},


        plugin = {
                 "json:target/CucumberReports/CucumberReport.json",
                "junit:target/CucumberReports/CucumberReport.xml",
                "html:target/CucumberReport.html","pretty"
        })



public class Runner {

}
