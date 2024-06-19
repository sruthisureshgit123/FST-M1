package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static activities.ActionBase.doSwipe;

public class Activity4 {
    // Set up method
    //Driver Initialization
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //open selenium page
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();
        //wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text = 'Get Started!']")));

        //scroll to the end of the page
        Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.8));
        Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.6));

        doSwipe(driver, start, end, 200);
        doSwipe(driver, start, end, 200);
        doSwipe(driver, start, end, 200);
        doSwipe(driver, start, end, 200);

        //wait for the element To-Do List
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        //Find Elements
        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));

        addTaskInput.sendKeys("Add tasks to list");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Get number of tasks");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("clear the list");
        addTaskButton.click();
        Thread.sleep(1000);

        //clear the list
        driver.findElement(AppiumBy.xpath("android.widget.TextView[contains(@text, 'Clear List')]")).click();

        //assertion
        List<WebElement> tasksAdded = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android"));
        Assert.assertEquals(tasksAdded.size(), 0);
    }
    @AfterClass
    public void tearDown(){
            driver.quit();
    }


}
