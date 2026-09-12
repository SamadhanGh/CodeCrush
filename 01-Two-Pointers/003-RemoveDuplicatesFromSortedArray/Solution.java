package p003;

import java.util.Arrays;

public class Solution {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // Slow pointer: points to the last unique element
        int rd = 0;

        // Fast pointer: traverses the array
        for (int i = 1; i < nums.length; i++) {

            // New unique element found
            if (nums[rd] != nums[i]) {
                rd++;
                nums[rd] = nums[i];
            }
        }

        return rd + 1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("Unique elements count: " + k);
        System.out.println(
                "Array: " + Arrays.toString(Arrays.copyOf(nums, k))
        );
    }
}