package org.restfullbooker.allfiles;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/org/restfullbooker/allfiles/restfullbookerCreateToken.feature",
        glue="src/test/java/org/restfullbooker/allfiles/RestFullBookerCreateToken.java"
)
public class runner {

}
