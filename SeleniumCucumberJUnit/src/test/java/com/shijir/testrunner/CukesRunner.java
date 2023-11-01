package com.shijir.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resource/features",
        glue = "com/shijir/step_definition",
        plugin = {"html:target/cucumber-html-report"},
        dryRun = false,
        tags = ""
)
public class CukesRunner {
}
