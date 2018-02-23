package randomAnitest.strings;

public class AtoI {

/*

function takes a string (which represents an integer) as an argument and returns its value

input = "34275"
return int - 34275

	3 4 2 7 5
	0 1 2 3 4

	5 -> 5
	7 -> 70
	2 -> 200
	4 -> 4000
	3 -> 30000

	sum => ans

	convert a char to integer digit.

	'0' -> ASCII value say 116
	'4' -> ASCII value 0's value 116 + 4 -> 120
	so 120 - 166 = 4 (i.e. int value of char '4')

	so to generalize any int's ASCII char value - 0's ASCII value = the int itself

	Assumption: we are not handling the sign (+/-) of the number
	add this would be a simple extension of the function - just check whether there is a non-digit
	char in the first index of the string array and process it separately.
	also we are not handling decimals as it is given that the input will be an integer
	also, to handle a decimal point we can extend the same logic by splitting the whole and fractional parts
	of the number
*/

    public static void main(String ... args) throws Exception {

        String input = "79300397";

        System.out.println(new AtoI().convertStringToInteger(input));

    }

    int convertStringToInteger(String s) throws Exception {

        // validate input
        if (!isNumeric(s)) { // check for any characters other than [0-9]
            throw new Exception("NaN");
        }
        char[] cArr = s.toCharArray();
        int ans = 0;
        int pow = 0;
        for (int i = cArr.length-1; i >= 0; i--) {
            int digit = convertDigitFromCharToInt(cArr[i]);
            ans += digit * (Math.pow(10, pow));
            pow++;
        }
        return ans;
    }

    int convertDigitFromCharToInt (char n) {
        return n - '0'; // ASCII values are integers
    }

    boolean isNumeric(String s) {
        for (char c: s.toCharArray()) {
            int digit = c - '0';
            if (digit < 0 || 9 < digit) {
                return false;
            }
        }
        return true;
    }
}
