package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String args[]){

        int array[] = {3,5,2,8,4,9};
        System.out.print("Before sorting :" );
        printArray(array);
        System.out.print("\n" );

        ascendingOrderData(array);

        System.out.print("\n" );
        System.out.print("After sorting :" );
        printArray(array);

   }

   static void ascendingOrderData(int data[]){
        int size = data.length;
        int i =0;
        int temp = 0;
        for( i=0;i<size;i++){
           for(int j=i+1;j<size;j++){
               if(data[i] > data[j]){
                   temp = data[i];
                   data[i] = data[j];
                   data[j] = temp;
               }

           }
            System.out.print(data[i]+ " , ");
       }
   }

    static void printArray(int data[]){
      for(int i=0;i<data.length;i++){
          System.out.print(data[i]+ " , ");
      }
    }

}
