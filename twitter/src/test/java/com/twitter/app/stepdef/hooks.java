package com.twitter.app.stepdef;

import com.twitter.app.utilities.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;


public class hooks {

    @Before()
    public static void setupBrowser() throws Exception {
        // System.setProperty("url", "twitter_prod");
        // System.setProperty("browserName", "chrome");
        String url = "https://twitter.com/";
        if (System.getProperty("url").contains("twitter_prod")) {
            url = "https://twitter.com/";
        }
        DriverUtils.setDriver(System.getProperty("browserName"));
        DriverUtils.navigateToURL(url);
    }

    @After()
    public static void tear(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            DriverUtils.takeScreenShot(scenario.getName().replaceAll(" ", "_"));
        }
        DriverUtils.tearDown();
    }

}
