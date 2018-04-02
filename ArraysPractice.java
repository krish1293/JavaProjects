import java.util.Arrays;
import java.util.Arrays.*;

public class ArraysPractice{

    public static void main(String args[]){
        int arr[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 10;
        int numNotFound = missingNum(arr, n);
        System.out.printf("%d is not found in array\n", numNotFound);

        int arr2[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 15;

        // use this if subArraySum was no defined as a static method
        //  ArraysPractice arrSum = new ArraysPractice();
        // arrSum.subArraySum(arr2, n, sum);
        
        int arrSum = subArraySum(arr2, n, sum);

		int arr3[] = new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		
		Arrays.sort(arr3);
		
        System.out.printf("\n\nAfter sort: %s\n\n", Arrays.toString(arr3));
        
        int arr4[] = new int[]{16, 17, 4, 3, 5, 2};
        leaders(arr4, arr4.length);

        int arr5[] = new int[]{1,2,3,4,0};
        leaders(arr5, arr5.length);

    } // end of main

    /*** 
        missingNum takes 2 arguments an array and a number (n) (length of array + 1)
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

    /*** 
        subArraySum takes 3 arguments an array, a number (n) (length of array + 1) and sum
        Array should have numbers 1 - n
        Finds the subarray with given sum
   ****/
    public static int subArraySum(int arr[], int n, int sum){
        int currSum = 0;
        for(int i = 0; i < n; i++){
            currSum = arr[i];
            for (int j = i + 1; j <= n; j++){
                if (currSum == sum){
                    int p = j - 1;
                    System.out.printf("%d sum was found between %d and %d\n", currSum, i, p);
                    return 1;
                }
                if(currSum > sum || j == n)   
                    break;
                currSum = currSum + arr[j];
            }
        }

        System.out.println("No Subarray found");
        return 0;

    } // end of subArraySum

    public static void leaders(int arr[], int n){
        int maxInt = 0;
        for (int i = 0; i < n; i++){
            maxInt = arr[i];
            for (int j = i + 1; j < n; j++){
                if (maxInt < arr[j]){
                    maxInt = arr[j];
                    System.out.printf("%d ", maxInt);
                }
            }
            maxInt = arr[n-1];

            //System.out.println(maxInt);
        }
        System.out.printf("%d \n", maxInt);
    } // end of leaders

} // end of ArraysPractice