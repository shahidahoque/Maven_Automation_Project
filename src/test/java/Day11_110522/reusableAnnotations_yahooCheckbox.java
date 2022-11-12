package Day11_110522;

import ReusableLibrary.ReusableActions;
import ReusableLibrary.Reusable_Annotations;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class reusableAnnotations_yahooCheckbox extends Reusable_Annotations {
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
