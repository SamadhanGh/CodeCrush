# Rotate Array

This repository contains a solution for the "Rotate Array" problem from LeetCode. The solution uses an efficient in-place rotation technique that runs in O(n) time complexity with O(1) space complexity.

### Problem Description

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

### Approach

1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n-k` elements.

This method achieves the goal in linear time with no extra space required.

### Code

The code implements the approach using a helper function `reverse()` to perform in-place reversal of array segments.

### Example

**Input:**  
`nums = [1,2,3,4,5,6,7], k = 3`

**Output:**  
`[5,6,7,1,2,3,4]`

### Time Complexity
- **O(n)**: We reverse the array three times, and each reversal takes linear time.

### Space Complexity
- **O(1)**: No extra space is used, as we modify the array in place.

### Conclusion

This solution is optimal and works efficiently for large arrays, making it ideal for problems with constraints on time and space.
