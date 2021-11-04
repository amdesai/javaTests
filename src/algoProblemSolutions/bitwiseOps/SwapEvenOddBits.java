package algoProblemSolutions.bitwiseOps;

    /*

Given an unsigned 8-bit integer, swap its even and odd bits. The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.

For example, 10101010 should be 01010101. 11100010 should be 11010001.

Bonus: Can you do this in one line?


    */

public class SwapEvenOddBits {

    public static void main(String ... args) {

//        System.out.println("43261596 reversed is: " + Integer.toUnsignedString(new ReverseBits().reverseBits(43261596)));
//        System.out.println("43261596 reversed is: " + Integer.reverse(43261596)); // java's own library method
        byte i;
        i = 111;
        System.out.println(Integer.toBinaryString(i));
        i= new SwapEvenOddBits().swapEvenOddBits(i);
        System.out.println(Integer.toBinaryString(i));

        i = 63;
        System.out.println(Integer.toBinaryString(i));
        i= new SwapEvenOddBits().swapEvenOddBits(i);
        System.out.println(Integer.toBinaryString(i));

    }

    public byte swapEvenOddBits(byte n) {

        return n;
    }




}
