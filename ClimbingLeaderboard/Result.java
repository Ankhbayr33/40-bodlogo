package ClimbingLeaderboard;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    List<Integer> distinctRanked = new ArrayList<>();
        distinctRanked.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                distinctRanked.add(ranked.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        int index = distinctRanked.size() - 1;

        for (int score : player) {
            while (index >= 0 && score >= distinctRanked.get(index)) {
                index--;
            }
            result.add(index + 2);
        }

        return result;
    }
}
