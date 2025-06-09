package TreeHuffmanDecoding;

class Decoding {
    void decode(String s, Node root) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);
            current = (bit == '0') ? current.left : current.right;

            if (current.left == null && current.right == null) {
                System.out.print(current.data);
                current = root;
            }
        }
    }
}

