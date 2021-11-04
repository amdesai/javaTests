package algoProblemSolutions.strings;
import java.util.*;

public class DecodeString {
    
/*

djskgh .. 2[asmdn 4[sda] asd ]..sa .. 4[gfh] .. asda

decHlpr(2, asmdn4[sd...end)
   4 .. decHlpr(4, sda]) -> sda
asmdn<4Xsda>
   asd..] --> asmd... asd
<2Xasmd...asd>  

O(N*M)
O(M)

*/

    public String decodeString(String s) {
        Map<String, Integer> codeLength = new HashMap<>();
        return decHelper(s, 0, codeLength);
    }


    String decHelper(String s, int i, Map<String, Integer> codeLength) { //
        String res = "";
        String num = "";
        String decoded = "";
        int cL = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ']') {
                cL++;
                codeLength.put(res, cL);
                break;
            } else if (c >= '0' && c <= '9') {//handle numbers
                num+=c;
            } else if (c == '[') {
                int mul = Integer.parseInt(num);
                num = "";
                Integer len = 0;
                decoded = decHelper(s, i+1, codeLength);
                cL += codeLength.get(decoded);
                i += codeLength.get(decoded);
                decoded = multiply(mul, decoded);
                res += decoded;
            } else {
                res += c;
            }
            cL++;
            i++;
        }
        return res;
    }

    String multiply(int m, String s) {
        int n = 0;
        String res = "";
        while (n < m) {
            res += s;
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString("abc3[cd]xyz"));
    }


}