import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class ArraysPractice{

    public static void main(String args[]){
        int arr[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 10;
        int numNotFound = missingNum(arr, n);
        System.out.printf("%d is not found in array\n", numNotFound);

    } // end of main

    /*** 
        missingNum takes to arguments an array and a number (n) (length of array + 1)
        Array should have numbers 1 - n
        numTotal = sum of all numbers in the array
            to get the missing number subtract all the numbers in array from the 
            numTotal
   ****/
    public static int missingNum(int intArr[], int n){
        int numTotal = n*(n+1)/2;  
       // System.out.printf("numTotal before: %d\n", numTotal);
        for(int i = 0; i < n-1; i++){
            numTotal = numTotal - intArr[i]; 
        }
        return numTotal;
    } //end of missingNum

} // end of ArraysPractice