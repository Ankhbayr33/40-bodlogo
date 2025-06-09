package CastleOnTheGrid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Result {


    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
  
int n = grid.size();

        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        dist[startX][startY] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            if (x == goalX && y == goalY) {
                return dist[x][y];
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                while (nx >= 0 && nx < n && ny >= 0 && ny < n && grid.get(nx).charAt(ny) == '.') {
                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
        }

        return -1;  
    
}
    }