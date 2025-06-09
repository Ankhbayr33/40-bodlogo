package LargestRectangle;

import java.util.List;
import java.util.Stack;

public class Result {
    public static long largestRectangle(List<Integer> h) {
     Stack<Integer> stack = new Stack<>();
    long maxArea = 0;
    int i = 0;
    int n = h.size();

    while (i < n) {
        if (stack.isEmpty() || h.get(i) >= h.get(stack.peek())) {
            stack.push(i++);
        } else {
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            long area = (long) h.get(top) * width;
            maxArea = Math.max(maxArea, area);
        }
    }

    while (!stack.isEmpty()) {
        int top = stack.pop();
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        long area = (long) h.get(top) * width;
        maxArea = Math.max(maxArea, area);
    }

    return maxArea;

    }
}
