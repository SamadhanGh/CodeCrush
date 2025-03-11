# Pascal's Triangle - Variation 3

## Problem Statement
Given an integer `numRows`, generate the first `numRows` of Pascal's Triangle.

### Example

#### Input
```plaintext
numRows = 5
```

#### Output
```plaintext
[
    [1],
    [1, 1],
    [1, 2, 1],
    [1, 3, 3, 1],
    [1, 4, 6, 4, 1]
]
```

---

## Intuition
This approach combines elements from both **Variation 1** (complete triangle generation) and **Variation 2** (optimized row generation).

### Key Insight
- For each row:
    - Start with 1.
    - Compute each element as the sum of two values directly above it in the previous row.
    - End with 1.

---

## Brute Force Approach
This approach is a combination of Variation 1 and Variation 2 (using the combination formula).

### Pseudocode:
```
for(row = 1 to n) {
    temp_list = []
    for(col = 1 to row) {
        temp_list.add(hcr(row-1, col-1));
    }
    ans.add(temp_list);
}
return ans;
```

### Complexity Analysis
- **Time Complexity:** `O(n^3)` - Outer loop runs `n` times, and generating each row takes `O(n × n × r)`.
- **Space Complexity:** `O(1)` - Only storing the result, no extra space used.

---

## Optimized Approach

1. Initialize an empty list `result` to store rows.
2. Add the first row `[1]` directly since it's always the same.
3. For each subsequent row:
    - Start the row with `1`.
    - Use a loop to calculate inner elements as the sum of two adjacent elements from the previous row.
    - End the row with `1`.
4. Add the constructed row to the `result` list.
5. Return the final `result` list.

---

## Code Implementation

```java
package _3_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class VariationThree {
    
    List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) return result;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if (numRows == 1) return result;

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);

            // Start the next row
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);

            // Add this new row to final result
            result.add(row);
        }

        return result;
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(n^2)` - Outer loop runs `n` times, and generating each row takes linear time.
- **Space Complexity:** `O(1)` - No extra space is used apart from the result storage.

---

## Example Walkthrough

### Input
```plaintext
numRows = 5
```

### Output
```plaintext
[
    [1],
    [1, 1],
    [1, 2, 1],
    [1, 3, 3, 1],
    [1, 4, 6, 4, 1]
]
```

---

### 🚀 If you found this helpful, give a ⭐ to this repository!

