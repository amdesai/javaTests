package algoProblemSolutions.strings;

public class ReverseVowels {
    /*

    Write a function that takes a string as input and reverse only the vowels of a string.

    Example 1:
    Given s = "hello", return "holle".

    Example 2:
    Given s = "leetcode", return "leotcede".

    vowels: "aeiou"

    l  e  e  t  c  o  a  d  e
    0 1  2 3  4  5  6  7  8
                      ^
    l  e  a  t  c  o  e  d  e

    */

    public static void main(String ... args) {

        String input = "laetcaeaeaeid";

        System.out.println(input);
        System.out.println(new ReverseVowels().reverseVowels(input));

    }


    String reverseVowels(String data) {
        if (data == null || data.length() < 2) {
            return data;
        }
        char[] dataChars = data.toCharArray();
        String vowels = "aeiou";
        int f = 0;
        int b = data.length() - 1;
        while (f < b) {
            if (vowels.contains(String.valueOf(dataChars[f])) && vowels.contains(String.valueOf(dataChars[b]))) {
                //swap
                char tmp = dataChars[f];
                dataChars[f] = dataChars[b];
                dataChars[b] = tmp;
                f++;
                b--;
            } else {
                // update pointers
                if (!vowels.contains(String.valueOf(dataChars[f]))) {
                    f++;
                }
                if (!vowels.contains(String.valueOf(dataChars[b]))) {
                    b--;
                }
            }
        }
        return String.valueOf(dataChars);
    }
}