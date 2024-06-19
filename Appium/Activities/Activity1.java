package activities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    // Set up method
    //Driver Initialization
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

       driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiply")).click();
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_8")).click();
        driver.findElement(AppiumBy.accessibilityId("Equals")).click();

        //Assertions
        String result = driver.findElement((AppiumBy.id("com.coloros.calculator:id/result")))
                .getText();
        Assert.assertEquals(result,"40");

    }
    @AfterClass
public  void tearDown(){
        driver.quit();
    }
}