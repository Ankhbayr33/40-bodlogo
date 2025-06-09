package SelfBalancingTree;

class Solution {

    static Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            node.ht = 0;
            return node;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        root.ht = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

  
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = 1 + Math.max(height(x.left), height(x.right));
        y.ht = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = 1 + Math.max(height(y.left), height(y.right));
        x.ht = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    static int height(Node node) {
        return node == null ? -1 : node.ht;
    }

    static int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
}
