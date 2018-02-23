package randomAnitest.arrays;

import java.util.Stack;

public class BalancedBraces {

    public static String opening = "{([";
    public static String closing = "}])";

    public static void main (String ... args) {
        System.out.println("{{}[()]}: " + new BalancedBraces().regularBracketSequence2("{{}[()]}"));
        System.out.println("{{{}[()]}: " + new BalancedBraces().regularBracketSequence2("{{{}[()]}"));
        System.out.println("{{}(()[()])}: " + new BalancedBraces().regularBracketSequence2("{{}(()[()])}"));
        System.out.println("{{}[()(){}{()}]}: " + new BalancedBraces().regularBracketSequence2("{{}[()(){}{()}]}"));
        System.out.println("()()()()()({}{{}}{}): " + new BalancedBraces().regularBracketSequence2("()()()()()({}{{}}{})"));
    }

    boolean regularBracketSequence2(String sequence) {

        Stack<Character> s = new Stack<Character>();

        char[] chars = sequence.toCharArray();

        for (char c: chars){
            if (opening.contains(String.valueOf(c))) {
                s.push(c);
            } else {
                char b = s.pop();
                if ( c == ']' && b != '[')
                    return false;
                if (c == ')' && b != '(')
                    return false;
                if (c == '}' && b != '{')
                    return false;
            }
        }
        return s.isEmpty();
    }

}
