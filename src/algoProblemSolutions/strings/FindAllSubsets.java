package algoProblemSolutions.strings;

import java.util.ArrayList;

public class FindAllSubsets {

    public static void main (String ... args) {
        ArrayList<Character> set = new ArrayList<Character>();
        set.add('a');
        set.add('b');
        set.add('c');
        ArrayList<ArrayList<Character>> subsets = getSubsets(set);
        System.out.println(subsets.toString());
    }


    public static ArrayList<ArrayList<Character>> getSubsets(ArrayList<Character> set) {

        ArrayList<ArrayList<Character>> subsets = new ArrayList<ArrayList<Character>>();
        int max = 1 << set.size();
        for (int k =0; k< max ; k++) {
            ArrayList<Character> subset = convertIntToSet(k, set);
            subsets.add(subset);
        }
        return subsets;
    }

    public static ArrayList<Character> convertIntToSet(int n, ArrayList<Character> set) {
        ArrayList<Character> subset = new ArrayList<Character>();
        int i = 0;
        for (int k = n; k > 0; k >>= 1) {
//            System.out.print(Integer.toBinaryString(k) + ", ");
            if ((k & 1) == 1) {
                subset.add(set.get(i));
            }
            i++;
        }
        return subset;
    }


}
