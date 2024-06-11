package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the page is"+driver.getTitle());

        WebElement username = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text ()='Confirm Password']/following-sibling::input"));
        WebElement email = driver.findElement(By.xpath("//label[contains(text(),'mail')]/following-sibling::input"));
        WebElement signUp = driver.findElement(By.xpath("//button[text()='Sign Up']"));

        username.sendKeys("User1");
        password.sendKeys("password");
        confirmPassword.sendKeys("password");
        email.sendKeys("abc@xyz.com");
        signUp.click();

        //print registration message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Confirmation message is "+ message);

        driver.quit();


    }
}
