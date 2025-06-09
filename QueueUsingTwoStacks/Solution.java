package QueueUsingTwoStacks;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stackNewestOnTop = new Stack<>(); // Энqueue-д зориулсан стек
        Stack<Integer> stackOldestOnTop = new Stack<>(); // Деqueue болон peek-д зориулсан стек

        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int value = scanner.nextInt();
                stackNewestOnTop.push(value); // enqueue
            } else if (type == 2) {
                shiftStacks(stackNewestOnTop, stackOldestOnTop);
                stackOldestOnTop.pop(); // dequeue
            } else if (type == 3) {
                shiftStacks(stackNewestOnTop, stackOldestOnTop);
                System.out.println(stackOldestOnTop.peek()); // print front
            }
        }

        scanner.close();
    }

    // stackOldest хоосон үед stackNewest-ийн бүх элементийг буцааж хийнэ
    private static void shiftStacks(Stack<Integer> stackNewest, Stack<Integer> stackOldest) {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}

