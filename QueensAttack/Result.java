package QueensAttack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) { 
    int up = n - r_q;
    int down = r_q - 1;
    int right = n - c_q;
    int left = c_q - 1;
    int upRight = Math.min(up, right);
    int upLeft = Math.min(up, left);
    int downRight = Math.min(down, right);
    int downLeft = Math.min(down, left);
    Set<String> obstacleSet = new HashSet<>();
    for (List<Integer> obstacle : obstacles) {
        obstacleSet.add(obstacle.get(0) + "," + obstacle.get(1));
    }

    int attackableSquares = 0;
    int[][] directions = {
        {1, 0},    // up
        {-1, 0},   // down
        {0, 1},    // right
        {0, -1},   // left
        {1, 1},    // up-right
        {1, -1},   // up-left
        {-1, 1},   // down-right
        {-1, -1}   // down-left
    };

    for (int[] dir : directions) {
        int row = r_q + dir[0];
        int col = c_q + dir[1];
        while (row >= 1 && row <= n && col >= 1 && col <= n) {
            if (obstacleSet.contains(row + "," + col)) break;
            attackableSquares++;
            row += dir[0];
            col += dir[1];
        }
    }

    return attackableSquares;
    }
}
