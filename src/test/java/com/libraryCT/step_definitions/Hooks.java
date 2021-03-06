package com.libraryCT.step_definitions;

import com.libraryCT.utilities.BrowserUtils;
import com.libraryCT.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After()
    public void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()){
            byte [] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "immage/png", scenario.getName());
        }

        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }
}
