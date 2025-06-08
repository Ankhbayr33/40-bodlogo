package FullCountingSort;

import java.util.List;

public class Result {
    public static void countSort(List<List<String>> arr) {
        int n = arr.size();
    StringBuilder[] result = new StringBuilder[n];
    
        for (int i = 0; i < n / 2; i++) {
        int index = Integer.parseInt(arr.get(i).get(0));
        if (result[index] == null) result[index] = new StringBuilder();
        result[index].append("- ");
    }
    
        for (int i = n / 2; i < n; i++) {
        int index = Integer.parseInt(arr.get(i).get(0));
        if (result[index] == null) result[index] = new StringBuilder();
        result[index].append(arr.get(i).get(1)).append(" ");
    }
    
    
    StringBuilder output = new StringBuilder();
    for (StringBuilder sb : result) {
        if (sb != null) output.append(sb);
    }
    System.out.println(output.toString().trim());

    }
}
