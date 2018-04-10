import java.util.*;

public class CodingPractice{

    public static void main(String[] args) {

        //1. Fibanacci 
        int fRec = fibRec(9);
        System.out.printf("fRec: %d\n", fRec);

        System.out.printf("fibIterative: %d\n", fibIterative(9));

        //2. Palindrome
        System.out.println("Palindrome");
        boolean palindrome = isPalindrome("racecar");
        System.out.println(palindrome);

        //3. two strings Anagrams?
        System.out.println("Anagaram");
        boolean anagram = isAnagram("iceman", "cinema");
        System.out.println(anagram);

        //4. Get Middle element of a Linked List

        //5. Add an element to the beginning of the Linked List 

        //6. Add an element to the end of the linked List

        //7. Add an element in the middle of the linked list

        //8. Remove an element from Linked List

        //9. Find smallest element in sorted rotated array
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ findSmallestNum(arr1, 0, n1-1));

        int arr2[] =  {2, 1, 3, 0};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ findSmallestNum(arr2, 0, n2-1));

        //10. Child can take 1, 2, 3, steps. Total steps he has to take is n.
        // Find num of ways he can traverse those steps.
        System.out.printf("\nRecurssion: %d ways to find %dth step\n", countWaystoFindStepRec(5), 5 );
        System.out.printf("\nIterative: %d ways to find %dth step\n", countWaystoFindStepIter(6), 6 );

        //11. given an array 1-n elements with one element duplicate. Find that element.

        //12. Print number in ascending order which contains 123 digits

        // 13. Given a sequence of M and N representing increasing and N representing decreasing, 
        // output the smallest number that follows this pattern. 

        // 14. Given a String, find maximum consecutive repeating character in string

        //15. print the reverse order of the string
    } // main

    // F(n) = F(n-1) + F(n-2)
    public static int fibRec(int n){
        if (n==0 || n==1){
            return n;
        }
        return fibRec(n-1) + fibRec(n-2);
    } //fibRec

    public static int fibIterative(int n){
        int arr[] = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];

    } // fibIterative

    // Palindrome: word that reads same forward & backward
    public static boolean isPalindrome(String str){
       
        StringBuffer strBuff = new StringBuffer(str).reverse();
        String rev = strBuff.toString();

        if(str.equals(rev)){
            return true;
        }

        return false;
    } // palindrome

    public static boolean isAnagram(String str1, String str2){
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);
        
        String word1 = new String(char1);
        String word2 = new String(char2);

        if(word1.equals(word2)){
            return true;
        }

        return false;
    } // isAnagram

    // 9. find smallest element in a sorted or roted array
    public static int findSmallestNum(int[] arr, int low, int high){

        int mid = (low + high)/2;

        //first element smallest
        if(high < low){
            return arr[0];
        }

        //if only one element left in the arr
        if(high == low){
            return arr[low];
        }
        // mid+1 is smallest
        if((mid < high) && (arr[mid+1] < arr[mid])){
            return arr[mid+1];
        }

        // mid is smallest
        if(mid > low && (arr[mid] < arr[mid-1])){
            return arr[mid];
        }

        if(arr[high] > arr[mid]){
            return findSmallestNum(arr, low, mid-1);
        }
        return findSmallestNum(arr, mid+1, high);

    } // findSmallestNum

    //10. 1 step = n-1, 2 steps = n-2, 3 steps = n-3
    // returns count of ways to reach nth stair using 1, 2, 3 steps
    public static int countWaystoFindStepRec(int n){
        if((n==1) || (n==0)){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        return countWaystoFindStepRec(n-3) +
               countWaystoFindStepRec(n-2) +
               countWaystoFindStepRec(n-1);
    } // countWaystoFindStepRec

    public static int countWaystoFindStepIter(int n) {
        
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= n; i++){
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }

        return arr[n];
    } // countWaystoFindStepIter

    //11. find one duplicate element in an array of length n-1
    public static int findDup(int[] arr) {
        

    } // findDup

} // CodingPractice