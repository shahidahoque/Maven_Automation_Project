package Review_Wednesday;

import java.util.ArrayList;

public class Review1005 {
    public static void main(String[] args) {
//exercise one
//create a linear array of car brands (5)
//print it out to the console using while loop

        String[] CarBrands;
        CarBrands = new String[]{"Nissan", "Toyota", "Infinity", "Tesla", "Honda"};
        int i = 0;

        while (i < CarBrands.length) {
            System.out.println("Car Brand Name:" + CarBrands[i]);
            i++;
        }

//exercise two
// lets create an array list of phone numbers (5)
// print it out to the console using for loop

        ArrayList<String> PhoneNumbers = new ArrayList<>();
        PhoneNumbers.add("917-586-3529");
        PhoneNumbers.add("929-423-4989");
        PhoneNumbers.add("917-200-4546");
        PhoneNumbers.add("718-212-4043");
        PhoneNumbers.add("646-628-2733");

        for (int b=0; b < PhoneNumbers.size(); b++){
            System.out.println("Phone Number: " + PhoneNumbers.get(b));
        }
    }
}
