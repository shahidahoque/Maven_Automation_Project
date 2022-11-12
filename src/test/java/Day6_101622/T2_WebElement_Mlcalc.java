package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_Mlcalc {
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
        driver.navigate().to("https://www.mlcalc.com");

        //wait a few seconds
        Thread.sleep(3000);

        //clear  and enter new value on purchase price feild
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the purchase price
        pPrice.clear();
        //type new value on the purchase price
        pPrice.sendKeys("450000");

        //clear and  enter new value on down payment feild
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        //clear the down payment
        dPayment.clear();
        //type a new value on the down payment
        dPayment.sendKeys("25");
    }
}
