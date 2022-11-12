package Action_Item;

import ReusableLibrary.ReusableActions_Logger;
import ReusableLibrary.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HealthFirst_ContactInformation extends Reusable_Annotations {
    @Test(priority = 1)
    public void Use_Case1() throws InterruptedException {
        //goes to health first home page
        driver.navigate().to("https://healthfirst.org/");
        //clicks on plans tab
        ReusableActions_Logger.mouseHover(driver,"//*[@href='javascript:void(0)']", logger, "Plans Tab");
        //clicks on medicare and managed long-term care plans within plans tab
        ReusableActions_Logger.clickAction(driver,"//*[@href='https://healthfirst.org/medicare-long-term-care-plans']", logger, "Medicare & Managed Long Term Care Plans");
        Thread.sleep(2000);
        //goes to Support When You Need It section
        ReusableActions_Logger.scrollByView(driver, "//*[@class='tile-main-title']", logger, "Section 4");
        Thread.sleep(2000);

        //Captures and Prints out contact information for Enrollment Services
        String enrollment = ReusableActions_Logger.getTextActionByIndex(driver, "//*[@class='col-md-6']", 0, logger, "Enrollment Services");
        System.out.println(enrollment);
        //clicks on each enrollment phone numbers to make call
        ReusableActions_Logger.clickAction(driver, "//*[@id='fsr2017_nhfc_fpn_2']", logger, "General Enrollment Number");
        Thread.sleep(3000);
        ReusableActions_Logger.clickAction(driver, "//*[@id='fsr2017_nhfc_ttd_tty_en_1']", logger, "English Enrollment Number");
        Thread.sleep(3000);
        ReusableActions_Logger.clickAction(driver, "//*[@id='fsr2017_nhfc_ttd_tty_es_1']", logger, "Spanish Enrollment Number");
        Thread.sleep(3000);

        //skips line
        System.out.println(" ");

        //captures and prints out contact information for member services
        String memberServices = ReusableActions_Logger.getTextActionByIndex(driver, "//*[@class='col-md-6']", 1, logger, "Member Services");
        System.out.println(memberServices);
        //clicks on each member services phone numbers to make call
        ReusableActions_Logger.clickAction(driver, "//*[@href='tel: 18882601010']", logger, "Medicare Service Number");
        Thread.sleep(3000);
        ReusableActions_Logger.clickAction(driver, "//*[@id='fsr2017_nhfc_ttd_tty_en_2']", logger, "English Member Service Number");
        Thread.sleep(3000);
        ReusableActions_Logger.clickAction(driver, "//*[@id='fsr2017_nhfc_ttd_tty_es_2']", logger, "Spanish Member Service Number");
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "Use_Case1")
    public void Use_Case2() throws InterruptedException {
        //goes to the sections titled other ways to reach us
        ReusableActions_Logger.scrollByView(driver, "//*[@class='tile tile-land']/h3", logger, "Section 5");
        Thread.sleep(2000);

        //captures and prints out Service Name
        String call = ReusableActions_Logger.getTextAction(driver, "//*[@class='form-pop']", logger, "callback");
        //skips line
        System.out.println(" ");
        System.out.println(call);
        //clicks on request call back
        ReusableActions_Logger.clickAction(driver, "//*[@data-plan-select='medicare-long-term']", logger, "Request Call Back");
        Thread.sleep(2000);
        //checks and prints if call back form is visible
        boolean callBackForm = driver.findElement(By.xpath("//*[@id='contact-form']")).isDisplayed();
        System.out.println("Call Back Form Is Found: " + callBackForm);
        logger.log(LogStatus.INFO, "Call Back Form Is Found: " + callBackForm);
        //closes call back form
        ReusableActions_Logger.clickAction(driver, "//*[@alt='Close Popup']", logger, "close");
        Thread.sleep(2000);

        //clicks on virtual community office link
        ReusableActions_Logger.clickAction(driver, "//*[@class='external-link-no-pop']", logger, "Request Call Back");
        Thread.sleep(2000);
        //switches to new tab to view virtual community services
        ReusableActions_Logger.switchToTabByIndex(driver, 1);
        Thread.sleep(2000);
        //skips line
        System.out.println(" ");
        //checks and prints if virtual community office is visible
        boolean virtualOffice = driver.findElement(By.xpath("//*[@itemprop='name']")).isDisplayed();
        System.out.println("Virtual Community Office is Visible: " + virtualOffice);
        logger.log(LogStatus.INFO,"Virtual Community Office is Visible: " + virtualOffice );
        //captures and print out virtual community office introduction
        String introMessage = ReusableActions_Logger.getTextAction(driver, "//*[@class='landingBannerImg']", logger, "Introduction");
        System.out.println(introMessage);
    }

   @Test(dependsOnMethods = "Use_Case2")
   public void Use_Case3() throws InterruptedException {
        //scrolls to services section of the page
        ReusableActions_Logger.scrollByView(driver, "//*[@class='landingProspectiveMemberSect']", logger, "Services");
        Thread.sleep(2000);
        //skips line
        System.out.println(" ");

        //Prints out the names of virtual services offered
        System.out.println("Virtual Services Offered: ");
        String service1 = ReusableActions_Logger.getTextActionByIndex(driver, "//*[@class='landingLinkGroup']/h5", 0, logger, "Sales Rep");
        System.out.println(service1);
        String service2 = ReusableActions_Logger.getTextActionByIndex(driver, "//*[@class='landingLinkGroup']/h5", 1, logger, "Sales Rep");
        System.out.println(service2);
        String service3 = ReusableActions_Logger.getTextActionByIndex(driver, "//*[@class='landingLinkGroup']/h5", 2, logger, "Sales Rep");
        System.out.println(service3);

        //clicks on links for sales rep search
        ReusableActions_Logger.clickAction(driver, "//*[text()='Search Representatives']", logger, "Service Link 1");
        Thread.sleep(2000);
        //skips line
        System.out.println(" ");
        //confirms that service information page is visible
        boolean salesRep = driver.findElement(By.xpath("//*[text()='Search Sales Representatives']")).isDisplayed();
        System.out.println("Sales Rep Search Page is visible: " + salesRep);
        logger.log(LogStatus.INFO,"Sales rep search page is Visible: " + salesRep);
        //goes back to virtual services page
        driver.navigate().back();

        //clicks link for scheduling appointment
        ReusableActions_Logger.clickAction(driver, "//*[text()='Schedule Appointment']", logger, "Service Link 2");
        Thread.sleep(2000);
        //confirms that service information page is visible
        boolean appointment = driver.findElement(By.xpath("//*[text()='Schedule an Appointment to Enroll']")).isDisplayed();
        System.out.println("Scheduling appointment Page is visible: " + appointment);
        logger.log(LogStatus.INFO,"Scheduling appointment page is Visible: " + appointment);
        //goes back to virtual services page
        driver.navigate().back();

        //clicks link for video library
        ReusableActions_Logger.clickAction(driver, "//*[text()='Enter Library']", logger, "Service Link 3");
        Thread.sleep(2000);
        //confirms that service information page is visible
        boolean library = driver.findElement(By.xpath("//*[text()='Video Library']")).isDisplayed();
        System.out.println("Video library page is visible: " + salesRep);
        logger.log(LogStatus.INFO,"Video library page is Visible: " + library);
        driver.navigate().back();
   }
}



