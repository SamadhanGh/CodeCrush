
---

````markdown
# 🚀 Max Sum Subarray of Size K (Sliding Window)

A simple and efficient **Java program** to find the maximum sum of any contiguous subarray of size `k` using the **Sliding Window Technique**.

---

## 🧩 Problem Statement

Given an array of integers `a[]` and an integer `k`, find the **maximum sum** of any subarray of size `k`.

### Example

```text
Input:
a = [2, 9, 31, -4, 21, 7]
k = 3

Subarrays of size 3:
[2, 9, 31]   → 42  
[9, 31, -4]  → 36  
[31, -4, 21] → 48  
[-4, 21, 7]  → 24  

✅ Output: 48
````

---

## 💡 Intuition

When the window moves forward, only **one element leaves** and **one new element enters**.
So instead of recalculating the full sum each time,
we **subtract the outgoing element** and **add the new incoming element**.

This saves time and gives an **O(n)** solution.

---

## 🪟 Sliding Window Diagram

```
Initial window (k = 3):
[ 2, 9, 31, -4, 21, 7 ]
  ↑--------↑
  Window 1 → sum = 42

Slide 1 step →
[ 2, 9, 31, -4, 21, 7 ]
     ↑--------↑
     Window 2 → sum = (42 - 2 + -4) = 36

Next →
[ 2, 9, 31, -4, 21, 7 ]
         ↑--------↑
         Window 3 → sum = (36 - 9 + 21) = 48 ✅

And so on...
```

🧠 Think of it like a **train of k coaches 🚆** —
when the train moves forward, one coach leaves and one new coach joins;
you just adjust the total weight (sum) instead of recounting everything.

---

## ⚙️ Algorithm Steps

1. Calculate sum of the first `k` elements → `wSum`.
2. Initialize `mSum = wSum`.
3. For each next element from index `k` to `n-1`:

    * Subtract the element leaving the window.
    * Add the new element entering the window.
    * Update `mSum = max(mSum, wSum)`.
4. Return `mSum`.

---

## ⏱️ Complexity

| Type  | Complexity | Explanation                    |
| ----- | ---------- | ------------------------------ |
| Time  | **O(n)**   | Each element is processed once |
| Space | **O(1)**   | Only a few variables used      |

---

## 💻 Java Code

```java
package _5_MaxSumSubArrayOfSizeK;

// Using the Sliding Window Technique
public class MaxSumOfSubArrayOfSizeK {

    static int maxSumSubArray(int[] a, int k) {
        if (a == null || a.length < k) {
            throw new IllegalArgumentException("Array must have at least k elements");
        }

        int wSum = 0;
        // Step 1: Calculate first window sum
        for (int i = 0; i < k; i++) {
            wSum += a[i];
        }

        int mSum = wSum; // Initialize max sum with first window sum

        // Step 2: Slide the window
        for (int i = k; i < a.length; i++) {
            wSum = wSum - a[i - k] + a[i];
            mSum = Math.max(mSum, wSum);
        }

        return mSum;
    }

    public static void main(String[] args) {
        int[] a = {2, 9, 31, -4, 21, 7};
        int k = 3;
        System.out.println(maxSumSubArray(a, k)); // Output: 48
    }
}
```

---

## ▶️ How to Run

```bash
javac MaxSumOfSubArrayOfSizeK.java
java MaxSumOfSubArrayOfSizeK
```

✅ Output:

```
48
```

---

## ⚠️ Edge Cases

| Case             | Description                  |
| ---------------- | ---------------------------- |
| `k > n`          | Invalid input                |
| `k == n`         | Result = sum of entire array |
| Negative numbers | Works fine                   |
| `k == 1`         | Just return max element      |

---
---

✨ **Sliding Window Technique — Smart, Simple, and Powerful!** ✨



