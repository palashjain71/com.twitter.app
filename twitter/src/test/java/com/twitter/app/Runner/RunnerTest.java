package com.twitter.app.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        monochrome = true, glue = {"src/test/java/com/twitter/app/stepdef"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber-report.json"},
        tags = "@Smoke" )


public class RunnerTest {


}
