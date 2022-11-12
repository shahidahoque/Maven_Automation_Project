package Day8_102322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class InClass_ActionItem {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        // add the options for maximizing the chrome meeting
        // options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen", "incognito");
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //Arraylist for storing destinations
        ArrayList <String> destinations = new ArrayList<>();
        destinations.add("New York");
        destinations.add("California");
        destinations.add("Florida");

        //Arraylist for storing number of adult passengers
        ArrayList <Integer> adultTraveler = new ArrayList<>();
        adultTraveler.add(2);
        adultTraveler.add(3);
        adultTraveler.add(4);

        //Arraylist for storing children ages from drop down
        ArrayList <String> childAge = new ArrayList<>();
        childAge.add("Under 1");
        childAge.add("1");
        childAge.add("2");


        for (int i=0; i<destinations.size(); i++) {
            //test step 1
            //goes to hotels.com website
            driver.navigate().to("https://www.hotels.com/");
            Thread.sleep(1000);

            //test step 2
            //clicks on destination search field
            driver.findElement(By.xpath("//*[@aria-label='Going to']")).click();
            Thread.sleep(1000);
            //stores search field as web element
            WebElement search = driver.findElement(By.xpath("//*[@data-stid='destination_form_field-menu-input']"));
            //inputs destinations from arraylist into search feild
            search.sendKeys(destinations.get(i));
            Thread.sleep(1000);
            //clicks on the first search result
            driver.findElements(By.xpath("//*[@class='truncate']")).get(0).click();

            //test step 3
            //waits one second
            Thread.sleep(1000);

            //test step 4
            //clicks on travels search field
            driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            Thread.sleep(2000);
            //sets the number of adult passengers to one
            driver.findElement(By.xpath("//*[@aria-label='Decrease the number of adults in room 1']")).click();
            Thread.sleep(2000);

            //test step 5
            //uses loop to increase the number of adult travelers based on arraylist values
            for (int j = 1; j < adultTraveler.get(i); j++) {
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']")).click();
                Thread.sleep(1000);
            }

            //test step 6
            //add one child to number of travelers
            driver.findElement(By.xpath("//*[@aria-label= 'Increase the number of children in room 1']")).click();
            Thread.sleep(1000);

            //test step 7
            //stores age dropdown tab as web element
            WebElement age = driver.findElement(By.xpath("//*[@id= 'age-traveler_selector_children_age_selector-0-0']"));
            //uses select command for choosing values on drop down tab
            Select ageDropDown = new Select(age);
            //using for loop to get a different child ages for each location based on arraylist values
            for (int k = 0; k < childAge.size(); k++){
                //selects child age based on text from arraylist values
                ageDropDown.selectByVisibleText(childAge.get(i));
                Thread.sleep(1000);
            }
            //clicks done to save all changes made to traveler info
            driver.findElement(By.xpath("//*[@id= 'traveler_selector_done_button']")).click();
            Thread.sleep(1000);

            //Step 8
            //clicks on search button
            driver.findElement(By.xpath("//*[@id= 'submit_button']")).click();

            //Step 9
            //waits a few seconds
            Thread.sleep(2000);

            //Step 10
            //stores all links for all hotels into web element
            ArrayList<WebElement>links = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));
            if (i==0){
                //for the first destination click first link
                links.get(0).click();
                Thread.sleep(2000);
            }
            if (i==1){
                //for the second destination click third link
                links.get(2).click();
                Thread.sleep(2000);
            }
            if (i==2){
                //for the third destination click on second link
                links.get(1).click();
                Thread.sleep(2000);
            }

            //Step 11
            //captures all tabs in arraylist
            ArrayList<String> tabs =  new ArrayList<>(driver.getWindowHandles());
            //switches to newly opened tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            //Step 12
            //captures hotel name as a variable
            String hotel = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
            //prints out hotel name
            System.out.println(destinations.get(i) + " Hotel Name: " + hotel);
            Thread.sleep(2000);

            //Step 13
            try{
                //tries to click on reserve a room button
                driver.findElement(By.xpath("//*[@data-stid='sticky-button']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                //prints out error message if not able to
                System.out.println("Rooms not available at this time.");
                Thread.sleep(2000);
            }

            //Step 14
            try {
                //tries to capture price per night of a hotel room
                String price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                //prints out price per night
                System.out.println("Price Per Night: " + price);
                Thread.sleep(2000);
            } catch (Exception e) {
                //prints out error message if not able to
                System.out.println("Price not available at this time.");
                Thread.sleep(2000);
            }

            //Step 15
            try {
                //tries to click on reserve button
                driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")).get(0).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                //prints out error message if not able to
                System.out.println("Reserve function not available at this time.");
                Thread.sleep(2000);
            }

            //Step 16
            try {
                //define javascript executor
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //scroll down to 200 pixels
                jse.executeScript("scroll(0,200)");
                //tries to capture check in and check out dates in a variable
                String dates = driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText();
                //prints out check in and check out dates
                System.out.println(dates);
                Thread.sleep(2000);
            } catch (Exception e) {
                //prints out error message if not able to
                System.out.println("Dates not available at this time.");
                Thread.sleep(2000);
            }

            //Step 17
            //closes second tab
            driver.close();

            //Step 18
            //switches to first tab
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(1000);
        }
        //Step 19
        //closes automated Chrome window
        driver.quit();
    }
}
