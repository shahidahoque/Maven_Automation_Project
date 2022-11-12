package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SwitchTabs {
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

        driver.navigate().to("https://www.fideliscare.org/");
        //sleep statement
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Medicaid Managed Care']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='btn btn-outline-primary btn-external btn-show link-external']")).click();
        Thread.sleep(2000);

        ArrayList<String> tabs =  new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.findElement(By.xpath("//*[@id= 'searchLocation']")).sendKeys("11230");
        Thread.sleep(2000);

        driver.switchTo().window(tabs.get(0));
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class= 'btn ng-binding btn-primary']")).click();
        Thread.sleep(2000);
    }
}
