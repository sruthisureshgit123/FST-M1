package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void test1() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Target Practice", title);

    }

    @Test
    public void test2() {
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));

        //Assertion for black button
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test (enabled = false)
    public void test3() {
        String subHeading = driver.findElement(By.className("sub header")).getText();
        //Assertion for sub heading
        Assert.assertTrue(subHeading.contains("Practice"));

    }
    @Test
    public void test4() {
        throw new SkipException("Skipping test case");
    }


        @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
