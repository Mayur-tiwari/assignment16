import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ass16Q6 {
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        if (k == 0 || k == queue.size()) {
            return;
        }

        Queue<Integer> tempQueue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            tempQueue.add(queue.poll());
        }

        Stack<Integer> stack = new Stack<>();
        while (!tempQueue.isEmpty()) {
            stack.push(tempQueue.poll());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);

        int k = 4;
        reverseKElements(queue, k);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
