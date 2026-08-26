public class Solution {
    /**
     * Two-pointer solution for Two Sum II - Input array is sorted.
     * Returns 1-based indices of the two numbers that add up to target.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // return 1-based indices
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++; // need larger sum
            } else {
                right--; // need smaller sum
            }
        }
        // As per problem statement there is exactly one solution, but
        // return a fallback in case input is unexpected.
        return new int[] { -1, -1 };
    }

    // Simple main to run a quick check locally
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {1, 2, 3, 4, 6};
        int target = 6;
        int[] ans = sol.twoSum(numbers, target);
        System.out.println("Indices: [" + ans[0] + ", " + ans[1] + "]");
    }
}
