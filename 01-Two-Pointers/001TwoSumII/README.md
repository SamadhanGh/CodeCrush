# 001 - Two Sum II (Input Array Is Sorted)

## Problem
Given an array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific `target` number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:
```
Input: numbers = [1,2,3,4,6], target = 6
Output: [2,4]
Explanation: 2nd element (2) + 4th element (4) = 6
```

## Constraints
- 2 <= numbers.length <= 3 * 10^4
- -1000 <= numbers[i] <= 1000
- numbers is sorted in non-decreasing order
- -1000 <= target <= 1000

## Approach (Two Pointers)
Because the array is sorted, we can use the two-pointer technique to find the pair in O(n) time and O(1) extra space.

1. Initialize two pointers, `left = 0` and `right = n - 1`.
2. While `left < right`:
   - compute `sum = numbers[left] + numbers[right]`
   - if `sum == target` → return `[left + 1, right + 1]` (1-indexed)
   - if `sum < target` → increment `left` (we need a bigger sum)
   - else → decrement `right` (we need a smaller sum)

### Visual Example
numbers: [1, 2, 3, 4, 6], target = 6
- left=0 (1), right=4 (6) → sum=7 > 6 → right--
- left=0 (1), right=3 (4) → sum=5 < 6 → left++
- left=1 (2), right=3 (4) → sum=6 == target → answer [2,4]

## Complexity
- Time: O(n) — single pass with two pointers
- Space: O(1) — only two pointer variables (output excluded)

## Pseudocode
```
left = 0
right = n - 1
while left < right:
  sum = numbers[left] + numbers[right]
  if sum == target: return [left+1, right+1]
  if sum < target: left++
  else: right--
```

---

This folder contains a reference Java solution in Solution.java.
