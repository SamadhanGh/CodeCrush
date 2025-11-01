
---

### 📘 **solution.md**

#### 🧩 Problem Statement:

Given a sorted array `nums` and a target value `target`, return the **starting and ending position** of `target` in the array.
If `target` is not found, return `[-1, -1]`.

Example:

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

---

#### ⚙️ Approach:

We use **binary search** twice:

1. **First binary search** → finds the **first occurrence** of the target.
   Once found, move **left** to check for earlier occurrences.
2. **Second binary search** → finds the **last occurrence** of the target.
   Once found, move **right** to check for later occurrences.

Both searches are **O(log n)**, so total complexity remains **O(log n)**.

---

#### 🧠 Algorithm Steps:

1. Initialize `start = 0`, `end = nums.length - 1`, and `ans = -1`.
2. Perform binary search:

    * If `nums[mid] == target`, store `ans = mid`.
    * To find **first**, move `end = mid - 1`.
    * To find **last**, move `start = mid + 1`.
3. Return `[first, last]`.

---

#### 💡 Example Dry Run:

```
nums = [5,7,7,8,8,10], target = 8
Binary search #1 → first occurrence
mid = 2 → 7 < 8 → move right
mid = 4 → 8 == 8 → ans = 4 → move left
mid = 3 → 8 == 8 → ans = 3 → move left (end = 2)
Result: first = 3

Binary search #2 → last occurrence
mid = 2 → 7 < 8 → move right
mid = 4 → 8 == 8 → ans = 4 → move right
mid = 5 → 10 > 8 → move left
Result: last = 4

Final Output = [3, 4]
```

---

#### 🧮 Time and Space Complexity:

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(log n)   |
| Space | O(1)       |

---


