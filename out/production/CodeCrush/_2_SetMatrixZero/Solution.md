# Set Matrix Zeroes
https://leetcode.com/problems/set-matrix-zeroes/description/
## Problem Statement
Given an `m x n` integer matrix, modify it **in-place** such that if an element is `0`, its entire row and column are set to `0`.

## Intuition
To solve this problem efficiently, we need to track which rows and columns should be set to zero without using extra space for a separate tracking matrix. Instead, we can leverage the **first row and first column** of the matrix itself as markers. This allows us to achieve an optimal **O(1) space complexity** while keeping the solution **O(m * n) in time complexity**.

## Approaches

### 1. Brute Force Approach
#### Explanation:
- Traverse the matrix and store the locations of all `0`s in a separate list.
- In a second pass, update the corresponding rows and columns to `0`.

#### Complexity:
- **Time Complexity**: O(m * n + m * n) = O(m * n)
- **Space Complexity**: O(m + n) (to store row and column markers separately)

---

### 2. Better Approach (Using Extra Arrays)
#### Explanation:
- Maintain two arrays: `row[]` and `col[]` to mark which rows and columns should be zeroed.
- First pass: Fill `row[]` and `col[]` based on encountered `0`s.
- Second pass: Use `row[]` and `col[]` to update the matrix.

#### Complexity:
- **Time Complexity**: O(m * n)
- **Space Complexity**: O(m + n) (extra arrays used)

---

### 3. Optimal Approach (Using First Row and First Column as Markers)
#### Explanation:
- Instead of using extra arrays, **use the first row and first column as markers**.
- First pass:
    - Mark rows and columns that need to be set to `0` using the first row and first column.
    - Also track if the **first row or first column itself should be zeroed**.
- Second pass:
    - Use the markers to set elements to `0`.
- Third pass:
    - Handle the **first row and first column separately** based on stored flags.

#### Complexity:
- **Time Complexity**: O(m * n)
- **Space Complexity**: O(1) (no extra space used)

## Code Implementation (Optimal Approach)

```java
class Solution {
  public void setZeroes(int[][] matrix) {
    boolean firstRow = false, firstCol = false;

    // Set markers in first row and first column
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (matrix[i][j] == 0) {
          if (i == 0) firstRow = true;
          if (j == 0) firstCol = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }

    // Replace inner matrix
    for (int i = 1; i < matrix.length; i++)
      for (int j = 1; j < matrix[0].length; j++)
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;

    // Last remaining checks
    if (firstRow)
      for (int j = 0; j < matrix[0].length; j++)
        matrix[0][j] = 0;

    if (firstCol)
      for (int i = 0; i < matrix.length; i++)
        matrix[i][0] = 0;
  }
}
```

## Complexity Analysis
- **Time Complexity**: O(m * n)
- **Space Complexity**: O(1)

## Example Walkthrough
### Example 1:
#### Input:
```
[[1,1,1],
 [1,0,1],
 [1,1,1]]
```
#### Processing:
- `matrix[1][1]` is `0`, so we mark row `1` and column `1`.
- Using markers, update the matrix.
- Adjust the first row and column.

#### Output:
```
[[1,0,1],
 [0,0,0],
 [1,0,1]]
```

---

### Example 2:
#### Input:
```
[[0,1]]
```
#### Output:
```
[[0,0]]
```

## Summary
- **Brute Force**: Extra list, O(m*n) time, O(m+n) space.
- **Better**: Extra arrays, O(m*n) time, O(m+n) space.
- **Optimal**: In-place marking, O(m*n) time, O(1) space.

