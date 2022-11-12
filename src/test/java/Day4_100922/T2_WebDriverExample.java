package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebDriverExample {
    public static void main(String[] args) throws InterruptedException {

        //define the web driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //define the chrome driver to use for your test
        //creating an instance for a chrome  driver to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to any site
        driver. navigate().to("https://www.google.com/");

        //quit the chrome session
        Thread.sleep(3000);

        driver.quit();

    } //end of main
}//end of class

