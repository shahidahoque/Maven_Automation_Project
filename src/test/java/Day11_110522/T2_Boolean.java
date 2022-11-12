package Day11_110522;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T2_Boolean {
    WebDriver driver;
    ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked(){
        //navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        ReusableActions.clickAction(driver, "//*[@class='_yb_1933e']", "Sign In Button");
        //verify if sign in button is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }

    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc001_verifySignedInOptionIsUnChecked(){
        //click on sign in button to uncheck it
        ReusableActions.clickAction(driver, "//*[@class='stay-signed-in checkbox-container']", "Signed In Checkbox");
        //verifies if sign in button is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }

}
