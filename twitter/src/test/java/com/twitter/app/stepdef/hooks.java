package com.twitter.app.stepdef;

import com.twitter.app.utilities.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;


public class hooks {

    @Before()
    public static void setupBrowser() throws Exception {
       // System.setProperty("url", "https://twitter.com/");
       // System.setProperty("browserName", "chrome");
        DriverUtils.setDriver(System.getProperty("browserName"));
        DriverUtils.navigateToURL(System.getProperty("url"));
    }

    @After()
    public static void tear(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            DriverUtils.takeScreenShot(scenario.getName().replaceAll(" ", "_"));
        }
        DriverUtils.tearDown();
    }

}
