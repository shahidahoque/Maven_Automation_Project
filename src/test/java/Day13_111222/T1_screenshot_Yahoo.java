package Day13_111222;

import ReusableLibrary.ReusableActions_Logger;
import ReusableLibrary.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T1_screenshot_Yahoo extends Reusable_Annotations {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        ReusableActions_Logger.clickAction(driver,"//*[@class = '_yb_1933eyyyy']",logger,"Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1
}
