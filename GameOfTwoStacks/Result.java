package GameOfTwoStacks;

import java.util.List;

class Result {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    int sum = 0, count = 0, i = 0, j = 0;

        while (i < a.size() && sum + a.get(i) <= maxSum) {
            sum += a.get(i);
            i++;
        }

        count = i;

        while (j < b.size() && i >= 0) {
            sum += b.get(j);
            j++;

            while (sum > maxSum && i > 0) {
                i--;
                sum -= a.get(i);
            }

            if (sum <= maxSum) {
                count = Math.max(count, i + j);
            }
        }

        return count;

    }

}
