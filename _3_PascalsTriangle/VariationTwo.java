package _3_PascalsTriangle;
//Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
public class VariationTwo {

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

