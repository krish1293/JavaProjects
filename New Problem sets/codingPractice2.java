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

        // 6.Robot movment
        String direct = "urdllduruu";
        roboPosition(direct);

        // 7. Spiral print of the matrix
        int rLen = 3;
        int cLen = 6;
        int matrix[][] = { {1,  2,  3,  4,  5,  6},
        {7,  8,  9,  10, 11, 12},
        {13, 14, 15, 16, 17, 18}
        };
        printSpiral(matrix, rLen, cLen);

        // 8. Subarray with 0 sum
        int[] origArr = {4, 2, -3, 1, 6};
        sumZero(origArr);
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
    public static void roboPosition(String str){
        char[] ch = str.toCharArray();
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        for(int i = 0; i < ch.length; i++){
            if(ch[i] == 'u'){
                up++;
            }
            else if(ch[i] == 'd'){
                down++;
            }
            else if(ch[i] == 'l'){
                left++;
            }
            else if(ch[i] == 'r'){
                right++;
            }
        }
        int y = up - down;
        int x = right - left;

        System.out.printf("Directions %s: coordinates (%d, %d)\n", str, x, y);

        
    } // roboPosition

    //7. Spiral order traversal of the matrix
    public static void printSpiral(int[][] matrix, int rLen, int cLen){
        int rStart = 0;
        int cStart = 0;
        
        while(rStart < rLen && cStart < cLen){

            for(int i = cStart; i < cLen; i++){
                System.out.print(matrix[rStart][i] + " ");
            }
            rStart++;

            for(int i = rStart; i < rLen; i++){
                System.out.print(matrix[i][cLen-1] + " ");
            }
            cLen--;

            if(rStart < rLen){
                for(int i = cLen-1; i >= cStart; i--){
                    System.out.print(matrix[rLen-1][i] + " ");
                }
                rLen--;
            }

            if(cStart < cLen){
                for(int i = rLen - 1; i >= rStart; i--){
                    System.out.print(matrix[i][cStart] +" ");
                    cStart++;
                }
            }
        }
        System.out.println();
    } // printSpiral

    //8. Subarray with 0 sum
    public static void sumZero(int[] arr){
        int len = arr.length;
        int sum = arr[0];
        int start = 0; 

        for(int i = 1; i < len; i++){
            // 
            while(sum > 0 &&  start < i - 1){
                sum -= arr[start++];
            }
            if(sum == 0){
                int p = i - 1;
                System.out.printf("Sum found between %d and %d\n", start, p);
            }

            if(i < len){
                sum += arr[i];
            }
        }
    } // sumZero

    //9. Car has to be given on rent. Different people come and ask for it for interval [s, e] and offer some price p. 
    //   To whom shall the car be given in order to earn maximum.
    public static int maxPrice(int start, int end, int price){
        Map<Integer, Integer> carValue = new HashMap<>();
        int interval = end - start; 
        int max = 0; 
        
        return max;
    }
    //10. Problem for BFS.
    //11. Loop in a linked list
    //12. 5th element from last of linked list
    //13. Tree given with 2 nodes having same child. Find that sort of thing in tree.
    //14. Find the common ancestor of 2 nodes in binary tree.
    //15. Given an array, need to go from 0-n, with almost no. of steps as a[i]. Find minimum steps we need for given array.
    //16. Angle between hour hand and minute hand at a given time.
    //17. Create data structure with pop(), push(), top(), min() in O(1)
    //18. Largest contiguous substring with no repeating elements. 
    //19. Given an string and a burst length, output the string that count of the same adjacent characters 
    //     in string are less than burst length. 
    //20. Given an array of distinct integers, output the number of sub-sequences of length 3, 
    //    either in increasing or decreasing order.
    //21. Given an array of integers and a sum, output the number of pairs whose addition is equal to the given sum. 
    //22. Given a sequence of M and N with M representing increasing and N representing decreasing, 
    //    output the smallest number that follows this patten. 
    //23. Given a string, the task is to find maximum consecutive repeating character in string
    //24. Print the reverse order of the string.
    //25. Given permutations with only adjacent swaps allowed. 
    //26. Given an array of non-negative numbers & a target value, 
    //    return the length of smallest subarray whose sum is greater than the target value. 
    //27. Find the largest number from the array of number.
    //28. Given an array, find the number of contiguous subarrays such that the product of the elements of the 
    //    subarray is less than or equal to a given positive integer k. 
 


} // codingPractice2