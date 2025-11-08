
---

## 🧾 **Solution.md** — *First Negative Integer in Every Window of Size K*

---

### 📘 **Problem Statement**

Given an array `arr[]` and an integer `k`, find the **first negative integer** in every contiguous subarray (window) of size `k`.
If no negative integer exists in a window, return `0` for that window.

---

### 💡 **Example**

**Input:**
`arr = [12, -1, -7, 8, -15, 30, 16, 28], k = 3`

**Output:**
`[-1, -1, -7, -15, -15, 0]`

**Explanation:**

```
Windows of size 3:
[12, -1, -7]  → -1
[-1, -7, 8]   → -1
[-7, 8, -15]  → -7
[8, -15, 30]  → -15
[-15, 30, 16] → -15
[30, 16, 28]  → 0
```

---

## 🧩 **Approach 1 — Brute Force (O(N×K))**

### 🧠 **Idea**

* Traverse every subarray of size `k`
* For each window, check all elements until the first negative is found
* If none found → store 0

---

### ⚙️ **Code**

```java
import java.util.*;

public class BruteForceSolution {
    public static int[] firstNegInt(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int firstNeg = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    firstNeg = arr[j];
                    break;
                }
            }
            res[i] = firstNeg;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(Arrays.toString(firstNegInt(arr, k)));
    }
}
```

---

### 📊 **Complexity**

| Type      | Complexity      | Explanation                                            |
| --------- | --------------- | ------------------------------------------------------ |
| **Time**  | O(N × K)        | Outer loop runs (N−K+1) times, inner loop runs up to K |
| **Space** | O(N−K+1) ≈ O(N) | Output array stores one result per window              |

---

### ❌ **Drawbacks**

* Re-checks overlapping elements repeatedly
* Not efficient for large arrays (up to 10⁶ elements)

---

## 🚀 **Approach 2 — Optimized (Sliding Window + Queue, O(N))**

### 🧠 **Idea**

* Maintain a **queue** to store negative numbers in the current window (FIFO)
* When window slides:

    * Remove element leaving the window (if it’s negative)
    * Add new element (if it’s negative)
* Front of queue (`peek()`) gives the **first negative**

---

### ⚙️ **Code**

```java
import java.util.*;

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        // Step 1️⃣: Process first window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0)
                queue.offer(arr[i]);
        }
        res.add(queue.isEmpty() ? 0 : queue.peek());

        // Step 2️⃣: Slide the window
        for (int i = k; i < n; i++) {
            // Remove element going out
            if (arr[i - k] < 0)
                queue.poll();

            // Add new element coming in
            if (arr[i] < 0)
                queue.offer(arr[i]);

            // Store first negative for current window
            res.add(queue.isEmpty() ? 0 : queue.peek());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(firstNegInt(arr, k)); // [-1, -1, -7, -15, -15, 0]
    }
}
```

---

### 📊 **Complexity**

| Type      | Complexity | Explanation                                |
| --------- | ---------- | ------------------------------------------ |
| **Time**  | O(N)       | Each element enters & leaves queue once    |
| **Space** | O(K)       | Queue stores at most K elements per window |

---

### ✅ **Advantages**

* Avoids redundant work
* Efficient for large input sizes
* Queue directly maintains relevant negatives only

---

### 🧩 **Summary Comparison**

| Approach    | Time   | Space | Technique              | Key Idea                    |
| ----------- | ------ | ----- | ---------------------- | --------------------------- |
| Brute Force | O(N×K) | O(N)  | Nested loops           | Re-check every window       |
| Optimized   | O(N)   | O(K)  | Sliding Window + Queue | Track negatives dynamically |

---

