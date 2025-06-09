package SimpleTextEditor;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();  
        sc.nextLine();         

        StringBuilder current = new StringBuilder(); 
        Stack<String> history = new Stack<>();       

        for (int i = 0; i < Q; i++) {
            String[] parts = sc.nextLine().split(" ");
            int command = Integer.parseInt(parts[0]);

            switch (command) {
                case 1:

                    history.push(current.toString()); 
                    current.append(parts[1]);
                    break;

                case 2:
    
                    history.push(current.toString()); 
                    int k = Integer.parseInt(parts[1]);
                    current.delete(current.length() - k, current.length());
                    break;

                case 3:
                    int pos = Integer.parseInt(parts[1]) - 1;
                    System.out.println(current.charAt(pos));
                    break;

                case 4:
                    if (!history.isEmpty()) {
                        current = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
    }
}
