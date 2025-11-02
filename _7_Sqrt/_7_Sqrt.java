package _7_Sqrt;

public class _7_Sqrt {

    public int mySqrt(int x) {
        if (x < 2) return x; // sqrt(0)=0, sqrt(1)=1 ✅

        int start = 1, end = x / 2, ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2; // safe midpoint

            if (mid <= x / mid) {   // instead of mid*mid <= x ✅ (prevents overflow)
                ans = mid;         // mid is a valid candidate
                start = mid + 1;   // try to find a larger sqrt
            } else {
                end = mid - 1;     // mid*mid > x → go smaller
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _7_Sqrt obj = new _7_Sqrt();   // create object
        int result = obj.mySqrt(3);    // call instance method
        System.out.println(result);    // print result ✅
    }
}
