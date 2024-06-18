package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given ("the user is on login page")
    public void openPage(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/login-form");
        Assertions.assertEquals("Login Form",driver.getTitle());
    }

    @When("the user enters username and password")
    public void enterCreds(){
        //Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");

    }

    @When("the user enters {string} and {string}")
    public void enterCredsFromFeature(String username, String password){
        //Enter username
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password
        driver.findElement(By.id("password")).sendKeys(password);

    }

    @And("clicks the login button")
    public void clickLogin(){
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("get the confirmation text and verify")
    public void getConfirmationMessage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
        driver.quit();
    }
    }


