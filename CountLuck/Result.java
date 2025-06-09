package CountLuck;

import java.util.ArrayList;
import java.util.List;

public class Result {
      public static String countLuck(List<String> matrix, int k) {
  int n = matrix.size();
    int m = matrix.get(0).length();
    char[][] grid = new char[n][m];
    boolean[][] visited = new boolean[n][m];
    int startX = 0, startY = 0;

    for (int i = 0; i < n; i++) {
        grid[i] = matrix.get(i).toCharArray();
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'M') {
                startX = i;
                startY = j;
            }
        }
    }

    int actualChoices = dfs(grid, visited, startX, startY);
    return (actualChoices == k) ? "Impressed" : "Oops!";
}

private static int dfs(char[][] grid, boolean[][] visited, int x, int y) {
    int n = grid.length;
    int m = grid[0].length;
    if (grid[x][y] == '*') return 0;

    visited[x][y] = true;

    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    List<int[]> nextMoves = new ArrayList<>();

    for (int[] d : dirs) {
        int nx = x + d[0];
        int ny = y + d[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
            !visited[nx][ny] && grid[nx][ny] != 'X') {
            nextMoves.add(new int[]{nx, ny});
        }
    }

    for (int[] move : nextMoves) {
        int res = dfs(grid, visited, move[0], move[1]);
        if (res != -1) {
            return res + (nextMoves.size() > 1 ? 1 : 0);
        }
    }

    return -1; 

    }
}
