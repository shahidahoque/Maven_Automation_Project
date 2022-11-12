package Day2_100222;

//Declared Java Class
public class T1_LinearArray {

    //declared main method
    public static void main(String[] args){

        //declared string array variable, array always starts from 0 index.
        String[] zipCode;
        //declared int array variable
        int[] streetNumber;

        //defining zip code values for linear string array
        zipCode = new String[]{"10001","12222","13332", "12342"};
        //defining street number values for linear integer array
        streetNumber = new int[]{000, 111, 222, 333};

        //print statement for linear string and int array values starting from index value 0
        System.out.println("zip code: "+ zipCode[0] + ", " + zipCode[1] + ", " + zipCode[2] + ", " + zipCode[3]);
        System.out.println("street number: "+ streetNumber[0] + ", " + streetNumber[1] + ", " + streetNumber[2] + ", " + streetNumber[3]);
    }//end of main method

}//end java class
