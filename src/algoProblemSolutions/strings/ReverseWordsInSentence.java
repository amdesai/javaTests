package algoProblemSolutions.strings;

public class ReverseWordsInSentence {

    public static void main(String[] args) {
        String sent = "is it is it";
        System.out.println(reverseWords(sent));
    }

    /*

    "this is"
    "is this"

    find words - store them in a list
    iterate on the list backwards and add spaces in between words.
    takes up O(n) additional space.

    reverse(s, 0, s.length()-1)
    reverse(s, ws, we)
    */

    private static String reverseWords(String sent) {
        if (sent==null || sent.isEmpty()) {
            return "";
        }
        char[] chars = sent.toCharArray();
        reverseRange(chars, 0, sent.length()-1);
        int s = 0;
        int e = 0;
        for (int i = 0; i < sent.length(); ++i) {
            if (chars[i] == ' ') { // end the last word
                reverseRange(chars, s, e-1);
                s = i+1;
                e = i+1;
            } else {
                e++;
            }
        }
        reverseRange(chars, s, e-1);
        return String.valueOf(chars);
    }

    private static void reverseRange(char[] chars, int l, int r) {
        while(l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r]=tmp;
            l++;
            r--;
        }
    }

}
