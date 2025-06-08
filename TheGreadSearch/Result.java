package TheGreadSearch;

import java.util.List;

public class Result {
    public static String gridSearch(List<String> G, List<String> P) {
    int R = G.size();
    int C = G.get(0).length();
    int r = P.size();
    int c = P.get(0).length();

    for (int i = 0; i <= R - r; i++) {
        for (int j = 0; j <= C - c; j++) {
            boolean match = true;
            for (int x = 0; x < r; x++) {
                if (!G.get(i + x).substring(j, j + c).equals(P.get(x))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return "YES";
            }
        }
    }
    return "NO";

    }
}
