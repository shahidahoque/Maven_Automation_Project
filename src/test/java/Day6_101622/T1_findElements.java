package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_findElements {
    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver with web driver manager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("start-fullscreen");

        //define web driver and add options to the method
        WebDriver driver = new ChromeDriver(options);

        //go to google homepage
        driver.navigate().to("https://www.yahoo.com");

        //wait a few seconds
        Thread.sleep(3000);

        //find elements I want to click on the second link within the group known as news
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();
    }
}
