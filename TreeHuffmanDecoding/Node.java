package TreeHuffmanDecoding;

abstract class Node implements Comparable<Node> {
    public int frequency; 
    public char data;     
    public Node left, right; 
    public Node(int freq) {
        frequency = freq;
    }

    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }

}
