package TreeHuffmanDecoding;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static Map<Character, String> mapA = new HashMap<>();

    public static Node buildTree(int[] charFreqs) {
        PriorityQueue<Node> trees = new PriorityQueue<>();

        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0) {
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));
            }
        }

        while (trees.size() > 1) {
            Node a = trees.poll();
            Node b = trees.poll();
            trees.offer(new HuffmanNode(a, b));
        }

        return trees.poll();
    }

    public static void printCodes(Node tree, StringBuffer prefix) {
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            mapA.put(leaf.data, prefix.toString());
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String test = input.next();

        int[] charFreqs = new int[256];
        for (char c : test.toCharArray()) {
            charFreqs[c]++;
        }

        Node tree = buildTree(charFreqs);
        printCodes(tree, new StringBuffer());

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        Decoding d = new Decoding();
        d.decode(s.toString(), tree);
    }
}
