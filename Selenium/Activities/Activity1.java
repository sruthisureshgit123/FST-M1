package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main (String[] args){
        //Get firefox driver
        WebDriverManager.firefoxdriver().setup();
        // create driver object
        WebDriver driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net");
        // find title of the page
        String title= driver.getTitle();
        System.out.println("Title of the page is "+ title);
        // Find About Us link using id and click it
        driver.findElement(By.id("about-link")).click();
        // Print the title of the new page
        System.out.println("About page title: " + driver.getTitle());

        // Close the browser
        driver.close();

    }
}
