package activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity21 {

        public static void main(String[] args) {
            // Set up Firefox driver
            WebDriverManager.firefoxdriver().setup();
            // Create a new instance of the Firefox driver
            WebDriver driver = new FirefoxDriver();
            //Create wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Open the page
            driver.get("https://v1.training-support.net/selenium/tab-opener");
            // Print the title of the page
            System.out.println("Home page title: " + driver.getTitle());
            //get the current window
            System.out.println("current window is "+ driver.getWindowHandle());

            // Find and click the button to open the new tab
            driver.findElement(By.xpath("//a[@id='launcher']")).click();

            //WAIT FOR THE NEW TAB TO OPEN
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> windows=driver.getWindowHandles();
            System.out.println("Opened tabs are ");
            for(String windw: windows){
                System.out.println(windw);
                driver.switchTo().window(windw);
            }
            //get the current window
            System.out.println("current window is "+ driver.getWindowHandle());

            // Wait for the new page to load
            wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
            // Print the handle of the current tab
            System.out.println("Current tab: " + driver.getWindowHandle());
            // Print the title and heading of the new page
            System.out.println("Page title: " + driver.getTitle());
            String pageHeading = driver.findElement(By.className("content")).getText();
            System.out.println("Page Heading: " + pageHeading);
            // Find and click the button on page to open another tab
            driver.findElement(By.id("actionButton")).click();

            // Wait for new tab to open
            wait.until(ExpectedConditions.numberOfWindowsToBe(3));
            // Switch focus
            for(String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Wait for the new page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
            // Print the handle of the current tab
            System.out.println("Current tab: " + driver.getWindowHandle());
            // Print the title and heading of the new page
            System.out.println("Page title: " + driver.getTitle());
            pageHeading = driver.findElement(By.className("content")).getText();
            System.out.println("Page Heading: " + pageHeading);
            // Close the browser
            driver.quit();
        }
    }

