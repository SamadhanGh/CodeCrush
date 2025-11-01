package _6_FirstAndLastostion;

public class _6_FirstAndLastPosition {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = solution.searchRange(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    // 🔹 Function to find the first occurrence of target
    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;  // store the position when found
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                ans = mid;
                // 👉 try to move LEFT to find an earlier occurrence
                end = mid - 1;
            } else if (nums[mid] < target) {
                // 👉 move right
                start = mid + 1;
            } else {
                // 👉 move left
                end = mid - 1;
            }
        }
        return ans;
    }

    // 🔹 Function to find the last occurrence of target
    private int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                ans = mid;
                // 👉 try to move RIGHT to find a later occurrence
                start = mid + 1;
            } else if (nums[mid] < target) {
                // 👉 move right
                start = mid + 1;
            } else {
                // 👉 move left
                end = mid - 1;
            }
        }
        return ans;
    }
}
