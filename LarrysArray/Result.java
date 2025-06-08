package LarrysArray;

import java.util.List;

public class Result {
    public static String larrysArray(List<Integer> A) {
    int inversions = 0;
        int n = A.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(i) > A.get(j)) {
                    inversions++;
                }
            }
        }
        return (inversions % 2 == 0) ? "YES" : "NO";

    }

}
