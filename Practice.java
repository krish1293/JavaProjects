import java.util.Arrays;
import java.util.Arrays.*;

public class Practice{

    public static void main(String[] args) {
        
        int arr[] = new int[] {5, 8, 10,2,3,15,8,1,6,8};

        System.out.printf("Before sort: %s", Arrays.toString(arr));
        System.out.println();

        for (int i = 0; i < arr.length; i++){
            int occurs = countNumofOccurance(arr, arr[i]);
            System.out.printf("\n%d found %d time(s) in array", arr[i], occurs);
        }
        
        Arrays.sort(arr);

        System.out.printf("\n\nAfter sort: %s", Arrays.toString(arr));

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

    public static int countNumofOccurance(int arr[], int value) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == value){
              //  System.out.printf("%d found at arr[%d] \n", value, i);   
                count++;
             }
        }  
        return count;
    }// end of countNumofOccurance

} // end of class