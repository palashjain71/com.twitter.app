package com.twitter.app.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

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

    public static void navigateToURL(String url)  {
        driver.get(url);
    }


    public static void tearDown()  {
        driver.quit();
        driver = null;
    }

}
