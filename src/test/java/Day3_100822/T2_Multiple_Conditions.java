package Day3_100822;

public class T2_Multiple_Conditions {
    public static void main(String[] args){
        //declare three integer variables
        int a, b, c;
        a = 2;
        b = 3;
        c = 4;

        //write a multiple conditional statements that covers when  a+b < c, a+b > c, or a+b = c.
        if (a+b < c){
            System.out.println("a and b is less than c");
        } else if (a+b > c){
            System.out.println("a and b is greater than c");
        } else {
            System.out.println("a and b is equal to c");
        } // end of condition
    } //end of main
}//end of class
