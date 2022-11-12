package Day3_100822;

import java.util.ArrayList;

public class T3_ArrayList_Loop_Conditions {
    public static void main(String[] args){

        //<>refers to anchor
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");
        countries.add("Australia");

        //using for loop to iterate through countries list and  print out only the country is USA or Australia
        for(int i=0; i<countries.size(); i++){

            //two equal will compare the values from right to left side
            //one equal is used to set a value for variable
            if (countries.get(i)== "USA"){
                System.out.println("Country is USA and index is " + i);
            } else if (countries.get(i) ==  "Australia"){
                System.out.println("Country is Australia and index is " + i);
            } //end of conditions

            //using an operator you can write both/multiple conditions on one if statement
            //using or || operator you can write multiple conditions in one if statement
            if(countries.get(i) == "USA" || countries.get(i) == "Australia"){
                System.out.println("Country is " + countries.get(i) + " and index is " + i);
            } // end of if condition with or operator

        } //end of  loop

    } //end of main
} //end of java class
