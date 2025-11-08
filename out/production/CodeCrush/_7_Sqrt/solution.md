
1. **How did `mid * mid <= x` become `mid <= x / mid`?**
2. **Why do we even do this?**

Let’s answer both clearly.

---

## ✅ 1️⃣ First, what are we trying to check?

We want to know:

```
Is mid² <= x ?
```

Because if `mid * mid` is **less than or equal** to `x`, then `mid` **might be the square root or smaller**.

Example:

```
x = 16
mid = 4
4 * 4 = 16 ✅ still valid
```

So **original check is correct**:

```java
if (mid * mid <= x)
```

---

## ❌ 2️⃣ But why can’t we write `mid * mid` ?

Because **mid * mid can overflow** in Java.

Example:

```
mid = 50000
mid * mid = 2,500,000,000  (2.5 billion)
```

But `int` max in Java = `2,147,483,647`
So result **overflows** → becomes negative → program breaks → while loop never ends → **TLE**

✅ So we need a **safe way** to check the same condition **without multiplying mid * mid**.

---

## ✅ 3️⃣ How do we convert safely? (Without overflow)

We start with:

```
mid * mid <= x
```

If we divide **both sides** by `mid` (only if mid > 0), we get:

```
mid <= x / mid
```

🔍 Example:

```
4 * 4 <= 16
4 <= 16 / 4
4 <= 4 ✅ same meaning
```

✅ No multiplication
✅ No overflow
✅ Math stays correct

---

## 🤔 But why dividing works?

Because:

```
mid * mid <= x
```

Divide both sides by **mid**:

```
mid <= x / mid
```

This only works because **mid is positive** (binary search ensures that).

So **both conditions mean the exact same thing**, but one is safe and one is unsafe.

---

## ✅ Final summary

| Version          | Is it safe? | Can overflow? | Why?                       |
| ---------------- | ----------- | ------------- | -------------------------- |
| `mid * mid <= x` | ❌ No        | ✅ Yes         | multiplies 2 big ints      |
| `mid <= x / mid` | ✅ Yes       | ❌ No          | just division, no overflow |

---

## 🔥 Proof with big number (your LeetCode test):

```
x = 2147395599
mid = 46341
```

❌ Overflow version:

```
mid * mid = 2147488281  --> OVERFLOW (becomes negative)
wrong result ❌
```

✅ Safe version:

```
x / mid = 2147395599 / 46341 = 46340
mid <= x / mid  → 46341 <= 46340 → false ✅ correct
```

---

