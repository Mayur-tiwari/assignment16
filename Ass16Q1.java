import java.util.*;
public class Ass16Q1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int[] result = findNearestElementWithHigherFrequency(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findNearestElementWithHigherFrequency(int[] arr) {
        int[] freq = new int[101];
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = arr.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            freq[arr[i]]++;
            indexMap.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            int nearestIndex = Integer.MAX_VALUE;
            int nearestElement = -1;

            for (int j = arr[i] + 1; j <= 100; j++) {
                if (freq[j] > freq[arr[i]] && indexMap.get(j) < nearestIndex) {
                    nearestIndex = indexMap.get(j);
                    nearestElement = j;
                }
            }

            result[i] = (nearestElement == -1) ? -1 : nearestElement;
        }

        return result;
    }
}
