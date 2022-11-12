package Review_Wednesday;

import java.util.ArrayList;

public class Review1012 {
    public static void main(String[] args) {
        /*
        int a = 5;
        int b = 8;

        if (a > b) {
            System.out.println("Option 1");
        } else if (b < a) {
            System.out.println("Option 2");
        } else if (a == b){
            System.out.println("Option 3");
        } else if (a+3 == b) {
            System.out.println("Option 4");
        } else if (b-1 >= 5+2) {
            System.out.println("Option 5");
        }

        ArrayList <String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Mexico");
        countries.add("Canada");

        if (countries.get(0).equals("USA") && countries.get(1).equals("Canada"));{
            System.out.println("Option 1");
        }
        else if (countries.get(0).equals("USA") && countries.get(1).equals("Canada"));{
            System.out.println("Option 1");
        } */

        String subjectLine = "Automation_AI05";

        //split the string
        String[] splitMessageArray = subjectLine.split("_");
        //take the second string from the array then grab the number only
        String actionItemNumber = splitMessageArray[1].substring(2);
        //print out John to the console
        System.out.println("The action number item is " + actionItemNumber);
    }
}
/*
    //this is an example of relative xpath
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");
    //this is an example of absolute xpath
        driver.findElement(By.xpath("//div[@class = 'RNNXgb']//div//div//input")).sendKeys("cars");

}
 */