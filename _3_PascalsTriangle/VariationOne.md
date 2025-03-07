# Pascal's Triangle - Variation 1

## Problem Statement

Given a row number `r` and column number `c`, find the element at position `(r, c)` in Pascal’s Triangle.

### Example

#### Input

```plaintext
r = 5, c = 3
```

#### Output

```plaintext
The element at position (5,3) is: 6
```

---

## Intuition

Pascal’s Triangle follows the binomial coefficient formula:

- Each element at `(r, c)` is given by the combination formula:

  **nCr = n! / (r! \* (n-r)!)**

- Using this formula, we can efficiently compute any element in Pascal’s Triangle.

### Visual Representation



(Insert your image of Pascal's Triangle here)
![Pascal's Triangle](https://github.com/SamadhanGh/CodeCrush/main/main/"C:\Users\sdgho\OneDrive\Pictures\Screenshots\Picture1.png")

## Visual Representation

##



(Insert your image of Pascal's Triangle here)Approach

### **Mathematical Approach (Using nCr Formula)**

#### Explanation:

1. The element at position `(r, c)` is computed using the formula `nCr = (n-1)C(c-1)`.
2. We compute `nCr` iteratively to avoid large factorial calculations.
3. Return the computed value.

#### Complexity:

- **Time Complexity:** `O(c)` (since we only compute up to `rC(c-1)`).
- **Space Complexity:** `O(1)` (constant space used).

---

## Code Implementation (Using nCr Formula)

```java
import java.util.*;

public class codeCrush {
    public static long nCr(int n, int r) {
        long res = 1;

        // Calculating nCr iteratively
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        return (int) nCr(r - 1, c - 1);
    }

    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (" + r + "," + c + ") is: " + element);
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(c)`, since we compute `nCr` in `O(c)` time.
- **Space Complexity:** `O(1)`, as no extra space is used.

---

## Example Walkthrough

### Example 1:

#### Input:

```plaintext
r = 5, c = 3
```

#### Processing:

- Using `nCr` formula: `4C2 = (4*3)/(2*1) = 6`

#### Output:

```plaintext
The element at position (5,3) is: 6
```

---

## Summary

| Approach               | Time Complexity | Space Complexity |
| ---------------------- | --------------- | ---------------- |
| **Mathematical (nCr)** | `O(c)`          | `O(1)`           |

---

### 🚀 If you found this helpful, give a ⭐ to this repository!

