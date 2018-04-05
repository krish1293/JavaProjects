// Krishna Patel

import java.util.Arrays;
import java.util.Arrays.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;
import java.util.Stack.*;

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
        // s
        subArraySum(arr2, n, sum);

		int arr3[] = new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		
		Arrays.sort(arr3);
		
        System.out.printf("\n\nAfter sort: %s\n\n", Arrays.toString(arr3));

        System.out.println("Leaders");
        int arr4[] = new int[]{16, 17, 4, 3, 5, 2};
        leaders(arr4, arr4.length);

        int arr5[] = new int[]{1,2,3,4,0};
        leaders(arr5, arr5.length);

        System.out.println("\nDistinct Ids");
        int arr6[] = {2, 3, 1, 2, 3, 3};
        int m = 3;
 
        System.out.println(distinctIds(arr6, arr6.length, m));

        int arr7[] = {2, 4, 1, 5, 3, 5, 1, 3};
        m = 2;
 
        System.out.println(distinctIds(arr7, arr7.length, m));

        System.out.println("\nWordLen4InStr");
        String str = "This sentence has four words";
        wordLen4InStr(str);
        System.out.println("\nValidate Paranthesis");
       // String paran = "((())(()))";
       // validateParanthesis(paran);
        System.out.println("\nValidate Paranthesis");
        String paran = "((())(()))";
        validateParanthesis(paran);

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

      // Function to find distintc id's
      public static int distinctIds(int arr[], int n, int mi)
      {
   
          Map<Integer, Integer> m = new HashMap<Integer, Integer>();
          int count = 0;
          int size = 0;
   
          // Store the occurrence of ids
          for (int i = 0; i < n; i++)
          {
   
              // If the key is not add it to map
              if (m.containsKey(arr[i]) == false)
              {
                  m.put(arr[i], 1);
                  size++;
              }
   
              // If it is present then increase the value by 1
              else m.put(arr[i], m.get(arr[i]) + 1);
          }
   
          // Start removing elements from the beginning
          for (Entry<Integer, Integer> mp:m.entrySet())
          {
              // Remove if current value is less than
              // or equal to mi
              if (mp.getKey() <= mi)
              {
                  mi -= mp.getKey();
                  count++;
              }
              // Return the remaining size
              else return size - count;
          }
   
          return size - count;
      } // Distinct Ids

 /**     public static void validateParanthesis(String str){
      public static void validateParanthesis(String str){
 
            int strLen = str.length();
    
            for(int i = 0; i < strLen; i++){
                if(str.charAt(i) == '('){
                    Stack.push(str.charAt(i));
                }
                if(str.charAt(i) == ')'){
    //                boolean empty = Stack.isEmpty();
					if(empty){
                    if(Stack.isEmpty()){
                        System.out.println("Missmatched paranthesis");
                    }
                    else if(!isMatchingPair(Stack.pop(), str.charAt(i))){
                        System.out.println("Paranthesis are maching");
                    }
                }
            }
    
          } // end of validateParanthesis
**/
   
      public static boolean isMatchingPair(char char1, char char2){
          if(char1 == '(' && char2 == ')'){
              return true;
          }
          else{
              return false;
          }
      }

      public static void wordLen4InStr(String str){

        System.out.println(str);
        int numWord = 0;
        String[] splitStr = str.split(" ");

        for(String elm: splitStr){
       
            if(elm.length() == 4){
                System.out.println(elm);
                numWord += 1;
            }
        }
        System.out.printf("Total number of words with length 4 are %d\n", numWord);
      } // end of wordLen4InStr

      public static void palindromicScore(String str){

      } // end of palindromicScore

} // end of ArraysPractice

