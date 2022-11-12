package Day2_100222;

public class T4_WhileLoop_LinearArray {
    public static void main (String[] args){
        //declare liner array for street number.
        int[] streetNumber = new int[] {111,222,333,444};

        //iterate through all street number by while loop
        //set the initializer
        int i = 0;

        //set condition for while loop
        //liner array get count by using length
        while(i < streetNumber.length){
            System.out.println("Street Number: " + streetNumber[i]);
            //incrementation for loop can either be i++ or i = i+1
            i++;
        } //end of while loop

    } //end of main method
} ///end of java class
