package Encryption;

public class Result {
    public static String encryption(String s) {
  s = s.replaceAll(" ", "");
    int L = s.length();
    int rows = (int)Math.floor(Math.sqrt(L));
    int cols = (int)Math.ceil(Math.sqrt(L));
    if (rows * cols < L) {
        rows++;
    }

    StringBuilder encrypted = new StringBuilder();

    for (int c = 0; c < cols; c++) {
        for (int r = 0; r < rows; r++) {
            int index = r * cols + c;
            if (index < L) {
                encrypted.append(s.charAt(index));
            }
        }
        encrypted.append(' ');
    }

    return encrypted.toString().trim();

    }
}
