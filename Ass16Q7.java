import java.util.*;

public class Ass16Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int remainingWords = countRemainingWords(input);
        System.out.println(remainingWords);
    }

    private static int countRemainingWords(String input) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            StringBuilder wordBuilder = new StringBuilder();
            while (i < input.length() && Character.isAlphabetic(ch)) {
                wordBuilder.append(ch);
                i++;
                if (i < input.length())
                    ch = input.charAt(i);
            }

            String word = wordBuilder.toString();

            if (!stack.isEmpty() && stack.peek().equals(word)) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }

        return stack.size();
    }
}
