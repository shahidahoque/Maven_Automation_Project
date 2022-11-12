package Day2_100222;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {
    public static void main(String[] args){

        //declare and define the arraylist for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11232");
        zipCode.add("16479");
        zipCode.add("16384");
        zipCode.add("12393");

        //use for loop to print all the values within the arraylist
        for(int i = 0; i < zipCode.size(); i++){
            //print each zip code automatically
            System.out.println("zip code: " + zipCode.get(i));

        } //end of loop
    } //end of main method
} //end of java class
