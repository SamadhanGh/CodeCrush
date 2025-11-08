package _8_FirstNegInWindow;
import java.util.*;

public class FirstNegInWindow {

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

