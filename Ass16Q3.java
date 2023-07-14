import java.util.Stack;

public class Ass16Q3 {
    public static void deleteMiddleElement(Stack<Integer> stack) {
        int size = stack.size();
        deleteMiddleElementUtil(stack, size, 0);
    }

    private static void deleteMiddleElementUtil(Stack<Integer> stack, int size, int current) {
        if (stack.empty() || current == size)
            return;

        int x = stack.pop();

        deleteMiddleElementUtil(stack, size, current + 1);

        if (current != size/2)
            stack.push(x);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        deleteMiddleElement(stack);

        System.out.println(stack);
    }
}
