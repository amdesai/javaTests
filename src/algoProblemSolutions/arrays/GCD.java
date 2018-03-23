package algoProblemSolutions.arrays;

public class GCD {

    public static void main(String[] args) {
        System.out.println("gcd(233342, 12648) = " + findGCD(233342, 12648));
    }

    private static int findGCD(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }


}
