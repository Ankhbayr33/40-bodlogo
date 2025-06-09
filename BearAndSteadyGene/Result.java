package BearAndSteadyGene;

public class Result {
    public static int steadyGene(String gene) {
    int n = gene.length();
    int target = n / 4;

    int[] count = new int[128];
    for (char c : gene.toCharArray()) {
        count[c]++;
    }

    if (count['G'] == target && count['A'] == target &&
        count['C'] == target && count['T'] == target) {
        return 0;
    }

    int minLen = n;
    int left = 0;

    for (int right = 0; right < n; right++) {
        count[gene.charAt(right)]--;

        while (count['G'] <= target && count['A'] <= target &&
               count['C'] <= target && count['T'] <= target) {
            minLen = Math.min(minLen, right - left + 1);
            count[gene.charAt(left)]++;
            left++;
        }
    }

    return minLen;

    }
}
