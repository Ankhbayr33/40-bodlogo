package AlmostSorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    public static void almostSorted(List<Integer> arr) {
        List<Integer> sortedArr = new ArrayList<>(arr);
    Collections.sort(sortedArr);

    // If already sorted, print yes and return
    if (arr.equals(sortedArr)) {
        System.out.println("yes");
        return;
    }

    int n = arr.size();
    int left = 0;
    int right = n - 1;

    // Find the first index from left where arr and sortedArr differ
    while (left < n && arr.get(left).equals(sortedArr.get(left))) {
        left++;
    }

    // Find the first index from right where arr and sortedArr differ
    while (right >= 0 && arr.get(right).equals(sortedArr.get(right))) {
        right--;
    }

    // Try swap operation: swap elements at left and right and check if sorted
    List<Integer> swappedArr = new ArrayList<>(arr);
    Collections.swap(swappedArr, left, right);

    if (swappedArr.equals(sortedArr)) {
        System.out.println("yes");
        System.out.println("swap " + (left + 1) + " " + (right + 1));
        return;
    }

    // Try reverse operation: reverse the subarray from left to right and check if sorted
    List<Integer> reversedArr = new ArrayList<>(arr);
    List<Integer> subList = reversedArr.subList(left, right + 1);
    Collections.reverse(subList);

    if (reversedArr.equals(sortedArr)) {
        System.out.println("yes");
        System.out.println("reverse " + (left + 1) + " " + (right + 1));
        return;
    }

    // If neither swap nor reverse sorts the array, print no
    System.out.println("no");

    }
}
