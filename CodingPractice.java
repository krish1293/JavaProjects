import java.util.HashMap;
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
        LinkedList list = new LinkedList();
        for(int i = 0; i < 10; i++){
            list.pushatEnd(i);
        }
        list.printList();
        int mid = list.prntMidElemLLM2(list);
        System.out.println("The middle element in list is " + mid + "\n");

        //5. Add an element to the beginning of the Linked List 

        //6. Add an element to the end of the linked List

        //7. Add an element in the middle of the linked list

        //8. Remove an element from Linked List

        //9. Find smallest element in sorted rotated array
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element in array is "+ findSmallestNum(arr1, 0, n1-1));

        int arr2[] =  {2, 1, 3, 0};
        int n2 = arr2.length;
        System.out.println("The minimum element in array is "+ findSmallestNum(arr2, 0, n2-1));

        //10. Child can take 1, 2, 3, steps. Total steps he has to take is n.
        // Find num of ways he can traverse those steps.
        System.out.printf("\nRecurssion: %d ways to find %dth step\n", countWaystoFindStepRec(5), 5 );
        System.out.printf("\nIterative: %d ways to find %dth step\n", countWaystoFindStepIter(6), 6 );

        //11. given an array 1-n elements with one element duplicate. Find that element.
        int[] dup = {5, 6, 1, 2, 6, 9, 10, 5};
        System.out.printf("\nDuplicate element is: %d\n", findDup(dup));

        //12. Print number in ascending order which contains 123 digits
        System.out.println("Following strings in array contais digits 123");
        String[] num123 =  { "123", "1232", "456", "234", "32145" };
        num123Dgts(num123);

        // 13. Given a sequence of M and N, M representing increasing and N representing decreasing, 
        // output the smallest number that follows this pattern. 

        // 14. Given a String, find maximum consecutive repeating character in string
        String maxRepChar = "aabbbbccaaa";
        System.out.printf("\nMax consecutive repeating char in %s is %c\n", maxRepChar, maxConsRepChar(maxRepChar) );

        //15. print the reverse order of the string
        String revOd = "Krishna";
        System.out.printf("\nRevers of %s is %s\n", revOd, printRevStr(revOd));

        //16. count each word in the string array
        Map<String, Integer> words = new HashMap<String, Integer>();
        String[] w = {"New", "words", "to", "count", "number", "of", "words", "in", "an", "array", "new", "new", "count"};
        countEachWord(w, words);
        System.out.println(words);

        //17. Sum of 2 fractions
        addFraction(1, 2, 3, 2);
        addFraction(1, 3, 3, 9);
        addFraction(1, 500, 2, 1500);
    } // main

    //1. F(n) = F(n-1) + F(n-2)
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

    //2. Palindrome: word that reads same forward & backward
    public static boolean isPalindrome(String str){
       
        StringBuffer strBuff = new StringBuffer(str).reverse();
        String rev = strBuff.toString();

        if(str.equals(rev)){
            return true;
        }

        return false;
    } // palindrome

    //3. Anagram
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
        
        int dup = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                dup = arr[i];
            }      
        }
        return dup;
    } // findDup

    //12. Print number in ascending order which contains 123 digits
    public static void num123Dgts(String[] arr){
        ArrayList<String> array = new ArrayList<>();
        for(String num: arr){
            if(num.contains("1") && num.contains("2") && num.contains("3")){
                array.add(num);
            }
        }
        Collections.sort(array);
        System.out.println(array.toString());

    } // num123Dgts

    // 14. Given a String, find maximum consecutive repeating character in string
    public static char maxConsRepChar(String str){
       
       int count = 0; 
       int currCnt = 1;
       char maxRep = str.charAt(0);
        for(int i = 0; i < str.length() - 1; i++){    
            if(str.charAt(i) == str.charAt(i+1)){
                currCnt++;
                System.out.printf("curChar: %c & currCnt: %d & count: %d\n", str.charAt(i), currCnt, count);
            }
            else{
                if(currCnt > count){
                    count = currCnt;
                    maxRep = str.charAt(i);
                }
                currCnt = 1;
            }
        }

        return maxRep;

    } // maxConsRepChar

    //15. print the reverse order of the string
    public static String printRevStr(String str){
        String rev = new String();

        for(int i = str.length()-1; i >= 0; i--){
            rev += str.charAt(i);    
        }
         
        return rev;
    } // printRevStr

    //16. Count each word in a text
    public static void countEachWord(String[] str, Map<String, Integer> words){
        for(int i = 0; i < str.length; i++){
            String word = str[i];
            Integer count = words.get(word);
            if(count != null){
                count++;
            }
            else{
                count = 1;
            }
            words.put(word, count);
        }
    } // countEachWord

    //17. There are two fractions examples: F1 = 3/4 and F2 = 5/6. Compute their sum and return the result.
    public static void addFraction(int num1, int den1, int num2, int den2){
        int den3 = gcd(den1, den2);
        System.out.printf("gcd: %d\n", den3);

        // count LCM: Least common Multiple
        den3 = (den1*den2)/den3;

        System.out.printf("lcm: %d\n", den3);

        // change fractions to have same denominator (add fraction)
        int num3 = ((num1) * (den3/den1)) + ((num2) * (den3/den2));

        int commFact = gcd(den3, num3);
        den3 = den3/commFact;
        num3 = num3/commFact;

        System.out.printf("%d/%d + %d/%d = %d/%d\n", num1, den1, num2, den2, num3, den3);

    } // addFraction

    public static int gcd(int a, int b){
        
        if (a == 0){
            return b;
        }
        return gcd(b%a, a);

    } //gcd

} // CodingPractice

class LinkedList{
    Node head;

    class Node{
        Node next;
        int data;

        public Node(int d){
            next = null;
            data = d;
        }
    } // Node

    public void pushFrist(int newData){
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void pushatEnd(int newData){
        
        if(head == null){
            head = new Node(newData);
            //head.next = null;
            System.out.println(head.data);
            
        }
        else{
            Node newNode = new Node(newData);
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }

    //4. Print middle of Linked List
    // Method 1: Traverse thru whole list, count the number of elements
    //           and using pointer get to the count/2 element and print it
    // Method 2: Keep 2 pointers - 1. moves by 2 elements and 2. moves to next element
    //           by the time 1st pointer is at the end of the list, 2nd pointer is in the middle
    public  int prntMidElemLLM2(LinkedList list){
        Node firstNode = head;
        Node secondNode = head;

        if(head != null){
            while(firstNode != null && firstNode.next != null){
                firstNode = firstNode.next.next;
                secondNode = secondNode.next;
            }
        }

        printList();
        return secondNode.data;
    } // printMidElemLLM2

    public void printList(){
        Node last = head;
        while(last != null){
            System.out.print(last.data + " ");
            last = last.next;
        }
        System.out.println();
    }
} // end of LinkedList