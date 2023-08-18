package Activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args) {
        int[] array = {10, 77, 10, 54, -11, 10};
        System.out.println("Original array:" + Arrays.toString(array));
        int searchNum = 10;
        int sum = 30;
        System.out.println("Result:" + result(array, searchNum, sum));

    }
    public static boolean result(int[] numbers, int searchNum, int sum) {
        int temp_sum = 0;
        for (int number : numbers) {
            if (number == searchNum) {
                temp_sum += searchNum;
            }
            if (temp_sum > sum) {
                break;
            }
        }

        return temp_sum == sum;

        }
    }


