package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {
    public static void main(String[] args) throws InterruptedException {

        //set up chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        //define the web driver
        WebDriver driver = new ChromeDriver();

        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com/");
        //maximize driver
        driver.manage().window().maximize();

        //click sign in button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //go back to yahoo home page
        driver.navigate().to("https://www.yahoo.com/");
        //wait 2 seconds
        Thread.sleep(1000);

        //click bell icon
        driver.findElement(By.xpath("//*[contains(@class, 'rapid-nonanchor')]")).click();
        //wait 2 seconds
        Thread.sleep(2000);

        driver.quit();
    }
}
