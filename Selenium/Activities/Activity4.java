package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Open the page
        driver.get("https://v1.training-support.net/selenium/target-practice");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        //find 3rd header and print its text
        String text1=driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("3rd Header text is"+text1);
        //print 5th header color
        String color =driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println("5th header color is"+color);
        // Find the violet button and print its classes
        String violetButtonClass = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println(violetButtonClass);
        // Find the grey button and print its text
        String greyButtonText = driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println(greyButtonText);


    }
}
