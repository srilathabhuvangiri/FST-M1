package activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args) {
        int aryNum[] = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(aryNum));

        int searchNum = 10;
        int desiredNum = 30;
        System.out.println("Result: " + result(aryNum, searchNum, desiredNum));
    }

    public static boolean result(int[] nums, int searchNum, int desiredNum) {
        int temp = 0;
        for (int numbers : nums) {
            if (numbers == searchNum) {
                temp +=searchNum;
            }
            if (temp > desiredNum) {
                break;
            }
        }
        return temp == desiredNum;
    }
}
