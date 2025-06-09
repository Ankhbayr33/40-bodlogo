package SwapNodes;
import java.util.List;
import java.util.ArrayList;

class BinaryTree {
    private TreeNode root;

    public BinaryTree(List<List<Integer>> indexes) {
        root = buildTree(indexes);
    }

    private TreeNode buildTree(List<List<Integer>> indexes) {
        TreeNode[] nodes = new TreeNode[indexes.size() + 1];
        for (int i = 1; i <= indexes.size(); i++) {
            nodes[i] = new TreeNode(i);
        }
        for (int i = 0; i < indexes.size(); i++) {
            int leftIndex = indexes.get(i).get(0);
            int rightIndex = indexes.get(i).get(1);
            if (leftIndex != -1 && leftIndex != 0) {
                nodes[i + 1].left = nodes[leftIndex];
            }
            if (rightIndex != -1 && rightIndex != 0) {
                nodes[i + 1].right = nodes[rightIndex];
            }
        }
        return nodes[1];
    }

    public void swapAtDepth(int k) {
        swapAtDepthHelper(root, 1, k);
    }

    private void swapAtDepthHelper(TreeNode node, int depth, int k) {
        if (node == null) return;

        if (depth % k == 0) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        swapAtDepthHelper(node.left, depth + 1, k);
        swapAtDepthHelper(node.right, depth + 1, k);
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.index);
        inorderHelper(node.right, result);
    }
}
