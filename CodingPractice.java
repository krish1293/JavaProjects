public class CodingPractice{

    public static void main(String[] args) {

        //1. Fibanacci 
        int fRec = fibRec(9);
        System.out.printf("fRec: %d\n", fRec);

        System.out.printf("fibIterative: %d\n", fibIterative(9));

        //2. palindrome

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

} // CodingPractice