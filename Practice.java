import java.util.Arrays;
import java.util.Arrays.*;

public class Practice{

    public static void main(String[] args) {
        
        int arr[] = new int[] {5, 8, 10,2,3,15,8,1,6,8};

        System.out.printf("Before sort: %s", Arrays.toString(arr));
        System.out.println();

       
        Arrays.sort(arr);

        System.out.printf("After sort: %s", Arrays.toString(arr));

        boolean dup = false; 
       for (int i = 0; i < arr.length; i++){
           for(int j = i + 1; j < arr.length; j++){
                if(dup==false && (arr[i] == arr[j])){
                    System.out.printf("\narr[%d]: %d & arr[%d]: %d\n", i, arr[i], j, arr[j]);   
                    dup = true;
                }
           }
       } 
    }
} // end of class