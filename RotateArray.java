
// Class to rotate an array 'nums' by 'k' positions
public class RotateArray {
    // Method to rotate the array
    public void rotate(int[] nums, int k) {
        // If the array is empty or has only one element, no rotation is needed
        if (nums.length <= 1) return;

        // Handle cases where k is larger than the array length by taking the remainder
        k = k % nums.length;

        // Reverse the entire array to prepare for the next rotations
        reverse(nums, 0, nums.length - 1);

        // Reverse the first 'k' elements to restore the original order in the first part
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements to complete the rotation
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse the array between indices 'start' and 'end'
    public void reverse(int[] nums, int start, int end) {
        // Swap the elements until the start index is less than the end index
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
