package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_mlcalc_scroll {
    public static void main(String[] args) throws InterruptedException{
        //set up chrome driver with web driver manager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("start-fullscreen");

        //define web driver and add options to the method
        WebDriver driver = new ChromeDriver(options);

        //go to google homepage
        driver.navigate().to("https://www.mlcalc.com");

        //wait a few seconds
        Thread.sleep(3000);

        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll down to 800 pixels
        jse.executeScript("scroll(0,2000)");
        //wait 2 secs
        Thread.sleep(2000);
        //scroll up to 400 pixels

        jse.executeScript("scroll(0,-1)");
        //wait 2 secs
        Thread.sleep(2000);

        //store calculate button into web element variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll into view of calculate button

        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //wait 2 secs
        Thread.sleep(2000);
        //quit chrome

        driver.quit();
    }
}
