# Next Permutation

https://leetcode.com/problems/next-permutation/ 

## Problem Statement
Given an array of integers representing a permutation of numbers, you need to find the **next lexicographical permutation**. If no such permutation exists, return the array sorted in ascending order.

### Example 1:
**Input:** `[1, 2, 3]`  
**Output:** `[1, 3, 2]`

### Example 2:
**Input:** `[3, 2, 1]`  
**Output:** `[1, 2, 3]`

### Example 3:
**Input:** `[1, 1, 5]`  
**Output:** `[1, 5, 1]`

---

## Brute Force Approach (Recursion)
### Idea:
1. **Generate all possible permutations** of the array.
2. **Sort them in ascending order** to ensure they are in lexicographical order.
3. Find the **next permutation** of the given array.

### Code for Brute Force Approach:
```java
import java.util.*;

public class NextPermutation {
    static void generatePermutations(int[] nums, int idx, List<List<Integer>> result) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            result.add(temp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            generatePermutations(nums, idx + 1, result);
            swap(nums, i, idx);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(nums, 0, permutations);
        Collections.sort(permutations, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });
        for (int i = 0; i < permutations.size(); i++) {
            if (permutations.get(i).equals(Arrays.asList(1, 2, 3))) {
                System.out.println("Next permutation: " + permutations.get(i + 1));
                break;
            }
        }
    }
}
```

---

## Optimal Approach (O(n))
### Steps to Follow:
1. **Find the Breakpoint:** Traverse the array from **right to left** and find the first element smaller than its next element. Call this index `idx1`.
2. **Find the Next Greater Element:** Traverse from **right to left** again and find the element greater than `nums[idx1]`. Call this index `idx2`.
3. **Swap Elements:** Swap `nums[idx1]` and `nums[idx2]`.
4. **Reverse the Remaining Elements:** Reverse the subarray starting from `idx1 + 1` to the end.

### Code for Optimal Approach:
```java
import java.util.*;

public class NextPermutationOptimal {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    static void nextPermutation(int[] nums) {
        int idx1 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }

        if (idx1 == -1) {
            reverse(nums, 0);
            return;
        }

        int idx2 = -1;
        for (int i = nums.length - 1; i > idx1; i--) {
            if (nums[i] > nums[idx1]) {
                idx2 = i;
                break;
            }
        }

        swap(nums, idx1, idx2);
        reverse(nums, idx1 + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }
}
```

---

## Complexity Analysis
✅ **Time Complexity:** `O(n)`  
✅ **Space Complexity:** `O(1)` (In-place modification)

---



