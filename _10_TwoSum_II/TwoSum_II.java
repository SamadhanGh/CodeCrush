package _10_TwoSum_II;

import java.util.Arrays;

public class TwoSum_II {

    public int[] twoSum(int[] nums, int target) {

        // Step 1: Sort the array (if not already sorted)
        Arrays.sort(nums);

        // Step 2: Initialize pointers
        int left = 0;
        int right = nums.length - 1;

        // Step 3: Use two-pointer technique
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                // return 1-based indices (if required)
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;  // need a bigger sum
            } else {
                right--; // need a smaller sum
            }
        }

        // Step 4: No pair found
        return new int[]{};
    }

    public static void main(String[] args) {
        int nums[] = {2, 4, 6, 7, 8};
        int target = 10;

        // Create object because twoSum is non-static
        TwoSum_II obj = new TwoSum_II();

        // Call method
        int[] result = obj.twoSum(nums, target);

        // Print array properly
        System.out.println("Result: " + Arrays.toString(result));
    }
}
