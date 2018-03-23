package algoProblemSolutions.arrays;

public class NearestPalindrome {

    public static void main(String[] args) {
        System.out.println(new NearestPalindrome().nearestPalindromic("230"));
    }

    public String nearestPalindromic(String num) {

        if (num == null || num.length() == 0) return "";
        int n = num.length();

        int leftLim = 0; int rightLim = 0;

        if (n % 2 == 0) {
            rightLim = n / 2;
            leftLim = rightLim - 1;
        } else {
            rightLim = 1 + (n / 2);
            leftLim = (n / 2) - 1;
        }

        int l = 0;
        int r = n-1;

        char[] newNum = num.toCharArray();
        char[] oldNum = num.toCharArray();
        boolean replaced = false;
        while (l <= leftLim && r >= rightLim) {
            if (oldNum[l] != oldNum[r]) {
                replaced = true;
                newNum[l] = oldNum[l];
                newNum[r] = oldNum[l];
            }
            l++;
            r--;
        }

        if (!replaced) { // the number was a palindrome to begin with
            if (n % 2 == 0) {
                newNum[l] = oldNum[l] == '0'? '1': (char) (oldNum[l] - 1);
                newNum[r] = oldNum[l] == '0'? '1': (char) (oldNum[r] - 1);
            } else {
                newNum[l] = oldNum[l] == '0'? '1': (char) (oldNum[l] - 1);
            }
        }
        return String.valueOf(newNum);
    }
}