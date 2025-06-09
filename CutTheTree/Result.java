package CutTheTree;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
    
int n = data.size();
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] subtreeSum = new int[n];
        boolean[] visited = new boolean[n];

        int totalSum = 0;
        for (int val : data) totalSum += val;

        dfs(0, data, tree, visited, subtreeSum);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(totalSum - 2 * subtreeSum[i]);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    private static int dfs(int node, List<Integer> data, List<List<Integer>> tree, boolean[] visited, int[] subtreeSum) {
        visited[node] = true;
        int sum = data.get(node);
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                sum += dfs(neighbor, data, tree, visited, subtreeSum);
            }
        }
        subtreeSum[node] = sum;
        return sum;
    }
}
