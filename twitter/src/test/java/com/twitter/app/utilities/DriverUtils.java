package com.twitter.app.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.mockito.exceptions.Reporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class DriverUtils {

    public static WebDriver driver;

    public static WebDriver setDriver(String browserName) throws Exception {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            //ChromeOptions options = new ChromeOptions();
            //options.setAcceptInsecureCerts(true);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            throw new Exception("We support only chrome browser");
        }

        return driver;
    }

    public static void navigateToURL(String url) {
        driver.get(url);
    }

    public static void takeScreenShot(String screenshotName) throws IOException {
        File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
                + screenshotName + ".png");
        FileUtils.copyFile(sourcePath, destinationPath);
    }


    public static void tearDown() {
        driver.quit();
        driver = null;
    }

}
