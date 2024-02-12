package org.restfullbooker.Report;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberReport {

    @Test
    public void cucumberReport(){
        System.out.println("teardown run ");
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/CucumberReports/CucumberReport.json");
        jsonFiles.add("target/CucumberReports/CucumberReport1.json");
        jsonFiles.add("target/CucumberReports/CucumberReport2.json");
        jsonFiles.add("target/CucumberReports/CucumberReport3.json");
       // jsonFiles.add("target/CucumberReports/CucumberReport4.json");

        String buildNumber = "1";
        String projectName = "cucumberProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration settings
        configuration.setBuildNumber(buildNumber);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

}
