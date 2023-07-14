import java.util.*;

public class Ass16Q4 {
    public static boolean canArrangeInIncreasingOrder(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> anotherQueue = new LinkedList<>();

        int expectedNumber = 1;

        while (!queue.isEmpty()) {
            int currentNumber = queue.poll();

            if (currentNumber == expectedNumber) {
                anotherQueue.add(currentNumber);
                expectedNumber++;

                while (!stack.isEmpty() && stack.peek() == expectedNumber) {
                    int poppedNumber = stack.pop();
                    anotherQueue.add(poppedNumber);
                    expectedNumber++;
                }
            } else {
                if (!stack.isEmpty() && stack.peek() < currentNumber) {
                    return false;
                }

                stack.push(currentNumber);
            }
        }

        while (!stack.isEmpty()) {
            int poppedNumber = stack.pop();
            anotherQueue.add(poppedNumber);
        }

        while (!anotherQueue.isEmpty()) {
            int currentNumber = anotherQueue.poll();

            if (currentNumber != expectedNumber) {
                return false;
            }

            expectedNumber++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            queue.add(num);
        }

        boolean result = canArrangeInIncreasingOrder(queue);
        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
