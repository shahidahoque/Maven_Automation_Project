package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearchExample {
    public static void main(String[] args) throws InterruptedException {

        //define the web driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //define the chrome driver to use for your test
        //creating an instance for a chrome  driver to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to any site
        driver. navigate().to("https://www.google.com/");

        //maximize my window
        //windows: driver.manage().window().maximize();
        //mac:
        driver.manage().window().fullscreen();

        //quit the chrome session
        Thread.sleep(3000);

        //search keyword on the search field
        //relative xpath  to locate the element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");

        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //capture the search result text
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //split message to extract out the search number
        String[] splitResult = result.split(" ");
        System.out.println("the search number is " + splitResult[1]);


        //closes the opened web server
        driver.quit();

    } //end of main
} //end of class
