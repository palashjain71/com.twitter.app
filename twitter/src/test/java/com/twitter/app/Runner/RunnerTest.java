package com.twitter.app.Runner;

import com.twitter.app.utilities.DriverUtils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        monochrome = true, glue = {"src/test/java/com/twitter/app/stepdef"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber-report.json"},
        tags = "@Smoke")

public class RunnerTest {

    @BeforeClass()
    public static void setupBrowser() throws Exception {
        System.setProperty("url","https://twitter.com/");
        System.setProperty("browserName","chrome");
        DriverUtils.setDriver(System.getProperty("browserName"));
        DriverUtils.navigateToURL(System.getProperty("url"));
    }

    @AfterClass()
    public static void tear()  {
        DriverUtils.tearDown();
    }

}
