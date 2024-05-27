package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test (groups ={"HeaderTests","ButtonTests"})
    public void TitleTest(){
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }

    @Test (groups ={"HeaderTests"},dependsOnMethods = {"TitleTest"})
    public void HeaderTest1(){
        WebElement h3 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(h3.getText(),"Third header");
    }

    @Test (groups ={"HeaderTests"},dependsOnMethods = {"TitleTest"})
    public void HeaderTest2(){
        WebElement h5 = driver.findElement(By.cssSelector("h5.green"));
       Assert.assertEquals(h5.getCssValue("color"), "rgb(33, 186, 69)");
    }

    @Test (groups ={"ButtonTests"},dependsOnMethods = {"TitleTest"})
    public void ButtonTest1(){
        WebElement oliveButton = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(oliveButton.getText(), "Olive");
    }

    @Test (groups ={"ButtonTests"},dependsOnMethods = {"TitleTest"})
    public void ButtonTest2(){
        WebElement oliveButton = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(oliveButton.getCssValue("color"), "brown");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
