package org.restfullbooker.task_1_positive;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//feature to tell feature file where it is
//glue to attach feature file to it
//preety to show colourfull output on console
//html:target/CucumberReport.html to give the cucumber report

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/org/restfullbooker/task_1_positive"},
        glue={"org.restfullbooker.task_1_positive"},

        plugin = {

                "html:target/CucumberReport.html","pretty"
        })



public class runner {

}
