package p002;

public class Solution {

    static void segregate0and1(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // Move left forward while seeing 0s (correct position)
            while (left < right && arr[left] == 0) {
                left++;
            }

            // Move right backward while seeing 1s (correct position)
            while (left < right && arr[right] == 1) {
                right--;
            }

            // arr[left] = 1 and arr[right] = 0 → swap them
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 1, 1, 0, 0};

        segregate0and1(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}