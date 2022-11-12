package Action_Item;

import ReusableLibrary.ReusableActions_Logger;
import ReusableLibrary.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MedicareManaged_LongTermCarePlans extends Reusable_Annotations {
    @Test(priority = 1)
    public void Use_Case1() throws InterruptedException {
        //goes to health first home page
        driver.navigate().to("https://healthfirst.org/");
        //clicks on plans tab
        ReusableActions_Logger.mouseHover(driver,"//*[@href='javascript:void(0)']", logger, "Plans Tab");
        //clicks on medicare and managed long-term care plans within plans tab
        ReusableActions_Logger.clickAction(driver,"//*[@href='https://healthfirst.org/medicare-long-term-care-plans']", logger, "Medicare & Managed Long Term Care Plans");
        Thread.sleep(2000);

        //captures page title and summary
        String title = ReusableActions_Logger.getTextAction(driver, "//*[@class='up-hero-inner']/h1", logger, "Title");
        String summary = ReusableActions_Logger.getTextAction(driver, "//*[@class='pure-box-description-desktop']", logger, "Summary");
        //prints out title and summary
        System.out.println("Title & Summary: "); System.out.println(title); System.out.println(summary);

        //scrolls to the different sections of the page
        ReusableActions_Logger.scrollByView(driver, "//*[@id='medicare-advantage-plans']", logger, "Section 1");
        Thread.sleep(3000);
        ReusableActions_Logger.scrollByView(driver, "//*[@id='long-term-care-plans']", logger, "Section 2");
        Thread.sleep(3000);
        ReusableActions_Logger.scrollByView(driver, "//*[@id='faq']", logger, "Section 3");
        Thread.sleep(3000);
        ReusableActions_Logger.scrollByView(driver, "//*[@class='tile-main-title']", logger, "Section 4");
        Thread.sleep(3000);
        ReusableActions_Logger.scrollByView(driver, "//*[@class='tile tile-land']/h3", logger, "Section 5");
        Thread.sleep(3000);

        //capture titles of each section
        String section1 = ReusableActions_Logger.getTextAction(driver, "//*[@id='medicare-advantage-plans']", logger, "Medicare Advantage");
        String section2 = ReusableActions_Logger.getTextAction(driver, "//*[@id='long-term-care-plans']", logger, "Long-Term Care");
        String section3 = ReusableActions_Logger.getTextAction(driver, "//*[@id='faq']", logger, "Questions");
        String section4 = ReusableActions_Logger.getTextAction(driver, "//*[@class='tile-main-title']", logger, "Support");
        String section5 = ReusableActions_Logger.getTextAction(driver, "//*[@class='tile tile-land']/h3", logger, "Additional");

        //prints out the titles of each section
        System.out.println(" "); System.out.println("Section Titles: ");
        System.out.println("1. " + section1); System.out.println("2. " + section2);
        String[] splitSection3 = section3.split(" "); System.out.println("3. " + splitSection3[0]);
        System.out.println("4. " + section4); System.out.println("5. " + section5);
    }

    @Test(dependsOnMethods = "Use_Case1")
    public void Use_Case2() throws InterruptedException {
        //scrolls to glossary
        ReusableActions_Logger.scrollByView(driver, "//*[@class='row plans-top-links-row flex-align-center']", logger, "Glossary");
        Thread.sleep(3000);

        //clicks on show glossary to open glossary contents
        ReusableActions_Logger.clickAction(driver, "//*[text()='Show Glossary']", logger, "glossary opens");
        Thread.sleep(3000);
        //checks and prints that glossary content is shown
        boolean glossaryOpen = driver.findElement(By.xpath("//*[@class='plans-list-glossary']")).isDisplayed();
        System.out.println(" "); System.out.println("Glossary contents are visible: " + glossaryOpen);
        logger.log(LogStatus.INFO, "Glossary contents are visible: " + glossaryOpen);

        //clicks cross button to close glossary
        ReusableActions_Logger.clickAction(driver, "//*[@class='plans-list-glossary-close js-close-glossary-btn']", logger, "glossary closes");
        Thread.sleep(3000);
        //checks and prints that glossary content is not shown
        boolean glossaryClose = driver.findElement(By.xpath("//*[@class='plans-list-glossary']")).isDisplayed();
        System.out.println("Glossary contents are not visible: " + glossaryClose);
        logger.log(LogStatus.INFO, "Glossary contents are not visible: " + glossaryClose);
    }

    @Test(dependsOnMethods = "Use_Case2")
    public void Use_Case3() throws InterruptedException {
        //scrolls to medicare advantage plans
        ReusableActions_Logger.scrollByView(driver, "//*[@id='medicare-advantage-plans']", logger, "Section 1");
        Thread.sleep(2000);

        //Captures all the plans that are being offered within the medicare advantage and long term care plans sections
        ArrayList <WebElement> numberOfPlans = new ArrayList<>(driver.findElements(By.xpath("//*[@class='col-md-6 plans-list-col']")));
        //skips line
        System.out.println(" ");
        //prints the number of available listed plans
        System.out.println("What is the total number of medicare and managed long-term care plans offered at HealthFirst?");
        System.out.println(numberOfPlans.size());

        //uses for loop to iterate through number of plans individually
        for(int i=0; i< numberOfPlans.size(); i++){
            //captures names of available medicare advantage and long term care plans
            String planName = ReusableActions_Logger.getTextActionByIndex(driver, "//*[@class='col-lg-12 col-md-12 mb-1']", i, logger, "Plan Title");
            System.out.println("Names of Available Plan: " + i);
            System.out.println(planName);

            //checks if there is a plan details tab for each plan
            boolean planDetails = driver.findElements(By.xpath("//*[text()='Plan Details']")).get(i).isDisplayed();
            System.out.println("There is a plan details tab: " + planDetails);
            logger.log(LogStatus.INFO, "There is a plan details tab: " + planDetails);
        }
    }
}




