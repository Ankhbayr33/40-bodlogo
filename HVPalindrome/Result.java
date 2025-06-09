package HVPalindrome;

public class Result {
    public static String highestValuePalindrome(String s, int n, int k) {
    char[] arr = s.toCharArray();
        boolean[] changed = new boolean[n];

        int left = 0, right = n - 1;

        // Step 1: Make it a palindrome
        while (left < right) {
            if (arr[left] != arr[right]) {
                char maxChar = (char) Math.max(arr[left], arr[right]);
                arr[left] = arr[right] = maxChar;
                changed[left] = true;
                k--;
            }
            left++;
            right--;
        }

        if (k < 0) return "-1";

        // Step 2: Maximize the value
        left = 0;
        right = n - 1;
        while (left <= right) {
            if (left == right) {
                if (k > 0 && arr[left] != '9') {
                    arr[left] = '9';
                    k--;
                }
            } else {
                if (arr[left] != '9') {
                    if (changed[left] && k >= 1) {
                        arr[left] = arr[right] = '9';
                        k--;
                    } else if (!changed[left] && k >= 2) {
                        arr[left] = arr[right] = '9';
                        k -= 2;
                    }
                }
            }
            left++;
            right--;
        }

        return new String(arr);

    }

}
