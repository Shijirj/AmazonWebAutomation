package com.shijir.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        features = "src/test/java/resource/features",
        glue = "com/shijir/step_definition",
        dryRun = false,
        tags = "@smoke and @regression"
)
public class CukesRunner {
}
