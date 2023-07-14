import java.util.Arrays;
import java.util.Stack;

public class Ass16Q8 {
    public static int maxDifference(int[] arr) {
        int n = arr.length;

        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Arrays.fill(leftSmaller, 0);
        Arrays.fill(rightSmaller, 0);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftSmaller[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightSmaller[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 8};
        System.out.println(maxDifference(arr));

        int[] arr2 = {2, 4, 8, 7, 7, 9, 3};
        System.out.println(maxDifference(arr2));

        int[] arr3 = {5, 1, 9, 2, 5, 1, 7};
        System.out.println(maxDifference(arr3));
    }
}
