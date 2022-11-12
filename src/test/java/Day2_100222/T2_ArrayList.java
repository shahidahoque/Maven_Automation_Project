package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args){

        //declare and define arraylist for countries
        ArrayList<String> countries = new ArrayList<>();
        //add values arraylist
        countries.add("USA");
        countries.add("Mexico");
        countries.add("China");
        countries.add("Canada");

        //print values from arraylist
        System.out.println("Countries value: " + countries.get(0));
        //print the number of values in the arraylist
        System.out.println("Countries count: " + countries.size());

        //declare integer arraylist
        ArrayList<Integer> streetNumber = new ArrayList<>();
        //define integer values for arraylist
        streetNumber.add(100);
        streetNumber.add(202);
        streetNumber.add(333);
        streetNumber.add(234);

        //print the values of the arraylist
        System.out.println("The First Street Number: " + streetNumber.get(0));

    } //end of main method
} //end of class
