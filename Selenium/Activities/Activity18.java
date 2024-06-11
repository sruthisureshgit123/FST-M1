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

public class Activity18 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of the page is"+driver.getTitle());

        WebElement multiSelect = driver.findElement(By.id("multi-select"));
        Select select =new Select(multiSelect);

        select.selectByVisibleText("Javascript");

        //select 4,5,6 index values
        for (int i=4;i<6;i++){
            select.selectByIndex(i);
        }

        //select by value]
        select.selectByValue("node");

        //print selected options
        System.out.println("Selected options are: ");
        List<WebElement> options=select.getAllSelectedOptions();
        for (WebElement element : options)
        {
            System.out.println(element);
        }

        select.deselectByIndex(5);

        //print selected options
        System.out.println("Selected options are: ");
        List<WebElement> optionsSelected=select.getAllSelectedOptions();
        for (WebElement element : optionsSelected)
        {
            System.out.println(element);
        }

    }
}
