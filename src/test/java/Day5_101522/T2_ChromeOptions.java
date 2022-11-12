package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[] args) {
        //set up chrome driver with web driver manager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        options.addArguments("start-fullscreen", "incognito");

        //define web driver and add options to the method
        WebDriver driver = new ChromeDriver(options);

        //go to google homepage
        driver.navigate().to("https://www.google.com");

        //locate element for search field and write cars
        //this is an example of relative xpath
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");

        //hit submit on the Google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //capture the search result and print it
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

        //extract out the number and print the search number only
        String[] arrayResult = result.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //close the driver window
        driver.quit();

    }
}
