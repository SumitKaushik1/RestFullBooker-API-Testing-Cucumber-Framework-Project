package org.restfullbooker.task_1_positive;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//feature to tell feature file where it is
//glue to attach feature file to it
@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/org/restfullbooker/task_1_positive/RestFullBookerCreateToken_1.feature",
        glue="src/test/java/org/restfullbooker/task_1_positive/RestFullBookerCreateToken_1.java",
        plugin={"pretty","html:target/CucumberReport.html"}
)

public class runner {

}
