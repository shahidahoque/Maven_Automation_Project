package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class T2_ImplicitWait_USPS {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        // options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //declare implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //navigates to usps website
        driver.navigate().to("https://www.usps.com/");

        //hover to send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        //declare mouse actions
        Actions mouseActions = new Actions(driver);
        //always end with perform
        mouseActions.moveToElement(sendTab).perform();

        //click on calculate price using mouse click
        WebElement calculatePrice = driver.findElement(By.xpath("//li[@class='tool-calc']"));
        mouseActions.moveToElement(calculatePrice).click().perform();

        //double click on usps home logo
        WebElement uspsHome = driver.findElement(By.xpath("//*[@alt='USPS.com home']"));
        //right-clicking on usps home logo
        mouseActions.moveToElement(uspsHome).contextClick().perform();
        //double-clicking on usps home logo
        mouseActions.moveToElement(uspsHome).doubleClick().perform();
    }
}
