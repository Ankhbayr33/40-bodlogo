package SwapNodes;
import java.util.*;

class Result {
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        BinaryTree tree = new BinaryTree(indexes);

        for (int k : queries) {
            tree.swapAtDepth(k);
            result.add(tree.inorderTraversal());
        }

        return result;
    }
}


