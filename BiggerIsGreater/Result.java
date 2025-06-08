package BiggerIsGreater;

import java.util.Arrays;

public class Result {
    public static String biggerIsGreater(String w) {
char[] chars = w.toCharArray();
    int i = chars.length - 2;

    while (i >= 0 && chars[i] >= chars[i + 1]) {
        i--;
    }

    if (i == -1) {
        return "no answer";
    }

    int j = chars.length - 1;
    while (chars[j] <= chars[i]) {
        j--;
    }

    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;

    Arrays.sort(chars, i + 1, chars.length);

    return new String(chars);
    }
}
