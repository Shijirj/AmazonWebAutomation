package com.shijir.step_definition;

import com.shijir.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setupScenario(){
        System.out.println("Setting up the test");
    }


    @After
    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // Capture the screenshot
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Driver.closeDriver();
    }

}
