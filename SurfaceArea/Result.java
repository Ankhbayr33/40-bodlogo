package SurfaceArea;

import java.util.List;

public class Result {
     public static int surfaceArea(List<List<Integer>> A) {
   int H = A.size();
        int W = A.get(0).size();

        int surfaceArea = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int height = A.get(i).get(j);

                if (height > 0) {
                    // Top and bottom surface areas
                    surfaceArea += 2;

                    // Check cell above
                    int up = (i == 0) ? 0 : A.get(i - 1).get(j);
                    surfaceArea += Math.max(height - up, 0);

                    // Check cell below
                    int down = (i == H - 1) ? 0 : A.get(i + 1).get(j);
                    surfaceArea += Math.max(height - down, 0);

                    // Check cell left
                    int left = (j == 0) ? 0 : A.get(i).get(j - 1);
                    surfaceArea += Math.max(height - left, 0);

                    // Check cell right
                    int right = (j == W - 1) ? 0 : A.get(i).get(j + 1);
                    surfaceArea += Math.max(height - right, 0);
                }
            }
        }
        return surfaceArea;
    }
}
