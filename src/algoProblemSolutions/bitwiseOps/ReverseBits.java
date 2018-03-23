package algoProblemSolutions.bitwiseOps;

    /*
    Reverse bits of a given 32 bits unsigned integer.
    For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
    Follow up:
    If this function is called many times, how would you optimize it?
    Related problem: Reverse Integer
    1101 0000 1010 1001 001
    n = 1  0  0
    bit = n % 2
    n = n / 2

    */

public class ReverseBits {

    public static void main(String ... args) {

//        System.out.println("43261596 reversed is: " + Integer.toUnsignedString(new ReverseBits().reverseBits(43261596)));
//        System.out.println("43261596 reversed is: " + Integer.reverse(43261596)); // java's own library method
        System.out.println(Integer.toBinaryString(0x55555555));

    }

    public int reverseBits(int n) {
//        System.out.println(Integer.toBinaryString(n));
        int rev = 0;
        int cnt = 0;
        while (cnt < 32) { // n
            rev += n & 1;
            n = n >>> 1; // shift 1 bit to the left - unsigned
//            System.out.println(n);
            if (cnt < 31) {
                rev = rev << 1;
            }
//            System.out.println(Integer.toBinaryString(rev));
            cnt++;
        }
        return rev;
    }




}
