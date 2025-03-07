# Pascal's Triangle - Variation 2
https://leetcode.com/problems/pascals-triangle-ii/description/

## Problem Statement

Given the row number `n`, print the `n`-th row of Pascal’s Triangle.

### Example

#### Input

```plaintext
n = 5
```

#### Output

```plaintext
1 4 6 4 1
```

---

## Intuition

Pascal’s Triangle follows the binomial coefficient formula:

- Each element at `(n, k)` is given by the combination formula:

  **nCr = (n-1)C(k-1) = (n-1)! / ((k-1)! * (n-k)!)**

- Using this formula, we can efficiently compute the entire row of Pascal’s Triangle.


## Approach

### **Brute Force Approach**

#### Explanation:

1. Generate the entire Pascal’s Triangle up to row n.
2. Print only the `n`-th row.
3. Uses nested loops, making it less efficient for large `n`.

#### Complexity:

- **Time Complexity:** `O(n^2)`, since we generate all previous rows.
- **Space Complexity:** `O(n^2)`, as we store the entire triangle.

#### Code Implementation (Brute Force)

```java
import java.util.*;

public class codeCrush {
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void pascalTriangle(int n) {
        // printing the entire row n:
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }
}
```

---

### **Optimized Approach (Using nCr Formula)**

#### Explanation:

1. The `n`-th row of Pascal’s Triangle follows the binomial coefficient formula.
2. We compute each element iteratively to avoid large factorial calculations.
3. This avoids storing unnecessary rows, making it more efficient.

#### Complexity:

- **Time Complexity:** `O(n)`, since we compute only `n` elements.
- **Space Complexity:** `O(1)`, as no extra space is used.

#### Code Implementation (Optimized)

```java
import java.util.*;

public class codeCrush {
    static void pascalTriangle(int n) {
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }
}
```

---

## Complexity Analysis

| Approach            | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| **Brute Force**     | `O(n^2)`        | `O(n^2)`         |
| **Optimized (nCr)** | `O(n)`          | `O(1)`           |

---

## Example Walkthrough

### Example 1:

#### Input:

```plaintext
n = 5
```

#### Processing:

- Using `nCr` formula:
  - `5C0 = 1`, `5C1 = 4`, `5C2 = 6`, `5C3 = 4`, `5C4 = 1`

#### Output:

```plaintext
1 4 6 4 1
```

---

### 🚀 If you found this helpful, give a ⭐ to this repository!

