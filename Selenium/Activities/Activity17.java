package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of the page is"+driver.getTitle());

        WebElement singleSelect = driver.findElement(By.id("single-select"));
        Select select =new Select(singleSelect);

        //Select option2 by visible text
        select.selectByVisibleText("Option 2");
        System.out.println("selected option is"+select.getFirstSelectedOption().getText());

        //Select option 3 by index
        select.selectByIndex(3);
        System.out.println("selected option is"+select.getFirstSelectedOption().getText());

        //Select option 4 by value
        select.selectByValue("4");
        System.out.println("selected option is"+select.getFirstSelectedOption().getText());

        //Print all options
        List<WebElement> options=select.getOptions();
        System.out.println("Options are ");
        for (WebElement option : options ){
            System.out.println(option.getText());

        }

        driver.quit();


    }
}
