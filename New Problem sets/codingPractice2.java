import java.util.*;

public class codingPractice2{

    public static void main(String[] args) {
        
        // 1. addFrac
        addFrac(1, 500, 2, 1500);

        // 2. revStr
        System.out.printf("Rverse String of %s is %s\n", "iceman", revStr("iceman"));

        // 3. powTen
        boolean pow10 = powTen(1000);
        if(pow10){
            System.out.printf("%d is power of 10\n", 1000);
        }
        // 4. Median
        int[] arr1 = {3, 6, 9 ,2};
        int[] arr2 = {10, 8, 1, 4};
        int med = median(arr1, arr2);
        System.out.printf("Median: %d\n", med);

        // 5. pairs
        int[] arr = {3,2,5,4,6,10,1,0,8};
        int k = 10;
        System.out.printf("Total number of pairs adding up to %d are %d\n", k, pairs(arr, k));
    } // main

    //1. There are two fractions example: F1 = 3/4 and F2 = 5/6. You need to compute their sum and return the result. 
    public static void addFrac(int num1, int den1, int num2, int den2){

        int gcdDen3 = gcd(den1, den2);

        int lcm = (den1*den2)/gcdDen3;

        int newNum = num1*(lcm/den1) + num2 * (lcm/den2);

        int lowest = gcd(lcm, newNum);
        lcm = lcm/lowest;
        newNum = newNum/lowest;

        System.out.printf("%d/%d + %d/%d = %d/%d\n", num1, den1, num2, den2, newNum, lcm); 

    } // addFrac

    public static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    } // gcd

    //2. Reverse a linked list.
    public static String revStr(String str){
        String rev = " ";
        for(int i = str.length()-1; i >= 0; i--){
            rev += str.charAt(i);
        }
        return rev;

    } // revStr

    //3. Find whether the given number is power of 10 or not
    public static boolean powTen(int num){
        if(num % 10 == 0){
            return true;
        }
        return false;
    } // powTen

    //4. Given two unsorted arrays, find the median (not the brute force approach).
    public static int median(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] arr3 = merge(arr1, arr2);
        int len = arr3.length;
        int med = 0;
        if((len % 2) == 1){
            med = arr3[len/2];
        }
        else{
            
            int middle = len/2;
            med = arr3[middle - 1] + arr3[middle];
            med = med/2;
        }  
        
        return med;

    } // median

    public static int[] merge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int arr3[] = new int[n+m];
        while(i < n  && j < m){
            if(arr1[i] <= arr2[j]){
                arr3[k++] = arr1[i++];
            }
            else{
                arr3[k++] = arr2[j++];
            }
        }

        while(i < n){
            arr3[k++] = arr1[i++];
        }
        while(j < m){
            arr3[k++] = arr2[j++];
        }

        return arr3;
    } // merge

    //5. Find the total number of pairs in array = k. 
    public static int pairs(int[] arr, int k){
        int countPairs = 0;

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if((arr[i] + arr[j]) == k){
                    countPairs++;
                }
            }
        }

        return countPairs;
    } // pairs

    //6. Given a robot which can only move in four directions, UP(U), DOWN(D), LEFT(L), RIGHT(R). 
    //   Given a string consisting of instructions to move. Output the co-ordinates of robot after the executing the instructions. 
    //   Initial position of robot is at origin(0, 0).
    //7. Spiral order traversal of the matrix
    //8. Subarray with 0 sum
    //9. Car has to be given on rent. Different people come and ask for it for interval [s, e] and offer some price p. 
    //   To whom shall the car be given in order to earn maximum.


} // codingPractice2