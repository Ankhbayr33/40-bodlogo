package NonDivisibleSubset;

import java.util.List;

public class Result {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] count = new int[k];
        for (int num : s) {
            count[num % k]++;
        }

        int result = 0;

        if (count[0] > 0) {
            result++;
        }

        int limit = k / 2;
        for (int i = 1; i <= limit; i++) {
            if (i != k - i) {
                result += Math.max(count[i], count[k - i]);
            }
        }

        if (k % 2 == 0 && count[limit] > 0) {
            result++;
        }

        return result;

    }

}
